package com.example.demo2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;

public class Activity2 extends AppCompatActivity {
    private EditText editText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity2_fragment);
        editText=(EditText)findViewById(R.id.activity2_edittext);
       String s= this.getIntent().getStringExtra("key");
       editText.setText(s);

    }
    public static Intent newInstent(Context context,String massage){
        Intent intent=new Intent(context, Activity2.class);
        intent.putExtra("key",massage);
        return intent;
    }
}