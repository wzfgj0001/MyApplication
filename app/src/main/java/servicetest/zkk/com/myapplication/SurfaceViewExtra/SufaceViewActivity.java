package servicetest.zkk.com.myapplication.SurfaceViewExtra;

import android.app.Activity;
import android.os.Bundle;

import servicetest.zkk.com.myapplication.CommUtils;

/**
 * Function:<br>
 * <p/>
 * date: 2017/2/21.
 *
 * @author GuJian
 */
public class SufaceViewActivity extends Activity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(new MySurfaceView(this));
        CommUtils.getPhoneInformation();
        CommUtils.getAppInfo(this);
    }
}
