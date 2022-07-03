package com.example.busticketbooking;

import static com.example.busticketbooking.R.layout.*;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.razorpay.Checkout;
import com.razorpay.PaymentResultListener;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.lang.String;
import java.util.HashMap;
import java.util.Map;

public class Book_Bus extends AppCompatActivity implements PaymentResultListener {
    Button button1,button2,button3,button4,button5,button6,button7,button8,button9,button10,button11,button12;
    Button button13,button14,button15,button16,button17,button18,button19,button20,button21,button22,button23,button24;
    Button buttonDone,ResetBtn;
    String AvailSeats;
    public String BusID;
    BusRVModel busRVModel;
    int count=0;
    Boolean flag;
    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;
    ArrayList<Integer> SeatArrayList=new ArrayList<>();
    ArrayList<Integer> SeatsAL=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(activity_book_bus);
        button1=findViewById(R.id.button1);
        button2=findViewById(R.id.button2);
        button3=findViewById(R.id.button3);
        button4=findViewById(R.id.button4);
        button5=findViewById(R.id.button5);
        button6=findViewById(R.id.button6);
        button7=findViewById(R.id.button7);
        button8=findViewById(R.id.button8);
        button9=findViewById(R.id.button9);
        button10=findViewById(R.id.button10);
        button11=findViewById(R.id.button11);
        button12=findViewById(R.id.button12);
        button13=findViewById(R.id.button13);
        button14=findViewById(R.id.button14);
        button15=findViewById(R.id.button15);
        button16=findViewById(R.id.button16);
        button17=findViewById(R.id.button17);
        button18=findViewById(R.id.button18);
        button19=findViewById(R.id.button19);
        button20=findViewById(R.id.button20);
        button21=findViewById(R.id.button21);
        button22=findViewById(R.id.button22);
        button23=findViewById(R.id.button23);
        button24=findViewById(R.id.button24);
        buttonDone=findViewById(R.id.buttonDone);
        ResetBtn=findViewById(R.id.ResetBtn);

        button1.setEnabled(false);
        button1.setBackgroundColor(Color.GRAY);
        button2.setEnabled(false);
        button2.setBackgroundColor(Color.GRAY);
        button3.setEnabled(false);
        button3.setBackgroundColor(Color.GRAY);
        button4.setEnabled(false);
        button4.setBackgroundColor(Color.GRAY);
        button5.setEnabled(false);
        button5.setBackgroundColor(Color.GRAY);
        button6.setEnabled(false);
        button6.setBackgroundColor(Color.GRAY);
        button7.setEnabled(false);
        button7.setBackgroundColor(Color.GRAY);
        button8.setEnabled(false);
        button8.setBackgroundColor(Color.GRAY);
        button9.setEnabled(false);
        button9.setBackgroundColor(Color.GRAY);
        button10.setEnabled(false);
        button10.setBackgroundColor(Color.GRAY);
        button11.setEnabled(false);
        button11.setBackgroundColor(Color.GRAY);
        button12.setEnabled(false);
        button12.setBackgroundColor(Color.GRAY);
        button13.setEnabled(false);
        button13.setBackgroundColor(Color.GRAY);
        button14.setEnabled(false);
        button14.setBackgroundColor(Color.GRAY);
        button15.setEnabled(false);
        button15.setBackgroundColor(Color.GRAY);
        button16.setEnabled(false);
        button16.setBackgroundColor(Color.GRAY);
        button17.setEnabled(false);
        button17.setBackgroundColor(Color.GRAY);
        button18.setEnabled(false);
        button18.setBackgroundColor(Color.GRAY);
        button19.setEnabled(false);
        button19.setBackgroundColor(Color.GRAY);
        button20.setEnabled(false);
        button20.setBackgroundColor(Color.GRAY);
        button21.setEnabled(false);
        button21.setBackgroundColor(Color.GRAY);
        button22.setEnabled(false);
        button22.setBackgroundColor(Color.GRAY);
        button23.setEnabled(false);
        button23.setBackgroundColor(Color.GRAY);
        button24.setEnabled(false);
        button24.setBackgroundColor(Color.GRAY);

        String[] Seats;
        int bg_yellow = getResources().getColor(R.color.bg_yellow);
        busRVModel = getIntent().getParcelableExtra("Bus");
        BusID=busRVModel.getBusID();
        firebaseDatabase=FirebaseDatabase.getInstance();
        databaseReference=firebaseDatabase.getReference("Bus").child(BusID);
        String AvailableSeats=busRVModel.getAvailableSeats();
        Seats=AvailableSeats.split(",");
        for (String seat : Seats) {
            SeatArrayList.add(Integer.valueOf(seat));
        }
        for (Integer num : SeatArrayList) {
            if (num == 1) {
                button1.setEnabled(true);
                button1.setBackgroundColor(bg_yellow);
            }
            if (num == 2) {
                button2.setEnabled(true);
                button2.setBackgroundColor(bg_yellow);
            }
            if (num == 3) {
                button3.setEnabled(true);
                button3.setBackgroundColor(bg_yellow);
            }
            if (num == 4) {
                button4.setEnabled(true);
                button4.setBackgroundColor(bg_yellow);
            }
            if (num == 5) {
                button5.setEnabled(true);
                button5.setBackgroundColor(bg_yellow);
            }
            if (num == 6) {
                button6.setEnabled(true);
                button6.setBackgroundColor(bg_yellow);
            }
            if (num == 7) {
                button7.setEnabled(true);
                button7.setBackgroundColor(bg_yellow);
            }
            if (num == 8) {
                button8.setEnabled(true);
                button8.setBackgroundColor(bg_yellow);
            }
            if (num == 9) {
                button9.setEnabled(true);
                button9.setBackgroundColor(bg_yellow);
            }
            if (num == 10) {
                button10.setEnabled(true);
                button10.setBackgroundColor(bg_yellow);
            }
            if (num == 11) {
                button11.setEnabled(true);
                button11.setBackgroundColor(bg_yellow);
            }
            if (num == 12) {
                button12.setEnabled(true);
                button12.setBackgroundColor(bg_yellow);
            }
            if (num == 13) {
                button13.setEnabled(true);
                button13.setBackgroundColor(bg_yellow);
            }
            if (num == 14) {
                button14.setEnabled(true);
                button14.setBackgroundColor(bg_yellow);
            }
            if (num == 15) {
                button15.setEnabled(true);
                button15.setBackgroundColor(bg_yellow);
            }
            if (num == 16) {
                button16.setEnabled(true);
                button16.setBackgroundColor(bg_yellow);
            }
            if (num == 17) {
                button17.setEnabled(true);
                button17.setBackgroundColor(bg_yellow);
            }
            if (num == 18) {
                button18.setEnabled(true);
                button18.setBackgroundColor(bg_yellow);
            }
            if (num == 19) {
                button19.setEnabled(true);
                button19.setBackgroundColor(bg_yellow);
            }
            if (num == 20) {
                button20.setEnabled(true);
                button20.setBackgroundColor(bg_yellow);
            }
            if (num == 21) {
                button21.setEnabled(true);
                button21.setBackgroundColor(bg_yellow);
            }
            if (num == 22) {
                button22.setEnabled(true);
                button22.setBackgroundColor(bg_yellow);
            }
            if (num == 23) {
                button23.setEnabled(true);
                button23.setBackgroundColor(bg_yellow);
            }
            if (num == 24) {
                button24.setEnabled(true);
                button24.setBackgroundColor(bg_yellow);
            }
        }

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                flag+=1;
//                if(flag%2==0) {
                SeatArrayList.remove(Integer.valueOf(1));
                SeatsAL.add(1);
                button1.setBackgroundColor(Color.GREEN);
                count++;
//                }
//                else{
//                    SeatArrayList.add(1);
//                    button1.setBackgroundColor(bg_yellow);
//                }
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SeatArrayList.remove(Integer.valueOf(2));
                SeatsAL.add(2);
                button2.setBackgroundColor(Color.GREEN);
                count++;
            }
        });
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SeatArrayList.remove(Integer.valueOf(3));
                SeatsAL.add(3);
                button3.setBackgroundColor(Color.GREEN);
                count++;
            }
        });
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SeatArrayList.remove(Integer.valueOf(4));
                SeatsAL.add(4);
                button4.setBackgroundColor(Color.GREEN);
                count++;
            }
        });
        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SeatArrayList.remove(Integer.valueOf(5));
                SeatsAL.add(5);
                button5.setBackgroundColor(Color.GREEN);
                count++;
            }
        });
        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SeatArrayList.remove(Integer.valueOf(6));
                SeatsAL.add(6);
                button6.setBackgroundColor(Color.GREEN);
                count++;
            }
        });
        button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SeatArrayList.remove(Integer.valueOf(7));
                SeatsAL.add(7);
                button7.setBackgroundColor(Color.GREEN);
                count++;
            }
        });
        button8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SeatArrayList.remove(Integer.valueOf(8));
                SeatsAL.add(8);
                button8.setBackgroundColor(Color.GREEN);
                count++;
            }
        });
        button9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SeatArrayList.remove(Integer.valueOf(9));
                SeatsAL.add(9);
                button9.setBackgroundColor(Color.GREEN);
                count++;
            }
        });
        button10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SeatArrayList.remove(Integer.valueOf(10));
                SeatsAL.add(10);
                button10.setBackgroundColor(Color.GREEN);
                count++;
            }
        });
        button11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SeatArrayList.remove(Integer.valueOf(11));
                SeatsAL.add(11);
                button11.setBackgroundColor(Color.GREEN);
                count++;
            }
        });
        button12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SeatArrayList.remove(Integer.valueOf(12));
                SeatsAL.add(12);
                button12.setBackgroundColor(Color.GREEN);
                count++;
            }
        });
        button13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SeatArrayList.remove(Integer.valueOf(13));
                SeatsAL.add(13);
                button13.setBackgroundColor(Color.GREEN);
                count++;
            }
        });
        button14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SeatArrayList.remove(Integer.valueOf(14));
                SeatsAL.add(14);
                button14.setBackgroundColor(Color.GREEN);
                count++;
            }
        });
        button15.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SeatArrayList.remove(Integer.valueOf(15));
                SeatsAL.add(15);
                button15.setBackgroundColor(Color.GREEN);
                count++;
            }
        });
        button16.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SeatArrayList.remove(Integer.valueOf(16));
                SeatsAL.add(16);
                button16.setBackgroundColor(Color.GREEN);
                count++;
            }
        });
        button17.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SeatArrayList.remove(Integer.valueOf(17));
                SeatsAL.add(17);
                button17.setBackgroundColor(Color.GREEN);
                count++;
            }
        });
        button18.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SeatArrayList.remove(Integer.valueOf(18));
                SeatsAL.add(18);
                button18.setBackgroundColor(Color.GREEN);
                count++;
            }
        });
        button19.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SeatArrayList.remove(Integer.valueOf(19));
                SeatsAL.add(19);
                button19.setBackgroundColor(Color.GREEN);
                count++;
            }
        });
        button20.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SeatArrayList.remove(Integer.valueOf(20));
                SeatsAL.add(20);
                button20.setBackgroundColor(Color.GREEN);
                count++;
            }
        });
        button21.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SeatArrayList.remove(Integer.valueOf(21));
                SeatsAL.add(21);
                button21.setBackgroundColor(Color.GREEN);
                count++;
            }
        });
        button22.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SeatArrayList.remove(Integer.valueOf(22));
                SeatsAL.add(22);
                button22.setBackgroundColor(Color.GREEN);
                count++;
            }
        });
        button23.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SeatArrayList.remove(Integer.valueOf(23));
                SeatsAL.add(23);
                button23.setBackgroundColor(Color.GREEN);
                count++;
            }
        });
        button24.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SeatArrayList.remove(Integer.valueOf(24));
                SeatsAL.add(24);
                button24.setBackgroundColor(Color.GREEN);
                count++;
            }
        });

        ResetBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
                overridePendingTransition(0, 0);
                startActivity(getIntent());
                overridePendingTransition(0, 0);
            }
        });

//Displays the price of each seat in the present bus
        String price=busRVModel.getPrice();
        TextView priceDisplay=findViewById(R.id.priceDisplay);
        priceDisplay.setText("Price per seat: Rs."+ price);

        buttonDone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//Checking if any seats are selected
                if (SeatsAL.isEmpty()) {
//Runs if no seats selected
                    Toast.makeText(Book_Bus.this, "Select a minimum of 1 seat to pay", Toast.LENGTH_SHORT).show();
                } else{
//Runs if seats are selected
                    Toast.makeText(Book_Bus.this, "Redirecting...", Toast.LENGTH_SHORT).show();

//Calculating Ticket price
                    int amount=count*Integer.valueOf(price)*100;
                    count=0;

//Calling Razorpay API
                    razorPayAPI(amount);

//Converting arraylist into strings so as to update in Database
                    AvailSeats=String.valueOf(SeatArrayList.get(0));
                    for(int i=1;i<SeatArrayList.size();i++){
                        AvailSeats+=","+String.valueOf(SeatArrayList.get(i));
                    }
                }
            }

//The RazorPay API method
            private void razorPayAPI(int amount) {
                Checkout checkout=new Checkout();
                checkout.setKeyID("<keyID>");
                JSONObject object=new JSONObject();
                try {
                    object.put("name","Yellow Bus");
                    object.put("Description","Bus Ticket");
                    object.put("theme.color",bg_yellow);
                    object.put("currency","INR");
                    object.put("amount",amount);
                    object.put("prefill.contact","<phone>");
                    object.put("prefill.email","<email>");
                    checkout.open(Book_Bus.this,object);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        });
    }


    //Method related to RazorPay API
    @Override
    public void onPaymentSuccess(String s) {
        AlertDialog.Builder builder=new AlertDialog.Builder(this);
        builder.setTitle("Payment ID");
        Toast.makeText(this, "Payment Successful", Toast.LENGTH_SHORT).show();
//        builder.setMessage(s);
//        builder.show();
        String FinalSeats="";
        for(int i=0;i<SeatsAL.size();i++){
            FinalSeats+=SeatsAL.get(i);
            if(i!=SeatsAL.size()-1){
                FinalSeats+=",";
            }
        }
        Intent intent = new Intent(Book_Bus.this, Ticket.class);
        intent.putExtra("BusID", busRVModel.getBusID());
        intent.putExtra("Source", busRVModel.getSrc());
        intent.putExtra("Destination", busRVModel.getDest());
        intent.putExtra("Timings", busRVModel.getTimings());
        intent.putExtra("Seats", FinalSeats);
        startActivity(intent);
        finish();

//Updating value of available seats in Database
        Map<String,Object> map=new HashMap<>();
        map.put("availableSeats", AvailSeats);

        databaseReference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                databaseReference.updateChildren(map);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(Book_Bus.this, "All seats booked", Toast.LENGTH_SHORT).show();
            }
        });

    }

    //Method related to RazorPay API
    @Override
    public void onPaymentError(int i, String s) {
        Toast.makeText(getApplicationContext(), "Payment Cancelled", Toast.LENGTH_SHORT).show();
        Toast.makeText(Book_Bus.this, "Try again", Toast.LENGTH_SHORT).show();
    }

    //Method to change the default action of Back button
    @Override
    public void onBackPressed(){
        startActivity(new Intent(Book_Bus.this,Customer_Dashboard.class));
    }
}