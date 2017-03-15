package servicetest.zkk.com.myapplication.EventExa;

import android.app.Activity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;

import servicetest.zkk.com.myapplication.Logger;
import servicetest.zkk.com.myapplication.R;

/**
 * Function:事件拦截测试<br>
 * <p/>
 * date: 2017/2/17.
 *
 * @author GuJian
 */

/**
 * 测试一下上传
 */
public class EventActivity  extends Activity implements View.OnClickListener{
    private EventButton mEventButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.eventexa_layout);
        mEventButton = (EventButton) findViewById(R.id.event_btn);
//        mEventButton.setOnClickListener(this);
//        mEventButton.setOnTouchListener(new View.OnTouchListener() {
//            @Override
//            public boolean onTouch(View v, MotionEvent event) {
//                String eventState = "";
//                switch (event.getAction()){
//                    case MotionEvent.ACTION_DOWN:
//                        eventState = "ACTION_DOWN";
//                        break;
//                    case MotionEvent.ACTION_MOVE:
//                        eventState = "ACTION_MOVE";
//                        break;
//                    case MotionEvent.ACTION_UP:
//                        eventState = "ACTION_UP";
//                        break;
//                }
//                Logger.v("eventButon===onTouch===:"+eventState);
//                return false;
//            }
//        });
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        String eventState = "";
        switch (ev.getAction()){
            case MotionEvent.ACTION_DOWN:
                eventState = "ACTION_DOWN";
                break;
            case MotionEvent.ACTION_MOVE:
                eventState = "ACTION_MOVE";
                break;
            case MotionEvent.ACTION_UP:
                eventState = "ACTION_UP";
                break;
        }
        Logger.v("EventActivity===dispatchTouchEvent===:" + eventState);
        //Logger.v("EventActivity===dispatchTouchEvent===:" + super.dispatchTouchEvent(ev));
    //    Logger.v("EventActivity===dispatchTouchEventreal===:" + super.dispatchTouchEvent(ev));
        return super.dispatchTouchEvent(ev);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        String eventState = "";
        switch (event.getAction()){
            case MotionEvent.ACTION_DOWN:
                eventState = "ACTION_DOWN";
                break;
            case MotionEvent.ACTION_MOVE:
                eventState = "ACTION_MOVE";
                break;
            case MotionEvent.ACTION_UP:
                eventState = "ACTION_UP";
                break;
        }
        Logger.v("EventActivity===onTouchEvent===:"+eventState);
//        Logger.v("EventActivity===onTouchEvent===:" + super.onTouchEvent(event));
        return super.onTouchEvent(event);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.event_btn:
                Logger.v("EventButton===ONCLICK===:");
                break;
        }
    }
}
