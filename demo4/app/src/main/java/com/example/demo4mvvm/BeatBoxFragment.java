package com.example.demo4mvvm;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.demo4mvvm.databinding.FragmentBeatBoxBinding;
import com.example.demo4mvvm.databinding.ListItemSoundBinding;

import java.util.List;

public class BeatBoxFragment extends Fragment {

    private BeatBox mbeatbox;

    public static BeatBoxFragment newInstance(){
        return new BeatBoxFragment();
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle saved) {
        FragmentBeatBoxBinding binding = DataBindingUtil //我们要绑定视图是fragment_beat_box.xml 所以绑定工具名字和xml名字相同，首字母大写
                .inflate(inflater, R.layout.fragment_beat_box, container,false);
        binding.recyclerView.setLayoutManager(new GridLayoutManager(getActivity(),3));
        binding.recyclerView.setAdapter(new SoundAdapter(mbeatbox.getSounds()));

        return binding.getRoot();
    }

    @Override
    public void onCreate(Bundle saved){
        super.onCreate(saved);

        mbeatbox=new BeatBox(getActivity());
    }




    private class SoundHolder extends RecyclerView.ViewHolder{
        private ListItemSoundBinding mBinding;
        private SoundHolder(ListItemSoundBinding binding){
            super(binding.getRoot());
            mBinding=binding;
            mBinding.setViewModel(new SoundViewModel(mbeatbox));
        }

        public void bind(Sound sound){
            mBinding.getViewModel().setSound(sound);
            mBinding.executePendingBindings();
        }

    }

    private class SoundAdapter extends RecyclerView.Adapter<SoundHolder>{
        private List<Sound> mSounds;

        private  SoundAdapter(List<Sound> sounds){
            mSounds=sounds;
        }
        @NonNull
        @Override
        public SoundHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            LayoutInflater inflater=LayoutInflater.from(getActivity());
            ListItemSoundBinding binding=DataBindingUtil.inflate(inflater,R.layout.list_item_sound,parent,false);
            return new SoundHolder(binding);
        }

        @Override
        public void onBindViewHolder(@NonNull SoundHolder holder, int position) {
            Sound sound=mSounds.get(position);
            holder.bind(sound);
        }

        @Override
        public int getItemCount() {
            return mSounds.size();
        }
    }
}
