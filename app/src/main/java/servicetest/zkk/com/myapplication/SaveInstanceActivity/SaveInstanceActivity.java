package servicetest.zkk.com.myapplication.SaveInstanceActivity;

import android.app.Activity;
import android.content.res.Configuration;
import android.os.Bundle;
import android.widget.EditText;

import servicetest.zkk.com.myapplication.Logger;
import servicetest.zkk.com.myapplication.R;

/**
 * Function:<br>
 * <p/>
 * date: 2017/2/27.
 *
 * @author GuJian
 */
public class SaveInstanceActivity extends Activity{
    EditText editText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Logger.v("onCreate");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_saveinstance);
//        editText = (EditText) findViewById(R.id.edit_text);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        Logger.v("onSaveInstanceState");
        super.onSaveInstanceState(outState);
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
    }
}
