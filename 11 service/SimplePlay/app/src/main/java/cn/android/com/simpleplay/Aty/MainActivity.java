package cn.android.com.simpleplay.Aty;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.Calendar;

import cn.android.com.simpleplay.MyBroadcast.AlarmReceiver;
import cn.android.com.simpleplay.MyService.MusicService;
import cn.android.com.simpleplay.R;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btnCallAlarm;
    private Button btnExitAlarm;
    AlarmManager alarmManager;
    PendingIntent pendingIntent;

    private Button btnStartPlay;
    private Button btnStopPlay;
    private Intent intentPlay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_layout);

        initView();

    }

    private void initView() {
        btnCallAlarm = (Button) findViewById(R.id.btn_call_alarm_service);
        btnExitAlarm = (Button) findViewById(R.id.btn_exit);

        btnStartPlay = (Button) findViewById(R.id.btn_start_play);
        btnStopPlay = (Button) findViewById(R.id.btn_stop_play);

        btnCallAlarm.setOnClickListener(this);
        btnExitAlarm.setOnClickListener(this);
        btnStartPlay.setOnClickListener(this);
        btnStopPlay.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_call_alarm_service:
                Toast.makeText(MainActivity.this , "注册了广播，请5s后查看通知栏" , Toast.LENGTH_LONG).show();
                setAlarm(true);
                break;
            case R.id.btn_exit:
                Toast.makeText(MainActivity.this , "取消了pendingIntent" , Toast.LENGTH_LONG).show();
                setAlarm(false);
                finish();
                break;
            case R.id.btn_start_play:
                Toast.makeText(MainActivity.this , "绑定了playService" , Toast.LENGTH_LONG).show();
                intentPlay = new Intent(MainActivity.this , MusicService.class);
                startService(intentPlay);
                break;
            case R.id.btn_stop_play:
                stopService(intentPlay);
                Toast.makeText(MainActivity.this , "解绑了playService" , Toast.LENGTH_LONG).show();
                break;
        }
    }

    /**
     * @param isStart 启动设置闹钟标志位
     */
    private void setAlarm(Boolean isStart) {
        alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);
        pendingIntent = PendingIntent.getBroadcast(MainActivity.this, 0, new Intent(this, AlarmReceiver.class), 0);
        // 进行闹铃注册
        if (isStart) {
            Calendar calendar = Calendar.getInstance();
            calendar.setTimeInMillis(System.currentTimeMillis());
            calendar.setTimeInMillis(System.currentTimeMillis());
            calendar.add(Calendar.SECOND, 5);//不是毫秒级的
            alarmManager.set(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(), pendingIntent);
        } else {
            alarmManager.cancel(pendingIntent);
        }

    }
}
