package com.example.myfirstapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import soup.neumorphism.NeumorphCardView;
import soup.neumorphism.NeumorphImageButton;

public class Device extends AppCompatActivity {
    int device_no=0;
    FirebaseDatabase database;
    String str;
    NeumorphImageButton lock_btn,back_btn;
    NeumorphCardView fan,bulb,lamp;
    int flag1=0,flag2=0,flag3=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_device);
        Bundle extras=getIntent().getExtras();
        device_no=extras.getInt("device_no");

        lock_btn=findViewById(R.id.device_lock_btn);

        database= FirebaseDatabase.getInstance();
        DatabaseReference myRef=database.getReference().child("devices").child(Integer.toString(device_no))
                .child("lock");

        lock_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myRef.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        str = snapshot.getValue().toString();

                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });
                if(str=="orange"){
                    lock_btn.setColorFilter(Color.GREEN);
                    myRef.setValue("green");
                }
                else if(str=="green"){
                    lock_btn.setColorFilter(Color.GRAY);
                    myRef.setValue("gray");
                }
                else if(str=="gray"){
                    lock_btn.setColorFilter(Color.parseColor("#f0b064"));
                    myRef.setValue("orange");
                }
                else{
                    lock_btn.setColorFilter(Color.parseColor("#f0b064"));
                    myRef.setValue("orange");
                }
            }
        });

        back_btn=findViewById(R.id.device_back_btn);
        back_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        fan=findViewById(R.id.device_fan_btn);
        ImageView img1=findViewById(R.id.fan_ic);
        fan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(flag1==0){
                    img1.setColorFilter(Color.parseColor("#f0b064"));
                    flag1=1;
                }
                else{
                    img1.setColorFilter(Color.GRAY);
                    flag1=0;
                }
            }
        });

        bulb=findViewById(R.id.device_bulb_btn);
        ImageView img2=findViewById(R.id.bulb_ic);
        bulb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(flag2==0){
                    img2.setColorFilter(Color.parseColor("#f0b064"));
                    flag2=1;
                }
                else{
                    img2.setColorFilter(Color.GRAY);
                    flag2=0;
                }
            }
        });
        lamp=findViewById(R.id.device_lamp_btn);
        ImageView img3=findViewById(R.id.lamp_ic);
        lamp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(flag3==0){
                    img3.setColorFilter(Color.parseColor("#f0b064"));
                    flag3=1;
                }
                else{
                    img3.setColorFilter(Color.GRAY);
                    flag3=0;
                }
            }
        });
    }
}