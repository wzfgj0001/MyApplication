package servicetest.zkk.com.myapplication.IpcExa;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import servicetest.zkk.com.myapplication.Logger;

/**
 * Function:<br>
 * <p/>
 * date: 2017/3/1.
 *
 * @author GuJian
 */
public class IpcMainActvity  extends Activity{
    private Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Logger.v("IpcMainActvityOnCREATE:" + UserManager.sUserId + "");
        button = new Button(this);
        button.setText("IPC ACTIVITY");
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                UserManager.increase();
                startActivity(new Intent(IpcMainActvity.this,AprocessActvity.class));
            }
        });
        setContentView(button);
    }
    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        Logger.v("IpcMainActvityoNewIntent:" + UserManager.sUserId + "");;
    }
}
