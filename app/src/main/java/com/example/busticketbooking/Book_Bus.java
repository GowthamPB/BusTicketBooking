package com.example.busticketbooking;

import static com.example.busticketbooking.R.layout.*;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Iterator;

public class Book_Bus extends AppCompatActivity {
    Button button1,button2,button3,button4,button5,button6,button7,button8,button9,button10,button11,button12;
    Button button13,button14,button15,button16,button17,button18,button19,button20,button21,button22,button23,button24;
    Button buttonDone;
    int flag=1;
    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;
    ArrayList<Integer> SeatArrayList=new ArrayList<>();
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
        int bg_yellow = getResources().getColor(R.color.bg_yellow);
        firebaseDatabase=FirebaseDatabase.getInstance();
        databaseReference=firebaseDatabase.getReference("Booked Seats");
        BusRVModel busRVModel = getIntent().getParcelableExtra("Bus");
        String BusID=busRVModel.getBusID();
        String Timings=busRVModel.getTimings();
        StoringSeatData storingSeatData=new StoringSeatData(SeatArrayList);

        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                databaseReference.child(BusID).child(Timings).setValue(storingSeatData);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(Book_Bus.this, "Error is: "+error.toString(), Toast.LENGTH_SHORT).show();
            }
        });

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                flag+=1;
                if(flag%2==0) {
                    SeatArrayList.add(1);
                    button1.setBackgroundColor(Color.GREEN);
                }
                else{
                    SeatArrayList.remove(Integer.valueOf(1));
                    button1.setBackgroundColor(bg_yellow);
                }
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                flag+=1;
                if(flag%2==0) {
                    SeatArrayList.add(2);
                    button2.setBackgroundColor(Color.GREEN);
                }
                else{
                    SeatArrayList.remove(Integer.valueOf(2));
                    button2.setBackgroundColor(bg_yellow);
                }
            }
        });
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                flag+=1;
                if(flag%2==0) {
                    SeatArrayList.add(3);
                    button3.setBackgroundColor(Color.GREEN);
                }
                else{
                    SeatArrayList.remove(Integer.valueOf(3));
                    button3.setBackgroundColor(bg_yellow);
                }
            }
        });
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                flag+=1;
                if(flag%2==0) {
                    SeatArrayList.add(4);
                    button4.setBackgroundColor(Color.GREEN);
                }
                else{
                    SeatArrayList.remove(Integer.valueOf(4));
                    button4.setBackgroundColor(bg_yellow);
                }
            }
        });
        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                flag+=1;
                if(flag%2==0) {
                    SeatArrayList.add(5);
                    button5.setBackgroundColor(Color.GREEN);
                }
                else{
                    SeatArrayList.remove(Integer.valueOf(5));
                    button5.setBackgroundColor(bg_yellow);
                }
            }
        });
        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                flag+=1;
                if(flag%2==0) {
                    SeatArrayList.add(6);
                    button6.setBackgroundColor(Color.GREEN);
                }
                else{
                    SeatArrayList.remove(Integer.valueOf(6));
                    button6.setBackgroundColor(bg_yellow);
                }
            }
        });
        button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                flag+=1;
                if(flag%2==0) {
                    SeatArrayList.add(7);
                    button7.setBackgroundColor(Color.GREEN);
                }
                else{
                    SeatArrayList.remove(Integer.valueOf(7));
                    button7.setBackgroundColor(bg_yellow);
                }
            }
        });
        button8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                flag+=1;
                if(flag%2==0) {
                    SeatArrayList.add(8);
                    button8.setBackgroundColor(Color.GREEN);
                }
                else{
                    SeatArrayList.remove(Integer.valueOf(8));
                    button8.setBackgroundColor(bg_yellow);
                }
            }
        });
        button9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                flag+=1;
                if(flag%2==0) {
                    SeatArrayList.add(9);
                    button9.setBackgroundColor(Color.GREEN);
                }
                else{
                    SeatArrayList.remove(Integer.valueOf(9));
                    button9.setBackgroundColor(bg_yellow);
                }
            }
        });
        button10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                flag+=1;
                if(flag%2==0) {
                    SeatArrayList.add(10);
                    button10.setBackgroundColor(Color.GREEN);
                }
                else{
                    SeatArrayList.remove(Integer.valueOf(10));
                    button10.setBackgroundColor(bg_yellow);
                }
            }
        });
        button11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                flag+=1;
                if(flag%2==0) {
                    SeatArrayList.add(11);
                    button11.setBackgroundColor(Color.GREEN);
                }
                else{
                    SeatArrayList.remove(Integer.valueOf(11));
                    button11.setBackgroundColor(bg_yellow);
                }
            }
        });
        button12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                flag+=1;
                if(flag%2==0) {
                    SeatArrayList.add(12);
                    button12.setBackgroundColor(Color.GREEN);
                }
                else{
                    SeatArrayList.remove(Integer.valueOf(12));
                    button12.setBackgroundColor(bg_yellow);
                }
            }
        });
        button13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                flag+=1;
                if(flag%2==0) {
                    SeatArrayList.add(13);
                    button13.setBackgroundColor(Color.GREEN);
                }
                else{
                    SeatArrayList.remove(Integer.valueOf(13));
                    button13.setBackgroundColor(bg_yellow);
                }
            }
        });
        button14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                flag+=1;
                if(flag%2==0) {
                    SeatArrayList.add(14);
                    button14.setBackgroundColor(Color.GREEN);
                }
                else{
                    SeatArrayList.remove(Integer.valueOf(14));
                    button14.setBackgroundColor(bg_yellow);
                }
            }
        });
        button15.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                flag+=1;
                if(flag%2==0) {
                    SeatArrayList.add(15);
                    button15.setBackgroundColor(Color.GREEN);
                }
                else{
                    SeatArrayList.remove(Integer.valueOf(15));
                    button15.setBackgroundColor(bg_yellow);
                }
            }
        });
        button16.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                flag+=1;
                if(flag%2==0) {
                    SeatArrayList.add(16);
                    button16.setBackgroundColor(Color.GREEN);
                }
                else{
                    SeatArrayList.remove(Integer.valueOf(16));
                    button16.setBackgroundColor(bg_yellow);
                }
            }
        });
        button17.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                flag+=1;
                if(flag%2==0) {
                    SeatArrayList.add(17);
                    button17.setBackgroundColor(Color.GREEN);
                }
                else{
                    SeatArrayList.remove(Integer.valueOf(17));
                    button17.setBackgroundColor(bg_yellow);
                }
            }
        });
        button18.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                flag+=1;
                if(flag%2==0) {
                    SeatArrayList.add(18);
                    button18.setBackgroundColor(Color.GREEN);
                }
                else{
                    SeatArrayList.remove(Integer.valueOf(18));
                    button18.setBackgroundColor(bg_yellow);
                }
            }
        });
        button19.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                flag+=1;
                if(flag%2==0) {
                    SeatArrayList.add(19);
                    button19.setBackgroundColor(Color.GREEN);
                }
                else{
                    SeatArrayList.remove(Integer.valueOf(19));
                    button19.setBackgroundColor(bg_yellow);
                }
            }
        });
        button20.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                flag+=1;
                if(flag%2==0) {
                    SeatArrayList.add(20);
                    button20.setBackgroundColor(Color.GREEN);
                }
                else{
                    SeatArrayList.remove(Integer.valueOf(20));
                    button20.setBackgroundColor(bg_yellow);
                }
            }
        });
        button21.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                flag+=1;
                if(flag%2==0) {
                    SeatArrayList.add(21);
                    button21.setBackgroundColor(Color.GREEN);
                }
                else{
                    SeatArrayList.remove(Integer.valueOf(21));
                    button21.setBackgroundColor(bg_yellow);
                }
            }
        });
        button22.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                flag+=1;
                if(flag%2==0) {
                    SeatArrayList.add(22);
                    button22.setBackgroundColor(Color.GREEN);
                }
                else{
                    SeatArrayList.remove(Integer.valueOf(22));
                    button22.setBackgroundColor(bg_yellow);
                }
            }
        });
        button23.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                flag+=1;
                if(flag%2==0) {
                    SeatArrayList.add(23);
                    button23.setBackgroundColor(Color.GREEN);
                }
                else{
                    SeatArrayList.remove(Integer.valueOf(23));
                    button23.setBackgroundColor(bg_yellow);
                }
            }
        });
        button24.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                flag+=1;
                if(flag%2==0) {
                    SeatArrayList.add(24);
                    button24.setBackgroundColor(Color.GREEN);
                }
                else{
                    SeatArrayList.remove(Integer.valueOf(24));
                    button24.setBackgroundColor(bg_yellow);
                }
            }
        });
        buttonDone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (SeatArrayList.isEmpty()) {
                    Toast.makeText(Book_Bus.this, "Select a minimum of 1 seat", Toast.LENGTH_SHORT).show();
                } else{
                    startActivity(new Intent(Book_Bus.this,Payment.class));
                    for (Integer num : SeatArrayList) {
                        if (num == 1) {
                            button1.setEnabled(false);
                            button1.setBackgroundColor(Color.GRAY);
                        }
                        if (num == 2) {
                            button2.setEnabled(false);
                            button2.setBackgroundColor(Color.GRAY);
                        }
                        if (num == 3) {
                            button3.setEnabled(false);
                            button3.setBackgroundColor(Color.GRAY);
                        }
                        if (num == 4) {
                            button4.setEnabled(false);
                            button4.setBackgroundColor(Color.GRAY);
                        }
                        if (num == 5) {
                            button5.setEnabled(false);
                            button5.setBackgroundColor(Color.GRAY);
                        }
                        if (num == 6) {
                            button6.setEnabled(false);
                            button6.setBackgroundColor(Color.GRAY);
                        }
                        if (num == 7) {
                            button7.setEnabled(false);
                            button7.setBackgroundColor(Color.GRAY);
                        }
                        if (num == 8) {
                            button8.setEnabled(false);
                            button8.setBackgroundColor(Color.GRAY);
                        }
                        if (num == 9) {
                            button9.setEnabled(false);
                            button9.setBackgroundColor(Color.GRAY);
                        }
                        if (num == 10) {
                            button10.setEnabled(false);
                            button10.setBackgroundColor(Color.GRAY);
                        }
                        if (num == 11) {
                            button11.setEnabled(false);
                            button11.setBackgroundColor(Color.GRAY);
                        }
                        if (num == 12) {
                            button12.setEnabled(false);
                            button12.setBackgroundColor(Color.GRAY);
                        }
                        if (num == 13) {
                            button13.setEnabled(false);
                            button13.setBackgroundColor(Color.GRAY);
                        }
                        if (num == 14) {
                            button14.setEnabled(false);
                            button14.setBackgroundColor(Color.GRAY);
                        }
                        if (num == 15) {
                            button15.setEnabled(false);
                            button15.setBackgroundColor(Color.GRAY);
                        }
                        if (num == 16) {
                            button16.setEnabled(false);
                            button16.setBackgroundColor(Color.GRAY);
                        }
                        if (num == 17) {
                            button17.setEnabled(false);
                            button17.setBackgroundColor(Color.GRAY);
                        }
                        if (num == 18) {
                            button18.setEnabled(false);
                            button18.setBackgroundColor(Color.GRAY);
                        }
                        if (num == 19) {
                            button19.setEnabled(false);
                            button19.setBackgroundColor(Color.GRAY);
                        }
                        if (num == 20) {
                            button20.setEnabled(false);
                            button20.setBackgroundColor(Color.GRAY);
                        }
                        if (num == 21) {
                            button21.setEnabled(false);
                            button21.setBackgroundColor(Color.GRAY);
                        }
                        if (num == 22) {
                            button22.setEnabled(false);
                            button22.setBackgroundColor(Color.GRAY);
                        }
                        if (num == 23) {
                            button23.setEnabled(false);
                            button23.setBackgroundColor(Color.GRAY);
                        }
                        if (num == 24) {
                            button24.setEnabled(false);
                            button24.setBackgroundColor(Color.GRAY);
                        }

                    }
                }
            }
        });




    }
}