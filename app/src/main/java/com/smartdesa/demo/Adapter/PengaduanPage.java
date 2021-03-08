package com.smartdesa.demo.Adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.smartdesa.demo.pengaduan.FnDisposisi;
import com.smartdesa.demo.pengaduan.FnPenduduk;

public class PengaduanPage extends FragmentPagerAdapter {

    public PengaduanPage(FragmentManager fm) {
        super(fm);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                return new FnDisposisi();
            case 1:
                return new FnPenduduk();
            default:
                return null;
        }

    }

    @Override
    public int getCount() {
        return 2;
    }

}
