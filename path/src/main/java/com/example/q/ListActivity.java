package com.example.q;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.example.q.canvas.EntranceActivity;

public class ListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
    }

    public void onClick(View view) {
        Intent intent = new Intent(this, ViewActivity.class);
        switch (view.getId()) {
            case R.id.button:
                intent.putExtra("flag", 0);
                startActivity(intent);
                break;
            case R.id.button2:
                intent.putExtra("flag", 1);
                startActivity(intent);
                break;
            case R.id.button3:
                startActivity(new Intent(this, EntranceActivity.class));
                break;
        }
    }
}
