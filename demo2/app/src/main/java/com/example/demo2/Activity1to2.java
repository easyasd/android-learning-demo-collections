package com.example.demo2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class Activity1to2 extends AppCompatActivity {
    private Button button1;
    private EditText editText1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity1to2);
        button1=(Button)findViewById(R.id.activity1_button);
        editText1=(EditText)findViewById(R.id.activity1_edittext);
        button1.setText("Activity1 clicke to Activity2");
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=Activity2to1.newIntent(Activity1to2.this,editText1.getText().toString());
                startActivityForResult(intent,1100);
            }
        });

    }
    @Override
    protected void onActivityResult(int requestCode,int resultCode,Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode != 444) {
            return;
        }
        if (requestCode == 1100) {
            if (data == null) {
                return;
            }
            String text = data.getStringExtra("key2");
            editText1.setText(text);
        }

    }
}
