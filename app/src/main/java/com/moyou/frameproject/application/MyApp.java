package com.moyou.frameproject.application;

import android.app.Application;

/**
 * Created by Administrator on 2017/8/11 0011.
 */

public class MyApp extends Application {

    public static MyApp instance;

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        MyAppInitSDK.initLibrary(this);
    }

    public static MyApp getInstance() {
        return instance;
    }
}
