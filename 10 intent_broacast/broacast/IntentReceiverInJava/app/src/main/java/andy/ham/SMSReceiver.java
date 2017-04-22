package andy.ham;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.SmsMessage;
import android.util.Log;

public class SMSReceiver extends BroadcastReceiver{
	
	private static final String TAG = "onReceive" ;
	@Override
	public void onReceive(Context context, Intent intent) {
		// TODO Auto-generated method stub
		Log.i(TAG, "onReceive-->running!");
		
		//接受Intent对象当中的数据
		Bundle bundle = intent.getExtras();
		//在Bundle对象当中有一个属性名为pdus，这个属性的值是一个Object数组
		Object[] myOBJpdus = (Object[]) bundle.get("pdus"); 
		//创建一个SmsMessage类型的数组
        SmsMessage[] messages = new SmsMessage[myOBJpdus.length];  
        System.out.println(messages.length);
        for (int i = 0; i<myOBJpdus.length; i++) 
        {  
          //使用Object数组当中的对象创建SmsMessage对象
          messages[i] = SmsMessage.createFromPdu((byte[]) myOBJpdus[i]);  
          //调用SmsMessage对象的getDisppalyMessageBody()方法，就可以得到消息的内容
          System.out.println(messages[i].getDisplayMessageBody());
        }
	}
}
