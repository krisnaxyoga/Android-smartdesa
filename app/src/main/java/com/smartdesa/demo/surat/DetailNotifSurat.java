package com.smartdesa.demo.surat;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.smartdesa.demo.API.APIRequestData;
import com.smartdesa.demo.API.RetroServer;
import com.smartdesa.demo.R;
import com.smartdesa.demo.Util.SessionManager;
import com.squareup.picasso.Picasso;

public class DetailNotifSurat extends AppCompatActivity {

    //Deklarasi Variable
    SessionManager sessionManager;
    TextView tv_no_surat,tv_track,tv_tanggal_cetak,tv_nama_pemohon,tv_jenis_surat,tv_keperluan;
    String Sid,Sno_surat,Strack,Stanggal_cetak,Snama_pemohon,Sjenis_surat,Skeperluan, Sfoto;
    ImageView profilphoto;
    APIRequestData mApiInterface;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_notif_surat);

        tv_no_surat = findViewById(R.id.tv_no_surat);
        tv_track = findViewById(R.id.tv_track);
        tv_tanggal_cetak = findViewById(R.id.tv_tanggal_cetak);
        tv_nama_pemohon = findViewById(R.id.tv_nama_pemohon);
        tv_jenis_surat = findViewById(R.id.tv_jenis_surat);
        tv_keperluan = findViewById(R.id.tv_keperluan);
        profilphoto = findViewById(R.id.profilphoto);

        mApiInterface = RetroServer.getClient().create(APIRequestData.class);

        sessionManager = new SessionManager(this);
        Snama_pemohon = sessionManager.getUserDetail().get(SessionManager.NAMA);
        Sfoto = sessionManager.getUserDetail().get(SessionManager.FOTO);

        Sid = getIntent().getStringExtra("id");
        Sno_surat = getIntent().getStringExtra("nomor_surat");
        Strack = getIntent().getStringExtra("track_number");
        Stanggal_cetak = getIntent().getStringExtra("tanggal_cetak");
        Sjenis_surat = getIntent().getStringExtra("jenis_acara");
        Skeperluan = getIntent().getStringExtra("keperluan");

        tv_no_surat.setText(Sno_surat);
        tv_track.setText(Strack);
        tv_tanggal_cetak.setText(Stanggal_cetak);
        tv_nama_pemohon.setText(Snama_pemohon);
        tv_jenis_surat.setText(Sjenis_surat);
        tv_keperluan.setText(Skeperluan);

//        String img = RetroServer.URL_IMG_PROFIL + Sfoto;

        if(Sfoto==null){

        }else {
            Picasso.with(DetailNotifSurat.this).
                    load(Sfoto).
                    placeholder(R.drawable.progress_animation).
                    error(R.drawable.icon).
                    fit().
                    into(profilphoto);
        }

    }
}