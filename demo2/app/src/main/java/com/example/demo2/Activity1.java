package com.example.demo2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Activity1 extends FragmentActivity implements View.OnClickListener {
    int flag=1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity1_fragment);
        Button button = (Button) findViewById(R.id.activity1_fragment2_button);
        button.setOnClickListener(this);
        replaceFragment(new Activity1_fragment1());
    }
        @Override
        public  void onClick(View V){
        flag++;
            switch (flag%2){
                case 0:
                    replaceFragment(new Activity1_fragment3());
                    break;
                case 1:replaceFragment(new Activity1_fragment1());
                default:break;
            }
    }
        private  void replaceFragment(Fragment fragment){  //动态添加fragment
        FragmentManager fragmentManager=getSupportFragmentManager();
        FragmentTransaction transaction=fragmentManager.beginTransaction();
        transaction.replace(R.id.fragment1_1,fragment);
        transaction.commit();
    }

}