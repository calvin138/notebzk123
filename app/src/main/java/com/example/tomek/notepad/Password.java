package com.example.tomek.notepad;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Password extends AppCompatActivity {

    private EditText password;
    private Button enter, change;
    String x;

    public static final String PW = "pw";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_password);

        password = (EditText)findViewById(R.id.passwordet);
        enter = (Button)findViewById(R.id.enter);
        change = (Button)findViewById(R.id.buttonchange);

        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(Password.this);
        x = sharedPreferences.getString(PW,"");

        enter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (password.getText().toString().equals(x)){
                    startActivity(new Intent(Password.this, MainActivity.class));
                }
            }
        });
        change.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Password.this, Changepassword.class));
            }
        });
    }
}
