package com.smartdesa.demo.tutorial;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.smartdesa.demo.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class ThirdSlide extends Fragment {

    TextView done,back;
    ViewPager viewPager;

    public ThirdSlide() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_third_slide, container, false);

        done = view.findViewById(R.id.done);
        viewPager = getActivity().findViewById(R.id.viewPager);
        back = view.findViewById(R.id.back);
        done.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().onBackPressed();
            }
        });

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewPager.setCurrentItem(1);
            }
        });

        return view;
    }
}