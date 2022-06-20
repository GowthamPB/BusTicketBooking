package com.example.busticketbooking;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

public class SignUp extends AppCompatActivity {
    Button button;
    TextView textView2;
    EditText email,password,name;
    FirebaseDatabase firebaseDatabase;
    DatabaseReference reference;
    FirebaseAuth mAuth;
    ProgressDialog loader;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_sign_up);
        button=findViewById(R.id.button);
        textView2=findViewById(R.id.textView2);
        email=findViewById(R.id.user_name);
        password=findViewById(R.id.password);
        name=findViewById(R.id.username);
        loader=new ProgressDialog(this);
        mAuth=FirebaseAuth.getInstance();
        textView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(SignUp.this,MainActivity.class);
                startActivity(intent);
            }
        });
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String password1=password.getText().toString();
                String email1=email.getText().toString();
                String name1=name.getText().toString();
                    if(!name1.isEmpty()){
                        name.setError(null);
                        if(!email1.isEmpty()) {
                            email.setError(null);
                            if(!password1.isEmpty()) {
                                password.setError(null);
                                if(name1.matches("^[a-z0-9_-]{3,15}$")){
                                    name.setError(null);
                                        if (email1.matches("^[a-zA-Z0-9_!#$%&’*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$")) {
                                            email.setError(null);
                                            if (password1.matches("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}$")) {
                                                password.setError(null);
                                                loader.setMessage("Sign Up in progress...");
                                                loader.setCanceledOnTouchOutside(false);
                                                loader.show();
                                                firebaseDatabase=FirebaseDatabase.getInstance();
                                                reference=firebaseDatabase.getReference("users");
                                                String password2=password.getText().toString();
                                                String email2=email.getText().toString();
                                                String name2=name.getText().toString();
                                                StoringData storingData=new StoringData(name2,email2,password2);
                                                reference.child(name2).setValue(storingData);
                                                Toast.makeText(SignUp.this, "Registration successful!!!", Toast.LENGTH_SHORT).show();
                                                Intent intent=new Intent(SignUp.this,Customer_Dashboard.class);
                                                startActivity(intent);
                                                finish();

                                            } else {
                                                password.setError("Invalid password");
                                            }
                                        } else {
                                            email.setError("Invalid email");
                                        }
                                    }else {
                                       name.setError("Invalid username");
                                    }
                            }else{
                                password.setError("Password field can't be empty");
                            }
                    }else{
                            email.setError("Email field can't be empty");
                        }
                    } else{
                        name.setError("Name field can't be empty");
                    }
                }
            });
        }








//    private void sendUserToNextActivity() {
//        Intent intent=new Intent(SignUp.this,Customer_Dashboard.class);
//        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK|Intent.FLAG_ACTIVITY_NEW_TASK);
//        startActivity(intent);
//    }
}

//                if(password1.equals("admin") && email1.equals("admin")){
//                    Intent intent=new Intent(MainActivity.this,Admin_Dashboard.class);
//                    startActivity(intent);
//                    finish();

//                    Intent intent=new Intent(MainActivity.this,Customer_Dashboard.class);
//                    startActivity(intent);
//                    finish();
//                                        Toast.makeText(SignUp.this, "Success", Toast.LENGTH_SHORT).show();
//                                        firebaseDatabase=FirebaseDatabase.getInstance();
//                                        reference=firebaseDatabase.getReference("message");
//                                        reference.setValue("Hello world");
//                                        String password2=password.getText().toString();
//                                        String email2=email.getText().toString();
//                                        String name2=name.getText().toString();
//                                        StoringData storingData=new StoringData(name2,email2,password2);
//
//                                        reference.child(name2).setValue(storingData);

//        mAuth.createUserWithEmailAndPassword(email1, password1).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
//@Override
//public void onComplete(@NonNull Task<AuthResult> task) {
//        if (!task.isSuccessful()) {
//        String error = task.getException().toString();
//        Toast.makeText(SignUp.this, "Error occurred:" + error, Toast.LENGTH_SHORT).show();
//        } else {
//        String CurrentUserId = mAuth.getCurrentUser().getUid();
//        reference = FirebaseDatabase.getInstance().getReference().child("users").child(CurrentUserId);
//        HashMap userInfo = new HashMap();
//        userInfo.put("Username", name1);
//        userInfo.put("Email", email1);
//        userInfo.put("Password", password1);
//        reference.updateChildren(userInfo).addOnCompleteListener(new OnCompleteListener() {
//@Override
//public void onComplete(@NonNull Task task) {
//        if (task.isSuccessful()) {
//        loader.dismiss();
//        Toast.makeText(SignUp.this, "Registration Successful", Toast.LENGTH_SHORT).show();
//        Intent intent = new Intent(SignUp.this, Customer_Dashboard.class);
//        startActivity(intent);
//        finish();
//
//        } else {
//        Toast.makeText(SignUp.this, "Failed to Register!!! Please try again later", Toast.LENGTH_SHORT).show();
//        }
//        }
//        });
//        }
//        }
//});