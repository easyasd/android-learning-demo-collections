package com.example.demo4mvvm;

public class Sound {
    private String mAssetPath;
    private String mName;

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
}
