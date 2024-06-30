package com.example.watertime;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Placeorder extends AppCompatActivity {

    EditText name,add,id;
    Button bok;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_placeorder);

        name = (EditText) findViewById(R.id.myname);
        add=(EditText) findViewById(R.id.myadd);
        id=(EditText) findViewById(R.id.pid);
        bok=(Button) findViewById(R.id.button);

        String product=getIntent().getStringExtra("keyname");
        String prod=getIntent().getStringExtra("key");

        id.setText(product);
        name.setText(prod);

        bok.setOnClickListener(v -> insert());

    }
    public void insert()
    {
        if(true) {
            try {
                String nama = name.getText().toString();
                String grama = add.getText().toString();
                String code = id.getText().toString();


                SQLiteDatabase db = openOrCreateDatabase("SQliteDb", Context.MODE_PRIVATE, null);
                db.execSQL("CREATE TABLE IF NOT EXISTS records(code INTEGER PRIMARY KEY AUTOINCREMENT,nama Varchar,grama Varchar/*,FOREIGN KEY(nama)REFERENCES users(username)*/)");
                String sql = "insert into records(code,nama,grama)values(?,?,?)";
                SQLiteStatement statement = db.compileStatement(sql);
                statement.bindString(1, code);
                statement.bindString(2, nama);
                statement.bindString(3, grama);
                statement.execute();
                Toast.makeText(this, "order success \nProceed to payment", Toast.LENGTH_LONG).show();

                id.setText("");
                name.setText("");
                add.setText("");

                id.requestFocus();

                if ( true) {
                    Intent i = new Intent(getApplicationContext(), Payment.class);
                    startActivity(i);
                }


            } catch (Exception ex) {
                Toast.makeText(this, "Order failed \n enter valid credentials", Toast.LENGTH_LONG).show();
            }


//            if ( true) {
//                Intent i = new Intent(getApplicationContext(), Payment.class);
//                startActivity(i);
//            }


        }






    }
    }
