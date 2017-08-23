package com.moyou.frameproject.application;

import android.app.Application;

/**
 * Created by Administrator on 2017/8/11 0011.
 */

public class BaseApplication extends Application {

    public static BaseApplication instance;

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        MyAppInitSDK.initLibrary(this);
    }

    public static BaseApplication getInstance() {
        return instance;
    }
}
