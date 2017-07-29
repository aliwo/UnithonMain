package com.example.hansung.uniton_project.Login;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.hansung.uniton_project.HttpLoopJ.HttpModule;
import com.example.hansung.uniton_project.HttpLoopJ.RestClient;
import com.example.hansung.uniton_project.MainActivity;
import com.example.hansung.uniton_project.R;
import com.loopj.android.http.RequestParams;

public class RegistrationActivity extends AppCompatActivity
{
    private EditText nameText;
    private EditText accountText;
    private EditText passwordText;
    private Button register;
    private RestClient client;
    private HttpModule module;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        findViews();
    }

    private void findViews()
    {
        client = new RestClient(RegistrationActivity.this);
        module = new HttpModule(client, client.getContext());
        nameText = (EditText) findViewById(R.id.edit_name_registration);
        accountText = (EditText) findViewById(R.id.edit_text_account_registration);
        passwordText = (EditText) findViewById(R.id.edit_text_password_registration);
        register = (Button) findViewById(R.id.button_registration);

        register.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                String name = nameText.getText().toString();
                String account = accountText.getText().toString();
                String password = passwordText.getText().toString();

                LoginVerifier verifier = new LoginVerifier();
                if(!verifier.verify(1, name))
                {
                    Toast.makeText(RegistrationActivity.this, "이름 값을 확인해 주세요", Toast.LENGTH_SHORT);
                    return;
                }
                if (!verifier.verify(2, account))
                {
                    Toast.makeText(RegistrationActivity.this, "계정 값을 확인해 주세요", Toast.LENGTH_SHORT);
                    return;
                }
                if (!verifier.verify(3, password))
                {
                    Toast.makeText(RegistrationActivity.this, "패스워드 값을 확인해 주세요", Toast.LENGTH_SHORT);
                    return;
                }
                module.register(name, account, password);

            }
        });
    }
}
