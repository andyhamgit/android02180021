package com.example.xmldesigns;




import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class MainActivity extends Activity {
	/** Called when the activity is first created. */
	RadioButton r1 = null;
	RadioButton r2 = null;
	RadioButton r3 = null;
	RadioButton r4 = null;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		//radioGroup = (RadioGroup) findViewById(R.id.radioGroup);
		 
		// 获得单选按钮
		r1 = (RadioButton) findViewById(R.id.a);
		r2 = (RadioButton) findViewById(R.id.b);
		r3 = (RadioButton) findViewById(R.id.c);
		r4 = (RadioButton) findViewById(R.id.d);
		r1.setClickable(true);
		// 监听单选按钮
		//radioGroup.setOnCheckedChangeListener(mChangeRadio);
        Button botton1 =(Button)findViewById(R.id.sure);
        Button botton2 =(Button)findViewById(R.id.cancel);
	}
}
	