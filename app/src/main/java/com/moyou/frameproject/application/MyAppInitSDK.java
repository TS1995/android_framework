package com.moyou.frameproject.application;

import android.content.Context;

import com.orhanobut.logger.AndroidLogAdapter;
import com.orhanobut.logger.Logger;

/**
 * Created by Administrator on 2017/8/11 0011.
 */

public class MyAppInitSDK {

    /**
     * 初始化一些第三方
     * @param context
     */
    public static void initLibrary(Context context) {
        Logger.addLogAdapter(new AndroidLogAdapter());
    }
}
