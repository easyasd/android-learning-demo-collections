package com.example.demo3;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import androidx.fragment.app.Fragment;

public class Activity4_item2_fragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.activity4_item2_fragment, container, false);//碎片视图
        EditText editText=(EditText)v.findViewById(R.id.activity4_item2_edittext);
        editText.setText("item2");
        return v;
    }
}
