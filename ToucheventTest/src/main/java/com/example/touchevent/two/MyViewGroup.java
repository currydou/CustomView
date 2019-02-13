package com.example.touchevent.two;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.LinearLayout;

/**
 * Crated by curry.zhang on 12/27/2016.
 * getleft获得的不是固定值吗？？先放着，猜想，只有用属性动画时，他才是固定的
 * 1，感觉源码写的逻辑有问题
 * 2，scrollview先往上画一小块，然后往下滑大于这一小块。之后滑动的距离会自动再加上这一小块，突然往下了
 * 3，跟书上的用的拦截不是一个方法，试试是不是都可以
 * <p>
 * 之前遇过的滑动问题
 * 试试用一个scrollview行不信
 */

public class MyViewGroup extends LinearLayout {

    private int yDown;
    private int totalMove;

    public MyViewGroup(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    /**
     * 外部拦截法
     *
     * @param ev
     * @return
     */
    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        boolean isIntercept = false;
        int y = (int) ev.getY();
        switch (ev.getAction()) {
            case MotionEvent.ACTION_DOWN:
                yDown = y;
                break;
            case MotionEvent.ACTION_MOVE:
                if (y - yDown > 0) {
                    isIntercept = true;
                } else {
                    isIntercept = false;
                }
                break;
            case MotionEvent.ACTION_UP:
                break;
        }
        return isIntercept;
    }

    /**
     * 实现view的滑动有三种方式，这里用layout（）
     *
     * @param event
     * @return
     */
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        int y = (int) event.getY();
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN://上面down的时候没有拦截，所以这里的down应该收不到，但是上面的已经获取了ydown，应该没有影响
                yDown = y;
                break;
            case MotionEvent.ACTION_MOVE:
                Log.e("curry111", String.valueOf(getScrollY()));
                if (y - yDown > 0 ) {
                    int mMove = y - yDown;
                    totalMove += mMove;
                    layout(getLeft(), getTop() + mMove, getRight(), getBottom() + mMove);//这时候这两种写法一样
//                    layout((int) getX(), (int) (getY() + mMove), (int) (getX()+getWidth()), (int) (getY()+getHeight() + mMove));
                }
                break;
            case MotionEvent.ACTION_UP:
                layout(getLeft(), getTop() - totalMove, getRight(), getBottom() - totalMove);//这时候这两种写法一样
//                layout((int) getX(), (int) (getY() - totalMove), (int) (getX()+getWidth()), (int) (getY()+getHeight()  - totalMove));
                totalMove = 0;
                break;
        }
        return true;
    }
}
