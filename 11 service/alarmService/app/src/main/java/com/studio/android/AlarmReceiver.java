package com.studio.android;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class AlarmReceiver extends BroadcastReceiver {
	@Override
	public void onReceive(Context context, Intent arg1) {
		// TODO Auto-generated method stub
		context.startService(new Intent(context, NotifyService.class));
		/*
		 * 相当于： Intent i=new Intent(context,NotifyService.class);
		 * context.startService(i);
		 */

	}

}
