package com.example.findschedule;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class BuyItemAdapter extends RecyclerView.Adapter<BuyItemAdapter.ViewHolder> {
    private ItemClickListener clickListener;
    ArrayList<String[]> moneys; // 0 is id_note, 1 is name, 2 is name item, 2 is cost
    Context context;
    DatabaseHelper databaseHelper;
    public BuyItemAdapter(ArrayList<String[]> moneys, Context context) {
        this.moneys = moneys;
        this.context = context;
        databaseHelper = new DatabaseHelper(context);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater layoutInflater = LayoutInflater.from(viewGroup.getContext());
        View itemView = layoutInflater.inflate(R.layout.item_row, viewGroup, false);

        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        viewHolder.money.setText(moneys.get(i)[1] + " " + moneys.get(i)[2] + "k");
    }

    @Override
    public int getItemCount() {
        return moneys.size();
    }

    public void removeItem(int position) {
        databaseHelper.deleteData("cost_item", "id_note = " + moneys.get(position)[0] + " AND name = '" + moneys.get(position)[1] + "'");

        moneys.remove(position);
        notifyItemRemoved(position);
    }

    public void setClickListener(ItemClickListener itemClickListener){
        this.clickListener = itemClickListener;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView money;
        TextView delete;

        public ViewHolder( View itemView) {
            super(itemView);

            money = itemView.findViewById(R.id.content);
            delete = itemView.findViewById(R.id.delete_row);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // something new activity to detail note
                }
            });


            delete.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (clickListener != null) {
                        clickListener.onClickItem(v, getAdapterPosition());
                        removeItem(getAdapterPosition());
                    }

                }
            });
        }
    }
}
