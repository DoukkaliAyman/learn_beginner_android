package com.learn.mdessa;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

public class checkBox extends AppCompatActivity {
    CheckBox py,php,js;
    Button submit;
    TextView txt_check;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_box);

        py = findViewById(R.id.py);
        php = findViewById(R.id.php);
        js = findViewById(R.id.js);
        submit = findViewById(R.id.submit);
        txt_check = findViewById(R.id.text_check);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                show();
            }
        });



    }

    public  void show(){
        StringBuilder stringBuilder = new StringBuilder();

        if (py.isChecked()){
            stringBuilder.append(py.getText().toString()).append("\n");
        }else if(js.isChecked()){
            stringBuilder.append(js.getText().toString()).append("\n");
        }else if(php.isChecked()){
            stringBuilder.append(php.getText().toString()).append("\n");
        }else{
            stringBuilder.append("Plz check what you want");
        }

         txt_check.setText(stringBuilder.toString());
    }


}
