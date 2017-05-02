package cn.android.com.simpleplay.MyService;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.widget.Toast;

import cn.android.com.simpleplay.R;

public class MusicService extends Service {
    private MediaPlayer mPlayer;

    @Override
    public void onCreate() {
        mPlayer = MediaPlayer.create(getApplicationContext(), R.raw.gequ);
        //设置可以重复播放
        mPlayer.setLooping(true);
        super.onCreate();
    }

    @Override
    public void onStart(Intent intent, int startId) {
        Toast.makeText(MusicService.this, "MusicSevice onStart()"
                , Toast.LENGTH_SHORT).show();
        mPlayer.start();
        super.onStart(intent, startId);
    }

    @Override
    public void onDestroy() {
        Toast.makeText(MusicService.this, "MusicSevice onDestroy()"
                , Toast.LENGTH_SHORT).show();
        mPlayer.stop();
        super.onDestroy();
    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}
