package cn.android.com.simpleplay.MyService;

import android.app.NotificationManager;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.support.v7.app.NotificationCompat;
import android.widget.Toast;

import cn.android.com.simpleplay.R;

public class NotificationService extends Service {

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Toast.makeText(NotificationService.this , "成功启动了外部Notificaion" , Toast.LENGTH_LONG).show();
        //自定义Notification实例
        NotificationManager notifyManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this);
        builder.setSmallIcon(R.mipmap.ic_launcher);
        builder.setContentTitle("SimplePlay Notification");
        builder.setContentText("5秒钟定时到了");
        notifyManager.notify(1, builder.build());
        return super.onStartCommand(intent, flags, startId);
    }
}
