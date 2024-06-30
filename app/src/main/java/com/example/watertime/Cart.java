package com.example.watertime;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class Cart extends AppCompatActivity {

    ListView lst;
    ArrayList<String> titles = new ArrayList<String>();
    ArrayAdapter arrayAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);

        SQLiteDatabase db=openOrCreateDatabase("SQliteDb", Context.MODE_PRIVATE,null);

        lst = findViewById(R.id.list);
        final Cursor c = db.rawQuery("select * from records",null);

        int code = c.getColumnIndex("code");
        int nama = c.getColumnIndex("nama");
        int grama = c.getColumnIndex("grama");
        titles.clear();

        arrayAdapter = new ArrayAdapter(this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item,titles);
        lst.setAdapter(arrayAdapter);


        final ArrayList<student> stud =new ArrayList<student>();

        if(c.moveToFirst())
        {
            do{
                student stu =new student();
                stu.code =c.getString(code);
                stu.nama =c.getString(nama);
                stu.grama =c.getString(grama);

                stud.add(stu);
                titles.add(c.getString(code)+"\t"+c.getString(nama)+"\t "+c.getString(grama));



            }while (c.moveToNext());
            arrayAdapter.notifyDataSetChanged();
            lst.invalidateViews();
        }

        lst.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String aa= titles.get(position).toString();
                student stu = stud.get(position);
                Intent i= new Intent(getApplicationContext(), Cancel.class);
                i.putExtra("id",stu.code);
                i.putExtra("name",stu.nama);
                i.putExtra("add",stu.grama);
                startActivity(i);
            }
        });
    }
}