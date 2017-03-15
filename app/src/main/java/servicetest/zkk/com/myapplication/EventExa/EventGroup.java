package servicetest.zkk.com.myapplication.EventExa;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.LinearLayout;

import servicetest.zkk.com.myapplication.Logger;

/**
 * Function:<br>
 * <p/>
 * date: 2017/2/17.
 *
 * @author GuJian
 */
public class EventGroup extends LinearLayout{
    public EventGroup(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public EventGroup(Context context) {
        super(context);
    }

    public EventGroup(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
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
        Logger.v("EventGroup===onInterceptTouchEvent===:" + eventState);
//        Logger.v("EventGroup===onInterceptTouchEventReal===:" + super.onInterceptTouchEvent(ev));
        return super.onInterceptTouchEvent(ev);
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
        Logger.v("EventGroup===onTouchEvent===:" + eventState);
        Logger.v("EventGroup===onTouchEventReal===:" + false);
        return super.onTouchEvent(event);
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
        Logger.v("EventGroup===dispatchTouchEvent===:" + eventState);
       // Logger.v("EventGroup===dispatchTouchEventReal===:" + super.dispatchTouchEvent(ev));
        return super.dispatchTouchEvent(ev);
    }
}
