package com.example.watertime;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Shopmuljar extends AppCompatActivity {

    Button bt,or;
    TextView name,pname;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shopmuljar);

        bt =(Button) findViewById(R.id.button3);
        or =(Button) findViewById(R.id.button6);
        name=findViewById(R.id.textView11);
        pname=findViewById(R.id.textView12);


        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String product =name.getText().toString();
                String prod =pname.getText().toString();
                Intent intent = new Intent(getApplicationContext(),Placeorder.class);
                intent.putExtra("keyname",product);
                intent.putExtra("key",prod);
                startActivity(intent);
            }
        });

        or.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),Cart.class);
                startActivity(intent);
            }
        });

    }
}