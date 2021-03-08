package com.smartdesa.demo.updatefoto;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
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
import com.smartdesa.demo.Model.penduduk.ResponseModelPenduduk;
import com.smartdesa.demo.R;
import com.smartdesa.demo.Util.SessionManager;
import com.smartdesa.demo.homepage.Homepage;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class GaleriProfil extends AppCompatActivity {

    ImageView photo;
    TextView btn_galeri, btn_simpan;
    private static final int IMAGE_PICK_CODE = 1;
    private static final int PERMISSION_CODE = 2;
    String Sid, Sgambar="kosong";
    SessionManager sessionManager;
    public static Bitmap bitmap_profil;
    Uri imgaeuri;
    APIRequestData apiInterface;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_galeri_profil);

        photo = findViewById(R.id.photo);
        btn_galeri = findViewById(R.id.btn_galeri);
        btn_simpan = findViewById(R.id.btn_simpan);

        sessionManager = new SessionManager(this);
        Sid = sessionManager.getUserDetail().get(SessionManager.ID);

        apiInterface = RetroServer.getClient().create(APIRequestData.class);

        btn_galeri.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                    if (ActivityCompat.checkSelfPermission(GaleriProfil.this, android.Manifest.permission.READ_EXTERNAL_STORAGE) == PackageManager.PERMISSION_DENIED) {
                        String[] permission = {Manifest.permission.READ_EXTERNAL_STORAGE};
                        requestPermissions(permission, PERMISSION_CODE);
                    } else {
                        ImagePick();
                    }
                }
                else{
                    ImagePick();
                }
            }
        });
        btn_simpan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Sgambar.equals("kosong")) {
                    Toast.makeText(GaleriProfil.this, "Foto belum diambil!", Toast.LENGTH_SHORT).show();
                } else {
                    ganti_foto(Sid,Sgambar);
//                    Toast.makeText(FotoProfil.this, "Maintenance Server", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
    private void ImagePick(){
        Intent intent = new Intent(Intent.ACTION_PICK);
        intent.setType("image/*");
        startActivityForResult(intent, IMAGE_PICK_CODE);
    }
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch (requestCode) {
            case PERMISSION_CODE: {
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    ImagePick();
                } else {
                    Toast.makeText(GaleriProfil.this, "Permission denied", Toast.LENGTH_SHORT).show();
                }
            }
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK && requestCode == IMAGE_PICK_CODE) {

        }
        imgaeuri = data.getData();
        try {
            Bitmap bitmap = MediaStore.Images.Media.getBitmap(GaleriProfil.this.getContentResolver(), imgaeuri);
            BitmapToString(bitmap);
            photo.setImageBitmap(bitmap);
        } catch (IOException e) {
            Log.i("TAG", "Some exception " + e);
        }
    }
    private void BitmapToString(Bitmap bitmapImage){
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        bitmapImage.compress(Bitmap.CompressFormat.JPEG, 100, baos);
        byte[]arr=baos.toByteArray();
        Sgambar = Base64.encodeToString(arr,Base64.DEFAULT);
    }
    private void ganti_foto(String id, String foto) {

        apiInterface = RetroServer.getClient().create(APIRequestData.class);
        Call<ResponseModelPenduduk> call = apiInterface.fotoResponse(id,foto);
        call.enqueue(new Callback<ResponseModelPenduduk>() {
            @Override
            public void onResponse(Call<ResponseModelPenduduk> call, Response<ResponseModelPenduduk> response) {
//                ResponseModelPenduduk fotoResponse = response.body();

                if(response.body() != null && response.isSuccessful() && response.body().isError()){
                    Toast.makeText(GaleriProfil.this, "Perubahan Berhasil! Anda Telah Logout", Toast.LENGTH_SHORT).show();
//                    sessionManager.logoutData();
                    moveToLogout();

                } else {
                    Toast.makeText(GaleriProfil.this, response.body().getMessage(), Toast.LENGTH_SHORT).show();
                    Log.e("Retrofit Get Error", response.toString());
                }
            }

            @Override
            public void onFailure(Call<ResponseModelPenduduk> call, Throwable t) {
                Toast.makeText(GaleriProfil.this, t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
                Log.e("Retrofit Get Error", t.toString());
            }
        });

    }
    private void moveToLogout() {
        Intent intent = new Intent(GaleriProfil.this, Homepage.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NO_HISTORY);
        startActivity(intent);
        finish();
    }
}