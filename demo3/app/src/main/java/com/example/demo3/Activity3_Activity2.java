package com.example.demo3;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

public class Activity3_Activity2 extends AppCompatActivity {//该活动用来启动第二个碎片 在activity3_双页手机模式
    //点击Button启动该活动，进而启动fragment2

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity3_activity2);
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.activity3_fragment2,new Activity3_fragment2());
        transaction.commit();
    }
}