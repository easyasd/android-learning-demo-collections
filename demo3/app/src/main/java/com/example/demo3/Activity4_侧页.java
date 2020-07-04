package com.example.demo3;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.Menu;
import android.view.inputmethod.InputMethodManager;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.core.view.GravityCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class Activity4_侧页 extends AppCompatActivity {
    DrawerLayout drawer;
    NavigationView navigationView;
    Activity4_item1_fragment fragment_item1;
    Activity4_item2_fragment fragment_item2;
    Activity4_item3_fragment fragment_item3;
    Fragment fragment1,fragment2; //1是现在 2是之后 作比较
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_4);
        drawer = findViewById(R.id.drawer_layout);  // 在布局activity_4总布局名
        navigationView= findViewById(R.id.nav_view);  //布局activity_4内侧页总名
        navigationView.setCheckedItem(R.id.nav_item1);
        Toolbar toolbar = findViewById(R.id.toolbar);

        fragment_item1 = new Activity4_item1_fragment();//初始化 使打开该activity时有个碎片显示
        fragment1=fragment_item1;
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.nav_host_fragment,fragment_item1);
        transaction.commit();

        setSupportActionBar(toolbar);                       //工具栏 在布局app_bar_main中
        ActionBar actionBar=getSupportActionBar();
        if (actionBar!=null){
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setHomeAsUpIndicator(R.drawable.ic_menu_camera);
        }

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()){
                    case R.id.nav_item1:
                        switchContent(R.id.nav_item1);
                        break;
                    case R.id.nav_item2:
                       switchContent(R.id.nav_item2);
                        break;
                    case R.id.nav_item3:
                       switchContent(R.id.nav_item3);
                       break;
                }
                return true;
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.activity4, menu); //munu文件夹下的activity4.xml 右边三点选择
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem menuItem){
        switch (menuItem.getItemId()) {
            case android.R.id.home:
                drawer.openDrawer(GravityCompat.START);
                break;
            case R.id.action_settings:
                Toast.makeText(Activity4_侧页.this,"you just clicled settings",Toast.LENGTH_SHORT).show();
            default:break;
        }
      return true;
    }


    @Override
    public void onBackPressed() {
        if(drawer.isDrawerOpen(GravityCompat.START)){
            drawer.closeDrawer(GravityCompat.START);
        }else {
            super.onBackPressed();
        }
    }


    public void switchContent(int id) { //
        if (id== R.id.nav_item1) {
            if (fragment_item1 == null) {
                fragment_item1 = new Activity4_item1_fragment();
            }
            fragment2 = fragment_item1;
        } else if (id== R.id.nav_item2) {
            if (fragment_item2 == null) {
                fragment_item2 = new Activity4_item2_fragment();
            }
            fragment2 = fragment_item2;
        } else if (id == R.id.nav_item3) {
            if (fragment_item3 == null) {
                fragment_item3 = new Activity4_item3_fragment();
            }
            fragment2 = fragment_item3;
        }
        AddandConpare();

    }


    public void AddandConpare(){
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        if (fragment1!= fragment2) {//现在1和之后2是否一样 一样不管
            if (!fragment2.isAdded()) {//以后2是否被添加过 没被添加
                transaction.hide(fragment1)
                           .add(R.id.nav_host_fragment, fragment2)
                           .commitAllowingStateLoss();
            } else { //添加过
                transaction
                        .hide(fragment1)
                        .show(fragment2)
                        .commitAllowingStateLoss();
            }
            fragment1 = fragment2;//以后的变成现在的
            closeKeybord(Activity4_侧页.this);//键盘弹出控制
        }
        drawer.closeDrawer(GravityCompat.START);

    }

    public void testOnClick(View v){
        Toast.makeText(Activity4_侧页.this,"you just clicled the nav_head image",Toast.LENGTH_SHORT).show();
    }

    /**
     * 自动关闭软键盘
     * @param activity
     */
    public static void closeKeybord(Activity activity) {
        InputMethodManager imm =  (InputMethodManager)activity.getSystemService(Context.INPUT_METHOD_SERVICE);
        if(imm != null) {
            imm.hideSoftInputFromWindow(activity.getWindow().getDecorView().getWindowToken(), 0);
        }
    }

    /**
     * 打开关闭相互切换
     * @param activity
     */
    public static void hideKeyboard(Activity activity) {
        InputMethodManager imm = (InputMethodManager) activity.getSystemService(Context.INPUT_METHOD_SERVICE);
        if (imm.isActive()) {
            if (activity.getCurrentFocus().getWindowToken() != null) {
                imm.hideSoftInputFromWindow(activity.getCurrentFocus().getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
            }
        }
    }

}

