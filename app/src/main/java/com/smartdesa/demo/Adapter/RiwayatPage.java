package com.smartdesa.demo.Adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.smartdesa.demo.riwayat.RwPenduduk;
import com.smartdesa.demo.riwayat.RwPermohonan;
import com.smartdesa.demo.riwayat.RwTimeline;

public class RiwayatPage extends FragmentPagerAdapter {

    public RiwayatPage(FragmentManager fm) {
        super(fm);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                return new RwPermohonan();
            case 1:
                return new RwTimeline();
            case 2:
                return new RwPenduduk();
            default:
                return null;
        }

    }

    @Override
    public int getCount() {
        return 3;
    }
}
