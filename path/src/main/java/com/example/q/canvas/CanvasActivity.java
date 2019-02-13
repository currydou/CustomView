package com.example.q.canvas;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;

import com.example.q.R;


public class CanvasActivity extends Activity {

    private MyCanvasView myCanvasView = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_canvas);
        myCanvasView = (MyCanvasView)findViewById(R.id.myView);
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.android);
        myCanvasView.setBitmap(bitmap);

        Intent intent = getIntent();
        if(intent != null){
            MyCanvasView.DrawMode drawMode = MyCanvasView.DrawMode.valueOf(intent.getIntExtra("drawMode", 0));
            myCanvasView.setDrawMode(drawMode);
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if(myCanvasView != null){
            myCanvasView.destroy();
            myCanvasView = null;
        }
    }
}
