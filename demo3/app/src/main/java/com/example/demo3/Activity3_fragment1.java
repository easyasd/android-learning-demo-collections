package com.example.demo3;



import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.fragment.app.Fragment;


public class Activity3_fragment1 extends Fragment implements View.OnClickListener {
    private EditText editText;
    private Button button;
    private Callbacks mCallbacks;
    public interface Callbacks{
        void onSelect(String ss);//可以传参
    }
    @Override
    public void onDetach(){
        super.onDetach();
        mCallbacks=null;
    }
    @Override
    public void onAttach(Context context){
        super.onAttach(context);
        mCallbacks=(Callbacks)context;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.activity3_fragment1, container, false);//碎片视图
        editText=(EditText)v.findViewById(R.id.activity3_fragment1_edittext);
        button=(Button)v.findViewById(R.id.activity3_fragment1_button);
        button.setOnClickListener(this);
        return v;
    }
    @Override
    public  void onClick(View V){//点击回调callsback
        mCallbacks.onSelect(editText.getText().toString());
    }



}
