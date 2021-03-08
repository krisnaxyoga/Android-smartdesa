package com.smartdesa.demo.Adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.smartdesa.demo.tutorial.FirstSlide;
import com.smartdesa.demo.tutorial.SecondSlide;
import com.smartdesa.demo.tutorial.ThirdSlide;

public class IntroAdapter extends FragmentPagerAdapter {


    public IntroAdapter(FragmentManager fm) {
        super(fm);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                return new FirstSlide();
            case 1:
                return new SecondSlide();
            case 2:
                return new ThirdSlide();
            default:
                return null;
        }

    }

    @Override
    public int getCount() {
        return 3;
    }
}
