package com.example.touchevent;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.MotionEvent;

public class PublicNumberActivity extends FragmentActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.temptest);

//        TempTestView view= (TempTestView) findViewById(R.id.view);


//                ObjectAnimator.ofFloat(view, "translationY", 0, 100).setDuration(100).start();

    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        switch (ev.getAction()) {
            case MotionEvent.ACTION_DOWN:
                System.out.println("d");
                break;
            case MotionEvent.ACTION_MOVE:
                System.out.println("d");
                break;
            case MotionEvent.ACTION_UP:
                System.out.println("d");
                break;

        }
        return super.dispatchTouchEvent(ev);
    }
}
