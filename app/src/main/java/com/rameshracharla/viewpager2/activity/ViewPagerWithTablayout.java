package com.rameshracharla.viewpager2.activity;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;
import com.rameshracharla.viewpager2.R;
import com.rameshracharla.viewpager2.fragment.FragmentOne;
import com.rameshracharla.viewpager2.fragment.FragmentThree;
import com.rameshracharla.viewpager2.fragment.FragmentTwo;

public class ViewPagerWithTablayout extends AppCompatActivity {
    private static final int NUM_PAGES = 3;
    public static ViewPager2 viewPager;
    private FragmentStateAdapter pagerAdapter;
    //For Tab Titles
    private String[] titles = new String[]{"Fragment One", "Fragment Two", "Fragment Three"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_viewpager_tablayout);
        viewPager = findViewById(R.id.view_pager);
        pagerAdapter = new MyPagerAdapter(this);
        viewPager.setAdapter(pagerAdapter);
        // Horizontal Scroll
        viewPager.setOrientation(ViewPager2.ORIENTATION_HORIZONTAL);
        //Vertical scroll
        //viewPager.setOrientation(ViewPager2.ORIENTATION_VERTICAL);
        TabLayout tabLayout = (TabLayout) findViewById(R.id.tab_layout);
        new TabLayoutMediator(tabLayout, viewPager, (tab, position) -> tab.setText(titles[position])).attach();
    }

    private class MyPagerAdapter extends FragmentStateAdapter {
        public MyPagerAdapter(FragmentActivity fa) {
            super(fa);
        }

        @NonNull
        @Override
        public Fragment createFragment(int pos) {
            switch (pos) {
                case 0: {
                    return new FragmentOne();
                }
                case 1: {
                    return new FragmentTwo();
                }
                case 2: {
                    return new FragmentThree();
                }
                default:
                    return new FragmentOne();
            }
        }

        @Override
        public int getItemCount() {
            return NUM_PAGES;
        }
    }

    @Override
    public void onBackPressed() {
        if (viewPager.getCurrentItem() == 0) {
            //activity will close
            super.onBackPressed();
        } else {
            // will move to previous page
            viewPager.setCurrentItem(viewPager.getCurrentItem() - 1);
        }
    }
}