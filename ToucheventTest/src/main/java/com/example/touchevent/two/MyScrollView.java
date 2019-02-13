package com.example.touchevent.two;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.ScrollView;

/**
 * Created by curry.zhang on 12/28/2016.
 */

public class MyScrollView extends ScrollView {

    private int mLastX;
    private int mLastY;

    public MyScrollView(Context context) {
        super(context);
    }

    public MyScrollView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MyScrollView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        switch (ev.getAction()) {
            case MotionEvent.ACTION_MOVE:
                int scrollY = getScrollY();
                if (scrollY == 0) {
                    getParent().requestDisallowInterceptTouchEvent(false);//父容器可以拦截
                } else {
                    getParent().requestDisallowInterceptTouchEvent(true);//入容器不可以拦截
                }
                Log.e("curry", String.valueOf(scrollY));
                break;
        }
        return super.onTouchEvent(ev);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {

        return super.dispatchTouchEvent(ev);
    }

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
