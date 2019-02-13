package com.example.test.androidart.elasticslide;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.Button;
import android.widget.Scroller;

/**
 * Created by curry.zhang on 4/10/2017.
 */

public class TestButton extends Button {

    private Scroller scroller;

    public TestButton(Context context) {
        this(context, null);
    }

    public TestButton(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public TestButton(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    private void init(Context context) {
        scroller = new Scroller(context);


    }

    public void smoothScrollTo(int destX, int destY) {
        int scrollX = getScrollX();
        int diffX = destX - scrollX;
        scroller.startScroll(scrollX, 0, diffX, 0, 1000);
        invalidate();
    }

    @Override
    public void computeScroll() {
        super.computeScroll();
        if (scroller.computeScrollOffset()) {
            scrollTo(scroller.getCurrX(), scroller.getCurrY());
            postInvalidate();
        }
    }
}
