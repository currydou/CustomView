package com.example.test.hongyang.custom;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;

import com.example.test.R;

/**
 * Created by curry.zhang on 3/28/2017.
 */

public class CustomProgressBar extends View {
    /**
     * 第一圈的颜色
     */
    private int mFirstColor;
    /**
     * 第二圈的颜色
     */
    private int mSecondColor;
    /**
     * 圈的宽度
     */
    private int mCircleWidth;
    /**
     * 画笔
     */
    private Paint mPaint;
    /**
     * 当前进度
     */
    private int mProgress;

    /**
     * 速度
     */
    private int mSpeed;

    /**
     * 是否应该开始下一个颜色
     */
    private boolean isNext = false;

    public CustomProgressBar(Context context) {
        this(context, null);
    }

    public CustomProgressBar(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    /**
     * 必要的初始化，获得一些自定义的值
     *
     * @param context
     * @param attrs
     * @param defStyle
     */
    public CustomProgressBar(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        TypedArray a = context.getTheme().obtainStyledAttributes(attrs, R.styleable.CustomProgressBar, defStyle, 0);
        int n = a.getIndexCount();

        for (int i = 0; i < n; i++) {
            int attr = a.getIndex(i);
            switch (attr) {
                case R.styleable.CustomProgressBar_firstColor:
                    mFirstColor = a.getColor(attr, Color.GREEN);
                    break;
                case R.styleable.CustomProgressBar_secondColor:
                    mSecondColor = a.getColor(attr, Color.RED);
                    break;
                case R.styleable.CustomProgressBar_circleWidth:
                    mCircleWidth = a.getDimensionPixelSize(attr, (int) TypedValue.applyDimension(
                            TypedValue.COMPLEX_UNIT_PX, 20, getResources().getDisplayMetrics()));
                    break;
                case R.styleable.CustomProgressBar_speed:
                    // 默认20
                    mSpeed = a.getInt(attr, 20);
                    break;
            }
        }
        a.recycle();
        mPaint = new Paint();
        // 绘图线程
        new Thread() {
            public void run() {
                while (true) {
                    mProgress++;
                    if (mProgress == 360) {
                        mProgress = 0;
                        if (!isNext) {
                            isNext = true;
                        } else {
                            isNext = false;
                        }
                    }
                    postInvalidate();
                    try {
                        Thread.sleep(mSpeed);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }.start();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        // 获取圆心的x坐标
        int centre = getWidth() / 2;
        // 半径
        int radius = centre - mCircleWidth / 2;
        // 设置圆环的宽度
        mPaint.setStrokeWidth(mCircleWidth);
        // 消除锯齿
        mPaint.setAntiAlias(true);
        // 设置空心
        mPaint.setStyle(Paint.Style.STROKE);
        // 用于定义的圆弧的形状和大小的界限
        //RectF 和 Rect 都是矩形 ， 类型不同 ，前者是float类型 。他们还有一些方法不同
        RectF oval = new RectF(centre - radius, centre - radius, centre + radius, centre + radius);
        // 第一颜色的圈完整，第二颜色跑
        if (!isNext) {
            // 设置圆环的颜色
            mPaint.setColor(mFirstColor);
            // 画出圆环
            canvas.drawCircle(centre, centre, radius, mPaint);
            // 设置圆环的颜色
            mPaint.setColor(mSecondColor);
            // 根据进度画圆弧
            canvas.drawArc(oval, -90, mProgress, false, mPaint);
        } else {
            // 设置圆环的颜色
            mPaint.setColor(mSecondColor);
            // 画出圆环
            canvas.drawCircle(centre, centre, radius, mPaint);
            // 设置圆环的颜色
            mPaint.setColor(mFirstColor);
            // 根据进度画圆弧
            canvas.drawArc(oval, -90, mProgress, false, mPaint);
        }

    }
}
