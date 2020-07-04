package com.example.demo3;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import androidx.fragment.app.Fragment;

public class Activity4_item1_fragment extends Fragment {
    EditText editText;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.activity4_item1_fragment, container, false);//碎片视图
        editText=(EditText)v.findViewById(R.id.activity4_item1_edittext);
        editText.setText("item1");
        return v;
    }


}
