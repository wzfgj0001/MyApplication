package servicetest.zkk.com.myapplication.CanvasExa;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.widget.TextView;

import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;

import servicetest.zkk.com.myapplication.Logger;
import servicetest.zkk.com.myapplication.R;

/**
 * Function:<br>
 * <p/>
 * date: 2017/2/21.
 *
 * @author GuJian
 */
public class MyClock extends TextView implements GestureDetector.OnGestureListener{
    GestureDetector mGesturDetecto = new GestureDetector(this);
    public MyClock(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public MyClock(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MyClock(Context context) {
        super(context);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Paint paintCircle = new Paint();
        paintCircle.setStyle(Paint.Style.STROKE);
        paintCircle.setAntiAlias(true);
        paintCircle.setStrokeWidth(5);
        paintCircle.setColor(getResources().getColor(R.color.blue));
        int x =  getWidth()>=getHeight()?getHeight():getWidth();
        canvas.drawCircle(getWidth()/2,getHeight()/2,x/2,paintCircle);
        canvas.save();
        canvas.restore();
    }

    public  void main(String[] args){
        SoftReference<String> sr = new SoftReference<String> (new String("hello"));
        WeakReference<String> wr = new WeakReference<String>(new String("hello"));
        System.out.println("sr:"+sr.get());
        System.out.println("wr:" + wr.get());
        System.gc();
        System.out.println("sr:" + sr.get());
        System.out.println("wr:"+wr.get());

        new Thread(new Runnable() {
            @Override
            public void run() {
                /*非静态匿名内部类隐式持有外部类的引用*/
                testMethod();

            }
        }).start();
    }

    public void testMethod(){
        System.out.println("testMethjod");
    }

    @Override
    public boolean onDown(MotionEvent e) {
        Logger.v("onDown");
        return false;
    }

    @Override
    public void onShowPress(MotionEvent e) {
        Logger.v("onShowPress");
    }

    @Override
    public boolean onSingleTapUp(MotionEvent e) {
        Logger.v("onSingleTapUp");
        return false;
    }

    @Override
    public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
        Logger.v("onScroll");
        return false;
    }

    @Override
    public void onLongPress(MotionEvent e) {
        Logger.v("onLongPress");
    }

    @Override
    public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
        Logger.v("onFling");
        return false;
    }
}
