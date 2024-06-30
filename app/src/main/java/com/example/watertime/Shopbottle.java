package com.example.watertime;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

public class Shopbottle extends AppCompatActivity {

    Button bt,or;
    TextView name,pname;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shopbottle);

        name=findViewById(R.id.textView6);
        pname=findViewById(R.id.textView9);

        bt =(Button) findViewById(R.id.button);
        or =(Button) findViewById(R.id.ord1);

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