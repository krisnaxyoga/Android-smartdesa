package com.smartdesa.demo.riwayat;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.smartdesa.demo.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class RwTimeline extends Fragment {

    TextView tv_tanggal_pengajuan;
    String Stanggal;

    public RwTimeline() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View view = inflater.inflate(R.layout.fragment_rw_timeline, container, false);

        tv_tanggal_pengajuan = view.findViewById(R.id.tv_tanggal_pengajuan);
        Stanggal = getActivity().getIntent().getStringExtra("tanggal_pengajuan");
        tv_tanggal_pengajuan.setText(Stanggal);

        return view;
    }
}