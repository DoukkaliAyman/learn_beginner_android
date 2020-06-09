package com.learn.storage;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class storeTextFile extends AppCompatActivity {
    private ToggleButton toggleButton;
  //  private Boolean theme_mode;
    private TextView textView;


    @Override
    protected void onCreate(final Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_store_text_file);
        textView = findViewById(R.id.teswt_tewt);


        getSettings();

        try {
            textView.setText(checkSetting());
        } catch (IOException e) {
            e.printStackTrace();
        }



        toggleButton = findViewById(R.id.statusToggle);

       // Just Test Something
        toggleButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                   // getTheme().applyStyle(R.style.AppThemeDark,true);//  setTheme(R.style.AppThemeDark);
                //   getSettings(isChecked+"");
                // Toast.makeText(getApplicationContext(),isChecked+"",Toast.LENGTH_LONG).show();
                }else {
                //    getTheme().applyStyle(R.style.AppTheme,true);// setTheme(R.style.AppTheme);
                    try {
                        checkSetting();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                 //   Toast.makeText(getApplicationContext(),isChecked+"",Toast.LENGTH_LONG).show();

                }
            }
        });
    }


    private void getSettings(){
        try {
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(openFileOutput("settings_appStore.txt", Context.MODE_PRIVATE));
            outputStreamWriter.write("ayman_doukkali");
            outputStreamWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private String ReadData() throws IOException {
        String theme_data = "";
        InputStream inputStream = openFileInput("settings_appStore.txt");
        if (inputStream != null){
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

            String temp_data = "";
            StringBuilder stringBuilder = new StringBuilder();

             while ( (temp_data = bufferedReader.readLine()) != null){
                stringBuilder.append(temp_data);
             }
             inputStream.close();
             theme_data = stringBuilder.toString();


        }
        return theme_data;
    }
    private String checkSetting() throws IOException{
        if (!ReadData().isEmpty() ){
            String read = ReadData();
              //  getApplication().setTheme(R.style.AppThemeDark);
           // Toast.makeText(getApplicationContext(),ReadData(),Toast.LENGTH_LONG).show();
return read;
        }else {
           // getApplication().setTheme(R.style.AppTheme);
            return "not work";
        }
    }

}