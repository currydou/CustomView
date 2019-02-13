package com.example.test;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.test.androidart.ArtActivity;
import com.example.test.hongyang.custom.Custom1Activity;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnArt:
                startActivity(new Intent(MainActivity.this, ArtActivity.class));
                break;
            case R.id.btnHYCustom1:
                startActivity(new Intent(MainActivity.this, Custom1Activity.class));
                break;
        }
    }

}
