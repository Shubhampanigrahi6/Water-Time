package com.example.watertime;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Payment extends AppCompatActivity {

    Button cas,gpay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);

        cas=(Button) findViewById(R.id.cash);
        gpay =(Button) findViewById(R.id.online);

        gpay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent lunchIntent= getPackageManager().getLaunchIntentForPackage("com.google.android.apps.nbu.paisa.user");

                startActivity(lunchIntent);
            }
        });

        cas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    Intent intent = new Intent(getApplicationContext(), Orderconfirm.class);
                    Toast.makeText(Payment.this, " Your order received successfully \n Our delivery person will reach you soon \nGet ready to hydrated soon!!!!!!!! ", Toast.LENGTH_LONG).show();
                    startActivity(intent);

                }

        }
        );



    }
}