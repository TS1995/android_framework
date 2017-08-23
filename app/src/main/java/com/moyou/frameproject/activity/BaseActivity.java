package com.moyou.frameproject.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.moyou.baselibrary.AppManager;

import org.greenrobot.eventbus.EventBus;

import butterknife.ButterKnife;

/**
 * Created by Administrator on 2017/8/11 0011.
 */

public abstract class BaseActivity extends AppCompatActivity {
    protected Context mContext;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext = this;
        ButterKnife.bind(this);
        openActivityEventBus();
        setContentView(getLayout());
        getIntentExtras();
        initActivityData();
        OnActivityClickListener();
        AppManager.getAppManager().addActivity(this);
    }

    protected abstract boolean openEventBus();

    protected abstract void getIntentExtras();

    protected abstract int getLayout();

    protected abstract void initActivityData();

    protected abstract void OnActivityClickListener();


    private void openActivityEventBus() {
        if (openEventBus()) {
            EventBus.getDefault().register(this);
        }
    }

    private void closeActivityEventBus() {
        if (openEventBus()) {
            EventBus.getDefault().unregister(this);
        }
    }

    protected void startActivityFinish(Class<?> clazz) {
        Intent intent = new Intent(this, clazz);
        startActivity(intent);
        finish();
    }

    protected void startActivity(Class<?> clazz) {
        Intent intent = new Intent(this, clazz);
        startActivity(intent);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        closeActivityEventBus();
        AppManager.getAppManager().finishActivity(this);
    }
}
