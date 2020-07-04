package com.example.demo1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import java.util.UUID;

public class ItemActivity extends SingleFragmentActivity {
    protected Fragment createFragment(){
        UUID itemid=(UUID)getIntent().getSerializableExtra("itemid");
        return ItemFragment.newInstance(itemid);
    }
    public static Intent newInstance(Context packageContext,UUID ItemId){
        Intent intent=new Intent(packageContext,ItemActivity.class);
        intent.putExtra("itemid",ItemId);
        return intent;
    }

}
