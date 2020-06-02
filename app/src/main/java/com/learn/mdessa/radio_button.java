package com.learn.mdessa;

import android.support.annotation.IdRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Switch;
import android.widget.TextView;

public class radio_button extends AppCompatActivity {

    RadioGroup radioGroup;
    RadioButton radioButton;
    TextView textDetails;
    Button button;
    ImageView image_View;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_radio_button);
        radioGroup = (RadioGroup) findViewById(R.id.radio_group);
        textDetails = (TextView) findViewById(R.id.text_view);
        button = (Button) findViewById(R.id.btn_choose);
        image_View = (ImageView) findViewById(R.id.img_view);

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group,@IdRes int checkedId) {
                    radioButton = findViewById(checkedId);
                switch(radioButton.getId()){
                    case R.id.pizza_radio:
                        image_View.setImageResource(R.drawable.ic_local_pizza);
                        break;
                    case R.id.humb_radio:
                        image_View.setImageResource(R.drawable.ic_humborger);
                        break;
                    case R.id.stick_radio:
                        image_View.setImageResource(R.drawable.ic_stick);
                        break;
                }

            }
        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (radioButton.getId()){
                    case R.id.pizza_radio:
                        textDetails.setText("Pizza is a savory dish of Italian origin.");
                        break;
                    case R.id.humb_radio:
                        textDetails.setText("A hamburger is a sandwich consisting of one.");
                        break;
                    case R.id.stick_radio:
                        textDetails.setText("Barbecue or barbeque is a cooking method.");
                        break;
                    default:
                        textDetails.setText("Details - Click Button");
            }}
        });




    }
}
