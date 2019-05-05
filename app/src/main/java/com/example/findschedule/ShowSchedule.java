package com.example.findschedule;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class ShowSchedule extends AppCompatActivity {

    ArrayList<Data2> dayList = new ArrayList<Data2>();
    public static Integer numDay;

    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.show_schedule);

        Intent intent = this.getIntent();

        dayList = (ArrayList<Data2>)intent.getSerializableExtra("dayList");
        numDay = intent.getIntExtra("numDays",1);
        String namePlace = intent.getStringExtra("namePlace");

        Toolbar toolbar =  findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ActionBar actionBar = getSupportActionBar();

        toolbar.setTitle("Lịch Trình " + namePlace + " " + String.valueOf(numDay) + " ngày");

        final RecyclerView rvContacts = (RecyclerView) findViewById(R.id.rvContacts_main);

        ContactsAdapter adapter = new ContactsAdapter(dayList);

        rvContacts.setAdapter(adapter);

    }

    public static class ContactsAdapter extends
            RecyclerView.Adapter<ContactsAdapter.ViewHolder> {

        //private static List<Contact> mContacts;
        private static List<Data2> mContacts;
        //private static ArrayList<Contact> dataSend;
        private static ArrayList<Data2> dataSend;
        public static Context context;

        public static class ViewHolder extends RecyclerView.ViewHolder {

            //private List<Contact> mContacts;
            public TextView nameTextView;
            public Button messageButton;
            public RecyclerView recyclerView;
            public ListPlace listPlace;
            public LinearLayout linearLayout;

            public ViewHolder(View itemView) {

                super(itemView);
                //mContacts = Contact.createContactsList(20);
                recyclerView = itemView.findViewById(R.id.rvContacts);
                linearLayout = itemView.findViewById(R.id.linePlace);
                //listPlace = new ListPlace(mContacts);
                //recyclerView.setAdapter(listPlace);

                nameTextView = (TextView) itemView.findViewById(R.id.soNgay);
                //messageButton = (Button) itemView.findViewById(R.id.message_button);
            }
        }




        // Pass in the contact array into the constructor
        public ContactsAdapter(ArrayList<Data2> contacts) {
            mContacts = contacts;
            dataSend = contacts;
        }


        @Override
        public ContactsAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            context = parent.getContext();
            LayoutInflater inflater = LayoutInflater.from(context);

            View contactView = inflater.inflate(R.layout.item_main_recyclerview, parent, false);

            ViewHolder viewHolder = new ViewHolder(contactView);
            return viewHolder;
        }

        @Override
        public void onBindViewHolder(ContactsAdapter.ViewHolder viewHolder, final int position) {

            ListPlace listPlace;


            //Contact contact = mContacts.get(position);
            Data2 contact = mContacts.get(position);

            TextView textView = viewHolder.nameTextView;

            RecyclerView recyclerView = viewHolder.recyclerView;
            //listPlace = new ListPlace(contact.getListItems());
            //recyclerView.setAdapter(listPlace);

            //listPlace = new ListPlace(contact.getListItems());
            listPlace = new ListPlace(contact.getPlaceItems());
            recyclerView.setAdapter(listPlace);


            textView.setText("Ngày " + String.valueOf(position + 1));


            viewHolder.linearLayout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(context,MainFragment.class);
                    Bundle bundle = new Bundle();

                    intent.putExtra("listPlace",dataSend);
                    intent.putExtra("position",position);
                    intent.putExtra("numDay",numDay);
                    context.startActivity(intent);
                    //Toast.makeText(context,"xxx",Toast.LENGTH_SHORT).show();
                }
            });

            //Button button = viewHolder.messageButton;

//            if (contact.isOnline()) {
//                button.setText("Message");
//                button.setEnabled(true);
//            }
//            else {
//                button.setText("Offline");
//                button.setEnabled(false);
//            }

        }

        // Return the total count of items
        @Override
        public int getItemCount() {
            return mContacts.size();
        }
    }

}
