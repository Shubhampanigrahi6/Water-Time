package com.example.watertime;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class Shopabout extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shopabout);

        Button contactpage,feedback;

        String sendto="shubhampanigrahi6@gmail.com";


        contactpage =(Button) findViewById(R.id.contact);
        feedback =(Button) findViewById(R.id.button9);



        contactpage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),Contactpage.class);
                startActivity(intent);
            }
        });


        feedback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent emailIntent=new Intent(Intent.ACTION_SENDTO);
                emailIntent.setData(Uri.parse("mailto:"+sendto));
                startActivity(emailIntent);
            }
        });



    }
}