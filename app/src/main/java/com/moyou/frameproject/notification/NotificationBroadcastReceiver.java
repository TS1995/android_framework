package com.moyou.frameproject.notification;

import android.app.NotificationManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/**
 * Created by Administrator on 2017/4/5 0005.
 * 通知的时间点击侧滑监听类
 */

public class NotificationBroadcastReceiver extends BroadcastReceiver {

    public static final String TYPE = "notification_type";
    //如：定义的通知类型
    public static final int MSG_TYPE = 1;

    @Override
    public void onReceive(Context context, Intent intent) {
        String action = intent.getAction();
        int type = intent.getIntExtra(TYPE, -1);
        if (type != -1) {
            NotificationManager notificationManager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
            notificationManager.cancel(type);
        }
        //点击事件
        if (action.equals("clicked")) {
            setClickedAndCancelled(type);
        }
        //侧滑事件
        if (action.equals("cancelled")) {
            setClickedAndCancelled(type);
        }
    }

    /**
     * 事件处理
     *
     * @param type
     */
    private void setClickedAndCancelled(int type) {
        switch (type) {
            case MSG_TYPE:
                break;
        }
    }

}
