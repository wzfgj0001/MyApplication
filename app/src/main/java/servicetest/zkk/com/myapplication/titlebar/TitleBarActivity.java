package servicetest.zkk.com.myapplication.titlebar;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Toast;

import servicetest.zkk.com.myapplication.R;

/**
 * Function:TitleBar自定义组合控件<br>
 * <p/>
 * date: 2017/2/9.
 *
 * @author GuJian
 */
public class TitleBarActivity extends Activity implements TitleBar.TitleBarListener{
    TitleBar titleBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.title_bar_activity_layout);
        titleBar = (TitleBar) findViewById(R.id.title_bar);
        titleBar.setCenterTv(R.string.app_name);
        titleBar.setTitleBarListener(this);
        titleBar.setLeftDrawable(R.drawable.back_arrow);
    }

    @Override
    public void onClickRight() {
//        Toast.makeText(this,"right",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onClickLeft() {
        Toast.makeText(this, "left", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onClickCenter() {
//        Toast.makeText(this,"right",Toast.LENGTH_SHORT).show();
    }
}
