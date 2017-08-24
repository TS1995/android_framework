package com.moyou.frameproject.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.moyou.baselibrary.AppManager;

import org.greenrobot.eventbus.EventBus;

import butterknife.ButterKnife;

/**
 * Created by Administrator on 2017/8/11 0011.
 * 测试更新版本
 */

public abstract class BaseActivity extends FatherActivity {
    protected Context mContext;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext = this;
        AppManager.getAppManager().addActivity(this);
        setContentView(getActivityLayout());
        openActivityEventBus();
        ButterKnife.bind(this);
        getIntentExtras();
        initActivityData();
        OnActivityClickListener();
    }

    @Override
    protected void noNet() {
        super.noNet();
    }

    @Override
    protected void okNet() {
        super.okNet();
    }

    protected abstract boolean openEventBus();

    protected abstract void getIntentExtras();

    protected abstract int getActivityLayout();

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
