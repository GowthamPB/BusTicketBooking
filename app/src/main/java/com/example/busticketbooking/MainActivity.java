package com.example.busticketbooking;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity {
    Button button;
    TextView textView2;
    EditText user_name,password;
    FirebaseAuth mAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow() .setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main_activity);
        button=findViewById(R.id.button);
        textView2=findViewById(R.id.textView2);
        user_name =findViewById(R.id.user_name);
        password=findViewById(R.id.password);
        mAuth=FirebaseAuth.getInstance();
        textView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,SignUp.class);
                startActivity(intent);
            }
        });
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String password1=password.getText().toString();
                String username1= user_name.getText().toString();
                if(password1.equals("admin") && username1.equals("admin")){
                    Intent intent=new Intent(MainActivity.this, MainActivity2.class);
                    Toast.makeText(MainActivity.this, "Welcome admin", Toast.LENGTH_SHORT).show();
                    startActivity(intent);
                    finish();
                }else{
                    if(!username1.isEmpty()){
                        user_name.setError(null);
                        if(!password1.isEmpty()) {
                            password.setError(null);
                            if(username1.matches("^[a-z0-9_-]{3,15}$")){
                                user_name.setError(null);
                                if(password1.matches("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}$")){
                                    password.setError(null);
                                        final String password_data=password.getText().toString();
                                final String username_data= user_name.getText().toString();
                                FirebaseDatabase firebaseDatabase= FirebaseDatabase.getInstance();
                                DatabaseReference databaseReference=firebaseDatabase.getReference("users");
                                Query check_email=databaseReference.orderByChild("name").equalTo(username_data);
                                                                check_email.addListenerForSingleValueEvent(new ValueEventListener() {
                            @Override
                            public void onDataChange(@NonNull DataSnapshot snapshot) {
                                if(snapshot.exists()){
                                    user_name.setError(null);
                                    String password_check=snapshot.child(username_data).child("password").getValue(String.class);
                                    if(password1.equals(password_check)){
                                                password.setError(null);
                                                Toast.makeText(MainActivity.this, "Login Successful", Toast.LENGTH_SHORT).show();
                                                Intent intent=new Intent(MainActivity.this,Customer_Dashboard.class);
                                                startActivity(intent);
                                                finish();
                                            }else{
                                                password.setError("Incorrect Password");
                                            }
                                        }else{
                                            user_name.setError("Username does not exist");
                                        }
                                    }
                                    @Override
                                    public void onCancelled(@NonNull DatabaseError error) {

                                    }
                                                                });
                                } else{
                                    password.setError("Invalid password");
//                                        password.setErrorEnabled(false);
                                }
                            }
                            else{
                                user_name.setError("Invalid user_name");
                            }
                        }else{
                            password.setError("Password field can't be empty");
                        }
                    }
                    else{
                        user_name.setError("Username field can't be empty");
                    }
                }
            }
        });
    }
}




