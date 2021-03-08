package com.smartdesa.demo.tutorial;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.smartdesa.demo.R;
import com.smartdesa.demo.dialog.TutorialDialog;

/**
 * A simple {@link Fragment} subclass.
 */
public class FirstSlide extends Fragment {

    TextView next;
    ViewPager viewPager;

    public FirstSlide() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_first_slide, container, false);

        viewPager = getActivity().findViewById(R.id.viewPager);
        next = view.findViewById(R.id.next);

        loaddialog();

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewPager.setCurrentItem(1);
            }
        });

        return view;
    }
    public void loaddialog(){
        TutorialDialog tutorialDialog = new TutorialDialog();
        tutorialDialog.show(getActivity().getSupportFragmentManager(), "example dialog");
    }
}