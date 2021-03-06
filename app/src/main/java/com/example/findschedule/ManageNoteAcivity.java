package com.example.findschedule;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

public class ManageNoteAcivity extends AppCompatActivity {

    private TabLayout tabLayout;
    private ViewPager viewPager;

    String idNote;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        tabLayout = findViewById(R.id.tablayout);
        viewPager = findViewById(R.id.viewpager);

        Intent intent = getIntent();
        idNote = intent.getStringExtra("id");

        ViewPageAdapter viewPageAdapter = new ViewPageAdapter(getSupportFragmentManager());

        FragmentQuy quyFragment = new FragmentQuy();
        Bundle bundle = new Bundle();
        bundle.putString("id", idNote);
        quyFragment.setArguments(bundle);
        quyFragment.setContext(this);

        FragmentMua mua = new FragmentMua();
        mua.setArguments(bundle);
        mua.setContext(this);

        final FragmentTong tong = new FragmentTong();
        tong.setArguments(bundle);
        tong.setContext(this);

        viewPageAdapter.addFragment(quyFragment, "Quỹ");
        viewPageAdapter.addFragment(mua, "Chi tiêu");
        viewPageAdapter.addFragment(tong, "Tính tiền");

        viewPager.setAdapter(viewPageAdapter);
        tabLayout.setupWithViewPager(viewPager);

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {

                if (tab.getPosition() == 2) {
                    if(tong.view != null) {
                        tong.onResume();
                    }

                }

            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });


    }
}
