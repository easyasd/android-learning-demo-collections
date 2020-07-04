package com.example.demo2;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class Activity2to1 extends AppCompatActivity {
    private Button button2;
    private EditText editText2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("activity 2","create");
        setContentView(R.layout.activity_activity2to1);
        editText2=(EditText)findViewById(R.id.activity2_edittext);

        Intent intent=getIntent();
        String text=intent.getStringExtra("key1");//获取key对应的键值
        editText2.setText(text);

    }
    public static Intent newIntent(Context packgeContext,String info){
        Intent intent=new Intent(packgeContext,Activity2to1.class);
        intent.putExtra("key1",info);//先key 后info
        return intent;
    }

    @Override
    protected void onStart(){
        super.onStart();
        Log.d("activity2","start");
    }
    @Override
    protected void onResume(){
        super.onResume();
        Log.d("activity2","resume");




    }

    @Override
    protected void onPause(){
        super.onPause();
        Log.d("activity2","pause");


    }
    @Override
    protected void onStop(){
        super.onStop();
        Log.d("activity2","stop");


    }
    @Override
    protected void onDestroy(){
        super.onDestroy();
        Log.d("activity2","destroy");
    }
    protected void onRestart(){
        super.onRestart();
        Log.d("activity2","restart");
    }

    public void onBackPressed(){
        Intent data=new Intent();
        data.putExtra("key2",editText2.getText().toString());
        setResult(444,data);

        super.onBackPressed();

    }

}
