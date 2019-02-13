package com.example.touchevent.mythink;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.ScrollView;


public class ScrollViewTest extends ScrollView {

    private int lastY;


    public ScrollViewTest(Context context) {
        this(context, null);
    }

    public ScrollViewTest(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public ScrollViewTest(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        //

    }

    /**
     * 先不管padding
     *
     * @return
     */
    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        switch (ev.getAction()) {
            case MotionEvent.ACTION_DOWN:
                lastY = (int) ev.getY();
                break;
            case MotionEvent.ACTION_MOVE:
                int currentY = (int) ev.getY();
//                if (currentY - lastY > 0) {
                    if (getScrollY() == 0) {
                        getParent().requestDisallowInterceptTouchEvent(false);//父容器可以拦截
                    } else {
                        getParent().requestDisallowInterceptTouchEvent(true);//入容器不可以拦截
                    }
//                }

                break;
            case MotionEvent.ACTION_UP:
                break;
        }
        return super.onTouchEvent(ev);
    }


}
