package com.example.busticketbooking;

import androidx.appcompat.app.AppCompatActivity;
import androidx.print.PrintHelper;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Build;
import android.os.Bundle;
import android.os.strictmode.WebViewMethodCalledOnWrongThreadViolation;
import android.print.PrintAttributes;
import android.print.PrintDocumentAdapter;
import android.print.PrintJob;
import android.print.PrintManager;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class Ticket extends AppCompatActivity {
    TextView VarBusID,VarSrc,VarDest,VarTimings,VarSeat;
    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;
    String BusID;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ticket);
        VarBusID = findViewById(R.id.idBusID);
        VarSrc = findViewById(R.id.idBusSource);
        VarDest = findViewById(R.id.idBusDestination);
        VarTimings = findViewById(R.id.idBusTimings);
        VarSeat = findViewById(R.id.idBusSeat);
        Intent intent=getIntent();
        String busID=intent.getStringExtra("BusID");
        String src=intent.getStringExtra("Source");
        String dest=intent.getStringExtra("Destination");
        String Timings=intent.getStringExtra("Timings");
        String Seats=intent.getStringExtra("Seats");

        VarBusID.setText(busID);
        VarSrc.setText("From: "+src);
        VarDest.setText("To: "+dest);
        VarTimings.setText("Timings: "+Timings);
        VarSeat.setText("Seat Num: "+Seats);

        View view = getWindow().getDecorView().findViewById(android.R.id.content);
        view.setDrawingCacheEnabled(true);
        view.measure(View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED),View. MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED));
        view.layout(0, 0, view.getMeasuredWidth(), view.getMeasuredHeight());
        view.buildDrawingCache(true);
        Bitmap bitmap = Bitmap.createBitmap(view.getDrawingCache());
        view.setDrawingCacheEnabled(false);
        PrintHelper photoPrinter = new PrintHelper(Ticket.this);
        photoPrinter.setScaleMode(PrintHelper.SCALE_MODE_FIT);
        photoPrinter.printBitmap("print", bitmap);

    }
}