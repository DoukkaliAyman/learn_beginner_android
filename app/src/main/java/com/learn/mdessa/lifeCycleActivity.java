package com.learn.mdessa;

import android.annotation.SuppressLint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class lifeCycleActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_life_cycle);
        Toast.makeText(getApplicationContext(),"onCreate",Toast.LENGTH_LONG);

        /*Start Activity*/
            //on create
            //on Start
            //on Resume

        /*Out of activity (Click home button)*/
            //on pause
            // on stop

        /*Restart Activity*/
            //on restart
            //on Resume
            //on Start

        /*Out of activity (exit)*/
            //on pause
            // on stop
            //on destroy
    }

    @SuppressLint("ShowToast")
    @Override
    protected void onPause() {
        super.onPause();
        Toast.makeText(getApplicationContext(),"on Pause",Toast.LENGTH_LONG);
    }

    @Override
    protected void onResume() {
        super.onResume();
        Toast.makeText(getApplicationContext(),"onResume",Toast.LENGTH_LONG);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Toast.makeText(getApplicationContext(),"onStart",Toast.LENGTH_LONG);
    }

    @Override
    protected void onStop() {
        super.onStop();
        Toast.makeText(getApplicationContext(),"onStop",Toast.LENGTH_LONG);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Toast.makeText(getApplicationContext(),"onDestroy",Toast.LENGTH_LONG);
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Toast.makeText(getApplicationContext(),"onRestart",Toast.LENGTH_LONG);
    }
}
