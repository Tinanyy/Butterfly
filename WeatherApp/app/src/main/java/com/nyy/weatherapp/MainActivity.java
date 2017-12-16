package com.nyy.weatherapp;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.avos.avoscloud.AVException;
import com.avos.avoscloud.AVObject;
import com.avos.avoscloud.SaveCallback;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private ViewPager mViewPager;
    private FragmentPagerAdapter mAdapter;
    private List<Fragment> mFrangments = new ArrayList<Fragment>();
    private List<AVObject>mList =new ArrayList<>();


    private TextView tabWeather;
    private TextView tabFriends;
    private TextView tabDaily;
    private TextView tabProfile;    //底部四个按钮

    private MainTab01 tab1;
    private MainTab02 tab2;
    private MainTab03 tab3;
    private MainTab04 tab4;   //四个tab

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
      //  AVOSCloud.initialize(this,"PERiOIG21hei7nyYcD5lSReS-gzGzoHsz","EfU0SpXgzLBBOL3Rlbkaz754");
        //测试SDK是否正常工作

         AVObject testObject=new AVObject("TestObject");
         testObject.put("words","hello world");

        testObject.saveInBackground(new SaveCallback() {
            @Override
            public void done(AVException e) {
                if(e==null){
                    Log.d("saved","success");
                }
            }
        });

        initView();
        initEvent();


    }

    //清除掉所有的选中状态
    public void reset() {
        tabWeather.setTextColor(Color.parseColor("#AEADAD"));
        tabFriends.setTextColor(Color.parseColor("#AEADAD"));
        tabDaily.setTextColor(Color.parseColor("#AEADAD"));
        tabProfile.setTextColor(Color.parseColor("#AEADAD"));
    }

    private void initView() {

        mViewPager = (ViewPager) findViewById(R.id.container);


        tabWeather = (TextView) this.findViewById(R.id.txt_weather);
        tabFriends = (TextView) this.findViewById(R.id.txt_friends);
        tabDaily = (TextView) this.findViewById(R.id.txt_daily);
        tabProfile = (TextView) this.findViewById(R.id.txt_profile);

        tab1 = new MainTab01();
        tab2 = new MainTab02();
        tab3 = new MainTab03();
        tab4 = new MainTab04();

        mFrangments.add(tab1);
        mFrangments.add(tab2);
        mFrangments.add(tab3);
        mFrangments.add(tab4);



        mAdapter = new FragmentPagerAdapter(getSupportFragmentManager()) {

            @Override
            public int getCount() {
                return mFrangments.size();
            }

            @Override
            public Fragment getItem(int arg0) {
                return mFrangments.get(arg0);
            }
        };

        mViewPager.setAdapter(mAdapter);

    }

    private void initEvent(){

        tabWeather.setOnClickListener(this);
        tabFriends.setOnClickListener(this);
        tabDaily.setOnClickListener(this);
        tabProfile.setOnClickListener(this);


        mViewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener()

        {
            @Override
            public void onPageSelected(int arg0) {

                //当前选中的fragment下标
                int currentItem=mViewPager.getCurrentItem();
                reset();
                switch (currentItem) {
                    case 0:
                        tabWeather.setTextColor(Color.parseColor("#68CECE"));
                        break;
                    case 1:
                        tabFriends.setTextColor(Color.parseColor("#68CECE"));
                        break;
                    case 2:
                        tabDaily.setTextColor(Color.parseColor("#68CECE"));
                        break;
                    case 3:
                        tabProfile.setTextColor(Color.parseColor("#68CECE"));
                        break;
                    default:
                        break;

                }

            }

            @Override
            public void onPageScrolled(int arg0, float arg1, int arg2) {

            }

            @Override
            public void onPageScrollStateChanged(int arg0) {

            }
        });

    }



    @Override
    public void onClick(View v) {
         reset();
        switch (v.getId()) {
            case R.id.txt_weather:
                setTabSelected(0);
                break;
            case R.id.txt_friends:
                setTabSelected(1);
                break;
            case R.id.txt_daily:
                setTabSelected(2);
                break;
            case R.id.txt_profile:
                setTabSelected(3);
                break;
            default:
                break;
        }
    }


    //根据传入的参数来设置选项中的tab页

    private void setTabSelected(int i) {

        switch (i) {
            case 0:
                    tabWeather.setTextColor(Color.parseColor("#68CECE"));
                break;
            case 1:
                tabFriends.setTextColor(Color.parseColor("#68CECE"));
                break;
            case 2:
                tabDaily.setTextColor(Color.parseColor("#68CECE"));
                break;
            case 3:
                tabProfile.setTextColor(Color.parseColor("#68CECE"));
                break;
            default:
                break;
        }
        mViewPager.setCurrentItem(i);  //切换fragment
    }

}

