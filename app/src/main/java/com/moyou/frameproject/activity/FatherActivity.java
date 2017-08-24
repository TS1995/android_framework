package com.moyou.frameproject.activity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import static com.moyou.baselibrary.NetWorkUtils.NO_NET;
import static com.moyou.frameproject.service.ApplicationBroadcastServe.NET_BROADCAST;
import static com.moyou.frameproject.service.ApplicationBroadcastServe.NET_KEY;

/**
 * Created by Administrator on 2017/8/24 0024.
 * 最基层抽象activity:主要做一些广播处理
 */

public abstract class FatherActivity extends AppCompatActivity {

    private boolean isOnPause;

    private BroadcastReceiver broadcastReceiver;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setNetIncident();
    }

    //注册网络监听广播（接收从ApplicationBroadcastServe发过来的自定义广播）
    //isOnPause 是防止广播在多个页面重复执行 接收广播只在当前显示的页面接收
    private void setNetIncident() {
        broadcastReceiver = new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
                //判断code网络状态：这里只有2种：0或者非0  0=无网络  非0=有网络
                int code = intent.getIntExtra(NET_KEY, -1);
                //收到断网的广播 立刻执行noNet函数
                if (code == NO_NET && !isOnPause) {
                    noNet();
                }
                //收到网络连接成功的广播 立刻执行okNet函数
                else if (code != NO_NET && !isOnPause) {
                    okNet();
                }
            }
        };
        //接收广播的动作NET_BROADCAST——对应的代码:如下
        // ApplicationBroadcastServe类里面的: Intent netWorkIntent = new Intent(NET_BROADCAST);
        IntentFilter intentFilter = new IntentFilter();
        //指定接收的Action
        intentFilter.addAction(NET_BROADCAST);
        //注册广播
        registerReceiver(broadcastReceiver, intentFilter);
    }

    protected void noNet() {
    }

    protected void okNet() {

    }

    @Override
    protected void onResume() {
        super.onResume();
        isOnPause = false;
    }

    @Override
    protected void onPause() {
        super.onPause();
        isOnPause = true;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(broadcastReceiver);
    }
}
