package com.example.watertime;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.telecom.Call;
import android.view.View;
import android.widget.Button;

public class Contactpage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contactpage);

        Button call,mail;

        call=(Button) findViewById(R.id.call);
        mail =(Button) findViewById(R.id.mail);

        String sent="shubhampanigrahi6@gmail.com";

        call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:9040375137"));
                startActivity(intent);
            }
        });
        mail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent emailIntent=new Intent(Intent.ACTION_SENDTO);
                emailIntent.setData(Uri.parse("mailto:"+sent));
                startActivity(emailIntent);
            }
        });


    }
}