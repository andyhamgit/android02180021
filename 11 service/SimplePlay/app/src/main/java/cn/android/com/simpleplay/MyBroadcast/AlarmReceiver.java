package cn.android.com.simpleplay.MyBroadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import cn.android.com.simpleplay.MyService.NotificationService;

/**
 * Created by ZWZ on 2017/4/27.
 */

public class AlarmReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        //启动Notification服务
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.setClass(context, NotificationService.class);
        context.startService(intent);
    }

}
