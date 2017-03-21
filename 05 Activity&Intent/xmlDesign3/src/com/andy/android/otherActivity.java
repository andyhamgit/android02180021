package com.andy.android;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class otherActivity extends Activity{
	private Intent intent;
	private Bundle bunde;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.other);
		/* 取得Intent 中的Bundle 对象 */
		Bundle bunde = this.getIntent().getExtras();
		/* 取得Bundle 对象中的数据 */
		String ans = bunde.getString("ans");
		/* 判断所选答案*/
		String sexText = "";
		if (ans.equals("in")) {
			sexText = "正确";
			} else {
			sexText = "错误";
			}
		TextView tv1 = (TextView) findViewById(R.id.text1);
		tv1.setText("您选择的答案是：" + sexText);
		
		/* 以findViewById()取得Button 对象，并添加onClickListener */
		Button btn3_back = (Button) findViewById(R.id.button_back);
		btn3_back.setOnClickListener(new Button.OnClickListener() {
			@Override
			public void onClick(View v) {
			// TODO Auto-generated method stub
			/* 返回result 回上一个activity */
			otherActivity.this.setResult(RESULT_OK, intent);
			/* 结束这个activity */
		otherActivity.this.finish();
			}
			});
	}
		
}
		



