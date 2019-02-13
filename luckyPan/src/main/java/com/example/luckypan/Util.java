package com.example.luckypan;

import android.content.Context;

/**
 * �ߴ����������
 * @author layer
 * 2016-9-19
 */
public class Util {

	//��ȡ��Ļ�����Ĺ�ģ����
    public static int dip2px(Context context, float dpValue) {
    	//��ȡ������С
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dpValue * scale + 0.5f);
    }
    //����Ĳ�������
    public static int sp2px(Context context, float spValue) {
        final float fontScale = context.getResources().getDisplayMetrics().scaledDensity;
        return (int) (spValue * fontScale + 0.5f);
    }
    //��ת�Ƕȵĸı����
    public static double change(double a){
        return a * Math.PI  / 180;
    }
    //�ı�ĽǶ�
    public static double changeAngle(double a){
        return a * 180 / Math.PI;
    }

}
