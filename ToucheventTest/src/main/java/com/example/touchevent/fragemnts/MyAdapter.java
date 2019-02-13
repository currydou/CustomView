package com.example.touchevent.fragemnts;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by curry.zhang on 12/28/2016.
 */

public class MyAdapter extends PagerAdapter {

    List<View> list = new ArrayList<>();
    private Context mContext;


    public MyAdapter(Context context, List<View> imageViewList) {
        mContext = context;
        this.list=imageViewList;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        View imageView = list.get(position);
        container.addView(imageView);
        return imageView;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView(list.get(position));
    }
}
