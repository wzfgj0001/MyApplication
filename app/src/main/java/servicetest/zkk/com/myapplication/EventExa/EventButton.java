package servicetest.zkk.com.myapplication.EventExa;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;

import servicetest.zkk.com.myapplication.Logger;

/**
 * Function:button事件拦截控件<br>
 * <p/>
 * date: 2017/2/17.
 *
 * @author GuJian
 */
public class EventButton extends TextView {
    int lastX ;
    int lastY ;
    public EventButton(Context context) {
        super(context);
    }

    public EventButton(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public EventButton(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent event) {
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
        Logger.v("eventButon===dispatchTouchEvent===:"+eventState);
        Logger.v("eventButon===getX===:"+event.getX()+"getY==="+event.getY());
        Logger.v("eventButon===getrawX===:"+event.getRawX()+"getRAY==="+event.getRawY());
    //    Logger.v("eventButon===dispatchTouchEventReal===:"+super.dispatchTouchEvent(event));
        return super.dispatchTouchEvent(event);
    }

    /**
     * 重写onTouchEvent 滑动事件
     * @param event
     * @return
     */
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        String eventState = "";
        int x = (int) event.getX();
        int y = (int) event.getY();
        switch (event.getAction()){
            case MotionEvent.ACTION_DOWN:
                Logger.v("eventButon===onTouchEvent===:"+eventState);
                lastX = x;
                lastY = y;
                break;
               // break;
            case MotionEvent.ACTION_MOVE:
                eventState = "ACTION_MOVE";
                int offsetX = x - lastX;
                int offsetY = y - lastY;
                /*1 使用layout方法修改view位置*/
//                layout(getLeft()+offsetX,getTop()+offsetY
//                ,getRight()+offsetX,getBottom()+offsetY);

                /*2 使用layoutParams*/
//                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) getLayoutParams();
//                layoutParams.leftMargin = getLeft()+offsetX;
//                layoutParams.topMargin = getTop()+offsetY;
//                setLayoutParams(layoutParams);
                /*3 yon使用scrollBy*/
                ((View)getParent()).scrollBy(-offsetX,-offsetY);
                break;
            case MotionEvent.ACTION_UP:
                eventState = "ACTION_UP";
                break;
        }
        Logger.v("eventButon===onTouchEvent===:"+eventState);
//        Logger.v("eventButon===onTouchEventReal===:" +super.onTouchEvent(event) );
        return  true;
    }
}
