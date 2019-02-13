package com.example.q;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;

public class ViewActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        int flag = getIntent().getIntExtra("flag", 0);
        switch (flag) {
            case 0:
                setContentView(R.layout.activity_main);
                break;
            case 1:
                setContentView(R.layout.drawview);
                break;
        }

    }


}
