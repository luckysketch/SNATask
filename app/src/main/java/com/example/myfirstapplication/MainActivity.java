package com.example.myfirstapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.transition.Slide;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ExpandableListView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    ViewPager  viewPager;
    static final int TOTAL_FRAGMENT=3;
    SlidePagerAdaptor pagerAdaptor;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        viewPager=(ViewPager)findViewById(R.id.pager);
        pagerAdaptor=new SlidePagerAdaptor(getSupportFragmentManager());
        viewPager.setAdapter(pagerAdaptor);

    }

    public class SlidePagerAdaptor extends FragmentPagerAdapter{

        public SlidePagerAdaptor(FragmentManager fm){
            super(fm);
        }
        @Override
        public Fragment getItem(int position) {
            if(position==0){
                return new FirstFragment();
            }
            else if(position==1){
                return new SecondFragment();
            }
            else {
                return new ThirdFragment();
            }
        }

        @Override
        public int getCount() {
            return TOTAL_FRAGMENT;
        }
    }
}