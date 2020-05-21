package com.learn.mdessa;

import android.annotation.SuppressLint;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
         final TextView result = (TextView) findViewById(R.id.result);
        Button btn = (Button) findViewById(R.id.btn);
         final EditText number1 = (EditText) findViewById(R.id.x);
         final EditText number2= (EditText) findViewById(R.id.y);




        btn.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.M)
            @Override
            public void onClick(View v ){
                if (TextUtils.isDigitsOnly(number1.getText().toString()) && TextUtils.isDigitsOnly(number2.getText().toString())){

                   double numb1 = Double.parseDouble(number1.getText().toString()) ;
                   double numb2 =  Double.parseDouble(number2.getText().toString());

                    result.setText("result :"+(numb1+numb2));
                }
                else if(number1.getText().toString().equals("") && number2.getText().toString().equals("") ){
                    result.setText("put Value !!!!");
                }else{
                    result.setText("Just Number !!!!");
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                        result.setTextColor(getColor(R.color.colorRed));
                        result.setTextSize(25);
                    }

                }



            }
        });




    }}