package com.example.demo5;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.litepal.LitePal;

public class LitePalActivity extends AppCompatActivity implements View.OnClickListener {
    Button adddata;
    Button createDatabase;
    TextView showtext;
    EditText editText_id;
    EditText editText_name;
    EditText editText_number;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        createDatabase=(Button)findViewById(R.id.createdatabase);  //创建数据库
        showtext=(TextView)findViewById(R.id.showinfotextview);    //展示数据库数据
        adddata=(Button)findViewById(R.id.adddata);                //添加数据
        editText_id=(EditText)findViewById(R.id.edittext_id);            //数据添加的地方 id
        editText_name=(EditText)findViewById(R.id.edittext_name);        //name
        editText_number=(EditText)findViewById(R.id.edittext_number);


        createDatabase.setOnClickListener(this);
        adddata.setOnClickListener(this);


    }
    @Override
    public  void onClick(View V){
        switch (V.getId()){
            case R.id.createdatabase:
                LitePal.getDatabase();                      //生成一个数据库
                showtext.setText("成功创建数据库");
                break;
            case R.id.adddata:
                litepal_table1 table1 =new litepal_table1();
                    table1.setId(editText_id.getText().toString());                   //添加数据
                    table1.setName(editText_name.getText().toString());
                    table1.setNumber(editText_number.getText().toString());
                    table1.save();
                    editText_number.setText("");
                    editText_name.setText("");
                    editText_id.setText("");
                    showtext.setText("导入数据库成功");
                break;
            default:break;
        }

    }
}