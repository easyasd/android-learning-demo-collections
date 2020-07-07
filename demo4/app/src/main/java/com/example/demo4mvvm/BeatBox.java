package com.example.demo4mvvm;

import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.content.res.AssetManager;
import android.media.AudioManager;
import android.media.SoundPool;
import android.util.Log;

import com.example.demo4mvvm.databinding.ListItemSoundBinding;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class BeatBox { //负责从assets找到资源，修改名字，加载音乐，赋值id，再放入LIst<Sounds>内，播放pool音乐

    private static final String TAG="BeatBox";
    private static final String SOUNDS_FOLDER="sample_sounds";
    private static final int MAX_SOUNDS=5;

    private AssetManager mAssets;
    private List<Sound> mSounds=new ArrayList<>();
    private SoundPool mSoundPool;


    BeatBox(Context context){
        mAssets=context.getAssets();
        mSoundPool=new SoundPool(MAX_SOUNDS, AudioManager.STREAM_MUSIC,0);
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
                load(sound); //加入pool,写上id
                mSounds.add(sound);
            }
        }catch (IOException e){
            Log.e(TAG,"Could not list assets",e);
        }

    }

    public void load(Sound sound) throws IOException{//加入pool,写上id
        AssetFileDescriptor adf=mAssets.openFd(sound.getAssetPath());
        int soundId=mSoundPool.load(adf,1);
        sound.setSoundId(soundId);
    }

    public List<Sound> getSounds(){
        return mSounds;
    }

    public void play(Sound sound){
        Integer soundId=sound.getSoundId();
        if (soundId==null)
            return;
        mSoundPool.play(soundId,1.0f,1.0f,1,0,1.0f);
    }

    public void release(){
        mSoundPool.release();
    }

}
