package com.example.watertime;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class HomescreenActivity extends AppCompatActivity {

    ImageButton btl,jar,muljar,combo,waste,about;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homescreen);

        btl =(ImageButton) findViewById(R.id.imageButton);
        jar =(ImageButton) findViewById(R.id.imageButton2);
        muljar=(ImageButton) findViewById(R.id.imageButton3);
        combo=(ImageButton) findViewById(R.id.imageButton4);
        waste=(ImageButton) findViewById(R.id.imageButton5);
        about=(ImageButton) findViewById(R.id.imageButton6);

        btl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),Shopbottle.class);
                startActivity(intent);
            }
        });
        jar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),Shopjar.class);
                startActivity(intent);
            }
        });
        muljar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),Shopmuljar.class);
                startActivity(intent);
            }
        });
        combo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),Shopcombo.class);
                startActivity(intent);
            }
        });
        waste.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),Shopwaste.class);
                startActivity(intent);
            }
        });
        about.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),Shopabout.class);
                startActivity(intent);
            }
        });
    }
}