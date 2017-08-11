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

    /**
     * 初始化一些第三方
     *
     * @param mContext
     */
    public static void initLibrary(Context mContext) {
        Logger.addLogAdapter(new AndroidLogAdapter());
        Glide.get(mContext).register(GlideUrl.class, InputStream.class, new OkHttpUrlLoader.Factory(new OkHttpClient()));
    }
}
