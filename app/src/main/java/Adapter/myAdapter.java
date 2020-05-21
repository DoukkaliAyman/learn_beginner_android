package Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.learn.mdessa.R;

import java.util.List;

import Model.listItems;

public class myAdapter extends RecyclerView.Adapter<myAdapter.viewHolder> {


    private Context context;
    private List<listItems> list;

    public myAdapter(Context context, List list) {
        this.context = context;
        this.list = list;

    }

    @NonNull
    @Override
    public myAdapter.viewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_recycler_view,viewGroup,false);

        return new viewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull myAdapter.viewHolder viewHolder, int position) {

listItems listItems = new listItems("ayman doukkali",
        )

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class viewHolder extends RecyclerView.ViewHolder {
        private TextView title;
        private TextView descr;
        public viewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.title);
            descr = itemView.findViewById(R.id.details);

        }
    }
}
