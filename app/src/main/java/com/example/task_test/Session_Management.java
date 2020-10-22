package com.example.task_test;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;

import java.util.HashMap;

public class Session_Management {

    public static final String KEY_NAME ="Testname";
    public static final String KEY_EMAIL = "Testemail";
    SharedPreferences pref;
    SharedPreferences.Editor editor;
    Context context;

    int PRIVATE_MODE = 0;

    private static final String PREF_NAME = "Test";
    private static final String IS_LOGIN = "Testloggedin";



    public Session_Management( Context context) {
        this.pref = context.getSharedPreferences(PREF_NAME,PRIVATE_MODE);
        this.editor = pref.edit();
        this.context = context;
    }

    public void createLoginSession(String name, String Email) {
        editor.putBoolean(IS_LOGIN, true);
        editor.putString(KEY_NAME, name);
        editor.putString(KEY_EMAIL, Email);
        editor.commit();
    }

    public HashMap<String, String> getUserDetails() {
        HashMap<String, String> User = new HashMap<String, String>();
        User.put(KEY_NAME, pref.getString(KEY_NAME, null));
        User.put(KEY_EMAIL, pref.getString(KEY_EMAIL, null));
        return User;
    }

    public void CheckLogin(){
        if(!this.TestLoggedin()) {
            Intent i = new Intent(context, MainActivity.class);
            i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(i);
        }
    }

    boolean TestLoggedin() {
        return pref.getBoolean(IS_LOGIN,false);
    }

    public void Logoutuser() {
        editor.clear();
        editor.commit();

        Intent i = new Intent(context, LoginActivity.class);
        i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(i);

    }

}

