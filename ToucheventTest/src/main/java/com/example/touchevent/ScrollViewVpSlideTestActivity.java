package com.example.touchevent;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;

import com.example.touchevent.fragemnts.BlankFragment1;
import com.example.touchevent.fragemnts.BlankFragment2;
import com.example.touchevent.fragemnts.MyAdapter;
import com.example.touchevent.fragemnts.MyAdapter2;
import com.example.touchevent.one.MyScrollView;

import java.util.ArrayList;
import java.util.List;

public class ScrollViewVpSlideTestActivity extends FragmentActivity {
    List<View> list = new ArrayList<>();
    List<Fragment> listViewPager = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

//        viewpagerViewpager();
//        viewpagerSrcoll();
        test();
    }

    private void viewpagerViewpager() {
        setContentView(R.layout.viewpager_viewpager);

        ViewPager viewPager = (ViewPager) findViewById(R.id.viewpagerBig);
        listViewPager.add(new BlankFragment1());
        listViewPager.add(new BlankFragment2());
        viewPager.setAdapter(new MyAdapter2(getSupportFragmentManager(), listViewPager));
    }

    private void viewpagerSrcoll() {
        setContentView(R.layout.viewpager_scrollview);

        ViewPager viewPager = (ViewPager) findViewById(R.id.vpTest);
        for (int i = 0; i < 3; i++) {
            ImageView imageView = new ImageView(this);
            imageView.setBackgroundResource(R.mipmap.ic_launcher);
            list.add(imageView);
        }
        viewPager.setAdapter(new MyAdapter(this, list));
    }

    private void test() {
        setContentView(R.layout.layout_one_scroll);

        final MyScrollView scrollView = (MyScrollView) findViewById(R.id.test);
        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                scrollView.getChildAt(0).scrollTo(0, 10);
            }
        });
    }




    /**
     * 只有当down返回true才会收到后续的move，up事件
     *
     * @param ev
     * @return
     */
    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {

        return super.dispatchTouchEvent(ev);
    }


    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                break;
            case MotionEvent.ACTION_MOVE:
                break;
            case MotionEvent.ACTION_UP:
                break;
        }
        return super.onTouchEvent(event);
    }
}
