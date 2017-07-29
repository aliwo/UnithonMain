package com.example.hansung.uniton_project.Login;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by aliwo on 2017-07-29.
 */

public class User extends AppCompatActivity
{
    public static final String PREFS_NAME = "UserInfo";

    private SharedPreferences.Editor editor;
    public static String email;
    public static String password;
    public static String name;
    public static String token;

    public User(Context context)
    {
        SharedPreferences settings = context.getSharedPreferences(User.PREFS_NAME, 0);
        editor = settings.edit();
    }

    public void autologin(String email, String password, String token)
    {
        this.email = email;
        this.password = password;
        this.token = token;
        editor.putString("email", email);
        editor.putString("password", password);
        editor.putString("token", token);
    }
    public void register(String email, String password, String name, String token)
    {
        this.email = email;
        this.password = password;
        this.token = token;
        this.name = name;

        editor.putString("email", email);
        editor.putString("password", password);
        editor.putString("name", name);
        editor.putString("token", token);

    }


}
