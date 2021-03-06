package com.example.ihsan;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

public class SplashActivity extends AppCompatActivity {

    //Жидкие экраны сплашки и все

    private static final int NUM_PAGES = 5;
    private ViewPager viewPager;
    private SplashActivity.ScreenSlidePagerAdapter pagerAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        viewPager = findViewById(R.id.pager);
        pagerAdapter = new SplashActivity.ScreenSlidePagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(pagerAdapter);
    }
    private class ScreenSlidePagerAdapter extends FragmentStatePagerAdapter {
        public ScreenSlidePagerAdapter(@NonNull FragmentManager fm) {
            super(fm);
        }
        @NonNull
        @Override
        public Fragment getItem(int position) {
            switch (position)
        {
                case 0:
                    OnBoardingFragment0 tab0 = new OnBoardingFragment0();
                    return tab0;
                case 1:
                    OnBoardingFragment1 tab1 = new OnBoardingFragment1();
                    return tab1;
                case 2:
                    OnBoardingFragment2 tab2 = new OnBoardingFragment2();
                return tab2;
                case 3:
                    OnBoardingFragment3 tab3 = new OnBoardingFragment3();
                    return tab3;
                case 4:
                    OnBoardingFragment4 tab4 = new OnBoardingFragment4();
                    return tab4;

            }
            return null;
        }
        @Override
        public int getCount() {
            return NUM_PAGES;
        }
    }

}