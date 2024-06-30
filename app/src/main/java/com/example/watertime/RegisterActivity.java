package com.example.watertime;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class RegisterActivity extends AppCompatActivity {
    EditText username,password,repassword;
    Button btnsignup,btnsignin;
    DBHelper myDB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);


        username= findViewById(R.id.username);
        password= findViewById(R.id.editTextTextPassword2);
        repassword= findViewById(R.id.editTextTextPassword3);

        btnsignup= findViewById(R.id.Regbutton);
        btnsignin= findViewById(R.id.existbtn);

        myDB=new DBHelper(this);

        btnsignup.setOnClickListener(v -> {
            String user= username.getText().toString();
            String pass= password.getText().toString();
            String repass= repassword.getText().toString();


            if(user.equals("") || pass.equals("")||repass.equals(" "))
            {
                Toast.makeText(RegisterActivity.this, "fill all the fields", Toast.LENGTH_SHORT).show();
            }
            else
            {
                if(pass.equals(repass))
                {
                   Boolean usercheckResult = myDB.checkusername(user);
                   if (!usercheckResult)
                   {
                      boolean regresult = myDB.insertData(user,pass);
                      if (regresult)
                      {
                          Toast.makeText(RegisterActivity.this, "Registration successful", Toast.LENGTH_SHORT).show();
                          Intent intent = new Intent(getApplicationContext(),LoginActivity.class);
                          startActivity(intent);
                      }
                      else
                      {
                          Toast.makeText(RegisterActivity.this, "Registration failed", Toast.LENGTH_SHORT).show();
                      }
                   }
                   else
                   {
                       Toast.makeText(RegisterActivity.this, "user already exist please login", Toast.LENGTH_SHORT).show();
                   }
                }
                else
                {
                    Toast.makeText(RegisterActivity.this, "password is not matching", Toast.LENGTH_SHORT).show();
                }
            }

        });

        btnsignin.setOnClickListener(v -> {
            Intent intent =new Intent(getApplicationContext(),LoginActivity.class);
            startActivity(intent);
        });
    }
}