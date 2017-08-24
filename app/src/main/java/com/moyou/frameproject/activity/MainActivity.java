package com.moyou.frameproject.activity;

import com.moyou.frameproject.R;


public class MainActivity extends BaseActivity {


    @Override
    protected void noNet() {
    }

    @Override
    protected void okNet() {
    }

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
    protected void initActivityData() {
        startActivity(HomeActivity.class);
    }

    @Override
    protected void OnActivityClickListener() {

    }


}
