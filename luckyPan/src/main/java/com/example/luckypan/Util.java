package com.example.luckypan;

import android.content.Context;

/**
 * 尺寸测量工具类
 * @author layer
 * 2016-9-19
 */
public class Util {

	//获取屏幕测量的规模比例
    public static int dip2px(Context context, float dpValue) {
    	//获取比例大小
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dpValue * scale + 0.5f);
    }
    //字体的测量比例
    public static int sp2px(Context context, float spValue) {
        final float fontScale = context.getResources().getDisplayMetrics().scaledDensity;
        return (int) (spValue * fontScale + 0.5f);
    }
    //旋转角度的改变距离
    public static double change(double a){
        return a * Math.PI  / 180;
    }
    //改变的角度
    public static double changeAngle(double a){
        return a * 180 / Math.PI;
    }

}
