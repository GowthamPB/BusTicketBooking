package com.example.busticketbooking;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Add_Bus extends AppCompatActivity {
    private EditText busNum,src,dest,timings,price;
    private Button button;
    private FirebaseDatabase firebaseDatabase;
    private DatabaseReference databaseReference;
    private String BusID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_bus);
        busNum=findViewById(R.id.BusNumber);
        src=findViewById(R.id.source);
        dest=findViewById(R.id.dest);
        timings=findViewById(R.id.timings);
        price=findViewById(R.id.price);
        button=findViewById(R.id.btn);
        firebaseDatabase=FirebaseDatabase.getInstance();
        databaseReference=firebaseDatabase.getReference("Bus");

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String busNumVar=busNum.getText().toString();
                String srcVar=src.getText().toString();
                String destVar=dest.getText().toString();
                String timingsVar=timings.getText().toString();
                String priceVar=price.getText().toString();
                BusID=busNumVar;
                BusRVModel busRVModel=new BusRVModel(busNumVar,srcVar,destVar,timingsVar,priceVar,BusID);
                databaseReference.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {

                        databaseReference.child(BusID).setValue(busRVModel);
                        Toast.makeText(Add_Bus.this, "Bus added", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(Add_Bus.this,MainActivity2.class));
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {
                        Toast.makeText(Add_Bus.this, "Error is: "+error.toString(), Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });
    }
}
