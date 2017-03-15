package servicetest.zkk.com.myapplication.IpcExa;

import android.app.Application;

import servicetest.zkk.com.myapplication.Logger;

/**
 * Function:<br>
 * <p/>
 * date: 2017/3/1.
 *
 * @author GuJian
 */
public class MyApplication extends Application{
    @Override
    public void onCreate() {
        super.onCreate();
        String processName = UserManager.getProcessName(getApplicationContext());
        Logger.v("prcross name start:"+processName);
    }
}
