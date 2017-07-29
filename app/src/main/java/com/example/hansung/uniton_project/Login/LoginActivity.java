package com.example.hansung.uniton_project.Login;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.hansung.uniton_project.HttpLoopJ.HttpModule;
import com.example.hansung.uniton_project.HttpLoopJ.RestClient;
import com.example.hansung.uniton_project.R;

/**
 * Created by HANSUNG on 2017-07-29.
 */

public class LoginActivity extends AppCompatActivity
{
    private EditText accoutText;
    private EditText passwordText;
    private TextView loginButton;
    private TextView registerButton;
    private RestClient client;
    private HttpModule module;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        findViews();
    }

    private void findViews()
    {
        client = new RestClient(LoginActivity.this);
        module = new HttpModule(client, client.getContext());
        accoutText = (EditText) findViewById(R.id.edit_text_account_login);
        passwordText = (EditText) findViewById(R.id.edit_text_password_login);
        loginButton = (TextView) findViewById(R.id.login_button_login);
        registerButton = (TextView) findViewById(R.id.register_button_register);

        loginButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                String account = accoutText.getText().toString();
                String password = passwordText.getText().toString();

                LoginVerifier verifier = new LoginVerifier();
                if (!verifier.verify(2, account))
                {
                    Toast.makeText(LoginActivity.this, "계정 값을 확인해 주세요", Toast.LENGTH_SHORT);
                    return;
                }
                if (!verifier.verify(3, password))
                {
                    Toast.makeText(LoginActivity.this, "패스워드 값을 확인해 주세요", Toast.LENGTH_SHORT);
                    return;
                }

                module.login(account, password);
            }
        });

        registerButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent intent = new Intent(LoginActivity.this, RegistrationActivity.class);
                startActivity(intent);
            }
        });

    }



}
