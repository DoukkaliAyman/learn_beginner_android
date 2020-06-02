package com.learn.mdessa.moving_data_between_activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.learn.mdessa.R;

public class sec_activity_data extends AppCompatActivity {
    EditText edt_rec;
    Button back;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sec_data);

        edt_rec = findViewById(R.id.rec_data);
        back = findViewById(R.id.back);


Bundle bundle = getIntent().getExtras();

       edt_rec.setText(bundle.getString("data_sended"));



        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               Intent intent =getIntent();
                final String data = edt_rec.getText().toString();
               intent.putExtra("data_back",data);
               setResult(RESULT_OK,intent);
               finish();
            }
        });

    }
}
