package com.example.myfirstapplication;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.appcompat.content.res.AppCompatResources;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import soup.neumorphism.NeumorphImageButton;
//this class is created to bundle all data retrieval function at one place
public class FunctionContainer {
    int fragment_no;
    String str;
    FirebaseDatabase database;

    public FunctionContainer(int fragment_no) {
        this.fragment_no = fragment_no;
    }

    public void onLockButtonClicked(NeumorphImageButton imageButton){
        database=FirebaseDatabase.getInstance();
        DatabaseReference myRef=database.getReference().child("devices").child(Integer.toString(fragment_no)).child("lock");
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                str=snapshot.getValue().toString();
                Log.w("my app","this is the data : "+str);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        if(str=="orange"){
            imageButton.setColorFilter(Color.GREEN);
            myRef.setValue("green");
        }
        else if(str=="green"){
            imageButton.setColorFilter(Color.GRAY);
            myRef.setValue("gray");
        }
        else if(str=="gray"){
            imageButton.setColorFilter(Color.parseColor("#f0b064"));
            myRef.setValue("orange");
        }
        else{
            imageButton.setColorFilter(Color.GRAY);
            myRef.setValue("gray");
        }
    }

    public void onSqureButtonClicked(NeumorphImageButton imageButton,int btn_no){
        database=FirebaseDatabase.getInstance();
        DatabaseReference ref=database.getReference().child("devices").child(Integer.toString(fragment_no))
                .child("switches").child(Integer.toString(btn_no)).child("state");
        ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                str = snapshot.getValue().toString();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        if(str=="0"){
            // imageButton.setShapeType(R.styleable.NeumorphImageButton_neumorph_shapeType);
            imageButton.setColorFilter(Color.parseColor("#f0b064"));
            ref.setValue("1");
        }
        else if(str=="1"){
            imageButton.setColorFilter(Color.GRAY);
            ref.setValue("0");
        }
        else{
            imageButton.setColorFilter(Color.GRAY);
            ref.setValue("0");
        }
        Log.w("my app","this is the data : "+str);


    }
    public void setInitialValues(){
        int i,k;
        database=FirebaseDatabase.getInstance();
        DatabaseReference ref=database.getReference().child("devices");
        for(i=0;i<3;i++){
            DatabaseReference temp_ref=ref.child(Integer.toString(i));
            temp_ref.child("lock").setValue("gray");
            DatabaseReference temp_ref2=temp_ref.child("switches");
            for(k=0;k<8;k++){
                temp_ref2.child(Integer.toString(k)).child("state").setValue("0");
            }
        }
    }
    public void setInitialLockColor(NeumorphImageButton imageButton){
        database=FirebaseDatabase.getInstance();
        DatabaseReference myRef=database.getReference().child("devices").child(Integer.toString(fragment_no)).child("lock");
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                str=snapshot.getValue().toString();
                Log.w("my app","this is the data : "+str);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        if(str=="orange"){
            imageButton.setColorFilter(Color.parseColor("#f0b064"));
        }
        else if(str=="green"){
            imageButton.setColorFilter(Color.GREEN);
        }
        else if(str=="Gray"){
            imageButton.setColorFilter(Color.GRAY);
        }
    }
    public void setInitialSquareBtnColor(NeumorphImageButton imageButton,int btn_no){
        database=FirebaseDatabase.getInstance();
        DatabaseReference ref=database.getReference().child("devices").child(Integer.toString(fragment_no))
                .child("switches").child(Integer.toString(btn_no)).child("state");
        ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                str = snapshot.getValue().toString();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        if(str=="0"){


            imageButton.setColorFilter(Color.GRAY);


        }
        else {
            imageButton.setColorFilter(Color.parseColor("#f0b064"));
        }
        Log.w("my app","this is the color : "+str);
    }
}
