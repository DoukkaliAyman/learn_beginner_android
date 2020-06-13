package com.games.recycler_sqlite.Controller;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.games.recycler_sqlite.MainActivity;
import com.games.recycler_sqlite.Model.Data;
import com.games.recycler_sqlite.R;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.MyViewHolder> {

    private Context context;
    private List<Data> list;
    private databaseHelper databasehelper;

    public Adapter(Context context, List<Data> list) {
        this.context = context;
        this.list = list;
    }

    public Adapter(Context context, List<Data> list, databaseHelper databasehelper) {
        this.context = context;
        this.list = list;
        this.databasehelper = databasehelper;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.recycler_view_item,viewGroup,false);
        return new MyViewHolder(itemView) ;
    }


    @Override
    public void onBindViewHolder(@NonNull Adapter.MyViewHolder holder, final int i) {
        final Data data = list.get(i);
        holder.data.setText(data.getName());
        holder.timestamp.setText(formatDate(data.getTimeStamp()));
        holder.delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                deleteData(i);
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView data,timestamp;
        public ImageView delete;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            data = itemView.findViewById(R.id.data);
            timestamp = itemView.findViewById(R.id.timestamp);
            delete  = itemView.findViewById(R.id.delete);

        }
    }
    private void deleteData(int i){
        databasehelper.deleteData(list.get(i));
        list.remove(i);
        MainActivity.notifyAdapter();
    }
    private String formatDate(String dateStr){
        try {
            @SuppressLint("SimpleDateFormat") SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Date date = fmt.parse(dateStr);
            SimpleDateFormat fmtOut  = new SimpleDateFormat("MMM d");
            return  fmtOut.format(date);
        } catch (ParseException e) {
            Log.e("error", e.getMessage());
        }
        return "";
    }
}
