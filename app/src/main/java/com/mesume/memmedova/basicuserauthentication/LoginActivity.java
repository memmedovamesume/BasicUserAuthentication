package com.mesume.memmedova.basicuserauthentication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.mesume.memmedova.basicuserauthentication.constants.Constants;

public class LoginActivity extends AppCompatActivity {

    TextView goToRegisterPage;
    Button loginButton;
    EditText emailInput, passwordInput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        emailInput = (EditText) findViewById(R.id.email_input);
        passwordInput = (EditText) findViewById(R.id.password_input);
        goToRegisterPage = (TextView) findViewById(R.id.go_to_register_page);
        goToRegisterPage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LoginActivity.this, RegisterActivity.class));
            }
        });
        loginButton = (Button) findViewById(R.id.button_login);
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = emailInput.getText().toString().strip();
                String password = passwordInput.getText().toString().strip();
                SharedPreferences sp = getSharedPreferences(Constants.SP_FILE_NAME, Context.MODE_PRIVATE);

                String realemail = sp.getString(Constants.EMAIL, "");
                String realpassword = sp.getString(Constants.PASSWORD, "");
                if(realpassword.isEmpty()||realemail.isEmpty()){
                    startActivity(new Intent(LoginActivity.this, RegisterActivity.class));
                    finish();
                }
                else if(email.equals(realemail) && password.equals(realpassword)){
                    startActivity(new Intent(LoginActivity.this, HomeActivity.class));
                    finish();
                }
                else{
                    Toast.makeText(LoginActivity.this, "Giris bilgileri yanlisdir", Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}