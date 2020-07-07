package com.example.demo4mvvm;

import android.content.Context;
import android.content.res.AssetManager;
import android.util.Log;

import com.example.demo4mvvm.databinding.ListItemSoundBinding;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class BeatBox {
    private static final String TAG="BeatBox";
    private static final String SOUNDS_FOLDER="sample_sounds";
    private AssetManager mAssets;
    private List<Sound> mSounds=new ArrayList<>();

    BeatBox(Context context){
        mAssets=context.getAssets();
        loadSounds();
    }

    private void loadSounds(){
        String[] soundNames;
        try {
            soundNames=mAssets.list(SOUNDS_FOLDER); //读取所有音乐资源名字
            Log.i(TAG,"Found"+soundNames.length+" sounds");
            for (String filename:soundNames){            //修改名字，加上路径，加入mSound;
                String assetPath=SOUNDS_FOLDER+"/"+filename;
                Sound sound=new Sound(assetPath);
                mSounds.add(sound);
            }
        }catch (IOException e){
            Log.e(TAG,"Could not list assets",e);
        }

    }

    public List<Sound> getSounds(){
        return mSounds;
    }

}
