package com.mesume.memmedova.basicuserauthentication.models;

import android.content.Context;
import android.content.SharedPreferences;

import com.mesume.memmedova.basicuserauthentication.constants.Constants;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.Buffer;

public class HesabBilgileri {
    private  static  HesabBilgileri hesabBilgileri;
    private String ad;
    private String soyad;
    private String email;
    private String password;
    private HesabBilgileri(String name, String surname, String email, String password){
        this.ad = name;
        this.soyad = surname;
        this.email = email;
        this.password = password;
    }
    public String getAd(){
        return  this.ad;
    }
    public String getSoyad(){
        return  this.soyad;
    }
    public  String getEmail(){
        return  this.email;
    }
    public String getPassword(){
        return  this.password;
    }
    public static HesabBilgileri getInstance(String name, String surname, String email, String password){
        if(hesabBilgileri == null){
            hesabBilgileri = new HesabBilgileri(name, surname, email, password);
        }
        return  hesabBilgileri;
    }
    public void save(Context context) throws IOException {
        SharedPreferences sharedPreferences = context.getSharedPreferences(Constants.SP_FILE_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(Constants.NAME, this.ad);
        editor.putString(Constants.SURNAME, this.soyad);
        editor.putString(Constants.EMAIL, this.email);
        editor.putString(Constants.PASSWORD, this.password);
        editor.apply();
    }

}
