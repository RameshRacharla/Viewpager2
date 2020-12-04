package com.rameshracharla.viewpager2.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.rameshracharla.viewpager2.R;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button viewpagertablayout;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        viewpagertablayout = (Button) findViewById(R.id.viewpagertablayout);

        viewpagertablayout.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.viewpagertablayout:
                Intent i = new Intent(MainActivity.this, ViewPagerWithTablayout.class);
                startActivity(i);
                break;


            case R.id.viewpagerrecyclerview:

                break;
        }
    }
}
