package com.learn.mdessa;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class alert_Dialogue extends AppCompatActivity {

    private AlertDialog.Builder alertDialogue;
    Button button_alert;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alert__dialogue);




        button_alert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alertDialogue= new AlertDialog.Builder(alert_Dialogue.this);
                alertDialogue.setTitle("Close");
                alertDialogue.setMessage("Really you want to close this app !");
                alertDialogue.setIcon(R.mipmap.ic_launcher);
                alertDialogue.setCancelable(false);
                alertDialogue.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        alert_Dialogue.this.finish();

                    }
                });
                alertDialogue.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });
            }
        });

        AlertDialog dialog = alertDialogue.create();
        dialog.show();

    }
}
