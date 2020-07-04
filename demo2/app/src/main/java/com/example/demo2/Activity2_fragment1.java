package com.example.demo2;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import androidx.fragment.app.Fragment;

public class Activity2_fragment1 extends Fragment {
    private EditText editText;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.activity2_fragment1, container, false);//碎片视图
        editText=(EditText)v.findViewById(R.id.activity2_fragment1_edittext);
        editText.setText(getActivity().getIntent().getStringExtra("key4"));
        return v;
    }

}
