package com.smartdesa.demo.fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import com.airbnb.lottie.LottieAnimationView;
import com.bumptech.glide.Glide;
import com.smartdesa.demo.API.APIRequestData;
import com.smartdesa.demo.API.RetroServer;
import com.smartdesa.demo.Adapter.AdapterRiwayat;
import com.smartdesa.demo.homepage.JenisSurat;
import com.smartdesa.demo.Model.permohonan.ModelPermohonan;
import com.smartdesa.demo.Model.permohonan.ResponseListPermohonan;
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
public class RiwayatFragment extends Fragment {

    APIRequestData mApiInterface;
    private RecyclerView mRecycler;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private ImageButton tambahlist;
    private List<ModelPermohonan> listriwayat = new ArrayList<>();
    SessionManager sessionManager;
    LottieAnimationView gambar;
    String Sid, Snama, Sfoto;
    ImageView profilphoto;

    public RiwayatFragment() {}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View view = inflater.inflate(R.layout.fragment_riwayat, container, false);

        mRecycler = view.findViewById(R.id.recycle_view);
        mLayoutManager = new LinearLayoutManager(getContext());
        mRecycler.setLayoutManager(mLayoutManager);
        mApiInterface = RetroServer.getClient().create(APIRequestData.class);
        gambar = view.findViewById(R.id.gambar);
        profilphoto = view.findViewById(R.id.profilphoto);

        sessionManager = new SessionManager(getContext());

        Sid = sessionManager.getUserDetail().get(SessionManager.ID);
        Snama = sessionManager.getUserDetail().get(SessionManager.NAMA);
        Sfoto = sessionManager.getUserDetail().get(SessionManager.FOTO);

        tambahlist = view.findViewById(R.id.tambahlist);
        tambahlist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(view.getContext(), JenisSurat.class);
                view.getContext().startActivity(intent);
            }
        });

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
        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        loadjenis(Sid);
    }

    public void loadjenis(String id) {
        Call<ResponseListPermohonan> data = mApiInterface.getResponseRiwayat(id);
        data.enqueue(new Callback<ResponseListPermohonan>() {
            @Override
            public void onResponse(Call<ResponseListPermohonan> call, Response<ResponseListPermohonan> response) {

                if(response.body().getKode()==1){
                    gambar.setVisibility(View.GONE);

//                    Toast.makeText(getContext(),response.body().getMessage(), Toast.LENGTH_SHORT).show();

                    listriwayat = response.body().getData();

                    mAdapter = new AdapterRiwayat(getActivity(), listriwayat);
                    mRecycler.setAdapter(mAdapter);
                    mAdapter.notifyDataSetChanged();

                }else if(response.body().getKode()==0){
                    Toast.makeText(getContext(), "Data Kosong", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<ResponseListPermohonan> call, Throwable t) {
                Toast.makeText(getContext(),"Gagal Menghubungi Server", Toast.LENGTH_SHORT).show();

            }
        });

    }
}