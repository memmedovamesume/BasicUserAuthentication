package com.mesume.memmedova.basicuserauthentication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.mesume.memmedova.basicuserauthentication.models.HesabBilgileri;

import java.io.IOException;

public class RegisterActivity extends AppCompatActivity {

    EditText adInput;
    EditText soyadInput;
    EditText emailInput;
    EditText sifreInput;
    EditText tekrarsifreInput;
    Button tesdiqleButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        adInput = (EditText) findViewById(R.id.register_name_input);
        soyadInput = (EditText) findViewById(R.id.register_input_soyad);
        emailInput = (EditText) findViewById(R.id.register_input_email);
        sifreInput = (EditText) findViewById(R.id.register_input_password);
        tekrarsifreInput = (EditText) findViewById(R.id.register_input_password_again);
        tesdiqleButton = (Button) findViewById(R.id.register_submit);

        tesdiqleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String ad = adInput.getText().toString();
                String soyad =soyadInput.getText().toString();
                String email =emailInput.getText().toString();
                String sifre = sifreInput.getText().toString();
                String tekrarsifre = tekrarsifreInput.getText().toString();
                if (ad.isBlank()){
                    Toast.makeText(RegisterActivity.this, "Ad bos ola bilmez", Toast.LENGTH_LONG).show();

                }
               else if(soyad.isBlank()){
                    Toast.makeText(RegisterActivity.this, "Soyad bos ola bilmez",Toast.LENGTH_LONG).show();

                }
               else if (email.isBlank()){
                   Toast.makeText(RegisterActivity.this,"Email bos ola bilmez",Toast.LENGTH_LONG).show();

                }
                else if (sifre.isBlank()){
                    Toast.makeText(RegisterActivity.this,"sifre bos ola bilmez",Toast.LENGTH_LONG).show();

                }
                else if (tekrarsifre.isBlank()){

                    Toast.makeText(RegisterActivity.this,"tekrar sifre bos ola bilmez",Toast.LENGTH_LONG).show();

                }
                else if (!sifre.equals(tekrarsifre)){
                    Toast.makeText(RegisterActivity.this, "Sifre ve tekrar sifre eyni deyil", Toast.LENGTH_LONG).show();
                }
                else{
                    HesabBilgileri hesabBilgileri = HesabBilgileri.getInstance(ad, soyad, email, sifre);
                    try {
                        hesabBilgileri.save(RegisterActivity.this);
                    } catch (IOException e) {
                       Toast.makeText(RegisterActivity.this, "Xeta oldu", Toast.LENGTH_LONG).show();
                    }
                    startActivity(new Intent(RegisterActivity.this, HomeActivity.class));
                    finish();
                }
            }
        });
    }
}