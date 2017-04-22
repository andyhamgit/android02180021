package andy.ham;
import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class OtherActivity extends BroadcastReceiver {

	@Override
	public void onReceive(Context context, Intent intent) {
		//从Intent当中根据key取得value
		String value = intent.getStringExtra("testIntent");
		Log.e("IntentReceiver-->Test", value);
	}
	
}