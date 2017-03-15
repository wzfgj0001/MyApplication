package servicetest.zkk.com.myapplication.titlebar;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import servicetest.zkk.com.myapplication.CommUtils;
import servicetest.zkk.com.myapplication.R;

/**
 * Function:组合控件<br>
 * <p/>
 * date: 2017/2/9.
 *
 * @author GuJian
 */
public class TitleBar extends RelativeLayout implements View.OnClickListener{
    private final static int mDefaultLeftAndRightTextSize = 12;
    private final static int mDefaultTitleTextSize = 16;
    private final static int mDefaultLeftAndRightPadding = 10;
    private final static int mDefaultDrawablePadding = 3;

    private TextView mLeftCtv;
    private TextView mRightCtv;
    private TextView mTitleCtv;
    private TitleBarListener titleBarListener;
    private Context mContext;
    public TitleBar(Context context, AttributeSet attrs) {
        this(context, attrs,0);
    }

    public TitleBar(Context context) {
        this(context, null);
    }

    public TitleBar(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mContext = context;
        View view =  View.inflate(context, R.layout.title_bar_item, this);
        initView(view);
        initAttrs(context, attrs);
    }
    private void initAttrs(Context context, AttributeSet attrs) {
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.title_bar);
        final int attrLength = typedArray.getIndexCount();
        for (int i = 0; i < attrLength; i++) {
            initAttr(typedArray.getIndex(i), typedArray);
        }
        typedArray.recycle();
    }
    private void initAttr(int attr, TypedArray typedArray) {
        if (attr == R.styleable.title_bar_title_bar_leftText) {
            setLeftText(typedArray.getText(attr));
        } else if (attr == R.styleable.title_bar_title_bar_rightText) {
            setRightText(typedArray.getText(attr));
        } else if (attr == R.styleable.title_bar_title_bar_titleText) {
            setTitleText(typedArray.getText(attr));
        } else if (attr == R.styleable.title_bar_title_bar_leftDrawable) {
            setLeftDrawable(typedArray.getDrawable(attr));
        } else if (attr == R.styleable.title_bar_title_bar_rightDrawable) {
            setRightDrawable(typedArray.getDrawable(attr));
        } else if (attr == R.styleable.title_bar_title_bar_titleDrawable) {
            setTitleDrawable(typedArray.getDrawable(attr));
        } else if (attr == R.styleable.title_bar_title_bar_leftAndRightTextSize) {
            int textSize = typedArray.getDimensionPixelSize(attr, CommUtils.sp2px(mDefaultLeftAndRightTextSize));
            setLeftAndRightTextSize(textSize);
        } else if (attr == R.styleable.title_bar_title_bar_titleTextSize) {
            int textSize = typedArray.getDimensionPixelSize(attr, CommUtils.sp2px(mDefaultTitleTextSize));
            setTitleTextSize(textSize);
        } else if (attr == R.styleable.title_bar_title_bar_leftTextColor) {
            setLeftTextColor(typedArray.getColorStateList(attr));
        } else if (attr == R.styleable.title_bar_title_bar_rightTextColor) {
            setRightTextColor(typedArray.getColorStateList(attr));
        } else if (attr == R.styleable.title_bar_title_bar_titleTextColor) {
            setTitleTextColor(typedArray.getColorStateList(attr));
        } else if (attr == R.styleable.title_bar_title_bar_leftAndRightTextColor) {
            setLeftTextColor(typedArray.getColorStateList(attr));
            setRightTextColor(typedArray.getColorStateList(attr));
        } else if (attr == R.styleable.title_bar_title_bar_leftDrawablePadding) {
            setLeftDrawablePadding(typedArray.getDimensionPixelSize(attr, CommUtils.dp2px(mDefaultDrawablePadding)));
        } else if (attr == R.styleable.title_bar_title_bar_rightDrawablePadding) {
            setRightDrawaablePadding(typedArray.getDimensionPixelSize(attr, CommUtils.dp2px(mDefaultDrawablePadding)));
        } else if (attr == R.styleable.title_bar_title_bar_titleDrawablePadding) {
            setTitleDrawablePadding(typedArray.getDimensionPixelSize(attr, CommUtils.dp2px(mDefaultDrawablePadding)));
        }else if(attr == R.styleable.title_bar_title_bar_leftAndRightPadding){
            int leftAndRightPadding = typedArray.getDimensionPixelSize(attr, CommUtils.dp2px(mDefaultLeftAndRightPadding));
            mLeftCtv.setPadding(leftAndRightPadding, leftAndRightPadding, leftAndRightPadding, leftAndRightPadding);
            mRightCtv.setPadding(leftAndRightPadding, leftAndRightPadding, leftAndRightPadding, leftAndRightPadding);
        }
    }
    public void initView(View view){
        mLeftCtv = (TextView) view.findViewById(R.id.title_bar_left);
        mRightCtv = (TextView)view.findViewById(R.id.title_bar_right);
        mTitleCtv = (TextView)view.findViewById(R.id.title_bar_title);

        mLeftCtv.setOnClickListener(this);
        mRightCtv.setOnClickListener(this);
        mTitleCtv.setOnClickListener(this);

        setLeftDrawable(R.drawable.back_arrow);
    }

    public void setTitleBarListener(TitleBarListener titleBarListener) {
        this.titleBarListener = titleBarListener;
    }

    @Override
    public void onClick(View v) {
        if(titleBarListener!=null){
            switch (v.getId()){
                case R.id.title_bar_left:
                    titleBarListener.onClickLeft();
                    break;
                case R.id.title_bar_title:
                    titleBarListener.onClickCenter();
                    break;
                case R.id.title_bar_right:
                    titleBarListener.onClickRight();
                    break;
            }
        }else{
            switch (v.getId()){
                case R.id.title_bar_left:
                    Toast.makeText(mContext,"left",Toast.LENGTH_SHORT).show();
                    break;
                case R.id.title_bar_title:
                    titleBarListener.onClickCenter();
                    break;
                case R.id.title_bar_right:
                    titleBarListener.onClickRight();
                    break;
            }
        }
    }

    public  void setCenterTv(int resd){
        mTitleCtv.setText(resd);
    }
    private void setLeftDrawable(Drawable drawable) {
        if (drawable != null) {
            drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
            mLeftCtv.setCompoundDrawables(drawable, null, null, null);
            showLeft();
        }
    }

    public void setLeftDrawable(int id) {
        Drawable drawable = ContextCompat.getDrawable(getContext(), id);
        setLeftDrawable(drawable);
    }
    public void showLeft(){
        mLeftCtv.setVisibility(View.VISIBLE);
    }

    private void setLeftText(CharSequence text) {
        mLeftCtv.setText(text);
        showLeft();
    }
    private void setRightText(CharSequence text) {
        mRightCtv.setText(text);
        showRight();
    }
    public void showRight(){
        mRightCtv.setVisibility(View.VISIBLE);
    }
    public void setTitleText(CharSequence text) {
        mTitleCtv.setText(text);
        showTitle();
    }
    public void setRightDrawable(int id) {
        Drawable drawable = ContextCompat.getDrawable(getContext(), id);
        setRightDrawable(drawable);
    }
    private void setRightDrawable(Drawable drawable) {
        if(drawable != null){
            drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
            mRightCtv.setCompoundDrawables(null, null, drawable, null);
            showRight();
        }
    }

    private void showTitle(){
        mTitleCtv.setVisibility(View.VISIBLE);
    }

    private void setTitleDrawable(Drawable drawable) {
        if (drawable != null) {
            drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
            mTitleCtv.setCompoundDrawables(null, null, drawable, null);
            showTitle();
        }
    }
    private void setLeftAndRightTextSize(int px){
        mLeftCtv.setTextSize(TypedValue.COMPLEX_UNIT_PX, px);
        mRightCtv.setTextSize(TypedValue.COMPLEX_UNIT_PX, px);
    }
    private void setTitleTextSize(int px){
        mTitleCtv.setTextSize(TypedValue.COMPLEX_UNIT_PX, px);
    }
    private void setRightTextColor(ColorStateList color){
        mRightCtv.setTextColor(color);
    }
    private void setLeftTextColor(ColorStateList color){
        mLeftCtv.setTextColor(color);
    }
    public void setTitleTextColor(int id){
        setTitleTextColor(ColorStateList.valueOf(getColor(id)));
    }
    private void setTitleTextColor(ColorStateList color){
        mTitleCtv.setTextColor(color);
    }

    private void setLeftDrawablePadding(int px){
        mLeftCtv.setCompoundDrawablePadding(px);
    }
    private void setRightDrawaablePadding(int px){
        mRightCtv.setCompoundDrawablePadding(px);
    }

    private void setTitleDrawablePadding(int px){
        mTitleCtv.setCompoundDrawablePadding(px);
    }
    private int getColor(int id){
        return ContextCompat.getColor(getContext(), id);
    }


    public interface  TitleBarListener{
        public void onClickRight();
        public void onClickLeft();
        public void onClickCenter();
    }
}
