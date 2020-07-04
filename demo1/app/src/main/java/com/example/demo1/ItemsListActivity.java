package com.example.demo1;

import androidx.fragment.app.Fragment;

public class ItemsListActivity extends SingleFragmentActivity {
    @Override
    protected Fragment createFragment(){
        return ItemsListFragment.newInstance();
    }
}
