package com.example.touchevent.one;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.ScrollView;

/**
 * Created by curry.zhang on 12/28/2016.
 * 用一个和两个现在还是同样的问题
 */

public class MyScrollView extends ScrollView {

    private int mLastX;
    private int mLastY;

    private int yDown;
    private int totalMove;
    public MyScrollView(Context context) {
        super(context);
    }

    public MyScrollView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MyScrollView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }
    /**
     * 外部拦截法
     *
     * @param ev
     * @return
     */
//    @Override
//    public boolean onInterceptTouchEvent(MotionEvent ev) {
//        boolean isIntercept = false;
//        int y = (int) ev.getY();
//        switch (ev.getAction()) {
//            case MotionEvent.ACTION_DOWN:
//                yDown = y;
//                break;
//            case MotionEvent.ACTION_MOVE:
//                if (y - yDown > 0) {
//                    isIntercept = true;
//                } else {
//                    isIntercept = false;
//                }
//                break;
//            case MotionEvent.ACTION_UP:
//                break;
//        }
//        return isIntercept;
//    }

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
                totalMove -= getScrollY();
//                Log.e("curry", "1,"+String.valueOf(getScrollY()));
//                Log.e("curry", "2,"+getChildAt(0).getScrollY());
                break;
            case MotionEvent.ACTION_MOVE:
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
        return super.onTouchEvent(event);
    }
//    @Override
//    public boolean onTouchEvent(MotionEvent ev) {
//        switch (ev.getAction()) {
//            case MotionEvent.ACTION_MOVE:
//                int scrollY = getScrollY();
//                if (scrollY == 0) {
//                    getParent().requestDisallowInterceptTouchEvent(false);//父容器可以拦截
//                } else {
//                    getParent().requestDisallowInterceptTouchEvent(true);//入容器不可以拦截
//                }
//                Log.e("curry", String.valueOf(scrollY));
//                break;
//        }
//        return super.onTouchEvent(ev);
//    }

    /*
    *//**
     * 内部拦截法。
     * 1，父容器需要先拦截除了down以外的事件
     * 2，子容器在需要自己的使用事件的地方，不让父容器拦截即可
     *
     * @param ev
     * @return
     *//*
    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        int x = (int) ev.getX();
        int y = (int) ev.getY();
        switch (ev.getAction()) {
            case MotionEvent.ACTION_DOWN:
                getParent().requestDisallowInterceptTouchEvent(true);
                break;
            case MotionEvent.ACTION_MOVE:
                int deltaX = x - mLastX;
                int deltaY = y - mLastY;
                if (*//*父容器需要拦截*//*) {
                    getParent().requestDisallowInterceptTouchEvent(false);
                } else {
                    //父容器不需要拦截
                    getParent().requestDisallowInterceptTouchEvent(true);
                }
                break;
            case MotionEvent.ACTION_UP:
                break;
            default:
                break;
        }
        mLastX = x;
        mLastY = y;
        return super.dispatchTouchEvent(ev);
    }

    //父容器需要重写此方法
    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        int action = ev.getAction();
        if (action == MotionEvent.ACTION_DOWN) {
            return false;
        } else {
            return true;
        }
    }*/

}
