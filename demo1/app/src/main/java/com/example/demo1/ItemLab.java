package com.example.demo1;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class ItemLab {
    private static ItemLab sItemLab;
    private List<Item>mItems;

    public static ItemLab get(Context context){
        if(sItemLab==null){
            sItemLab=new ItemLab(context);
        }
        return sItemLab;
    }

    private ItemLab(Context context){
        mItems=new ArrayList<>();
        for(int i=0;i<100;i++){
            Item item=new Item();
            item.setmTitle("items "+i);
            item.setmSoved(i%2==0);
            mItems.add(item);
        }

    }

    public List<Item>getmItems(){
        return mItems;
    }

    public Item getItem(UUID id){
        for(Item item:mItems){
            if(item.getmId().equals(id)){
                return item;
            }
        }
        return null;
    }



}
