package com.example.demo2;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

public class Activity1_fragment1 extends Fragment implements View.OnClickListener{
    private Button button1;
    private Button button2;
    private EditText editText;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.activity1_fragment1, container, false);//碎片视图
        button1=(Button)v.findViewById(R.id.activity1_fragment1_button1);
        button1.setOnClickListener(this);
        button2=(Button)v.findViewById(R.id.activity1_fragment1_button2);
        button2.setOnClickListener(this);
        editText=(EditText)v.findViewById(R.id.activity1_fragment1_edittext);
        return v;
    }
    @Override
    public  void onClick(View V){
        switch (V.getId()){
            case R.id.activity1_fragment1_button1:
                Intent intent = Activity2.newInstent(getActivity(),editText.getText().toString());
                startActivity(intent);
                break;
            case R.id.activity1_fragment1_button2:
                break;
            default:break;
        }

    }

}
