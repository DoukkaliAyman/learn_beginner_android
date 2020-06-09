package com.learn.storage;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class sharedReferences extends AppCompatActivity {
private TextView status;
    private static final String MYKEY = "password";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.shared_pereferences);
         status = findViewById(R.id.status);


    }

    @Override
    protected void onStart() {
        super.onStart();
        SharedPreferences sharedPreferences = getSharedPreferences(MYKEY, 0);
        SharedPreferences.Editor edit = sharedPreferences.edit();
        edit.putString("key","15245ay");
        edit.apply();

        Toast.makeText(this,"15245ay"
                ,Toast.LENGTH_LONG).show();


    }

    @Override
    protected void onRestart() {
        super.onRestart();
        SharedPreferences Preferences = getSharedPreferences(MYKEY, 0);
        String myKey = Preferences.getString("key","not found");
        Toast.makeText(this,myKey,Toast.LENGTH_LONG).show();

        if (Preferences.contains("key")){
           if (myKey.equals("15245ay")){
               status.setText("Login with Success");
           }else {
               status.setText("plz Login again");
           }
        }



    }
}