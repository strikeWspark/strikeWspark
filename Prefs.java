package com.example.carepath;

import android.app.Activity;
import android.content.SharedPreferences;

public class Prefs {

    SharedPreferences sharedPreferences;
    public Prefs(Activity activity){
        sharedPreferences = activity.getPreferences(activity.MODE_PRIVATE);
    }

    public void setUser(String username){
        sharedPreferences.edit().putString("user",username).commit();
    }

    public void signout(){
        sharedPreferences.edit().putString("user",null).commit();
    }
    public String getUser(){
        return sharedPreferences.getString("user","dryfire");
    }
}
