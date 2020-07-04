package com.example.demo3;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;

public class Activity3_单双页 extends AppCompatActivity implements Activity3_fragment1.Callbacks {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_masterdetail);
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragmet_container,new Activity3_fragment1())
                .commit();
    }
    @Override
    public void onSelect(String ss){

        if (findViewById(R.id.detail_fragment_container)==null){
            Intent intent=new Intent(Activity3_单双页.this,Activity3_Activity2.class);
            startActivity(intent);
        }else {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.detail_fragment_container,new Activity3_fragment2())
                    .commit();
        }
    }

}