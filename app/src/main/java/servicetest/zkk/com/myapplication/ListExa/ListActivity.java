package servicetest.zkk.com.myapplication.ListExa;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import servicetest.zkk.com.myapplication.R;

/**
 * Function:<br>
 * <p/>
 * date: 2017/2/20.
 *
 * @author GuJian
 */
public class ListActivity extends Activity{
    private ListView mLv1;
    private ListView mLv2;
    private ListView mLv3;
    private TextView mEmpty;
    int lengthList = 20;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_layout);
        mLv1 = (ListView) findViewById(R.id.list_lv1);
        mLv2 = (ListView) findViewById(R.id.list_lv2);
        mLv3 = (ListView) findViewById(R.id.list_lv3);
//        mEmpty = (TextView) findViewById(R.id.empty_view);
        List<String> data = new ArrayList<>();
        for(int i=0;i<lengthList;i++){
            data.add(i+"");
        }
        ViewHolderAdapter adapter = new ViewHolderAdapter(this,data);
        TextView tv1 = new TextView(this);
        tv1.setText("shhs");
        mLv1.addHeaderView(tv1);
        mLv1.setAdapter(adapter);
        mLv2.setAdapter(adapter);
        mLv3.setAdapter(adapter);

//        mLv.setEmptyView(mEmpty);
    }
}
