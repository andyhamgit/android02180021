package ham.andy.handlermessageprogess;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ProgressBar;

public class MainActivity extends Activity {
    ProgressBar bar = null;
    Button startButton = null;
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bar = (ProgressBar)findViewById(R.id.bar);
        startButton = (Button)findViewById(R.id.startButton);
        startButton.setOnClickListener(new ButtonListener());
    }
    //当点击startButton按钮时，就会执行ButtonListener的onClick方法
    class ButtonListener implements OnClickListener{
        @Override
        public void onClick(View v) {
            // TODO Auto-generated method stub
            bar.setVisibility(View.VISIBLE);
            updateBarHandler.post(updateThread);
        }
    }

    //使用匿名内部类来复写Handler当中的handleMessage方法
    Handler updateBarHandler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            bar.setProgress(msg.arg1);
            updateBarHandler.post(updateThread);
        }

    };
    //线程类，该类使用匿名内部类的方式进行声明
    Runnable updateThread = new Runnable(){
        int i = 0 ;
        @Override
        public void run() {
            System.out.println("Begin Thread");
            i = i + 10 ;
            //得到一个消息对象，Message类是有Android操作系统提供
            Message msg = updateBarHandler.obtainMessage();
            //将msg对象的arg1参数的值设置为i,用arg1和arg2这两个成员变量传递消息，优点是系统性能消耗较少
            msg.arg1 = i ;
            try {
                //设置当前显示睡眠1秒
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            //将msg对象加入到消息队列当中
            updateBarHandler.sendMessage(msg);
            if( i == 100){
                //如果当i的值为100时，就将线程对象从handler当中移除
                updateBarHandler.removeCallbacks(updateThread);
            }
        }
    };
}