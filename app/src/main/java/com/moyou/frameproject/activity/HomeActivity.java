package com.moyou.frameproject.activity;

import com.moyou.frameproject.R;
import com.moyou.frameproject.notification.NotificationUtils;

import static com.moyou.frameproject.notification.NotificationBroadcastReceiver.MSG_TYPE;

/**
 * Created by Administrator on 2017/8/11 0011.
 */

public class HomeActivity extends BaseActivity {

    @Override
    protected boolean openEventBus() {
        return false;
    }

    @Override
    protected void getIntentExtras() {

    }

    @Override
    protected int getLayout() {
        return R.layout.activity_home;
    }

    @Override
    protected void initActivityData() {
        NotificationUtils.getInstance().setNotification("通知的内容", true, MSG_TYPE);
    }

    @Override
    protected void OnActivityClickListener() {

    }


}
