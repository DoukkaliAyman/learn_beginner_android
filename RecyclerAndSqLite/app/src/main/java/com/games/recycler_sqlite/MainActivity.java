package com.games.recycler_sqlite;

import android.app.Dialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.games.recycler_sqlite.Controller.Adapter;
import com.games.recycler_sqlite.Controller.databaseHelper;
import com.games.recycler_sqlite.Model.Data;

public class MainActivity extends AppCompatActivity {
    public static Adapter adapter;
    RecyclerView recyclerView;
     databaseHelper dbHelper ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setTitle(R.string.app_name);

        recyclerView = findViewById(R.id.recyclerView);
        dbHelper = new databaseHelper(this);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              /*  Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();*/
                showCustomDialog();
            }
        });
        adapter = new Adapter(this,dbHelper.getAllData(),dbHelper);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter);
    }

    public static void notifyAdapter() {
        adapter.notifyDataSetChanged();
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private void showCustomDialog() {
        final Dialog dialog = new Dialog(this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE); // before
        dialog.setContentView(R.layout.add_guest);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.setCancelable(false);

        WindowManager.LayoutParams lp = new WindowManager.LayoutParams();
        lp.copyFrom(dialog.getWindow().getAttributes());
        lp.width = WindowManager.LayoutParams.MATCH_PARENT;
        lp.height = WindowManager.LayoutParams.WRAP_CONTENT;

        final Button add_guest = (Button) dialog.findViewById(R.id.add);
        final Button back = (Button) dialog.findViewById(R.id.back);

        final EditText name_person = (EditText) dialog.findViewById(R.id.edit_name);
        final  EditText lname_person = (EditText) dialog.findViewById(R.id.edit_lname);
        final   EditText description_person = (EditText) dialog.findViewById(R.id.edit_description);
        final  EditText age_person = (EditText) dialog.findViewById(R.id.age_edit);



       // final View layout = getLayoutInflater().inflate(R.layout.custom_toast, (ViewGroup) findViewById(R.id.custom_toast_layout_id));
  //      TextView text = (TextView) layout.findViewById(R.id.text);
     //   text.setTextColor(Color.WHITE);
     //   text.setText("Please enter valid data");
    //    CardView lyt_card = (CardView) layout.findViewById(R.id.lyt_card);
  //      lyt_card.setCardBackgroundColor(getResources().getColor(R.color.colorPrimary));

   //     final Toast toast = new Toast(getApplicationContext());

        add_guest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {

               String name = name_person.getText().toString();
               String lname = lname_person.getText().toString();
               String description = description_person.getText().toString();
               String age = age_person.getText().toString();

                if (name.length() == 0 || lname.length() == 0 || description.length() == 0 || age.length() == 0)
                {
                        Snackbar.make(v, "please Complete all filed", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();

                 /*   toast.setDuration(Toast.LENGTH_LONG);
                    toast.setView(layout);
                    toast.show();*/
                }
                else
                {
                  dbHelper.insertData(new Data(name,lname,description,age));
                    adapter.notifyDataSetChanged();
                    dialog.dismiss();
                }
            }
        });

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();

            }
        });

        dialog.show();
        dialog.getWindow().setAttributes(lp);
    }
}