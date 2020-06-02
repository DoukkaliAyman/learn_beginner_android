package com.learn.mdessa;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.CalendarView;
import android.widget.TextView;

public class calendar extends AppCompatActivity {

    CalendarView calendarView;
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendar);
        calendarView = findViewById(R.id.calendar);
        textView = findViewById(R.id.result_cal);

       // calendarView.setMaxDate(20200530);
      //  calendarView.setMinDate(20200501);
        calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView view, int year, int month, int dayOfMonth) {

                String myDate =  dayOfMonth + "/"+  (month + 1) + "/"+ year;
                textView.setText(myDate);
            }
        });


    }
}
