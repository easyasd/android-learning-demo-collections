package com.example.demo3;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.fragment.app.Fragment;

public class Activity3_fragment2 extends Fragment {
    private EditText editText;
    private Button button;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.activity3_fragment2, container, false);//碎片视图
        editText=(EditText)v.findViewById(R.id.activity3_fragment2_edittext);

        return v;
    }

}
