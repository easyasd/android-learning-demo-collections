package com.example.demo1;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import android.widget.TextView;
import android.widget.Toast;
import android.widget.Toolbar;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;


public class ItemsListFragment extends Fragment {
    public Toolbar mToolbar;
    private EditText mEditText;
    private RecyclerView mRecyclerView;
    private ItemAdapter mAdapter;
    public static ItemsListFragment newInstance(){
        return new ItemsListFragment();
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_itemlist_recycler, container, false);//碎片视图

        mRecyclerView=(RecyclerView)v.findViewById(R.id.item_recycler_view);//recycler视图
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        upDateUI();
        return v;
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }


    private  class ItemHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        private TextView mTitleTextView;
        private  TextView mDateTextView;
        private Item mitem;
        public ItemHolder(LayoutInflater inflater , ViewGroup parent){
            super(inflater.inflate(R.layout.fragment_list_xxxcontent,parent,false));//content视图
            itemView.setOnClickListener(this);
            mTitleTextView=(TextView)itemView.findViewById(R.id.item_title_list);
            mDateTextView=(TextView)itemView.findViewById(R.id.item_data_list);
        }

        public void bind(Item item){
            mitem=item;
            mTitleTextView.setText(mitem.getmTitle());
            mDateTextView.setText(mitem.getmData().toString());
        }

        @Override
        public void onClick(View view){
            Toast.makeText(getActivity(),mitem.getmTitle()+"cliced",Toast.LENGTH_LONG).show();
            Intent intent=ItemPagerActivity.newInstance(getActivity(),mitem.getmId());
            startActivity(intent);
        }

    }


    private class ItemAdapter extends RecyclerView.Adapter<ItemHolder>{
        private List<Item>mItems;
        public ItemAdapter(List<Item>items){
            mItems=items;
        }

        @NonNull
        @Override
        public ItemHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            LayoutInflater layoutInflater=LayoutInflater.from(getActivity());
            return new ItemHolder(layoutInflater,parent);
        }

        @Override
        public void onBindViewHolder(@NonNull ItemHolder holder, int position) {
            Item item=mItems.get(position);
            holder.bind(item);

        }

        @Override
        public int getItemCount() {
            return mItems.size();
        }
    }

    private void upDateUI(){
        ItemLab itemLab=ItemLab.get(getActivity());
        List<Item>items=itemLab.getmItems();
        if (mAdapter==null){
        mAdapter=new ItemAdapter(items);
        mRecyclerView.setAdapter(mAdapter);}
        else {mAdapter.notifyDataSetChanged();}
    }

    @Override
    public  void onResume(){
        super.onResume();
        upDateUI();
        Log.d("test","test1");
    }


}
