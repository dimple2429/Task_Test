package com.example.task_test;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {

    EditText textusername, textpassword;

    Button btnLogin;

    AlertDialogManager alert = new AlertDialogManager();

    Session_Management session;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_activity);
        session = new Session_Management(getApplicationContext());
        textusername = findViewById(R.id.textusername);
        textpassword = findViewById(R.id.textpassword);
        Toast.makeText(getApplicationContext(),"User Login Status:" + session.TestLoggedin(), Toast.LENGTH_SHORT).show();

        btnLogin = findViewById(R.id.btnLogin);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String username = textusername.getText().toString();
                String password = textpassword.getText().toString();

                if(username.trim().length() > 0 && password.trim().length() > 0){
                    if(username.equals("test") && password.equals("test")){

                        session.createLoginSession("Test", "test@gmail.com");

                        Intent i = new Intent(getApplicationContext(), MainActivity.class);
                        startActivity(i);
                        finish();

                    }else{
                        alert.showAlertDialog(LoginActivity.this, "Login failed..", "Username/Password is incorrect", false);
                    }
                }else{

                    alert.showAlertDialog(LoginActivity.this, "Login failed..", "Please enter username and password", false);
                }

            }


        });

    }


    }

