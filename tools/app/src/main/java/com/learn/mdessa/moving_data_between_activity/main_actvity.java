package com.learn.mdessa.moving_data_between_activity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.learn.mdessa.R;

public class main_actvity extends AppCompatActivity {

    EditText edt_send;
    Button send;
    private final int REQUEST_CODE = 2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_actvity);

        edt_send = (EditText) findViewById(R.id.edt_sen_data);
        send = (Button)findViewById(R.id.send);

         String data = edt_send.getText().toString();
        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               Intent intent = new Intent(main_actvity.this,sec_activity_data.class);
                String data = edt_send.getText().toString();
                intent.putExtra("data_sended", data);
              //  startActivity(intent);
                startActivityForResult(intent,REQUEST_CODE);

            }
        });

    }

    @SuppressLint("SetTextI18n")
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode==REQUEST_CODE){
            if (resultCode == RESULT_OK){
                String data_back = data.getStringExtra("data_back");
                edt_send.setText("DATA RETURN : " + data_back);
            }
        }
    }
}
