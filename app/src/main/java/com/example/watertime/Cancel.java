package com.example.watertime;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Cancel extends AppCompatActivity {

    EditText name,add,id;
    Button bdelete;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cancel);

        id = (EditText) findViewById(R.id.myid);
        name = (EditText) findViewById(R.id.myname);
        add=(EditText) findViewById(R.id.myadd);
        bdelete=(Button) findViewById(R.id.button2);


        Intent i= getIntent();

        String t1=i.getStringExtra("id").toString();
        String t2=i.getStringExtra("name").toString();
        String t3=i.getStringExtra("add").toString();

        id.setText(t1);
        name.setText(t2);
        add.setText(t3);


//        bview.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent i= new Intent(getApplicationContext(), Cart.class);
//                startActivity(i);
//            }
//        });

        bdelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                delete();

            }
        });

//        bok.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                edit();
//
//            }
//        });

    }
    public void delete()
    {
        if(true) {
            try {
                String code = id.getText().toString();


                SQLiteDatabase db = openOrCreateDatabase("SQliteDb", Context.MODE_PRIVATE, null);

                String sql = "delete from records where  code=? ";
                SQLiteStatement statement = db.compileStatement(sql);

                statement.bindString(1, code);

                statement.execute();
                Toast.makeText(this, "Order cancelled", Toast.LENGTH_LONG).show();


                name.setText("");
                add.setText("");

                name.requestFocus();

                if(true){

                    Intent i= new Intent(getApplicationContext(), Cart.class);
                    startActivity(i);

                }

            } catch (Exception ex) {
                Toast.makeText(this, "stored failed", Toast.LENGTH_LONG).show();
            }
        }
    }

}



























//    public void edit()
//    {
//        try {
//            String code=id.getText().toString();
//            String nama=name.getText().toString();
//            String grama=add.getText().toString();
//
//
//
//            SQLiteDatabase db=openOrCreateDatabase("SQliteDb", Context.MODE_PRIVATE,null);
//
//            String sql="update records set nama=?,grama=? WHERE code=?";
//            SQLiteStatement statement= db.compileStatement(sql);
//            statement.bindString(1,code);
//            statement.bindString(2,nama);
//            statement.bindString(3,grama);
//            statement.execute();
//            Toast.makeText(this,"record updated",Toast.LENGTH_LONG).show();
//
//
//            id.setText("");
//            name.setText("");
//            add.setText("");
//
//            id.requestFocus();
//
//        }catch (Exception ex)
//        {
//            Toast.makeText(this,"stored failed",Toast.LENGTH_LONG).show();
//        }
//
//



