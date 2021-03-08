package com.smartdesa.demo.pengaduan;

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
import com.smartdesa.demo.API.APIRequestData;
import com.smartdesa.demo.API.RetroServer;
import com.smartdesa.demo.AdapterProfil.AdpContent;
import com.smartdesa.demo.AdapterProfil.AdpKategori;
import com.smartdesa.demo.AdapterProfil.AdpWilayah;
import com.smartdesa.demo.Model.kependudukan.ModelWilayah;
import com.smartdesa.demo.Model.kependudukan.ResponseWilayah;
import com.smartdesa.demo.Model.pengaduan.ModelCon;
import com.smartdesa.demo.Model.pengaduan.ModelKat;
import com.smartdesa.demo.Model.pengaduan.ResponseModelCon;
import com.smartdesa.demo.Model.pengaduan.ResponseModelKat;
import com.smartdesa.demo.R;
import com.smartdesa.demo.Util.SessionManager;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 */
public class FnPenduduk extends Fragment {

    SessionManager sessionManager;
    TextView no_pengaduan, tv_nama_dusun, tv_nik_pengadu, tv_nama_pengadu, tv_kategori, tv_created_at,tv_pengaduan;
    String Sno_pengaduan, Sdusun, Snik, Snama, Skategori, Stanggal, Scomment,Sfoto;
    private RecyclerView rc_wilayah, rc_kategori, rc_con;
    private RecyclerView.Adapter ad_wilayah, ad_kategori, ad_con;
    private RecyclerView.LayoutManager la_wilayah, la_kategori, la_con;
    private List<ModelWilayah> listwilayah = new ArrayList<>();
    private List<ModelKat> listkategori = new ArrayList<>();
    private List<ModelCon> listcon = new ArrayList<>();
    APIRequestData mApiInterface;
    ImageView profilphoto;

    public FnPenduduk() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View view = inflater.inflate(R.layout.fragment_fn_penduduk, container, false);

        no_pengaduan = view.findViewById(R.id.no_pengaduan);
//        tv_nama_dusun = view.findViewById(R.id.tv_nama_dusun);
        tv_nik_pengadu = view.findViewById(R.id.tv_nik_pengadu);
        tv_nama_pengadu = view.findViewById(R.id.tv_nama_pengadu);
//        tv_kategori = view.findViewById(R.id.tv_kategori);
        tv_created_at = view.findViewById(R.id.tv_created_at);
        profilphoto = view.findViewById(R.id.profilphoto);
//        tv_pengaduan = view.findViewById(R.id.tv_pengaduan);

        sessionManager = new SessionManager(getContext());
        mApiInterface = RetroServer.getClient().create(APIRequestData.class);

        Sdusun = sessionManager.getUserDetail().get(SessionManager.DUSUN_ID);
        Snik = sessionManager.getUserDetail().get(SessionManager.NIK);
        Snama = sessionManager.getUserDetail().get(SessionManager.NAMA);
        Sfoto = sessionManager.getUserDetail().get(SessionManager.FOTO);
        Sno_pengaduan = getActivity().getIntent().getStringExtra("no_pengaduan");
        Skategori = getActivity().getIntent().getStringExtra("pengaduan_category_id");
        Stanggal = getActivity().getIntent().getStringExtra("start_date");
        Scomment = getActivity().getIntent().getStringExtra("id");

        no_pengaduan.setText(Sno_pengaduan);
        tv_nik_pengadu.setText(Snik);
        tv_nama_pengadu.setText(Snama);
        tv_created_at.setText(Stanggal);

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

        //Recycler Kategori
        rc_kategori = view.findViewById(R.id.rc_kat);
        la_kategori = new LinearLayoutManager(getContext());
        rc_kategori.setLayoutManager(la_kategori);

        //Recycler Content
        rc_con = view.findViewById(R.id.rc_con);
        la_con = new LinearLayoutManager(getContext());
        rc_con.setLayoutManager(la_con);

        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        loaddusun(Sdusun);
        loadkat(Skategori);
        loadcon(Sno_pengaduan);
    }
    private void loadcon(String con){

        Call<ResponseModelCon> data = mApiInterface.getModelCon(con);
        data.enqueue(new Callback<ResponseModelCon>() {
            @Override
            public void onResponse(Call<ResponseModelCon> call, Response<ResponseModelCon> response) {

                if(response.body().getKode()==1){

                    listcon = response.body().getData();
                    ad_con = new AdpContent(getActivity(), listcon);
                    rc_con.setAdapter(ad_con);
                    ad_con.notifyDataSetChanged();

                }else{
                }
            }
            @Override
            public void onFailure(Call<ResponseModelCon> call, Throwable t) {
                Toast.makeText(getContext(),"Gagal Menghubungi Server", Toast.LENGTH_SHORT).show();
            }
        });
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
                }
            }
            @Override
            public void onFailure(Call<ResponseWilayah> call, Throwable t) {
                Toast.makeText(getContext(),"Gagal Menghubungi Server", Toast.LENGTH_SHORT).show();
            }
        });
    }
    private void loadkat(String kat){

        Call<ResponseModelKat> data = mApiInterface.getModelKat(kat);
        data.enqueue(new Callback<ResponseModelKat>() {
            @Override
            public void onResponse(Call<ResponseModelKat> call, Response<ResponseModelKat> response) {

                if(response.body().getKode()==1){

                    listkategori = response.body().getData();
                    ad_kategori = new AdpKategori(getActivity(), listkategori);
                    rc_kategori.setAdapter(ad_kategori);
                    ad_kategori.notifyDataSetChanged();

                }else{
                }
            }
            @Override
            public void onFailure(Call<ResponseModelKat> call, Throwable t) {
                Toast.makeText(getContext(),"Gagal Menghubungi Server", Toast.LENGTH_SHORT).show();
            }
        });
    }
}