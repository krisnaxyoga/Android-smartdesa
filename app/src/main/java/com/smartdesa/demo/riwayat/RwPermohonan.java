package com.smartdesa.demo.riwayat;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.smartdesa.demo.R;
import com.smartdesa.demo.Util.SessionManager;

/**
 * A simple {@link Fragment} subclass.
 */
public class RwPermohonan extends Fragment {

    SessionManager sessionManager;
    TextView track, tv_surat_pengantar, tv_tanggal_pengajuan, tv_nama_pemohon,tv_jenis_surat,tv_keperluan;
    String Sid, Strack, Ssurat, Stanggal, Snama, Sjenis, Skeperluan;


    public RwPermohonan() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View view = inflater.inflate(R.layout.fragment_rw_permohonan, container, false);

        track = view.findViewById(R.id.track);
        tv_surat_pengantar = view.findViewById(R.id.tv_surat_pengantar);
        tv_tanggal_pengajuan = view.findViewById(R.id.tv_tanggal_pengajuan);
        tv_nama_pemohon = view.findViewById(R.id.tv_nama_pemohon);
        tv_jenis_surat = view.findViewById(R.id.tv_jenis_surat);
        tv_keperluan = view.findViewById(R.id.tv_keperluan);

        sessionManager = new SessionManager(getContext());
        Snama = sessionManager.getUserDetail().get(SessionManager.NAMA);

        Sid = getActivity().getIntent().getStringExtra("id");
        Sjenis = getActivity().getIntent().getStringExtra("jenis_acara");
        Skeperluan = getActivity().getIntent().getStringExtra("keperluan");
        Stanggal = getActivity().getIntent().getStringExtra("tanggal_pengajuan");
        Strack = getActivity().getIntent().getStringExtra("track_number");
        Ssurat = getActivity().getIntent().getStringExtra("surat_pengantar");

        track.setText(Strack);
        tv_surat_pengantar.setText(Ssurat);
        tv_tanggal_pengajuan.setText(Stanggal);
        tv_nama_pemohon.setText(Snama);
        tv_jenis_surat.setText(Sjenis);
        tv_keperluan.setText(Skeperluan);


        return view;
    }
}