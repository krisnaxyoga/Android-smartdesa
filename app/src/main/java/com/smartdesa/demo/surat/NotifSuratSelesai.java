package com.smartdesa.demo.surat;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.smartdesa.demo.API.APIRequestData;
import com.smartdesa.demo.API.RetroServer;
import com.smartdesa.demo.Model.permohonan.ResponseModelPermohonan;
import com.smartdesa.demo.R;
import com.smartdesa.demo.Util.SessionManager;
import com.smartdesa.demo.fragment.Beranda;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class NotifSuratSelesai extends AppCompatActivity {

    //Deklarasi Variable
    SessionManager sessionManager;
    TextView tv_no_surat,tv_track,tv_tanggal_cetak,tv_nama_pemohon,tv_jenis_surat,tv_keperluan, btn_back, teks;
    String Sid,Sno_surat,Strack,Stanggal_cetak,Sid_pemohon,Snama_pemohon,Sjenis_surat,Skeperluan, Sfoto, Svalue="0";
    APIRequestData mApiInterface;
    AlertDialog.Builder dialog;
    LayoutInflater inflater;
    Button btn_verifikasi;
    View dialogView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notif_surat_selesai);

        tv_no_surat = findViewById(R.id.tv_no_surat);
        tv_track = findViewById(R.id.tv_track);
        tv_tanggal_cetak = findViewById(R.id.tv_tanggal_cetak);
        tv_nama_pemohon = findViewById(R.id.tv_nama_pemohon);
        tv_jenis_surat = findViewById(R.id.tv_jenis_surat);
        tv_keperluan = findViewById(R.id.tv_keperluan);
        btn_back = findViewById(R.id.btn_back);
        btn_verifikasi = findViewById(R.id.btn_verifikasi);

        btn_verifikasi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                konfirmasi();
            }
        });

        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        mApiInterface = RetroServer.getClient().create(APIRequestData.class);

        sessionManager = new SessionManager(this);
        Sid_pemohon = sessionManager.getUserDetail().get(SessionManager.ID);
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
    }

    public void konfirmasi(){
        dialog = new AlertDialog.Builder(NotifSuratSelesai.this);
        inflater = getLayoutInflater();
        dialogView = inflater.inflate(R.layout.dialog_konfirm, null);
        dialog.setView(dialogView);
        dialog.setCancelable(true);
        dialog.setIcon(R.drawable.logodesa);
        dialog.setTitle("Konfirmasi Pengambilan Permohonan Surat");

        teks = (TextView) dialogView.findViewById(R.id.teks);
        teks.setText("Dengan ini, saya "+Snama_pemohon+ " menyatakan bahwa benar saya telah menerima surat dengan nomor "+Sno_surat+ " melalui Kantor Desa");

        dialog.setPositiveButton("OKE", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                value(Sid);
            }
        });

        dialog.setNegativeButton("BATAL", new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });

        dialog.show();
    }
    public void value(String id){
        mApiInterface = RetroServer.getClient().create(APIRequestData.class);
        Call<ResponseModelPermohonan> call = mApiInterface.konfirmasiResponse(id);
        call.enqueue(new Callback<ResponseModelPermohonan>() {
            @Override
            public void onResponse(Call<ResponseModelPermohonan> call, Response<ResponseModelPermohonan> response) {

                if(response.body() != null && response.isSuccessful() && response.body().isStatus()){
                    Toast.makeText(NotifSuratSelesai.this, response.body().getMessage(), Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(NotifSuratSelesai.this, Beranda.class);
                    startActivity(intent);
                    finish();
//                    onBackPressed();

                } else {
                    Toast.makeText(NotifSuratSelesai.this, response.body().getMessage(), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<ResponseModelPermohonan> call, Throwable t) {
                Toast.makeText(NotifSuratSelesai.this, t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
                Log.e("Retrofit Get Error", t.toString());
            }
        });
        }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent intent = new Intent(NotifSuratSelesai.this, CetakSurat.class);
        startActivity(intent);
    }
}