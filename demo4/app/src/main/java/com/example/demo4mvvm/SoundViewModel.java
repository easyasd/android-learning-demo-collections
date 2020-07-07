package com.example.demo4mvvm;

import androidx.databinding.BaseObservable;

public class SoundViewModel extends BaseObservable {
    private Sound msound;
    private BeatBox mbeatbox;

    public SoundViewModel(BeatBox beatBox){
        mbeatbox=beatBox;
    }

    public String getTitle(){
        return msound.getName();
    }

    public Sound getMsound(){
        return msound;
    }

    public void setSound(Sound sound){
        msound=sound;
        notifyChange();//p331
    }
}
