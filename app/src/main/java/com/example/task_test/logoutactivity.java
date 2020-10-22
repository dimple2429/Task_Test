package com.example.task_test;

import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.HashMap;

public class logoutactivity extends AppCompatActivity {

     AlertDialogManager alert = new AlertDialogManager();

     TextView lblName, lblEmail;
    Session_Management session;
        Button btnLogout;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.logout);

        session = new Session_Management(getApplicationContext());

        TextView lblName =  findViewById(R.id.lblName);
        TextView lblEmail =  findViewById(R.id.lblEmail);

        btnLogout =  findViewById(R.id.btnLogout);

        Toast.makeText(getApplicationContext(), "User Login Status: " + session.TestLoggedin(), Toast.LENGTH_LONG).show();
        session.CheckLogin();

        // get user data from session
        HashMap<String, String> user = session.getUserDetails();

        // name
        String name = user.get(Session_Management.KEY_NAME);

        // email
        String email = user.get(Session_Management.KEY_EMAIL);

        // displaying user data
        lblName.setText(Html.fromHtml("Name: <b>" + name + "</b>"));
        lblEmail.setText(Html.fromHtml("Email: <b>" + email + "</b>"));

        btnLogout.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                //session clear
                session.Logoutuser();
            }
        });

    }
}
