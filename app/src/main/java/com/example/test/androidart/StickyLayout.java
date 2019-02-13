package com.example.test.androidart;

import android.content.Context;
import android.view.MotionEvent;
import android.widget.LinearLayout;

/**
 * 先改成无bom模式
 * http://blog.csdn.net/Nice_czm/article/details/51917760
 * Created by curry.zhang on 3/17/2017.
 */

public class StickyLayout extends LinearLayout {

    private int mTouchSlop;
    //分别记录上次滑动的坐标
    private int mLastX=0;
    private int mLastY = 0;
    //分别记录上次滑动的坐标(onInterceptTouchEvent)
    private int MLastXIntercept=0;
    private int MLastYIntercept = 0;
    private boolean mDisallowInterceptTouchEventOnHeader;

    public StickyLayout(Context context) {
        super(context);
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent event) {
        int intercepted = 0;
        int x = (int) event.getX();
        int y = (int) event.getY();

        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                MLastXIntercept = x;
                MLastYIntercept = y;
                mLastX = x;
                mLastY = y;
                intercepted=0;
                break;
            case MotionEvent.ACTION_MOVE:
                int deltaX = x - MLastXIntercept;
                int deltaY = y - MLastYIntercept;
//                if (mDisallowInterceptTouchEventOnHeader&&y<=ge)
                break;
            case MotionEvent.ACTION_UP:
                break;
        }

        return super.onInterceptTouchEvent(event);
    }
}
