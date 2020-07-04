package com.example.demo1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import java.util.List;
import java.util.UUID;

public class ItemPagerActivity extends AppCompatActivity {
    private ViewPager mViewPager;
    private List<Item>mItems;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_pager);
        UUID itemid = (UUID) getIntent().getSerializableExtra("itemid"); //1
        mViewPager = (ViewPager) findViewById(R.id.activity_item_view_pager);
        mItems = ItemLab.get(this).getmItems();
        FragmentManager fragmentManager = getSupportFragmentManager();
        mViewPager.setAdapter(new FragmentStatePagerAdapter(fragmentManager) {
            @Override
            public Fragment getItem(int position) {
                Item item = mItems.get(position);
                return ItemFragment.newInstance(item.getmId());
            }
            @Override
            public int getCount() {
                return mItems.size();
            }
        });

        for (int i = 0; i < mItems.size(); i++) {
            if (mItems.get(i).getmId().equals(itemid)) {
                mViewPager.setCurrentItem(i);
                break;
            }
        }
    }

    public static Intent newInstance(Context packageContenxt, UUID itemId){
        Intent intent=new Intent(packageContenxt,ItemPagerActivity.class);
        intent.putExtra("itemid",itemId);
        return intent;
    }
}
