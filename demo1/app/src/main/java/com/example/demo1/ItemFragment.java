package com.example.demo1;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import androidx.fragment.app.Fragment;
//import androidx.recyclerview.widget.LinearLayoutManager;
//import androidx.recyclerview.widget.RecyclerView;

import java.util.UUID;

public class ItemFragment extends Fragment {
    private Item mitem;
    private EditText mtitle;
    private  EditText mdate;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_item_dital, container, false);//碎片视图
        mtitle=(EditText)v.findViewById(R.id.item_title);
        mdate=(EditText)v.findViewById(R.id.item_data);
        mtitle.setText(mitem.getmTitle());

        return v;
    }

    public  static ItemFragment newInstance(UUID itemid){
        Bundle args=new Bundle();
        args.putSerializable("itemid",itemid);

        ItemFragment fragment =new ItemFragment();
        fragment.setArguments(args);
        return fragment;
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       UUID itemId=(UUID)getArguments().getSerializable("itemid");
        mitem=ItemLab.get(getActivity()).getItem(itemId);
    }
    @Override
    public  void onPause(){
        super.onPause();
        mitem.setmTitle(mtitle.getText().toString());
    }
}
