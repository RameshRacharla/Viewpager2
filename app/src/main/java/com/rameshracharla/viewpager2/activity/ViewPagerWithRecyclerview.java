package com.rameshracharla.viewpager2.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import com.rameshracharla.viewpager2.R;
import com.rameshracharla.viewpager2.adapter.MyAdapter;

import java.util.ArrayList;

public class ViewPagerWithRecyclerview extends AppCompatActivity {
    ViewPager2 myViewPager2;
    MyAdapter MyAdapter;
    TextView text_orientation;
    Button button;
    private ArrayList<String> arrayList = new ArrayList<>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_viewpager_recylerview);
        myViewPager2 = findViewById(R.id.view_pager);
        button = findViewById(R.id.button);
        text_orientation = findViewById(R.id.text_orientation);

        arrayList.add("Page 1");
        arrayList.add("Page 2");
        arrayList.add("Page 3");
        arrayList.add("Page 4");
        arrayList.add("Page 5");

        MyAdapter = new MyAdapter(this, arrayList);
        myViewPager2.setOrientation(ViewPager2.ORIENTATION_HORIZONTAL);
        text_orientation.setText("Horizontal");
        myViewPager2.setAdapter(MyAdapter);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (myViewPager2.getOrientation() == ViewPager2.ORIENTATION_HORIZONTAL) {
                    text_orientation.setText("Vertical");
                    myViewPager2.setOrientation(ViewPager2.ORIENTATION_VERTICAL);
                } else {
                    text_orientation.setText("Horizontal");
                    myViewPager2.setOrientation(ViewPager2.ORIENTATION_HORIZONTAL);
                }

            }
        });
    }
}
