package com.example.test.hongyang.custom;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;

import com.example.test.R;

/**
 * Created by curry.zhang on 3/28/2017.
 */

public class CustomTitleView extends View {
    /**
     * 文本
     */
    private String mTitleText;
    /**
     * 文本颜色
     */
    private int mTitleTextColor;
    /**
     * 文本大小
     */
    private int mTitleSize;

    /**
     * 绘制时控制文本绘制的范围
     */
    private Rect mBound;
    private Paint mPaint;

    public CustomTitleView(Context context) {
        this(context, null);
    }

    public CustomTitleView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public CustomTitleView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        //获得自定义的样式属性
        TypedArray a = context.getTheme().obtainStyledAttributes(
                attrs, R.styleable.CustomTitleView, defStyleAttr, 0);
        int n = a.getIndexCount();
        for (int i = 0; i < n; i++) {
            int attr = a.getIndex(i);
            switch (attr) {
                case R.styleable.CustomTitleView_titleText:
                    mTitleText = a.getString(attr);
                    break;
                case R.styleable.CustomTitleView_titleTextColor:
                    //默认设置为黑色
                    mTitleTextColor = a.getColor(attr, Color.BLACK);
                    break;
                case R.styleable.CustomTitleView_titleTextSize:
                    //默认设置为16sp，TypeValue也可以把sp转化为px
                    mTitleSize = a.getDimensionPixelSize(attr,
                            (int) TypedValue.applyDimension(
                                    TypedValue.COMPLEX_UNIT_SP, 16, getResources().getDisplayMetrics()));
                    break;
            }
        }
        a.recycle();
        /**
         * 获得绘制文本的宽和高
         */
        mPaint = new Paint();
        mPaint.setTextSize(mTitleSize);

        mBound = new Rect();
        //返回包围这个文本的最小矩形。然后可以用这个矩形的宽高
        mPaint.getTextBounds(mTitleText, 0, mTitleText.length(), mBound);

    }

    /**
     * -----------------------------------------------------------------------------------------这里的处理方式跟书上的不一样
     *
     * @param widthMeasureSpec  -------------------------------------------------------------但是都是只是处理wrap_content！！！
     * @param heightMeasureSpec
     */
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {

        int widthSpecMode = MeasureSpec.getMode(widthMeasureSpec);
        int widthSpecSize = MeasureSpec.getSize(widthMeasureSpec);
        int heightSpecMode = MeasureSpec.getMode(heightMeasureSpec);
        int heightSpecSize = MeasureSpec.getSize(heightMeasureSpec);
        //自己提供的值
        int width;
        int height;
        //处理宽
        if (widthSpecMode == MeasureSpec.EXACTLY) {
            //用默认的size
            width = widthSpecSize;
        } else {
            //否则自己计算，提供一个值。(文本的宽度加上左右padding的大小)
            width = getPaddingLeft() + mBound.width() + getPaddingRight();
        }
        //处理高
        if (heightSpecMode == MeasureSpec.EXACTLY) {
            height = heightSpecSize;
        } else {
            height = getPaddingTop() + mBound.height() + getPaddingBottom();
        }
        setMeasuredDimension(width, height);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        //长方形
        mPaint.setColor(Color.YELLOW);
        canvas.drawRect(0, 0, getWidth(), getHeight(), mPaint);

        //文本
        mPaint.setColor(mTitleTextColor);
        //------------------------------------------------
        canvas.drawText(mTitleText, getWidth() / 2 - mBound.width() / 2, getHeight() / 2 + mBound.height() / 2, mPaint); //为什么这里要除以4才在中间
        //-------------------------------------------不是。是因为预览的不准确，实际手机中 不这样。运行之后的效果和设想的一样。
    }
}
