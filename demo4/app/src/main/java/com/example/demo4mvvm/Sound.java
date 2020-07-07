package com.example.demo4mvvm;

import android.content.Intent;

public class Sound {     //最基本的数据，有路径，名字，id组成
    private String mAssetPath;
    private String mName;
    private Integer mSoundId;

    public Sound(String assetpath){
        mAssetPath=assetpath;
        String[] components=assetpath.split("/");
        String filename=components[components.length-1];
        mName=filename.replace(".wav","");
    }

    public String getAssetPath(){
        return mAssetPath;
    }

    public String getName(){
        return mName;
    }

    public Integer getSoundId(){
        return mSoundId;
    }

    public void setSoundId(Integer soundId){
        mSoundId=soundId;
    }
}
