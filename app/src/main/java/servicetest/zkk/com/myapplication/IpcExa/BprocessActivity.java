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
public class BprocessActivity extends Activity{
    private Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        button = new Button(this);
        button.setText("Bprocess");
        Logger.v("BprocessActivity:" + UserManager.sUserId + "");;
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(BprocessActivity.this, IpcMainActvity.class));
            }
        });
        setContentView(button);
    }
}
