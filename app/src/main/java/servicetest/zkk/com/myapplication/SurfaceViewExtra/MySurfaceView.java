package servicetest.zkk.com.myapplication.SurfaceViewExtra;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import servicetest.zkk.com.myapplication.Logger;

/**
 * Function:surfaceview的绘制<br>
 * <p/>
 * date: 2017/2/21.
 *
 * @author GuJian
 */
public class MySurfaceView extends SurfaceView implements SurfaceHolder.Callback,Runnable{
    boolean isRunning = true;
    private SurfaceHolder  holder  = null;
    Paint paint;
    private int x,y;
    public MySurfaceView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MySurfaceView(Context context) {
        super(context);
        holder = getHolder();
        holder.addCallback(this);
        paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        paint.setColor(Color.RED);
    }

    public MySurfaceView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public void run() {
//        Log
        while (isRunning){
            paint(paint);
            move();
            try{
                Thread.sleep(50);
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }

    private void paint(Paint paint) {
        Canvas canvas=holder.lockCanvas();
        //刷屏
        canvas.drawColor(Color.WHITE);

        canvas.drawCircle(x, y, 10, paint);

        holder.unlockCanvasAndPost(canvas);
    }

    @Override
    protected void onDraw(Canvas canvas) {
         canvas=holder.lockCanvas();
        //刷屏
        canvas.drawColor(Color.WHITE);

        canvas.drawCircle(x, y, 10, paint);

        holder.unlockCanvasAndPost(canvas);
    }

    @Override
    public void surfaceCreated(SurfaceHolder holder) {
        Logger.v("surfaceCreated");
    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {
        Logger.v("surfaceChanged");
        Thread thread = new Thread(this);
        thread.start();
    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {
        Logger.v("surfaceDestroyed");
        isRunning = false;
    }
    private void move(){
        x+=2;
        y+=2;
    }
}
