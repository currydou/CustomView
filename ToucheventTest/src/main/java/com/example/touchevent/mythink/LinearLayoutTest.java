package com.example.touchevent.mythink;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.LinearLayout;

/**
 * 这是个button，所以触摸的时候，getY()的父容器是button。
 * 在按下移动的过程中，假如移动了50(假设初始Y 60 和移动之后 110 的差值) ，移动后getY()是110，然后layout()重新布局，
 * getY()得到的值就会逐渐变小，差不多到达60， 因为 button 在靠近手指的位置，所以相对父容器的位置会变小
 * Created by curry.zhang on 4/6/2017.
 */
public class LinearLayoutTest extends LinearLayout {

    private static final String TAG = "TempTestView";
    private int lastX;
    private int lastY;
    private int diffY;
    private int initialY;
    boolean firstLayout = true;
    private int mLeft;
    private int mTop;
    private int mRight;
    private int mBottom;
    private int tempTop;
    private Context context;
    private int currentTop;
    private int diff;

    public LinearLayoutTest(Context context) {
        this(context, null);
    }

    public LinearLayoutTest(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public LinearLayoutTest(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        //
        this.context = context;
    }


    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
        if (firstLayout) {
            firstLayout = false;

            mLeft = getLeft();
            mTop = getTop();
            mRight = getRight();
            mBottom = getBottom();
            Log.i(TAG, "layout:" + left + "," + top + "," + right + "," + bottom);
        }

    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {

        switch (ev.getAction()) {
            case MotionEvent.ACTION_DOWN:
                System.out.println("d");
                break;
            case MotionEvent.ACTION_MOVE:
                System.out.println("d");
                break;
            case MotionEvent.ACTION_UP:
                System.out.println("d");
                break;
        }
        return super.dispatchTouchEvent(ev);
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        boolean intercept = false;
        switch (ev.getAction()) {
            case MotionEvent.ACTION_DOWN:
                lastY = (int) ev.getY();
                break;
            case MotionEvent.ACTION_MOVE:
                int currentY = (int) ev.getY();
                if (currentY - lastY > 0) {
                    //这里没有getScrollY()的说法。
                    //往下滑,拦截
                    intercept = true;
                    diff = currentY - lastY;
                    Log.i("curry", "getTop:" + getTop() + "  getTop:" + getY() + "  getTop:" + getTranslationY()+ "  currentTop:" + currentTop);
                } else {
                    //往上滑，内部消费事件
                    intercept = false;
                }

                break;
            case MotionEvent.ACTION_UP:
                break;
        }
        return intercept;
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                //第一次的时候获取手指触摸的y坐标
                lastY = (int) event.getY();
                break;
            case MotionEvent.ACTION_MOVE:
                //得到当前的y坐标
                int currentY = (int) event.getY();
                //计算差值
                diffY = currentY - lastY;
                Log.i(TAG, "currentY:" + currentY + "  initialY:" + initialY + "  diffY:" + diffY);
                //重新布局
                currentTop = getTop() + diffY-diff;
                layout(getLeft(), currentTop, getRight(), getBottom() + diffY);


                Log.i(TAG, getLeft() + "," + getTop() + "," + getRight() + "," + getBottom());
                break;
            case MotionEvent.ACTION_UP:
                //还原布局
                layout(mLeft, mTop, mRight, mBottom);


                Log.i(TAG, "diffY:" + diffY + "  " + mLeft + "," + mTop + "," + mRight + "," + mBottom);//测试获取坐标的几种方法
                break;
        }
        return super.onTouchEvent(event);//源码是不是也是true,去掉好像也没什么。。。。。。。。。
    }

}
