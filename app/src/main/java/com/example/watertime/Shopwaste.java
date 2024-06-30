package com.example.watertime;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Shopwaste extends AppCompatActivity {

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shopwaste);

        Button contactus,info;


        contactus =(Button) findViewById(R.id.contactbtn);
        info=(Button) findViewById(R.id.unicefbtn);


        contactus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),Contactpage.class);
                startActivity(intent);
            }
        });
        info.setOnClickListener(new View.OnClickListener() {
          @Override
            public void onClick(View v){
              gotoUrl("https://www.recyclenow.com");
          }
        });
    }

    private void gotoUrl(String s) {
        Uri uri = Uri.parse(s);
        startActivity(new Intent(Intent.ACTION_VIEW,uri));
    }
}