package com.moyou.frameproject.notification;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.support.v7.app.NotificationCompat;

import com.moyou.frameproject.R;
import com.moyou.frameproject.application.BaseApplication;

import static android.content.Context.NOTIFICATION_SERVICE;

/**
 * Created by Administrator on 2017/2/22 0022.
 */

public class NotificationUtils {

    private static NotificationUtils instance;

    public static final String TITLE_CONTENT = "框架通知";

    private NotificationCompat.Builder mBuilder;

    private NotificationManager notificationManager;

    public synchronized static NotificationUtils getInstance() {
        if (instance == null) {
            instance = new NotificationUtils();
        }
        return instance;
    }

    /**
     * @param type        通知点击时类型判断
     * @param content     通知的内容
     * @param isOpenVoice 是否打开声音
     */
    public void setNotification(String content, boolean isOpenVoice, int type) {
        onCreateNotification();
        mBuilder.setContentTitle(TITLE_CONTENT);
        mBuilder.setContentText(content);
        mBuilder.setWhen(System.currentTimeMillis());
        mBuilder.setPriority(Notification.PRIORITY_DEFAULT);
        mBuilder.setOngoing(false);
        mBuilder.setAutoCancel(true);
        mBuilder.setSmallIcon(R.mipmap.ic_launcher);
        if (!isOpenVoice) {
            mBuilder.build().sound = null;
            mBuilder.build().vibrate = null;
        }
        showNotification(0, type);
    }

    private void showNotification(int id, int type) {
        Intent intentClick = new Intent(BaseApplication.getInstance(), NotificationBroadcastReceiver.class);
        intentClick.setAction("clicked");
        intentClick.putExtra(NotificationBroadcastReceiver.TYPE, type);
        PendingIntent pendingIntentClick = PendingIntent.getBroadcast(BaseApplication.getInstance(), 0, intentClick, PendingIntent.FLAG_ONE_SHOT);

        Intent intentCancel = new Intent(BaseApplication.getInstance(), NotificationBroadcastReceiver.class);
        intentCancel.setAction("cancelled");
        intentCancel.putExtra(NotificationBroadcastReceiver.TYPE, type);
        PendingIntent pendingIntentCancel = PendingIntent.getBroadcast(BaseApplication.getInstance(), 0, intentCancel, PendingIntent.FLAG_ONE_SHOT);

        mBuilder.setContentIntent(pendingIntentClick).setDeleteIntent(pendingIntentCancel);
        notificationManager.notify(id, mBuilder.build());
    }


    private void onCreateNotification() {
        if (mBuilder == null) {
            mBuilder = new NotificationCompat.Builder(BaseApplication.getInstance());
        }
        if (notificationManager == null) {
            notificationManager = (NotificationManager) BaseApplication.getInstance().getSystemService(NOTIFICATION_SERVICE);
        }
    }
}


