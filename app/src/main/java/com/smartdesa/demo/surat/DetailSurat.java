package com.smartdesa.demo.surat;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.DialogInterface;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import com.smartdesa.demo.API.APIRequestData;
import com.smartdesa.demo.API.RetroServer;
import com.smartdesa.demo.AdapterProfil.AdpWilayah;
import com.smartdesa.demo.Model.kependudukan.ModelWilayah;
import com.smartdesa.demo.Model.kependudukan.ResponseWilayah;
import com.smartdesa.demo.Model.permohonan.ResponseModelPermohonan;

import com.smartdesa.demo.R;

import com.smartdesa.demo.Util.SessionManager;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DetailSurat extends AppCompatActivity{

    SessionManager sessionManager;
    AlertDialog.Builder dialog;
    LayoutInflater inflater;
    View dialogView;
    TextView tv_nama, tv_nik, tv_alamat, tv_dusun, id_surat, tv_jenis, teks;
    EditText et_keperluan, et_berlaku_dari, et_berlaku_hingga, et_jenis_acara, et_nama_pasangan, et_tahun_kawin, et_lokasi_kawin, et_pernyataan_sebagai, et_nama_usaha, et_jenis_usaha, et_alamat_usaha;
    private String Sidsurat="",Sid,Sdesa, Snama, Snik, Sdusun, Salamat, Skeperluan, Sberlaku_dari, Sberlaku_hingga, Snama_pasangan, Stahun_kawin,Slokasi_kawin, Spernyataan_sebagai, Snama_usaha, Sjenis_usaha, Salamat_usaha,Sjenis="", Skode="";
    Button btn_kirim;
    private RecyclerView rc_wilayah;
    private RecyclerView.Adapter ad_wilayah;
    private RecyclerView.LayoutManager la_wilayah;
    private List<ModelWilayah> listwilayah = new ArrayList<>();
    APIRequestData apiInterface;
    Calendar cl;
    DatePickerDialog dpd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_surat);

        createNotificationChannel();

        sessionManager = new SessionManager(this);
        tv_nama = findViewById(R.id.tv_nama);
        tv_dusun = findViewById(R.id.tv_dusun);
        tv_nik = findViewById(R.id.tv_nik);
        tv_alamat = findViewById(R.id.tv_alamat);
        tv_jenis = findViewById(R.id.tv_jenis);
        id_surat = findViewById(R.id.id_surat);
        btn_kirim = findViewById(R.id.btn_kirim);
        et_keperluan = findViewById(R.id.keperluan);
        et_berlaku_dari = findViewById(R.id.berlaku_dari);
        et_berlaku_hingga = findViewById(R.id.berlaku_hingga);
        et_jenis_acara = findViewById(R.id.jenis_acara);
        et_nama_pasangan = findViewById(R.id.nama_pasangan);
        et_tahun_kawin = findViewById(R.id.tahun_kawin);
        et_lokasi_kawin = findViewById(R.id.lokasi_kawin);
        et_pernyataan_sebagai = findViewById(R.id.pernyataan_sebagai);
        et_nama_usaha = findViewById(R.id.nama_usaha);
        et_jenis_usaha = findViewById(R.id.jenis_usaha);
        et_alamat_usaha = findViewById(R.id.alamat_usaha);

        Sid = sessionManager.getUserDetail().get(SessionManager.ID);
        Sdesa = sessionManager.getUserDetail().get(SessionManager.DESA_ID);
        Snama = sessionManager.getUserDetail().get(SessionManager.NAMA);
        Snik = sessionManager.getUserDetail().get(SessionManager.NIK);
        Sdusun = sessionManager.getUserDetail().get(SessionManager.DUSUN_ID);
        Salamat = sessionManager.getUserDetail().get(SessionManager.ALAMAT);
        Sidsurat = getIntent().getStringExtra("id");
        Skode = getIntent().getStringExtra("kode_surat");
        Sjenis = getIntent().getStringExtra("judul");
        apiInterface = RetroServer.getClient().create(APIRequestData.class);

        tv_nama.setText(Snama);
        tv_nik.setText(Snik);
        tv_dusun.setText(Sdusun);
        tv_alamat.setText(Salamat);
        tv_jenis.setText(Sjenis);
        id_surat.setText(Sidsurat);

        //Recycler Dusun
        rc_wilayah = findViewById(R.id.rc_dusun);
        la_wilayah = new LinearLayoutManager(DetailSurat.this);
        rc_wilayah.setLayoutManager(la_wilayah);

        //MENAMPILKAN FUNGSI IF UNTUK FUNCTION
        if(id_surat.getText().toString().equals("1")){
            et_jenis_acara.setVisibility(View.GONE);
            et_nama_pasangan.setVisibility(View.GONE);
            et_tahun_kawin.setVisibility(View.GONE);
            et_lokasi_kawin.setVisibility(View.GONE);
            et_pernyataan_sebagai.setVisibility(View.GONE);
            et_nama_usaha.setVisibility(View.GONE);
            et_jenis_usaha.setVisibility(View.GONE);
            et_alamat_usaha.setVisibility(View.GONE);

        }else if(id_surat.getText().toString().equals("2")){
            et_berlaku_dari.setVisibility(View.GONE);
            et_berlaku_hingga.setVisibility(View.GONE);
            et_jenis_acara.setVisibility(View.GONE);
            et_nama_pasangan.setVisibility(View.GONE);
            et_tahun_kawin.setVisibility(View.GONE);
            et_lokasi_kawin.setVisibility(View.GONE);
            et_pernyataan_sebagai.setVisibility(View.GONE);
            et_nama_usaha.setVisibility(View.GONE);
            et_jenis_usaha.setVisibility(View.GONE);
            et_alamat_usaha.setVisibility(View.GONE);

        }else if(id_surat.getText().toString().equals("3")){
            et_berlaku_dari.setVisibility(View.GONE);
            et_berlaku_hingga.setVisibility(View.GONE);
            et_jenis_acara.setVisibility(View.GONE);
            et_nama_pasangan.setVisibility(View.GONE);
            et_tahun_kawin.setVisibility(View.GONE);
            et_lokasi_kawin.setVisibility(View.GONE);
            et_pernyataan_sebagai.setVisibility(View.GONE);
            et_nama_usaha.setVisibility(View.GONE);
            et_jenis_usaha.setVisibility(View.GONE);
            et_alamat_usaha.setVisibility(View.GONE);

        }else if(id_surat.getText().toString().equals("4")){
            et_berlaku_dari.setVisibility(View.GONE);
            et_berlaku_hingga.setVisibility(View.GONE);
            et_jenis_acara.setVisibility(View.GONE);
            et_nama_pasangan.setVisibility(View.GONE);
            et_tahun_kawin.setVisibility(View.GONE);
            et_lokasi_kawin.setVisibility(View.GONE);
            et_pernyataan_sebagai.setVisibility(View.GONE);
            et_nama_usaha.setVisibility(View.GONE);
            et_jenis_usaha.setVisibility(View.GONE);
            et_alamat_usaha.setVisibility(View.GONE);

        }else if(id_surat.getText().toString().equals("5")){
            et_berlaku_dari.setVisibility(View.GONE);
            et_berlaku_hingga.setVisibility(View.GONE);
            et_jenis_acara.setVisibility(View.GONE);
            et_nama_pasangan.setVisibility(View.GONE);
            et_tahun_kawin.setVisibility(View.GONE);
            et_lokasi_kawin.setVisibility(View.GONE);
            et_pernyataan_sebagai.setVisibility(View.GONE);
            et_nama_usaha.setVisibility(View.GONE);
            et_jenis_usaha.setVisibility(View.GONE);
            et_alamat_usaha.setVisibility(View.GONE);

        }else if(id_surat.getText().toString().equals("6")){
            et_nama_pasangan.setVisibility(View.GONE);
            et_tahun_kawin.setVisibility(View.GONE);
            et_lokasi_kawin.setVisibility(View.GONE);
            et_pernyataan_sebagai.setVisibility(View.GONE);
            et_nama_usaha.setVisibility(View.GONE);
            et_jenis_usaha.setVisibility(View.GONE);
            et_alamat_usaha.setVisibility(View.GONE);

        }else if(id_surat.getText().toString().equals("7")){
            et_berlaku_dari.setVisibility(View.GONE);
            et_berlaku_hingga.setVisibility(View.GONE);
            et_jenis_acara.setVisibility(View.GONE);
            et_nama_usaha.setVisibility(View.GONE);
            et_jenis_usaha.setVisibility(View.GONE);
            et_alamat_usaha.setVisibility(View.GONE);

        }else if(id_surat.getText().toString().equals("8")){
            et_berlaku_dari.setVisibility(View.GONE);
            et_berlaku_hingga.setVisibility(View.GONE);
            et_jenis_acara.setVisibility(View.GONE);
            et_nama_pasangan.setVisibility(View.GONE);
            et_tahun_kawin.setVisibility(View.GONE);
            et_lokasi_kawin.setVisibility(View.GONE);
            et_pernyataan_sebagai.setVisibility(View.GONE);

        }else if(id_surat.getText().toString().equals("9")){
            et_berlaku_dari.setVisibility(View.GONE);
            et_berlaku_hingga.setVisibility(View.GONE);
            et_jenis_acara.setVisibility(View.GONE);
            et_nama_pasangan.setVisibility(View.GONE);
            et_tahun_kawin.setVisibility(View.GONE);
            et_lokasi_kawin.setVisibility(View.GONE);
            et_pernyataan_sebagai.setVisibility(View.GONE);

        }else if(id_surat.getText().toString().equals("10")){
            et_berlaku_dari.setVisibility(View.GONE);
            et_berlaku_hingga.setVisibility(View.GONE);
            et_jenis_acara.setVisibility(View.GONE);
            et_nama_pasangan.setVisibility(View.GONE);
            et_tahun_kawin.setVisibility(View.GONE);
            et_lokasi_kawin.setVisibility(View.GONE);
            et_pernyataan_sebagai.setVisibility(View.GONE);
            et_nama_usaha.setVisibility(View.GONE);
            et_jenis_usaha.setVisibility(View.GONE);
            et_alamat_usaha.setVisibility(View.GONE);

        }else if(id_surat.getText().toString().equals("11")){
            et_berlaku_dari.setVisibility(View.GONE);
            et_berlaku_hingga.setVisibility(View.GONE);
            et_jenis_acara.setVisibility(View.GONE);
            et_nama_pasangan.setVisibility(View.GONE);
            et_tahun_kawin.setVisibility(View.GONE);
            et_lokasi_kawin.setVisibility(View.GONE);
            et_pernyataan_sebagai.setVisibility(View.GONE);
            et_nama_usaha.setVisibility(View.GONE);
            et_jenis_usaha.setVisibility(View.GONE);
            et_alamat_usaha.setVisibility(View.GONE);

        }else if(id_surat.getText().toString().equals("12")){
            et_berlaku_dari.setVisibility(View.GONE);
            et_berlaku_hingga.setVisibility(View.GONE);
            et_jenis_acara.setVisibility(View.GONE);
            et_nama_pasangan.setVisibility(View.GONE);
            et_tahun_kawin.setVisibility(View.GONE);
            et_lokasi_kawin.setVisibility(View.GONE);
            et_pernyataan_sebagai.setVisibility(View.GONE);
            et_nama_usaha.setVisibility(View.GONE);
            et_jenis_usaha.setVisibility(View.GONE);
            et_alamat_usaha.setVisibility(View.GONE);

        }else if(id_surat.getText().toString().equals("13")){
            et_berlaku_dari.setVisibility(View.GONE);
            et_berlaku_hingga.setVisibility(View.GONE);
            et_jenis_acara.setVisibility(View.GONE);
            et_nama_pasangan.setVisibility(View.GONE);
            et_tahun_kawin.setVisibility(View.GONE);
            et_lokasi_kawin.setVisibility(View.GONE);
            et_pernyataan_sebagai.setVisibility(View.GONE);
            et_nama_usaha.setVisibility(View.GONE);
            et_jenis_usaha.setVisibility(View.GONE);
            et_alamat_usaha.setVisibility(View.GONE);

        }else if(id_surat.getText().toString().equals("14")){
            et_berlaku_dari.setVisibility(View.GONE);
            et_berlaku_hingga.setVisibility(View.GONE);
            et_jenis_acara.setVisibility(View.GONE);
            et_nama_pasangan.setVisibility(View.GONE);
            et_tahun_kawin.setVisibility(View.GONE);
            et_lokasi_kawin.setVisibility(View.GONE);
            et_pernyataan_sebagai.setVisibility(View.GONE);
            et_nama_usaha.setVisibility(View.GONE);
            et_jenis_usaha.setVisibility(View.GONE);
            et_alamat_usaha.setVisibility(View.GONE);

        }else if(id_surat.getText().toString().equals("15")){
            et_berlaku_dari.setVisibility(View.GONE);
            et_berlaku_hingga.setVisibility(View.GONE);
            et_jenis_acara.setVisibility(View.GONE);
            et_nama_pasangan.setVisibility(View.GONE);
            et_tahun_kawin.setVisibility(View.GONE);
            et_lokasi_kawin.setVisibility(View.GONE);
            et_pernyataan_sebagai.setVisibility(View.GONE);
            et_nama_usaha.setVisibility(View.GONE);
            et_jenis_usaha.setVisibility(View.GONE);
            et_alamat_usaha.setVisibility(View.GONE);
        }else{
            et_berlaku_dari.setVisibility(View.GONE);
            et_berlaku_hingga.setVisibility(View.GONE);
            et_jenis_acara.setVisibility(View.GONE);
            et_nama_pasangan.setVisibility(View.GONE);
            et_tahun_kawin.setVisibility(View.GONE);
            et_lokasi_kawin.setVisibility(View.GONE);
            et_pernyataan_sebagai.setVisibility(View.GONE);
            et_nama_usaha.setVisibility(View.GONE);
            et_jenis_usaha.setVisibility(View.GONE);
            et_alamat_usaha.setVisibility(View.GONE);
        }
        //AKHIR FUNGSI IF UNTUK FUNCTION


        //FUNGSI CALENDAR PADA EDITTEXT
        et_berlaku_dari.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cl = Calendar.getInstance();
                int day = cl.get(Calendar.DAY_OF_MONTH);
                int month = cl.get(Calendar.MONTH);
                int year = cl.get(Calendar.YEAR);

                dpd = new DatePickerDialog(DetailSurat.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        et_berlaku_dari.setText(year + "-" + month + "-" + dayOfMonth);
                    }
                }, year,month,day);
                dpd.show();
            }
        });

        et_berlaku_hingga.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cl = Calendar.getInstance();
                int day = cl.get(Calendar.DAY_OF_MONTH);
                int month = cl.get(Calendar.MONTH);
                int year = cl.get(Calendar.YEAR);

                dpd = new DatePickerDialog(DetailSurat.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        et_berlaku_hingga.setText(year + "-" + month + "-" + dayOfMonth);
                    }
                }, year,month,day);
                dpd.show();
            }
        });


        btn_kirim.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String keperlu = et_keperluan.getText().toString().trim();
                String ber_dari = et_berlaku_dari.getText().toString().trim();
                String ber_hingga = et_berlaku_hingga.getText().toString().trim();
                String jenis_acara = et_jenis_acara.getText().toString().trim();
                String nama_pasangan = et_nama_pasangan.getText().toString().trim();
                String tahun_kawin = et_tahun_kawin.getText().toString().trim();
                String lokasi_kawin = et_lokasi_kawin.getText().toString().trim();
                String pernyataan_sebagai = et_pernyataan_sebagai.getText().toString().trim();
                String nama_usaha = et_nama_usaha.getText().toString().trim();
                String jenis_usaha = et_jenis_usaha.getText().toString().trim();
                String alamat_usaha = et_alamat_usaha.getText().toString().trim();

                if (id_surat.getText().toString().equals("1")) {
                    if (keperlu.isEmpty()) {
                        et_keperluan.setError("Keperluan belum diisi");
                        et_keperluan.requestFocus();
                        return;
                    }
                    else if (ber_dari.isEmpty()) {
                        et_berlaku_dari.setError("Tanggal belum dipilih");
                        et_berlaku_dari.requestFocus();
                        return;
                    }else if (ber_hingga.isEmpty()) {
                        et_berlaku_hingga.setError("Tanggal belum dipilih");
                        et_berlaku_hingga.requestFocus();
                        return;
                    }else {
                        DialogForm();
                    }
                }else if(id_surat.getText().toString().equals("2")){
                    if (keperlu.isEmpty()) {
                        et_keperluan.setError("Keperluan belum diisi");
                        et_keperluan.requestFocus();
                        return;
                    } else {
                        DialogForm();
                    }
                }else if(id_surat.getText().toString().equals("3")){
                    if (keperlu.isEmpty()) {
                        et_keperluan.setError("Keperluan belum diisi");
                        et_keperluan.requestFocus();
                        return;
                    } else {
                        DialogForm();
                    }
                }else if(id_surat.getText().toString().equals("4")){
                    if (keperlu.isEmpty()) {
                        et_keperluan.setError("Keperluan belum diisi");
                        et_keperluan.requestFocus();
                        return;
                    } else {
                        DialogForm();
                    }
                }else if(id_surat.getText().toString().equals("5")){
                    if (keperlu.isEmpty()) {
                        et_keperluan.setError("Keperluan belum diisi");
                        et_keperluan.requestFocus();
                        return;
                    } else {
                        DialogForm();
                    }
                }else if(id_surat.getText().toString().equals("6")){
                    if (keperlu.isEmpty()) {
                        et_keperluan.setError("Keperluan belum diisi");
                        et_keperluan.requestFocus();
                        return;
                    }
                    else if (ber_dari.isEmpty()) {
                        et_berlaku_dari.setError("Tanggal belum dipilih");
                        et_berlaku_dari.requestFocus();
                        return;
                    }else if (ber_hingga.isEmpty()) {
                        et_berlaku_hingga.setError("Tanggal belum dipilih");
                        et_berlaku_hingga.requestFocus();
                        return;
                    }else if (jenis_acara.isEmpty()) {
                        et_jenis_acara.setError("Jenis acara belum diisi");
                        et_jenis_acara.requestFocus();
                        return;
                    }else {
                        DialogForm();
                    }
                }else if(id_surat.getText().toString().equals("7")){
                    if (keperlu.isEmpty()) {
                        et_keperluan.setError("Keperluan belum diisi");
                        et_keperluan.requestFocus();
                        return;
                    }
                    else if (nama_pasangan.isEmpty()) {
                        et_nama_pasangan.setError("Nama pasangan belum diisi");
                        et_nama_pasangan.requestFocus();
                        return;
                    }else if (tahun_kawin.isEmpty()) {
                        et_tahun_kawin.setError("Tahun kawin belum diisi");
                        et_tahun_kawin.requestFocus();
                        return;
                    }else if (lokasi_kawin.isEmpty()) {
                        et_lokasi_kawin.setError("Lokasi kawin belum diisi");
                        et_lokasi_kawin.requestFocus();
                        return;
                    }else if (pernyataan_sebagai.isEmpty()) {
                        et_pernyataan_sebagai.setError("Pernyataan belum diisi");
                        et_pernyataan_sebagai.requestFocus();
                        return;
                    }else {
                        DialogForm();
                    }
                }else if(id_surat.getText().toString().equals("8")){
                if (keperlu.isEmpty()) {
                    et_keperluan.setError("Keperluan belum diisi");
                    et_keperluan.requestFocus();
                    return;
                }
                else if (nama_usaha.isEmpty()) {
                    et_nama_usaha.setError("Nama usaha belum diisi");
                    et_nama_usaha.requestFocus();
                    return;
                }else if (jenis_usaha.isEmpty()) {
                    et_jenis_usaha.setError("Jenis usaha belum diisi");
                    et_jenis_usaha.requestFocus();
                    return;
                }else if (alamat_usaha.isEmpty()) {
                    et_alamat_usaha.setError("Alamat usaha belum diisi");
                    et_alamat_usaha.requestFocus();
                    return;
                }else {
                    DialogForm();
                }
            }else if(id_surat.getText().toString().equals("9")){
                    if (keperlu.isEmpty()) {
                        et_keperluan.setError("Keperluan belum diisi");
                        et_keperluan.requestFocus();
                        return;
                    }
                    else if (nama_usaha.isEmpty()) {
                        et_nama_usaha.setError("Nama usaha belum diisi");
                        et_nama_usaha.requestFocus();
                        return;
                    }else if (jenis_usaha.isEmpty()) {
                        et_jenis_usaha.setError("Jenis usaha belum diisi");
                        et_jenis_usaha.requestFocus();
                        return;
                    }else if (alamat_usaha.isEmpty()) {
                        et_alamat_usaha.setError("Alamat usaha belum diisi");
                        et_alamat_usaha.requestFocus();
                        return;
                    }else {
                        DialogForm();
                    }
                }else if(id_surat.getText().toString().equals("10")){
                    if (keperlu.isEmpty()) {
                        et_keperluan.setError("Keperluan belum diisi");
                        et_keperluan.requestFocus();
                        return;
                    } else {
                        DialogForm();
                    }
                }else if(id_surat.getText().toString().equals("11")){
                    if (keperlu.isEmpty()) {
                        et_keperluan.setError("Keperluan belum diisi");
                        et_keperluan.requestFocus();
                        return;
                    } else {
                        DialogForm();
                    }
                }else if(id_surat.getText().toString().equals("12")){
                    if (keperlu.isEmpty()) {
                        et_keperluan.setError("Keperluan belum diisi");
                        et_keperluan.requestFocus();
                        return;
                    } else {
                        DialogForm();
                    }
                }
                else if(id_surat.getText().toString().equals("13")){
                    if (keperlu.isEmpty()) {
                        et_keperluan.setError("Keperluan belum diisi");
                        et_keperluan.requestFocus();
                        return;
                    } else {
                        DialogForm();
                    }
                }else if(id_surat.getText().toString().equals("14")){
                    if (keperlu.isEmpty()) {
                        et_keperluan.setError("Keperluan belum diisi");
                        et_keperluan.requestFocus();
                        return;
                    } else {
                        DialogForm();
                    }
                }else if(id_surat.getText().toString().equals("15")){
                    if (keperlu.isEmpty()) {
                        et_keperluan.setError("Keperluan belum diisi");
                        et_keperluan.requestFocus();
                        return;
                    } else {
                        DialogForm();
                    }
                }else{
                    if (keperlu.isEmpty()) {
                        et_keperluan.setError("Keperluan belum diisi");
                        et_keperluan.requestFocus();
                        return;
                    } else {
                        DialogForm();
                    }
                }


            }
        });
    }

    private void register(String desa_id, String dusun_id,String keperluan, String kode_surat,String penduduk_id, String jenis_surat_id, String jenis_acara, String berlaku_dari, String berlaku_hingga
                          , String nama_pasangan, String tahun_kawin,String lokasi_kawin, String pernyataan_sebagai, String nama_usaha, String jenis_usaha, String alamat_usaha ,String no_kk) {

        apiInterface = RetroServer.getClient().create(APIRequestData.class);
        Call<ResponseModelPermohonan> call = apiInterface.permohonanResponse(desa_id, dusun_id,keperluan,kode_surat, penduduk_id, jenis_surat_id, jenis_acara, berlaku_dari, berlaku_hingga,
                nama_pasangan, tahun_kawin, lokasi_kawin, pernyataan_sebagai, nama_usaha, jenis_usaha, alamat_usaha, no_kk);
        call.enqueue(new Callback<ResponseModelPermohonan>() {
            @Override
            public void onResponse(Call<ResponseModelPermohonan> call, Response<ResponseModelPermohonan> response) {
                ResponseModelPermohonan loginResponse = response.body();

//                if (response.body() != null && !loginResponse.isError()) {

                if(response.body() != null && response.isSuccessful() && response.body().isStatus()){
                    Toast.makeText(DetailSurat.this, response.body().getMessage(), Toast.LENGTH_SHORT).show();
                    onBackPressed();

                } else {
                    Toast.makeText(DetailSurat.this, response.body().getMessage(), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<ResponseModelPermohonan> call, Throwable t) {
                Toast.makeText(DetailSurat.this, t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
                Log.e("Retrofit Get Error", t.toString());
            }
        });
    }

    private void createNotificationChannel() {
        // Create the NotificationChannel, but only on API 26+ because
        // the NotificationChannel class is new and not in the support library
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            CharSequence name = "Mengirim Permohonan Sukses";
            String description = "Permohonan "+Sjenis;
            int importance = NotificationManager.IMPORTANCE_DEFAULT;
            NotificationChannel channel = new NotificationChannel("Notif1", name, importance);
            channel.setDescription(description);
            // Register the channel with the system; you can't change the importance
            // or other notification behaviors after this
            NotificationManager notificationManager = getSystemService(NotificationManager.class);
            notificationManager.createNotificationChannel(channel);
        }
    }

    // untuk menampilkan dialog
    private void DialogForm() {
        dialog = new AlertDialog.Builder(DetailSurat.this);
        inflater = getLayoutInflater();
        dialogView = inflater.inflate(R.layout.dialog_konfirm, null);
        dialog.setView(dialogView);
        dialog.setCancelable(true);
        dialog.setIcon(R.drawable.logodesa);
        dialog.setTitle("Konfirmasi Permohonan");

        Skeperluan = et_keperluan.getText().toString();
        teks = (TextView) dialogView.findViewById(R.id.teks);
        teks.setText("Dengan ini, saya "+Snama+ " menyatakan bahwa benar saya mengajukan permohonan "+Sjenis+ " untuk keperluan " +Skeperluan+
                " kepada Pemerintah Desa melalui Persetujuan Kepala Dusun. Saya menyatakan bahwa informasi yang saya berikan adalah benar" +
                " dan sudah sesuai ketentuan perundangan-undangan yang berlaku");

        dialog.setPositiveButton("OKE", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Skeperluan = et_keperluan.getText().toString();
                Sberlaku_dari = et_berlaku_dari.getText().toString();
                Sberlaku_hingga = et_berlaku_hingga.getText().toString();
                Snama_pasangan = et_nama_pasangan.getText().toString();
                Stahun_kawin = et_tahun_kawin.getText().toString();
                Slokasi_kawin = et_lokasi_kawin.getText().toString();
                Spernyataan_sebagai = et_pernyataan_sebagai.getText().toString();
                Snama_usaha = et_nama_usaha.getText().toString();
                Sjenis_usaha = et_jenis_usaha.getText().toString();
                Salamat_usaha = et_alamat_usaha.getText().toString();

                register(Sdesa, Sdusun, Skeperluan, Skode, Sid, Sidsurat, Sjenis,Sberlaku_dari, Sberlaku_hingga, Snama_pasangan, Stahun_kawin, Slokasi_kawin, Spernyataan_sebagai
                        ,Snama_usaha, Sjenis_usaha, Salamat_usaha,Snik);

                NotificationCompat.Builder builder = new NotificationCompat.Builder(getApplicationContext(), "Notif1")
                        .setSmallIcon(R.drawable.logodesa)
                        .setContentTitle("Mengirim Permohonan Sukses")
                        .setContentText("Permohonan "+Sjenis)
                        .setPriority(NotificationCompat.PRIORITY_DEFAULT);

                NotificationManagerCompat notificationManagerCompat = NotificationManagerCompat.from(getApplicationContext());

                notificationManagerCompat.notify(100, builder.build());
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
    @Override
    public void onResume() {
        super.onResume();
        loaddusun(Sdusun);
    }
    private void loaddusun(String ddusun){

        Call<ResponseWilayah> data = apiInterface.getModelWilayah(ddusun);
        data.enqueue(new Callback<ResponseWilayah>() {
            @Override
            public void onResponse(Call<ResponseWilayah> call, Response<ResponseWilayah> response) {

                if(response.body().getKode()==1){

                    listwilayah = response.body().getData();
                    ad_wilayah = new AdpWilayah(DetailSurat.this, listwilayah);
                    rc_wilayah.setAdapter(ad_wilayah);
                    ad_wilayah.notifyDataSetChanged();

                }else{
                    Toast.makeText(DetailSurat.this, "Data Kosong", Toast.LENGTH_SHORT).show();
                }
            }
            @Override
            public void onFailure(Call<ResponseWilayah> call, Throwable t) {
                Toast.makeText(DetailSurat.this,"Gagal Menghubungi Server", Toast.LENGTH_SHORT).show();
            }
        });
    }

}