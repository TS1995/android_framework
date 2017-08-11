package com.moyou.frameproject.application;

import android.content.Context;

import com.bumptech.glide.Glide;
import com.bumptech.glide.integration.okhttp3.OkHttpUrlLoader;
import com.bumptech.glide.load.model.GlideUrl;
import com.orhanobut.logger.AndroidLogAdapter;
import com.orhanobut.logger.Logger;

import java.io.InputStream;

import okhttp3.OkHttpClient;

/**
 * Created by Administrator on 2017/8/11 0011.
 */

public class MyAppInitSDK {

    public static void initLibrary(Context mContext) {
        //初始化log日志
        Logger.addLogAdapter(new AndroidLogAdapter());
        //初始化glide图片加载
        Glide.get(mContext).register(GlideUrl.class, InputStream.class, new OkHttpUrlLoader.Factory(new OkHttpClient()));
    }
}
