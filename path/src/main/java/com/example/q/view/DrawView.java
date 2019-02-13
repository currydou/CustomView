package com.example.q.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.view.View;

import com.example.q.R;

/**
 * Created by curry.zhang on 4/12/2017.
 */

public class DrawView extends View {

    public DrawView(Context context) {
        super(context);
    }

    public DrawView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        /*
         * 方法 说明 drawRect 绘制矩形 drawCircle 绘制圆形 drawOval 绘制椭圆 drawPath 绘制任意多边形
         * drawLine 绘制直线 drawPoint 绘制点
         */
        // 创建画笔
        Paint p = new Paint();
        p.setColor(Color.RED);// 设置红色

        canvas.drawText("画圆：", 10, 20, p);// 画文本
        canvas.drawCircle(160, 20, 10, p);// 小圆
        p.setAntiAlias(true);// 设置画笔的锯齿效果。 true是去除，大家一看效果就明白了
        canvas.drawCircle(320, 20, 20, p);// 大圆

        canvas.drawText("画线及弧线：", 10, 90, p);
        p.setColor(Color.GREEN);// 设置绿色
        canvas.drawLine(260, 190, 300, 140, p);// 画线
        canvas.drawLine(310, 190, 390, 180, p);// 斜线

        //画笑脸弧线
        p.setStyle(Paint.Style.STROKE);//设置空心
        RectF oval1 = new RectF(350, 120, 380, 140);
        canvas.drawArc(oval1, 180, 180, false, p);//小弧形
        oval1.set(390, 120, 420, 140);
        canvas.drawArc(oval1, 180, 180, false, p);//小弧形
        oval1.set(360, 130, 410, 160);
        canvas.drawArc(oval1, 0, 180, false, p);//小弧形

        canvas.drawText("画矩形：", 10, 390, p);
        p.setColor(Color.GRAY);// 设置灰色
        p.setStyle(Paint.Style.FILL);//设置填满
        canvas.drawRect(160, 360, 380, 380, p);// 正方形
//        canvas.drawRect(160, 190, 160, 200, p);// 长方形

        canvas.drawText("画扇形和椭圆:", 10, 450, p);
        /* 设置渐变色 这个正方形的颜色是改变的 */
        Shader mShader = new LinearGradient(0, 0, 100, 100,
                new int[]{Color.RED, Color.GREEN, Color.BLUE, Color.YELLOW,
                        Color.LTGRAY}, null, Shader.TileMode.REPEAT); // 一个材质,打造出一个线性梯度沿著一条线。
//        p.setShader(mShader);
        // p.setColor(Color.BLUE);
        RectF oval2 = new RectF(160, 400, 500, 540);// 设置个新的长方形，扫描测量
        canvas.drawArc(oval2, 200, 130, true, p);
        // 画弧，第一个参数是RectF：该类是第二个参数是角度的开始，第三个参数是多少度，第四个参数是真的时候画扇形，是假的时候画弧线
        //画椭圆，把oval改一下
        oval2.set(510, 400, 550, 430);
        canvas.drawOval(oval2, p);

        p.setColor(Color.RED);
        canvas.drawText("画三角形：", 10, 500, p);
        // 绘制这个三角形,你可以绘制任意多边形
        Path path = new Path();
        path.moveTo(200, 500);// 此点为多边形的起点
        path.lineTo(240, 550);
        path.lineTo(200, 550);
        path.close(); // 使这些点构成封闭的多边形
        p.setStyle(Paint.Style.STROKE);//空心
        canvas.drawPath(path, p);

        /**
         * 旋转测试。顺时针旋转，以这个坐标为圆点
         */
        canvas.save();
        canvas.rotate(60f,200,500);
        canvas.drawPath(path, p);
        canvas.restore();

        //六边形
        // 你可以绘制很多任意多边形，比如下面画六连形，
        p.reset();//重置
        p.setColor(Color.LTGRAY);
        p.setStyle(Paint.Style.FILL_AND_STROKE);//设置空心
        Path path1 = new Path();
        path1.moveTo(580, 600);
        path1.lineTo(600, 600);
        path1.lineTo(610, 610);
        path1.lineTo(600, 620);
        path1.lineTo(580, 620);
        path1.lineTo(570, 610);
        path1.close();//封闭
        canvas.drawPath(path1, p);
        /*
         * Path类封装复合(多轮廓几何图形的路径
         * 由直线段*、二次曲线,和三次方曲线，也可画以油画。drawPath(路径、油漆),要么已填充的或抚摸
         * (基于油漆的风格),或者可以用于剪断或画画的文本在路径。
         */

        //画圆角矩形
        p.setStyle(Paint.Style.FILL);//充满
        p.setColor(Color.LTGRAY);
        p.setAntiAlias(true);// 设置画笔的锯齿效果
        canvas.drawText("画圆角矩形:", 10, 560, p);
        RectF oval3 = new RectF(180, 560, 300, 600);// 设置个新的长方形
        canvas.drawRoundRect(oval3, 5, 5, p);//第二个参数是x半径，第三个参数是y半径

        //画贝塞尔曲线
        canvas.drawText("画贝塞尔曲线:", 10, 710, p);
        p.reset();
        p.setStyle(Paint.Style.STROKE);
        p.setColor(Color.GREEN);
        Path path2 = new Path();
        path2.moveTo(400, 620);//设置Path的起点
        path2.quadTo(450, 610, 570, 700); //设置贝塞尔曲线的控制点坐标和终点坐标
        canvas.drawPath(path2, p);//画出贝塞尔曲线

        //画点
        p.setStyle(Paint.Style.FILL);
        p.setColor(Color.RED);
        canvas.drawText("画点：", 10, 890, p);
        canvas.drawPoint(60, 790, p);//画一个点
        canvas.drawPoints(new float[]{60, 400, 65, 400, 70, 400}, p);//画多个点

        //画图片，就是贴图
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.ic_launcher);
        canvas.drawBitmap(bitmap, 0, 0, p);
    }
}

