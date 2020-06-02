package com.learn.mdessa;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.TextView;
import android.widget.ToggleButton;

public class toggle_button extends AppCompatActivity {

    ToggleButton togglebutton;
    TextView text_Status;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_toggle_button);

        togglebutton = findViewById(R.id.toggleButton);
        text_Status = findViewById(R.id.textView);
        togglebutton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    text_Status.setText("Is on");
                }else{
                    text_Status.setText("Is off");
                }

            }
        });

    }
}
