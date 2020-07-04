package com.example.demo1;

import java.util.UUID;
import java.util.Date;
public class Item {
    public boolean ismSoved() {
        return mSoved;
    }

    public void setmSoved(boolean mSoved) {
        this.mSoved = mSoved;
    }

    public Date getmData() {
        return mData;
    }

    public void setmData(Date mData) {
        this.mData = mData;
    }

    public UUID getmId() {
        return mId;
    }

    public void setmId(UUID mId) {
        this.mId = mId;
    }

    private UUID mId;

    public String getmTitle() {
        return mTitle;
    }

    public void setmTitle(String mTitle) {
        this.mTitle = mTitle;
    }

    private String mTitle;
    private  Date mData;
    private boolean mSoved;

    public Item(){
        mId=UUID.randomUUID();
        mData=new Date();
    }
}
