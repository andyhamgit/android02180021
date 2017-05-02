package ham.andy.handlerthread;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity {
    private Button startButton = null;
    private Button endButton = null;
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        startButton = (Button)findViewById(R.id.startButton);
        startButton.setOnClickListener(new StartButtonListener());
        endButton = (Button)findViewById(R.id.endButton);
        endButton.setOnClickListener(new EndButtonListener());
    }
    //1、创建一个Handler对象
    Handler handler  = new Handler();
    class StartButtonListener implements OnClickListener{
        @Override
        public void onClick(View v) {
            //2、调用Handler的post方法，将要执行的线程对象添加到队列当中，同样下面也有停止按钮
            handler.post(updateThread);
        }
    }
    class EndButtonListener implements OnClickListener{

        @Override
        public void onClick(View v) {
            handler.removeCallbacks(updateThread);
        }
    }
    //3、将要执行的操作写在线程对象的run方法当中
    Runnable updateThread =  new Runnable(){
        @Override
        public void run() {
            System.out.println("UpdateThread");
            Log.v("tag", "UpdateThread");
            //在run方法内部，执行postDelayed或者是post方法
            handler.postDelayed(updateThread, 2000);
        }

    };
}