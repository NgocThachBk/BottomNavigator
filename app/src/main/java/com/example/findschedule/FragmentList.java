package com.example.findschedule;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;


public class FragmentList extends
        RecyclerView.Adapter<FragmentList.ViewHolder> {



    public static class ViewHolder extends RecyclerView.ViewHolder {

        public TextView nameTextView;
        public ImageView imageView;
        public TextView timeTextView;
        public TextView timeTQ;



        public ViewHolder(View itemView) {

            super(itemView);

            nameTextView = (TextView) itemView.findViewById(R.id.textName);
            imageView = (ImageView) itemView.findViewById(R.id.imgPlaceFragment);
            timeTextView = itemView.findViewById(R.id.tvTime);
            timeTQ = itemView.findViewById(R.id.timeThamQuan);
        }
    }

    private List<Data1> mContacts;
    public static Context context;

    // Pass in the contact array into the constructor
    public FragmentList(List<Data1> contacts) {
        mContacts = contacts;
    }


    @Override
    public FragmentList.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        View contactView = inflater.inflate(R.layout.fragment_recycle_item, parent, false);

        FragmentList.ViewHolder viewHolder = new FragmentList.ViewHolder(contactView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(FragmentList.ViewHolder viewHolder, int position) {

        Data1 contact = mContacts.get(position);
        ImageView imageView = viewHolder.imageView;
        TextView textView = viewHolder.nameTextView;
        TextView tvStart = viewHolder.timeTextView;
        TextView timeTQ = viewHolder.timeTQ;
        textView.setText(contact.getname());
        tvStart.setText(contact.getTimeStart());
        timeTQ.setText("T/g Tham Quan : " + contact.getPeriodOfTime());



        Glide.with(context).load(contact.getImage()).into(imageView);



    }

    // Return the total count of items
    @Override
    public int getItemCount() {
        return mContacts.size();
    }


}