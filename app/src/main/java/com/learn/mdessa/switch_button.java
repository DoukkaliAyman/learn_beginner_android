package com.learn.mdessa;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;

public class switch_button extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_switch_button);

        Switch switch_stts = findViewById(R.id.switch_stts);
        final TextView txt_stts = findViewById(R.id.text_stts);

        switch_stts.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    txt_stts.setText("Is on ");
                }else{
                    txt_stts.setText("Is off ");
                }
            }
        });
    }
}
