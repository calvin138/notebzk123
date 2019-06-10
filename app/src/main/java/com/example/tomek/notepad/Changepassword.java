package com.example.tomek.notepad;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Changepassword extends AppCompatActivity {

    TextView x2;
    EditText oldp, newp;
    Button savep;

    public static final String PW = "pw";

    String x;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_changepassword);
        oldp = (EditText)findViewById(R.id.oldp);
        newp = (EditText)findViewById(R.id.newp);
        savep = (Button)findViewById(R.id.savep);
        x2 = (TextView)findViewById(R.id.textView6);

        LoadData();

        savep.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(oldp.getText().toString().equals(x)) {
                    savePassword();
                    Toast.makeText(Changepassword.this, "Successfull", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(Changepassword.this, Password.class));
                } else{
                    Toast.makeText(Changepassword.this, "Failed", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    public void savePassword(){
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putString(PW, newp.getText().toString());
        editor.apply();
    }

    public void LoadData(){
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        x = sharedPreferences.getString(PW, "0000");
    }
}
