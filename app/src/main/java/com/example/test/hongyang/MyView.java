package com.example.test.hongyang;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Handler;
import android.util.AttributeSet;
import android.widget.TextView;

public class MyView extends TextView {

	private Paint paint;
	Path pathIn = new Path();
	Handler handler=new Handler();

	public MyView(Context context) {
		super(context);
	}

	public MyView(Context context, AttributeSet attrs) {
		super(context, attrs);
		paint = new Paint(Paint.ANTI_ALIAS_FLAG);
		paint.setColor(Color.RED);
	}

	public MyView(Context context, AttributeSet attrs, int defStyleAttr) {
		super(context, attrs, defStyleAttr);
	}
	
	@Override
	protected void onDraw(final Canvas canvas) {
		super.onDraw(canvas);
//		RectF rect = new RectF(getLeft(), getTop(), 200, 200);
//		canvas.drawArc(rect, 0, 60, true, paint);
		pathIn.moveTo(10.0f, 50);
		pathIn.lineTo(getWidth(), 50);
		paint.setTextSize(30f);
		canvas.drawTextOnPath("123",pathIn,0.0f,0.0f,paint);
//		pathIn.moveTo(0.0f, 0.0f );
//		pathIn.lineTo(0.0f, 100f);
//
//		handler.postDelayed(new Runnable() {
//			@Override
//			public void run() {
//				canvas.drawTextOnPath("123",pathIn,0.0f,0.0f,paint);
//			}
//		},3000);

	}

}
