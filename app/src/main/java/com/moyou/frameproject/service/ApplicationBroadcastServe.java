package com.moyou.frameproject.service;

import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.os.IBinder;
import android.support.annotation.Nullable;

import com.moyou.baselibrary.NetWorkUtils;
import com.moyou.frameproject.application.BaseApplication;

/**
 * Created by Administrator on 2017/8/11 0011.
 * APP广播服务类
 */

public class ApplicationBroadcastServe extends Service {

    //网络广播的action
    public static final String NET_BROADCAST = "NetworkServe";
    //网络广播Intent的key
    public static final String NET_KEY = "netWorkState";

    private BroadcastReceiver receiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            //网络监听广播(注意：因为机型问题有些机型会走2次~)
            if (action.equals(ConnectivityManager.CONNECTIVITY_ACTION)) {
                int code = NetWorkUtils.getAPNType(BaseApplication.getInstance());
                Intent netWorkIntent = new Intent(NET_BROADCAST);
                netWorkIntent.putExtra(NET_KEY, code);
                sendBroadcast(netWorkIntent);
            }
        }
    };

    @Override
    public void onCreate() {
        super.onCreate();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(ConnectivityManager.CONNECTIVITY_ACTION);
        registerReceiver(receiver, intentFilter);
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        unregisterReceiver(receiver);
    }
}
