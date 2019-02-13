package com.example.touchevent.fragemnts;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.touchevent.R;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class BlankFragment1 extends Fragment {


    private ViewPager viewPager;
    List<View> list = new ArrayList<>();

    public BlankFragment1() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_blank_fragment1, container, false);
        viewPager = (ViewPager) view.findViewById(R.id.vpTest);
        for (int i = 0; i < 3; i++) {
            ImageView imageView = new ImageView(getActivity());
            imageView.setBackgroundResource(R.mipmap.ic_launcher);
            list.add(imageView);
        }
        viewPager.setAdapter(new MyAdapter(getContext(), list));
        return view;
    }


}
