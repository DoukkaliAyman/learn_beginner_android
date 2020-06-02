package Adapter;

import android.content.Context;
import android.icu.text.CaseMap;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.learn.mdessa.R;

import java.util.List;

import Model.listItems;

public class myAdapter extends RecyclerView.Adapter<myAdapter.viewHolder>  {


    private Context context;
    private List<listItems> list;

    public myAdapter(Context context, List list) {
        this.context = context;
        this.list = list;

    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    @NonNull
    @Override
    public myAdapter.viewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_recycler_view,viewGroup,false);

        return new viewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull myAdapter.viewHolder holder, int position) {

    listItems listItems = list.get(position);
        holder.title.setText(listItems.getTitle());
        holder.descr.setText(listItems.getDescr());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }



    public class viewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private TextView title;
        private TextView descr;
        @RequiresApi(api = Build.VERSION_CODES.M)
        public viewHolder(@NonNull View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
            title = itemView.findViewById(R.id.title);
            descr = itemView.findViewById(R.id.details);

        }

        @Override
        public void onClick(View v) {
            int position = getAdapterPosition();
            listItems items =  list.get(position);
            String title = items.getTitle();
            String descr = items.getDescr();
            Toast.makeText(context, title + " -> " + descr,Toast.LENGTH_LONG).show();
        }



    }
}
