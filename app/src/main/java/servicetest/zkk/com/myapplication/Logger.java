package servicetest.zkk.com.myapplication;

import android.text.TextUtils;
import android.util.Log;

/**
 * Function:<br>
 * <p/>
 * date: 2017/2/17.
 *
 * @author GuJian
 */
public class Logger {
    public static final String TAG = "gujian";
    public static void v(String msg) {
        if (!TextUtils.isEmpty(msg)) {
            Log.d(TAG, msg);
        }
    }


}
