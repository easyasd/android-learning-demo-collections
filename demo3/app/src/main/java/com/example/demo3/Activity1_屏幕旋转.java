package com.example.demo3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

public class Activity1_屏幕旋转 extends AppCompatActivity {
    private EditText editText;
    private TextView textView;
    private String savekey="savekey";
    private String saveinfo=""; //
    //如果是fragment旋转，要想完全保留fragment存活，在fragment的onCreate()内加上setRetainInstance(false);
    //屏幕旋转还没写完，有一点应该考虑，旋转后是否更换布局。
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity1);
        if (savedInstanceState!=null)
            saveinfo=savedInstanceState.getString(savekey);
        editText=(EditText)findViewById(R.id.activity1_edittext);
        textView=(TextView)findViewById(R.id.activity1_text);
        textView.setText(saveinfo);
    }
    @Override
    public void onSaveInstanceState(Bundle saveinfo){
        super.onSaveInstanceState(saveinfo);
        saveinfo.putString(savekey,editText.getText().toString());
    }
}