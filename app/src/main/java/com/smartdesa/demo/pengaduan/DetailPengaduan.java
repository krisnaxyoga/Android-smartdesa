package com.smartdesa.demo.pengaduan;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Base64;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.smartdesa.demo.API.APIRequestData;
import com.smartdesa.demo.API.RetroServer;
import com.smartdesa.demo.Model.pengaduan.ResponseKirimPengaduan;
import com.smartdesa.demo.R;
import com.smartdesa.demo.Util.SessionManager;

import java.io.ByteArrayOutputStream;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DetailPengaduan extends AppCompatActivity {

    SessionManager sessionManager;
    APIRequestData apiInterface;
    AlertDialog.Builder dialog;
    LayoutInflater inflater;
    View dialogView;
    ImageView foto_pengaduan;
    private static final int CAMERA_REQUEST_CODE = 1;
    TextView tv_nama, tv_nik, tv_desa, tv_kategori,teks;
    String Sdesa, Stitle, Scontent, Sidpenduduk, Snama, Snik, Sidkategori, Skategori, Sfoto="kosong";
    public static Bitmap bitmap_foto;
    EditText et_title, et_content;
    Button btn_kirim, btn_kamera;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_pengaduan);

        sessionManager = new SessionManager(this);
        apiInterface = RetroServer.getClient().create(APIRequestData.class);
        tv_nama = findViewById(R.id.tv_nama);
        tv_nik = findViewById(R.id.tv_nik);
        tv_desa = findViewById(R.id.tv_desa);
        tv_kategori = findViewById(R.id.tv_kategori);
        et_title = findViewById(R.id.et_title);
        et_content = findViewById(R.id.et_content);
        btn_kirim = findViewById(R.id.btn_kirim);
        btn_kamera = findViewById(R.id.btn_kamera);
        foto_pengaduan = findViewById(R.id.foto_pengaduan);

        Sdesa = sessionManager.getUserDetail().get(SessionManager.DESA_ID);
        Sidpenduduk = sessionManager.getUserDetail().get(SessionManager.ID);
        Snama = sessionManager.getUserDetail().get(SessionManager.NAMA);
        Snik = sessionManager.getUserDetail().get(SessionManager.NIK);
        Sidkategori = getIntent().getStringExtra("id_pengaduan");
        Skategori = getIntent().getStringExtra("name");

        tv_nama.setText(Snama);
        tv_nik.setText(Snik);
        tv_kategori.setText(Skategori);

        btn_kamera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                if (intent.resolveActivity(getPackageManager()) != null) {
                    startActivityForResult(intent, CAMERA_REQUEST_CODE);
                }
            }
        });

        btn_kirim.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Stitle = et_title.getText().toString();
                Scontent = et_content.getText().toString();

                if(Stitle.isEmpty()){
                    et_title.setError("Judul pengaduan belum diisi");
                    et_title.requestFocus();
                    return;
                }else if(Scontent.isEmpty()){
                    et_content.setError("Isi pengaduan belum diisi");
                    et_content.requestFocus();
                    return;
                }else{
                    DialogForm();
                }
            }
        });
    }

    private void register(String desa_id, String penduduk_id,String pengaduan_category_id, String title, String content, String photo) {

        apiInterface = RetroServer.getClient().create(APIRequestData.class);
        Call<ResponseKirimPengaduan> call = apiInterface.pengaduanResponse(desa_id, penduduk_id, pengaduan_category_id,title,content,photo);
        call.enqueue(new Callback<ResponseKirimPengaduan>() {
            @Override
            public void onResponse(Call<ResponseKirimPengaduan> call, Response<ResponseKirimPengaduan> response) {

                if(response.body() != null && response.isSuccessful() && response.body().isStatus()){
                    Toast.makeText(DetailPengaduan.this, response.body().getMessage(), Toast.LENGTH_SHORT).show();
                    onBackPressed();

                } else {
                    Toast.makeText(DetailPengaduan.this, response.body().getMessage(), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<ResponseKirimPengaduan> call, Throwable t) {
                Toast.makeText(DetailPengaduan.this, t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
                Log.e("Retrofit Get Error", t.toString());
            }
        });
    }
    // untuk menampilkan dialog
    private void DialogForm() {
        dialog = new AlertDialog.Builder(DetailPengaduan.this);
        inflater = getLayoutInflater();
        dialogView = inflater.inflate(R.layout.dialog_konfirm, null);
        dialog.setView(dialogView);
        dialog.setCancelable(true);
        dialog.setIcon(R.drawable.logodesa);
        dialog.setTitle("Konfirmasi Pengaduan");

        Stitle = et_title.getText().toString();
        teks = (TextView) dialogView.findViewById(R.id.teks);
        teks.setText("Dengan ini, saya "+Snama+ " menyatakan bahwa benar saya mengajukan pengaduan dengan judul "+Stitle+ " kepada Pemerintah Desa melalui Persetujuan Perangkat Desa. Saya menyatakan bahwa informasi yang saya berikan adalah benar" +
                " dan sudah sesuai ketentuan perundangan-undangan yang berlaku");

        dialog.setPositiveButton("OKE", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Stitle = et_title.getText().toString();
                Scontent = et_content.getText().toString();

                register(Sdesa, Sidpenduduk, Sidkategori, Stitle, Scontent, Sfoto);

                NotificationCompat.Builder builder = new NotificationCompat.Builder(getApplicationContext(), "Notif1")
                        .setSmallIcon(R.drawable.logodesa)
                        .setContentTitle("Mengirim Pengaduan Sukses")
                        .setContentText("Pengaduan "+Stitle)
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
    private void BitMapToString(Bitmap bitmapImage){
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        bitmapImage.compress(Bitmap.CompressFormat.JPEG,100,baos);
        byte[]arr=baos.toByteArray();
        Sfoto = Base64.encodeToString(arr,Base64.DEFAULT);
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode){
            case(CAMERA_REQUEST_CODE) :
                if(resultCode == Activity.RESULT_OK){
                    bitmap_foto = (Bitmap) data.getExtras().get("data");
                    BitMapToString(bitmap_foto);
                    foto_pengaduan.setImageBitmap(bitmap_foto);
                }
                break;
        }

    }
}