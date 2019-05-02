package com.example.findschedule;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class NumberSchedule extends AppCompatActivity {
    String namePlace;
    EditText editText;
    RecyclerView rvContacts;
    DatabaseReference ref;
    Data1 data1;
    ArrayList<Data3> listSchedule = new ArrayList<Data3>();
    ArrayList<Data1> placeList;
    ArrayList<Data2> dayList = new ArrayList<Data2>();

    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.number_schedule);
        Intent intent = this.getIntent();

        rvContacts = (RecyclerView) findViewById(R.id.rvContacts_main);

        FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
        ref =  firebaseDatabase.getReference("Place");

        namePlace = intent.getStringExtra("namePlace");

        ValueEventListener eventListener = new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                DataSnapshot place = dataSnapshot.child(namePlace);
                placeList = new ArrayList<Data1>();
                for(DataSnapshot ds: place.getChildren()){
                    listSchedule.add(new Data3("Đà Lạt",0));
                    for(DataSnapshot dh:ds.getChildren()){
                        String key = dh.getKey();
                        Log.d("key",key);
                        data1 = dh.getValue(Data1.class);
                        //Log.d("hhh",data1.getname());
                        placeList.add(data1);
                    }
                    Data2.addItem(placeList,dayList);
                }

                //Log.d("aaa",listplace.toString());
                ContactsAdapter adapter = new ContactsAdapter(listSchedule);
                rvContacts.setAdapter(adapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        };

        ref.addListenerForSingleValueEvent(eventListener);
    }


    public static class ContactsAdapter extends
            RecyclerView.Adapter<ShowPlace.ContactsAdapter.ViewHolder> {

        //private static List<Contact> mContacts;
        private static List<Data3> listPlace;
        //private static ArrayList<Contact> dataSend;
        //private static ArrayList<Data2> dataSend;
        public static Context context;

        public static class ViewHolder extends RecyclerView.ViewHolder {

            //private List<Contact> mContacts;
            public TextView namePlace;
            public TextView numberSchedule;
            //public Button messageButton;
            //public RecyclerView recyclerView;
            //public ListPlace listPlace;
            public LinearLayout linearLayout;

            public ViewHolder(View itemView) {

                super(itemView);
                //mContacts = Contact.createContactsList(20);
                //recyclerView = itemView.findViewById(R.id.rvContacts);
                linearLayout = itemView.findViewById(R.id.linePlace);
                //listPlace = new ListPlace(mContacts);
                //recyclerView.setAdapter(listPlace);
                namePlace = itemView.findViewById(R.id.namePlace);
                numberSchedule = itemView.findViewById(R.id.numberSchedule);
                //nameTextView = (TextView) itemView.findViewById(R.id.soNgay);
                //messageButton = (Button) itemView.findViewById(R.id.message_button);
            }
        }




        // Pass in the contact array into the constructor
        public ContactsAdapter(ArrayList<Data3> contacts) {
            listPlace = contacts;
            //dataSend = contacts;
        }


        @Override
        public ShowPlace.ContactsAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            context = parent.getContext();
            LayoutInflater inflater = LayoutInflater.from(context);

            View contactView = inflater.inflate(R.layout.item_number_schedule, parent, false);

            ShowPlace.ContactsAdapter.ViewHolder viewHolder = new ShowPlace.ContactsAdapter.ViewHolder(contactView);
            return viewHolder;
        }

        @Override
        public void onBindViewHolder(ShowPlace.ContactsAdapter.ViewHolder viewHolder, final int position) {

            //ListPlace listPlace;


            //Contact contact = mContacts.get(position);
            //Data2 contact = mContacts.get(position);


            final Data3 value = listPlace.get(position);
            TextView name = viewHolder.namePlace;
            TextView number = viewHolder.numberSchedule;

            name.setText(value.getName());
            number.setText("Lịch trình " + String.valueOf(position + 1) + " ngày");

            //RecyclerView recyclerView = viewHolder.recyclerView;
            //listPlace = new ListPlace(contact.getListItems());
            //recyclerView.setAdapter(listPlace);

            //listPlace = new ListPlace(contact.getListItems());
            //listPlace = new ListPlace(contact.getPlaceItems());
            //recyclerView.setAdapter(listPlace);


            //.setText("Ngày " + String.valueOf(position + 1));


//            viewHolder.linearLayout.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View view) {
//                    Intent intent = new Intent(context,NumberSchedule.class);
//                    Bundle bundle = new Bundle();
//                    intent.putExtra("namePlace",value.getName());
//                    //intent.putExtra("position",position);
//                    context.startActivity(intent);
//                    //Toast.makeText(context,"xxx",Toast.LENGTH_SHORT).show();
//                }
//            });

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
            return listPlace.size();
        }
    }
}
