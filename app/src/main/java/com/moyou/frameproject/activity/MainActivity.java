package com.moyou.frameproject.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.moyou.frameproject.R;
import com.moyou.frameproject.activity.BaseActivity;
import com.moyou.frameproject.activity.HomeActivity;
import com.orhanobut.logger.AndroidLogAdapter;
import com.orhanobut.logger.Logger;


public class MainActivity extends BaseActivity {

    @Override
    protected boolean openEventBus() {
        return false;
    }

    @Override
    protected void getIntentExtras() {
    }

    @Override
    protected int getLayout() {
        return R.layout.activity_main;
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void initData() {
    }

    @Override
    protected void OnClickListener() {

    }
}
