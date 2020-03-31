package com.example.carepath;

import android.content.Intent;
import android.gesture.Prediction;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class LoginActivity extends AppCompatActivity {

    private MaterialButton next;
    private TextInputEditText username;
    private TextInputEditText password;
    private TextInputLayout userinput,pwdinput;
    private MaterialButton cacnel;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_activity);

        username = findViewById(R.id.username_edit);
        password = findViewById(R.id.password_edit);
        next = findViewById(R.id.submit_button);
        cacnel = findViewById(R.id.cancel_button);
        userinput = findViewById(R.id.username_input);
        pwdinput = findViewById(R.id.password_input);



        username.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                userinput.setError(null);
                return false;
            }
        });
        password.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                pwdinput.setError(null);
                return false;
            }
        });
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!TextUtils.isEmpty(username.getText()) && !TextUtils.isEmpty(password.getText())){
                    Prefs prefs = new Prefs(LoginActivity.this);
                    String user = username.getText().toString().trim();
                    prefs.setUser(user);
                    startActivity(new Intent(LoginActivity.this,MainActivity.class));
                    finish();
                }else{
                    userinput.setError("Fill the credentials first");
                    pwdinput.setError("Fill the credentials first");

                }

            }
        });

        cacnel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.exit(0);
            }
        });


    }
}
