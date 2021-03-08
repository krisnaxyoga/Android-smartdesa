package com.smartdesa.demo.register;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.smartdesa.demo.API.APIRequestData;
import com.smartdesa.demo.API.RetroServer;
import com.smartdesa.demo.Model.kk.ResponseModelKK;
import com.smartdesa.demo.Model.penduduk.ModelPenduduk;
import com.smartdesa.demo.Model.penduduk.ResponseModelPenduduk;
import com.smartdesa.demo.R;
import com.smartdesa.demo.Util.SessionManager;
import com.smartdesa.demo.fragment.Beranda;
import com.smartdesa.demo.homepage.Homepage;
import com.smartdesa.demo.login.LoginActivity;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RegisterValidation extends AppCompatActivity {

    APIRequestData mApiInterface;
    EditText et_kk, et_nik;
    String kk,nik;
    Button btn_kirim;
    private ProgressDialog pd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_validation);

        mApiInterface = RetroServer.getClient().create(APIRequestData.class);
        et_kk = findViewById(R.id.et_kk);
        et_nik = findViewById(R.id.et_nik);
        btn_kirim = findViewById(R.id.btn_kirim);
        pd = new ProgressDialog(RegisterValidation.this);
        pd.setMessage("loading...");
        btn_kirim = findViewById(R.id.btn_kirim);
        btn_kirim.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                kk = et_kk.getText().toString().trim();
                nik = et_nik.getText().toString().trim();
                if (kk.isEmpty()) {
                    et_kk.setError("Nomor Kartu Keluarga Belum diisi");
                    et_kk.requestFocus();
                    return;
                }
                if (nik.isEmpty()) {
                    et_nik.setError("NIK Belum diisi");
                    et_nik.requestFocus();
                    return;
                }else{
                    proses_validasi(kk,nik);
                }
            }
        });

    }
    @Override
    public void onBackPressed() {
        Intent intent = new Intent(RegisterValidation.this, Homepage.class);
        startActivity(intent);
        finish();
    }

    private void proses_validasi(String kk, String nik) {

        mApiInterface = RetroServer.getClient().create(APIRequestData.class);
        Call<ResponseModelKK> validasiCall = mApiInterface.userValidasi(kk,nik);
        validasiCall.enqueue(new Callback<ResponseModelKK>() {
            @Override
            public void onResponse(Call<ResponseModelKK> call, Response<ResponseModelKK> response) {
                ResponseModelKK validResponse = response.body();

                if (response.body() != null && !validResponse.isError()) {

                    //Ini untuk pindah
                    Toast.makeText(RegisterValidation.this, response.body().getMessage(), Toast.LENGTH_SHORT).show();
//                    Toast.makeText(LoginActivity.this, response.body().getModelPenduduk().getNama(), Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(RegisterValidation.this, RegisterActivity.class);
                    intent.putExtra("no_kk", kk);
                    startActivity(intent);
                    finish();

                } else {
                    Toast.makeText(RegisterValidation.this, response.body().getMessage(), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<ResponseModelKK> call, Throwable t) {

                Toast.makeText(RegisterValidation.this, t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
            }
        });

    }
}