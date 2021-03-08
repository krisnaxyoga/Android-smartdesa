package com.smartdesa.demo.updatefoto;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.smartdesa.demo.API.APIRequestData;
import com.smartdesa.demo.API.RetroServer;
import com.smartdesa.demo.homepage.Homepage;
import com.smartdesa.demo.Model.penduduk.ResponseModelPenduduk;
import com.smartdesa.demo.R;
import com.smartdesa.demo.Util.SessionManager;

import java.io.ByteArrayOutputStream;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FotoProfil extends AppCompatActivity {

    //Deklarasi Variable
    TextView btn_kamera, btn_simpan;
    ImageView selfie;
    public static Bitmap bitmap_profil;
    SessionManager sessionManager;
    private static final int CAMERA_REQUEST_CODE = 1;
    String Sid,Sselfie="kosong";
    APIRequestData apiInterface;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_foto_profil);

        btn_kamera = findViewById(R.id.btn_kamera);
        btn_simpan = findViewById(R.id.btn_simpan);
        selfie = findViewById(R.id.selfie);

//        startkamera();

        sessionManager = new SessionManager(this);
        Sid = sessionManager.getUserDetail().get(SessionManager.ID);

        apiInterface = RetroServer.getClient().create(APIRequestData.class);

        btn_kamera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                if (intent.resolveActivity(getPackageManager()) != null) {
                    startActivityForResult(intent, CAMERA_REQUEST_CODE);
                }
            }
        });

        btn_simpan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Sselfie.equals("kosong")) {
                    Toast.makeText(FotoProfil.this, "Foto belum diambil!", Toast.LENGTH_SHORT).show();
                } else {
                    ganti_foto(Sid,Sselfie);
//                    Toast.makeText(FotoProfil.this, "Maintenance Server", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
    private void BitMapToString(Bitmap bitmapImage){
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        bitmapImage.compress(Bitmap.CompressFormat.JPEG,100,baos);
        byte[]arr=baos.toByteArray();
        Sselfie = Base64.encodeToString(arr,Base64.DEFAULT);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode){
            case(CAMERA_REQUEST_CODE) :
                if(resultCode == Activity.RESULT_OK){
                    bitmap_profil = (Bitmap) data.getExtras().get("data");
                    BitMapToString(bitmap_profil);
                    selfie.setImageBitmap(bitmap_profil);
                }
                break;
        }

    }

    private void ganti_foto(String id, String foto) {

        apiInterface = RetroServer.getClient().create(APIRequestData.class);
        Call<ResponseModelPenduduk> call = apiInterface.fotoResponse(id,foto);
        call.enqueue(new Callback<ResponseModelPenduduk>() {
            @Override
            public void onResponse(Call<ResponseModelPenduduk> call, Response<ResponseModelPenduduk> response) {
//                ResponseModelPenduduk fotoResponse = response.body();

                if(response.body() != null && response.isSuccessful() && response.body().isError()){
                    Toast.makeText(FotoProfil.this, "Perubahan Berhasil! Anda Telah Logout", Toast.LENGTH_SHORT).show();
//                    sessionManager.logoutData();
                    moveToLogout();

                } else {
                    Toast.makeText(FotoProfil.this, response.body().getMessage(), Toast.LENGTH_SHORT).show();
                    Log.e("Retrofit Get Error", response.toString());
                }
            }

            @Override
            public void onFailure(Call<ResponseModelPenduduk> call, Throwable t) {
                Toast.makeText(FotoProfil.this, t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
                Log.e("Retrofit Get Error", t.toString());
            }
        });


    }
    private void moveToLogout() {
        Intent intent = new Intent(FotoProfil.this, Homepage.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NO_HISTORY);
        startActivity(intent);
        finish();
    }
    public void startkamera(){
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivityForResult(intent, CAMERA_REQUEST_CODE);
        }
    }
}