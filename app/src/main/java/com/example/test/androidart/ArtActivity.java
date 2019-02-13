package com.example.test.androidart;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.test.R;
import com.example.test.androidart.elasticslide.TestButton;


public class ArtActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main1);

//        scrollToAndByTest();
        scrollerTest();

    }

    private void scrollToAndByTest() {
        final Button btn1 = (Button) findViewById(R.id.btn1);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //以当前位置为基础，移动内容。初始位置始终是当前位置。也就是点击多次只会移动一次。
                btn1.scrollTo(50, 0);
            }
        });


        final Button btn2 = (Button) findViewById(R.id.btn2);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //以当前位置为基础，进行移动内容。移动后的位置是当前位置。点击多次，会移动多次
                btn2.scrollBy(60, 0);
            }
        });
    }

    private void scrollerTest() {
        final TestButton btnScroller = (TestButton) findViewById(R.id.btnScroller);
        btnScroller.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnScroller.smoothScrollTo(-50, 99);
            }
        });
    }

}
