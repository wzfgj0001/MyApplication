package servicetest.zkk.com.myapplication.CanvasExa;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.widget.TextView;

import servicetest.zkk.com.myapplication.Logger;
import servicetest.zkk.com.myapplication.R;

/**
 * Function:<br>
 * <p/>
 * date: 2017/2/21.
 *
 * @author GuJian
 */
public class MyClockActivity extends Activity{
    TextView mTv;
    int time = 60;
    Handler handler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clock_layout);
        mTv = (TextView) findViewById(R.id.text);
        handler = new Handler(new Handler.Callback() {
            @Override
            public boolean handleMessage(Message msg) {
                switch (msg.what){
                    case  1:
                        int LeftTime = (int) msg.obj;
                        Logger.v("leftTime:"+LeftTime);
                        mTv.setText(LeftTime + "");
                        break;
                }
                return false;
            }
        });

        new Thread(new Runnable() {
            @Override
            public void run() {
                while(time>0&&isFinishing()) {
                    time--;
                    Message msg = new Message();
                    msg.obj = time;
                    msg.what = 1;
                    handler.sendMessage(msg);
                    try {
                        Thread.sleep(1000);
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                }
            }
        }).start();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
