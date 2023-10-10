package com.mesume.memmedova.basicuserauthentication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Toast;

import com.mesume.memmedova.basicuserauthentication.constants.Constants;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        SharedPreferences sp = getSharedPreferences(Constants.SP_FILE_NAME, Context.MODE_PRIVATE);
        String email = sp.getString(Constants.EMAIL, "Email Tapilmadi");
        Toast.makeText(this, email, Toast.LENGTH_SHORT).show();
    }
}