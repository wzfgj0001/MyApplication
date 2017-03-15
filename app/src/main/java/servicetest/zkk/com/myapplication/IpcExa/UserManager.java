package servicetest.zkk.com.myapplication.IpcExa;

import android.app.ActivityManager;
import android.content.Context;

/**
 * Function:测试进程之间内存<br>
 * <p/>
 * date: 2017/3/1.
 *
 * @author GuJian
 */
public class UserManager {
    public static  int sUserId = 1;
    public static void increase(){
        sUserId++;
    }

    public static  String getProcessName(Context context){
        int pid = android.os.Process.myPid();
        ActivityManager activityManager = (ActivityManager) context.getSystemService(Context.ACTIVITY_SERVICE);
        for(ActivityManager.RunningAppProcessInfo appProcessInfo:activityManager.getRunningAppProcesses()){
            if(appProcessInfo.pid == pid){
                return  appProcessInfo.processName;
            }
        }
        return  null;
    }
}
