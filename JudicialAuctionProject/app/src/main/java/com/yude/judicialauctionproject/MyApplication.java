package com.yude.judicialauctionproject;

import android.app.Application;

import com.yude.judicialauctionproject.utils.ImageUtil;

/**
 * Created by hexiang on 17/3/5.
 */
public class MyApplication  extends Application{

    @Override
    public void onCreate() {
        super.onCreate();
        //以下只可以选择一个、第一个为系统默认，第二个 是自己定义的
        //ImageUtil.initConfig(getApplicationContext());
        ImageUtil.initConfigdefult(getApplicationContext());
    }





}
