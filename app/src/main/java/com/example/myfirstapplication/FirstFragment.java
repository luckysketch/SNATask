package com.example.myfirstapplication;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import soup.neumorphism.NeumorphImageButton;


public class FirstFragment extends Fragment {

    NeumorphImageButton lock_btn,btn1,btn2,btn3,btn4,btn5,btn6,btn7,btn8;
    FunctionContainer functionContainer;
    RelativeLayout relativeLayout;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_first, container, false);
        functionContainer=new FunctionContainer(0);
      //  functionContainer.setInitialValues();
        lock_btn=view.findViewById(R.id.frg1_lock);
        lock_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                functionContainer.onLockButtonClicked(lock_btn);

            }
        });
        btn1=view.findViewById(R.id.frg1_btn1);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                functionContainer.onSqureButtonClicked(btn1,0);
            }
        });
        btn2=view.findViewById(R.id.frg1_btn2);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                functionContainer.onSqureButtonClicked(btn2,1);
            }
        });
        btn3=view.findViewById(R.id.frg1_btn3);
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                functionContainer.onSqureButtonClicked(btn3,2);
            }
        });
        btn4=view.findViewById(R.id.frg1_btn4);
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                functionContainer.onSqureButtonClicked(btn4,3);
            }
        });
        btn5=view.findViewById(R.id.frg1_btn5);
        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                functionContainer.onSqureButtonClicked(btn5,4);
            }
        });
        btn6=view.findViewById(R.id.frg1_btn6);
        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                functionContainer.onSqureButtonClicked(btn6,5);
            }
        });
        btn7=view.findViewById(R.id.frg1_btn7);
        btn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                functionContainer.onSqureButtonClicked(btn7,6);
            }
        });
        btn8=view.findViewById(R.id.frg1_btn8);
        btn8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                functionContainer.onSqureButtonClicked(btn8,7);
            }
        });

        relativeLayout=view.findViewById(R.id.device0);
        relativeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getActivity(),Device.class);
                intent.putExtra("device_no",0);
                startActivity(intent);
            }
        });

        //setting intial color form the database
      /*  functionContainer.setInitialLockColor(lock_btn);
        functionContainer.setInitialSquareBtnColor(btn1,0);
        functionContainer.setInitialSquareBtnColor(btn2,1);
        functionContainer.setInitialSquareBtnColor(btn3,2);
        functionContainer.setInitialSquareBtnColor(btn4,3);
        functionContainer.setInitialSquareBtnColor(btn5,4);
        functionContainer.setInitialSquareBtnColor(btn6,5);
        functionContainer.setInitialSquareBtnColor(btn7,6);
        functionContainer.setInitialSquareBtnColor(btn8,7);*/


        return view;

    }
}