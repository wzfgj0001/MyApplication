package servicetest.zkk.com.myapplication.IpcExa;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import servicetest.zkk.com.myapplication.Logger;

/**
 * Function:测试一下<br>
 * <p/>
 * date: 2017/3/1.
 *
 * @author GuJian
 */
public class AprocessActvity  extends Activity {
    private Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Logger.v("Aprocess:"+UserManager.sUserId+"");
        button = new Button(this);
        button.setText("Aprocess");
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                UserManager.increase();
                startActivity(new Intent(AprocessActvity.this, BprocessActivity.class));
            }
        });
        setContentView(button);
    }
}
