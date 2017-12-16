package com.nyy.weatherapp;

import android.app.Application;

import com.avos.avoscloud.AVAnalytics;
import com.avos.avoscloud.AVOSCloud;


/**
 * Created by niyuanyuan on 2017/12/14.
 */

public class MyLeanCloudApp extends Application {
    @Override
    public void onCreate(){
      super.onCreate();
        //启用北美节点,默认已经用了大陆节点
    //    AVOSCloud.useAVCloudUS();

        //初始化参数依次this,APPId,AppKey
        AVOSCloud.initialize(this,"PERiOIG21hei7nyYcD5lSReS-gzGzoHsz","EfU0SpXgzLBBOL3Rlbkaz754");
        AVOSCloud.setDebugLogEnabled(true); //开启调试日志，应用发布之前要关闭
        AVAnalytics.enableCrashReport(this,true);
    }
}
