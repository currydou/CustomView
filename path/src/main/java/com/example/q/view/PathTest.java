package com.example.q.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by curry.zhang on 4/12/2017.
 */

public class PathTest extends View {

    private Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
    private Path path = new Path();
    Shader mShader = new LinearGradient(0, 0, 100, 100,
            new int[]{Color.RED, Color.GREEN, Color.BLUE, Color.YELLOW},
            null, Shader.TileMode.REPEAT);

    public PathTest(Context context) {
        super(context);
    }

    public PathTest(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public PathTest(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        paint.setColor(Color.GREEN);
        paint.setStyle(Paint.Style.FILL);
        paint.setStrokeWidth(5);
        paint.setShader(mShader);
        canvas.drawCircle(140, 140, 130, paint);
        Rect rect = new Rect(20, 80, 100, 100);
        canvas.drawRect(rect, paint);

    }
}
