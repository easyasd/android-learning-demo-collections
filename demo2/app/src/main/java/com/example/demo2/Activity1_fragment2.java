package com.example.demo2;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

public class Activity1_fragment2 extends Fragment {
    public EditText editText;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.activity1_fragment2, container, false);//
        editText=(EditText)v.findViewById(R.id.activity1_fragment2_Edittext2);
        return v;
    }
    @Override
    public void onResume(){
        super.onResume();
       // String ss=getArguments().getSerializable("key7").toString();
       // uiupdata(ss);
    }
    void uiupdata(String ms){
        editText.setText(ms);
    }



}
