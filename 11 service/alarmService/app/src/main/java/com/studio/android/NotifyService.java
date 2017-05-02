package com.studio.android;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.widget.Toast;

public class NotifyService extends Service {

	@Override
	public IBinder onBind(Intent arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	public void onCreate() {
		alarmService app = alarmService.getApp();
		app.btEvent("from NotifyService");
		Toast.makeText(this, "这是系统自带的service", Toast.LENGTH_LONG).show();

	}

}
