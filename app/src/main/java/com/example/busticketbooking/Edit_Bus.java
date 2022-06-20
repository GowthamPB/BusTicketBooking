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

import java.util.HashMap;
import java.util.Map;

public class Edit_Bus extends AppCompatActivity {
    public EditText busNumEdit,srcEdit,destEdit,timingsEdit,priceEdit;
    private DatabaseReference databaseReference;
    public String BusID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_bus);
        busNumEdit =findViewById(R.id.BusNumber);
        srcEdit=findViewById(R.id.source);
        destEdit=findViewById(R.id.dest);
        timingsEdit=findViewById(R.id.timings);
        priceEdit=findViewById(R.id.price);
        Button deleteButton = findViewById(R.id.deletebtn);
        Button updateButton = findViewById(R.id.updatebtn);
        FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
        BusRVModel busRVModel = getIntent().getParcelableExtra("Bus");
        if(busRVModel !=null){
            busNumEdit.setText(busRVModel.getBusNum());
            srcEdit.setText(busRVModel.getSrc());
            destEdit.setText(busRVModel.getDest());
            timingsEdit.setText(busRVModel.getTimings());
            priceEdit.setText(busRVModel.getPrice());
            BusID= busRVModel.getBusID();
        }
        databaseReference= firebaseDatabase.getReference("Bus").child(BusID);
        updateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String busNumVar= busNumEdit.getText().toString();
                String srcVar=srcEdit.getText().toString();
                String destVar=destEdit.getText().toString();
                String timingsVar=timingsEdit.getText().toString();
                String priceVar=priceEdit.getText().toString();

                Map<String,Object> map=new HashMap<>();
                map.put("busNum", busNumVar);
                map.put("src",srcVar);
                map.put("dest",destVar);
                map.put("timings",timingsVar);
                map.put("price",priceVar);
                map.put("busID",BusID);

                databaseReference.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        databaseReference.updateChildren(map);
                        Toast.makeText(Edit_Bus.this, "Bus updated", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(Edit_Bus.this,MainActivity2.class));

                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {
                        Toast.makeText(Edit_Bus.this, "Update Error", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });

        deleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                deleteBus();
            }
        });
    }
    private void deleteBus(){
        databaseReference.removeValue();
        Toast.makeText(this, "Bus Deleted!!!", Toast.LENGTH_SHORT).show();
        startActivity(new Intent(Edit_Bus.this,MainActivity2.class));
    }
}