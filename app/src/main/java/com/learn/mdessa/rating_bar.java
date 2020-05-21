package com.learn.mdessa;

import android.annotation.SuppressLint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.TextView;

public class rating_bar extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rating_bar);

        final RatingBar ratingBar = findViewById(R.id.rating_bar);
        final TextView textView = findViewById(R.id.txt_rating);
        Button btn_ratting = findViewById(R.id.btn_rating);
       final EditText editText_rating = findViewById(R.id.edit_rating);


        btn_ratting.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {
                textView.setText(ratingBar.getRating() + "\n" + editText_rating.getText());

            }
        });


    }
}
