package com.example.findschedule;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomSheetBehavior;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;


public class MainChiPhi extends AppCompatActivity {

    Spinner spinnerDS_xe;
    ImageButton back_btn;
    ImageButton menu_btn;
    ImageButton swap_btn;
    Button search_btn;
    EditText ddi;
    EditText dden;
    LinearLayout bottomsheet;
    BottomSheetBehavior bottomSheetBehavior;
    Context context;
    ListView lv;
    ListView ad;
    final ArrayList<Data2> placeList = new ArrayList<Data2>();
    private ArrayList<Data2> dataReceive;





    //final ArrayList<diadiem> placeList2 = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_chi_phi);

        Intent intent = this.getIntent();

        dataReceive = new ArrayList<Data2>();
        dataReceive = (ArrayList<Data2>)intent.getSerializableExtra("ChiPhi");

        Log.d("testne","xxx");

        Log.d("mangsand",dataReceive.get(0).getPlaceItems().get(0).getAteMoney());

//        back_btn  = (ImageButton) findViewById(R.id.backbtn);
//        back_btn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//            }
//        });
//
//        menu_btn = (ImageButton) findViewById(R.id.thacmac);
//        menu_btn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                AlertDialog.Builder mBuilder = new AlertDialog.Builder(MainChiPhi.this);
//                View mV = getLayoutInflater().inflate(R.layout.help_alert,null);
//                mBuilder.setView(mV);
//                AlertDialog dialog = mBuilder.create();
//                dialog.show();
//            }
//        });
//
//        ad = findViewById(R.id.place);
//        lv = findViewById(R.id.date_lt);
//        // Chọn 1 lịch trình cho 1 địa điểm bất kỳ, vd Da Nang
//        read(ad, lv, "Đà Nẵng");

        /*swap_btn = (ImageButton) findViewById(R.id.swap_tex);
        ddi = (EditText)  findViewById(R.id.di);
        dden = (EditText)  findViewById(R.id.den);
        swap_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String sw = ddi.getText().toString();
                ddi.setText(dden.getText().toString());
                dden.setText(sw);
            }
        });*/


        // Hiển thị danh sách lựa chọn phương tiện di chuyển


        /*SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();

        bottomsheet = (LinearLayout) findViewById(R.id.bottom_sheet);
        bottomSheetBehavior = BottomSheetBehavior.from(bottomsheet);*/

        /*ad = findViewById(R.id.place);
        lv = findViewById(R.id.date_lt);
        lv.setOnScrollListener(new AbsListView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(AbsListView view, int scrollState) {
                bottomSheetBehavior.setState(BottomSheetBehavior.STATE_EXPANDED);
            }

            @Override
            public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {

            }
        });*/

    }

    /*public void onClick (View v){
        if(v.getId() == R.id.search_but){
            String destination_location = dden.getText().toString();
            String original_location = ddi.getText().toString();
            List<Address> addressList = null;
            Geocoder geocoder = new Geocoder(this, Locale.getDefault());
            if (destination_location != null || !destination_location.equals("")) {

                try {
                    addressList = geocoder.getFromLocationName(destination_location, 1);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                Address address = addressList.get(0);
                LatLng de = new LatLng(address.getLatitude(), address.getLongitude());
                map.addMarker(new MarkerOptions().position(de));
                map.animateCamera(CameraUpdateFactory.newLatLng(de));
            }
        }
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        map = googleMap;
        //map.getUiSettings().setZoomControlsEnabled(true);
        LatLng first_location = new LatLng(10.880542, 106.805486);
        map.moveCamera(CameraUpdateFactory.newLatLngZoom(first_location,12));
    }*/

//    public class placeAdapter extends ArrayAdapter<diadiem> {
//        private Context context;
//        private int resource;
//        private List<diadiem> placelist;
//
//        public placeAdapter( Context context, int resource, List<diadiem> objects) {
//            super(context, resource, objects);
//            this.context = context;
//            this.resource = resource;
//            this.placelist = objects;
//        }
//
//        @Override
//        public View getView(int position, View convertView, ViewGroup parent) {
//            convertView =  LayoutInflater.from(context).inflate(R.layout.row_item_lo, parent, false);
//            TextView dd_t = (TextView) convertView.findViewById(R.id.diadiem_t);
//            TextView day = convertView.findViewById(R.id.date_ht);
//            TextView cp_an = convertView.findViewById(R.id.chi_phi_an_uong);
//            TextView cp_cong = convertView.findViewById(R.id.chi_phi_vao_cong);
//            TextView cp_o = convertView.findViewById(R.id.chi_phi_noi_o);
//            diadiem diadiem_name = placelist.get(position);
//            dd_t.setText(diadiem_name.getName());
//            day.setText(diadiem_name.getDate());
//            cp_an.setText(diadiem_name.getAte());
//            cp_cong.setText(diadiem_name.getGate());
//            cp_o.setText(diadiem_name.getHome());
//            return convertView;
//        }
//    }
//
//    public class dateAdapter extends ArrayAdapter<diadiem>{
//        private Context context;
//        private int resource;
//        private List<diadiem> placelist;
//
//        public dateAdapter( Context context, int resource, List<diadiem> objects) {
//            super(context, resource, objects);
//            this.context = context;
//            this.resource = resource;
//            this.placelist = objects;
//        }
//
//        @Override
//        public View getView(int position, View convertView, ViewGroup parent) {
//            convertView =  LayoutInflater.from(context).inflate(R.layout.row_item_location_price, parent, false);
//            TextView date = convertView.findViewById(R.id.ngay);
//            diadiem diadiem_date = placelist.get(position);
//            date.setText(diadiem_date.getDate());
//            return convertView;
//        }
//    }
//
//    public void read(ListView ad, ListView lv, String place_l){
//
//        placeAdapter padapter = new placeAdapter(this,R.layout.row_item_lo,placeList);
//        //dateAdapter dadapter = new dateAdapter(this,R.layout.row_item_location_price,placeList2);
////        FirebaseDatabase mDatebase = FirebaseDatabase.getInstance();
////        DatabaseReference mReferencePlace = mDatebase.getReference("Place");
////
////
////        DatabaseReference placeRef;
////
////        for (int i = 1; i <= (int) 10; i++){
////            final int[] count = {0};
////            final int getdate = i;
////            placeRef = mReferencePlace.child(place_l).child("Ngày " + i);
////            ValueEventListener changeListener = new ValueEventListener() {
////                @Override
////                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
////                    if (!dataSnapshot.hasChildren())
////                        return;
////
////                    for (DataSnapshot ds : dataSnapshot.getChildren()){
////                        diadiem pl = new diadiem();
////                        if (count[0] == 0)
////                            pl.setDate("Ngày " + getdate + ":");
////                        pl.setImage(ds.child("Image").getValue(String.class));
////                        pl.setName(ds.child("name").getValue(String.class));
////                        pl.setAte(ds.child("AteMoney").getValue(String.class));
////                        pl.setGate(ds.child("GateMoney").getValue(String.class));
////                        pl.setHome(ds.child("RestMoney").getValue(String.class));
////                        placeList.add(pl);
////                        count[0] = count[0] + 1;
////                    }
////                }
////
////                @Override
////                public void onCancelled(@NonNull DatabaseError databaseError) {
////
////                }
////            };
////            placeRef.addValueEventListener(changeListener);
////
//////            diadiem da = new diadiem();
//////            da.setDate("Ngày " + i);
//////            placeList2.add(da);
////
////            //ad.setAdapter(padapter);
////            lv.setAdapter(padapter);
////
////        }
//        lv.setAdapter(padapter);
//    }

}
