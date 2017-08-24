package com.moyou.frameproject.activity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import static com.moyou.baselibrary.NetWorkUtils.NO_NET;
import static com.moyou.frameproject.service.ApplicationServe.NET_BROADCAST;
import static com.moyou.frameproject.service.ApplicationServe.NET_KEY;

/**
 * Created by Administrator on 2017/8/24 0024.
 */

public class FatherActivity extends AppCompatActivity {

    private boolean isOnPause;

    private BroadcastReceiver broadcastReceiver;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setNetIncident();
    }

    private void setNetIncident() {
        broadcastReceiver = new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
                int code = intent.getIntExtra(NET_KEY, -1);
                if (code == NO_NET && !isOnPause) {
                    noNet();
                } else if (code != NO_NET && !isOnPause) {
                    okNet();
                }
            }
        };
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(NET_BROADCAST);
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
