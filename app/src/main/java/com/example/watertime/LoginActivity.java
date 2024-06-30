package com.example.watertime;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {

    Button button;
    EditText username,password;

    DBHelper myDB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        username = findViewById(R.id.editText);
        password = findViewById(R.id.editTextTextPassword);
        button = findViewById(R.id.okbtn);

        myDB=new DBHelper(this);

        button.setOnClickListener(v -> {
            String user = username.getText().toString();
            String pass = password.getText().toString();

            if (user.equals("")|| pass.equals(""))
            {
                Toast.makeText(LoginActivity.this, "please enter the credentials", Toast.LENGTH_SHORT).show();
            }
            else
            {
                 Boolean result = myDB.checkusernamePassword(user,pass);
                 if(result)
                 {
                    Intent intent = new Intent(getApplicationContext(),HomescreenActivity.class);
                    startActivity(intent);
                 }
                 else
                 {
                     Toast.makeText(LoginActivity.this, "invalid credentials;", Toast.LENGTH_SHORT).show();
                 }
            }
        });


    }
}

