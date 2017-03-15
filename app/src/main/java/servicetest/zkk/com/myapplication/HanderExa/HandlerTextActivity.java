package servicetest.zkk.com.myapplication.HanderExa;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;

import servicetest.zkk.com.myapplication.Logger;

/**
 * Function:<br>
 * <p/>
 * date: 2017/2/24.
 *
 * @author GuJian
 */
public class HandlerTextActivity extends Activity{
    private  int count = 0;
    Handler mThhanler;
    Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            count++;
            Logger.v("UI:" + msg.what);
            if(count<=3) {
                mThhanler.sendEmptyMessage(1);
            }
        }
    };
//    TestHandler handler = new TestHandler(this);
//    public static  class TestHandler extends  Handler{
//        WeakReference<Activity> mActivityReference;
//
//        public TestHandler(Activity activity) {
//            mActivityReference  = new WeakReference<Activity>(activity);
//        }
//
//        @Override
//        public void handleMessage(Message msg) {
//            super.handleMessage(msg);
//            final Activity activity = mActivityReference.get();
//            if(activity!=null) {
//                count++;
//                Logger.v("UI:" + msg.what);
//                if (count <= 3) {
//                    mThhanler.sendEmptyMessage(1);
//                }
//            }
//        }
//    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initData();
//        runOnUiThread(n);
    }
    public void initData(){
        new Thread(new Runnable() {
            @Override
            public void run() {
                Looper.prepare();
                mThhanler = new Handler(){
                    @Override
                    public void handleMessage(Message msg) {
                        super.handleMessage(msg);
                        Logger.v("thred:" + msg.what);
                        handler.sendEmptyMessage(0);
                    }
                };
                mThhanler.sendEmptyMessage(0);
                Looper.loop();
            }
        }).start();
    }
}
