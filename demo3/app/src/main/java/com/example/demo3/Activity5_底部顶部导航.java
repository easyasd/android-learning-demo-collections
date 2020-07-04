package com.example.demo3;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.widget.RadioGroup;

import java.util.ArrayList;
import java.util.List;

public class Activity5_底部顶部导航 extends AppCompatActivity {
    /*这个activity实现参考 简书用户：往事烦多
    地址：https://www.baidu.com/link?url=
     CfdJAtzvHIYbkPusFMaD9bKBclcbY7LrlpAotItowsL5Shn5CWtIl-Q313sIalnU&wd=&eqid=b09344d20009bda2000000065f00ae1b
     核心：1.viewPager    2.radioGroup
          3.3个碎片       4. fragmentPagerAdapter对viewPager适配
          5.（viewpager的监听影响到，即滑动）radioGrop的监听(点击底部导航)，进而更改viewpager内选择不同的碎片
          6. selector 点击或者咋的会更改底部导航图片*/
    private ViewPager viewPager;
    private RadioGroup radioGroup;
    private List<Fragment> fragmentList=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_5);

        viewPager=(ViewPager)findViewById(R.id.view_pager);
        radioGroup=(RadioGroup)findViewById(R.id.radio_group);

        ChatFragment chatFragment=new ChatFragment();
        ContactsFragment contactsFragment=new ContactsFragment();
        DiscoveryFragment discoveryFragment=new DiscoveryFragment();
        MeFragment meFragment=new MeFragment();

        fragmentList.add(chatFragment);
        fragmentList.add(contactsFragment);
        fragmentList.add(discoveryFragment);
        fragmentList.add(meFragment);

        viewPager.setAdapter(new Activity5_fragmentPagerAdapter(getSupportFragmentManager(),fragmentList));

        // ViewPager页面切换监听
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                switch (position){
                    case 0:
                        radioGroup.check(R.id.chat);
                        break;
                    case 1:
                        radioGroup.check(R.id.contacts);
                        break;
                    case 2:
                        radioGroup.check(R.id.discovery);
                        break;
                    case 3:
                        radioGroup.check(R.id.me);
                        break;
                    default:
                        break;
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        // RadioGroup选中状态改变监听
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId){
                    case R.id.chat:
                        /**
                         * setCurrentItem第二个参数控制页面切换动画
                         * true:打开/false:关闭
                         */
                        viewPager.setCurrentItem(0);
                        break;
                    case R.id.contacts:
                        viewPager.setCurrentItem(1);
                        break;
                    case R.id.discovery:
                        viewPager.setCurrentItem(2);
                        break;
                    case R.id.me:
                        viewPager.setCurrentItem(3);
                        break;
                    default:
                        break;
                }
            }
        });
    }
}