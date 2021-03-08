package com.smartdesa.demo.riwayat;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

import com.smartdesa.demo.API.APIRequestData;
import com.smartdesa.demo.API.RetroServer;
import com.smartdesa.demo.AdapterProfil.AdpWilayah;
import com.smartdesa.demo.Model.kependudukan.ModelWilayah;
import com.smartdesa.demo.Model.kependudukan.ResponseWilayah;
import com.smartdesa.demo.R;
import com.smartdesa.demo.Util.SessionManager;
import com.squareup.picasso.Picasso;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 */
public class RwPenduduk extends Fragment {

    SessionManager sessionManager;
    TextView lb_nama, lb_nik, tv_dusun, tv_alamat, tv_tempatlahir, tv_tanggallahir, tv_ayah, tv_ibu;
    String Snama, Snik, Sdusun, Salamat, Stempat, Stanggal, Sayah, Sibu, Sfoto;
    ImageView profilphoto;
    private RecyclerView rc_wilayah;
    private RecyclerView.Adapter ad_wilayah;
    private RecyclerView.LayoutManager la_wilayah;
    private List<ModelWilayah> listwilayah = new ArrayList<>();
    APIRequestData mApiInterface;


    public RwPenduduk() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View view = inflater.inflate(R.layout.fragment_rw_penduduk, container, false);

        lb_nama = view.findViewById(R.id.lb_nama);
        lb_nik = view.findViewById(R.id.lb_nik);
        tv_alamat = view.findViewById(R.id.tv_alamat);
        tv_tempatlahir = view.findViewById(R.id.tv_tempat_lahir);
        tv_tanggallahir = view.findViewById(R.id.tv_tanggal_lahir);
        tv_ayah = view.findViewById(R.id.tv_ayah);
        tv_ibu = view.findViewById(R.id.tv_ibu);

        profilphoto = view.findViewById(R.id.profilphoto);
        sessionManager = new SessionManager(getContext());
        mApiInterface = RetroServer.getClient().create(APIRequestData.class);

        Snama = sessionManager.getUserDetail().get(SessionManager.NAMA);
        Snik = sessionManager.getUserDetail().get(SessionManager.NIK);
        Sdusun = sessionManager.getUserDetail().get(SessionManager.DUSUN_ID);
        Salamat = sessionManager.getUserDetail().get(SessionManager.ALAMAT);
        Stempat = sessionManager.getUserDetail().get(SessionManager.TEMPATLAHIR);
        Stanggal = sessionManager.getUserDetail().get(SessionManager.TANGGALLAHIR);
        Sayah = sessionManager.getUserDetail().get(SessionManager.AYAH);
        Sibu = sessionManager.getUserDetail().get(SessionManager.IBU);
        Sfoto = sessionManager.getUserDetail().get(SessionManager.FOTO);

        lb_nama.setText(Snama);
        lb_nik.setText(Snik);
        tv_alamat.setText(Salamat);
        tv_tempatlahir.setText(Stempat);
        tv_tanggallahir.setText(Stanggal);
        tv_ayah.setText(Sayah);
        tv_ibu.setText(Sibu);

//        String img = RetroServer.URL_IMG_PROFIL + Sfoto;

        if(Sfoto==null){

        }else {
            Picasso.with(getContext()).
                    load(Sfoto).
                    placeholder(R.drawable.progress_animation).
                    error(R.drawable.icon).
                    fit().
                    into(profilphoto);
        }
        //Recycler Dusun
        rc_wilayah = view.findViewById(R.id.rc_dusun);
        la_wilayah = new LinearLayoutManager(getContext());
        rc_wilayah.setLayoutManager(la_wilayah);

        return view;
    }
    @Override
    public void onResume() {
        super.onResume();
        loaddusun(Sdusun);
    }
    private void loaddusun(String ddusun){

        Call<ResponseWilayah> data = mApiInterface.getModelWilayah(ddusun);
        data.enqueue(new Callback<ResponseWilayah>() {
            @Override
            public void onResponse(Call<ResponseWilayah> call, Response<ResponseWilayah> response) {

                if(response.body().getKode()==1){

                    listwilayah = response.body().getData();
                    ad_wilayah = new AdpWilayah(getActivity(), listwilayah);
                    rc_wilayah.setAdapter(ad_wilayah);
                    ad_wilayah.notifyDataSetChanged();

                }else{
                    Toast.makeText(getContext(), "Data Kosong", Toast.LENGTH_SHORT).show();
                }
            }
            @Override
            public void onFailure(Call<ResponseWilayah> call, Throwable t) {
                Toast.makeText(getContext(),"Gagal Menghubungi Server", Toast.LENGTH_SHORT).show();
            }
        });
    }
}