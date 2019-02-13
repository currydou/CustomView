package com.example.touchevent.fragemnts;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by curry.zhang on 12/28/2016.
 */

public class MyAdapter2 extends FragmentPagerAdapter {

    List<Fragment> list = new ArrayList<>();

    public MyAdapter2(FragmentManager fm, List<Fragment> fragmentList) {
        super(fm);
        this.list=fragmentList;
    }

    @Override
    public android.support.v4.app.Fragment getItem(int position) {
        Fragment fragment = list.get(position);
        return fragment;
    }

    @Override
    public int getCount() {
        return list.size();
    }
}
