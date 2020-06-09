package com.learn.storage.sqLite;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.learn.storage.R;
import com.learn.storage.sqLite.Controller.DatabaseHandler;
import com.learn.storage.sqLite.Model.Persone;

import java.util.List;

public class Main_Activity extends AppCompatActivity {

    DatabaseHandler db ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_);


        //insert

        db = new DatabaseHandler(this);
        db.addPersone(new Persone("Ayman","doukkali","nador", 25));
        db.addPersone(new Persone("Youssef","doukkali","nador", 20));
        db.addPersone(new Persone("zakariya","doukkali","nador", 15));





        //update date by id

        Persone setPersone = db.getpersone(2);

        setPersone.setAge(10);

        db.updatePersone(setPersone);


        //read data by id

        Persone OnePersone = db.getpersone(2);

        Log.d("persone Id : ", OnePersone.getAge()+"");

        //Drop row

        db.dropPerson(OnePersone);

        // read all data

        List<Persone> personeList = db.gatAllPersones();
        for (Persone p : personeList){
            String Info_People = "ID: " + p.getId()
                    +" Name: " + p.getName()
                    +" Last Name : " + p.getLname();
            Log.d("DATA", Info_People);
        }
       // count persons

        String countNumber = String.valueOf(db.countPerson());
        Log.d("number : ",countNumber);



    }
}
