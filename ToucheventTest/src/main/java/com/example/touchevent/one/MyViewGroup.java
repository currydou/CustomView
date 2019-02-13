package com.example.touchevent.one;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.LinearLayout;

/**
 *
 */

public class MyViewGroup extends LinearLayout {

    private int yDown;
    private int totalMove;

    public MyViewGroup(Context context, AttributeSet attrs) {
        super(context, attrs);
    }


    /**
     * 实现view的滑动有三种方式，这里用layout（）
     *
     * @param event
     * @return
     */
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        Log.e("curry", "3,"+getScrollY());
//        getParent().requestDisallowInterceptTouchEvent(true);
        return super.onTouchEvent(event);
    }
}
