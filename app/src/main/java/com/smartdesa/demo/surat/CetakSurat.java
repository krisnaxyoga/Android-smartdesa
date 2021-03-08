package com.smartdesa.demo.surat;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.airbnb.lottie.LottieAnimationView;

import java.util.ArrayList;
import java.util.List;

import com.bumptech.glide.Glide;
import com.smartdesa.demo.API.APIRequestData;
import com.smartdesa.demo.API.RetroServer;
import com.smartdesa.demo.Adapter.AdapterCetak;
import com.smartdesa.demo.Model.permohonan.ModelPermohonan;
import com.smartdesa.demo.Model.permohonan.ResponseListPermohonan;
import com.smartdesa.demo.R;
import com.smartdesa.demo.Util.SessionManager;
import com.squareup.picasso.Picasso;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CetakSurat extends AppCompatActivity {

    APIRequestData mApiInterface;
    private RecyclerView mRecycler;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private List<ModelPermohonan> listcetak = new ArrayList<>();
    SessionManager sessionManager;
    LottieAnimationView gambar;
    String Sid, Snama, Sfoto;
    ImageView profilphoto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cetak_surat);

        mRecycler = findViewById(R.id.recycle_view);
        mLayoutManager = new LinearLayoutManager(CetakSurat.this);
        mRecycler.setLayoutManager(mLayoutManager);
        mApiInterface = RetroServer.getClient().create(APIRequestData.class);
        gambar = findViewById(R.id.gambar);
        profilphoto = findViewById(R.id.profilphoto);

        sessionManager = new SessionManager(CetakSurat.this);

        Sid = sessionManager.getUserDetail().get(SessionManager.ID);
        Snama = sessionManager.getUserDetail().get(SessionManager.NAMA);
        Sfoto = sessionManager.getUserDetail().get(SessionManager.FOTO);

//        String img = RetroServer.URL_IMG_PROFIL + Sfoto;

        if(Sfoto==null){

        }else {
            Picasso.with(CetakSurat.this).
                    load(Sfoto).
                    placeholder(R.drawable.progress_animation).
                    error(R.drawable.icon).
                    fit().
                    into(profilphoto);
        }

    }

    @Override
    public void onResume() {
        super.onResume();
        loadjenis(Sid);
    }
    public void loadjenis(String id) {
        Call<ResponseListPermohonan> data = mApiInterface.getResponseNotif(id);
        data.enqueue(new Callback<ResponseListPermohonan>() {
            @Override
            public void onResponse(Call<ResponseListPermohonan> call, Response<ResponseListPermohonan> response) {

                if(response.body().getKode()==1){
                    gambar.setVisibility(View.GONE);

                    listcetak = response.body().getData();

                    mAdapter = new AdapterCetak(CetakSurat.this, listcetak);
                    mRecycler.setAdapter(mAdapter);
                    mAdapter.notifyDataSetChanged();

                }else{
                    Toast.makeText(CetakSurat.this, "Belum Ada Surat Dicetak", Toast.LENGTH_SHORT).show();
                }

            }

            @Override
            public void onFailure(Call<ResponseListPermohonan> call, Throwable t) {
                Toast.makeText(CetakSurat.this,"Gagal Menghubungi Server", Toast.LENGTH_SHORT).show();

            }
        });

    }
}