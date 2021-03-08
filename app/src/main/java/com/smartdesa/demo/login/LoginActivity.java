package com.smartdesa.demo.login;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.smartdesa.demo.API.APIRequestData;
import com.smartdesa.demo.API.RetroServer;
import com.smartdesa.demo.Model.penduduk.ModelPenduduk;
import com.smartdesa.demo.Model.penduduk.ResponseModelPenduduk;
import com.smartdesa.demo.NotFound;
import com.smartdesa.demo.R;
import com.smartdesa.demo.Util.SessionManager;
import com.smartdesa.demo.fragment.Beranda;
import com.smartdesa.demo.homepage.Homepage;
import com.smartdesa.demo.tutorial.TutorialActivity;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {

//    DatePickerDialog.OnDateSetListener setListener;

    APIRequestData mApiInterface;
    Button  btn_masuk, btn_regis;
    TextView tv_bulan,bulanlahir,date;
    EditText et_nik, et_tanggal, et_tahun;
    String nik, tanggal, tahun, Sdate, Sbulanlahir;
    private Spinner sp_bulan;
    private ProgressDialog pd;
    private String[] list_bulan = {"-Bulan-","Januari","Februari","Maret","April","Mei",
                                    "Juni","Juli","Agustus","September","Oktober","November","Desember"};
    SessionManager sessionManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        tv_bulan = findViewById(R.id.tv_bulan);
        et_tanggal = findViewById(R.id.et_tanggal);
        et_tahun = findViewById(R.id.et_tahun);
        et_nik = findViewById(R.id.et_nik);
        sp_bulan = findViewById(R.id.sp_bulan);
        bulanlahir = findViewById(R.id.bulanlahir);
        date = findViewById(R.id.date);
//        btn_date = findViewById(R.id.btn_date);
//        sm = new SessionManager(LoginActivity.this);
        pd = new ProgressDialog(LoginActivity.this);
        pd.setMessage("loading...");
        mApiInterface = RetroServer.getClient().create(APIRequestData.class);

        sp_bulan.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                tv_bulan.setText(list_bulan[position]);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                tv_bulan.setText("-Bulan-");
            }
        });

        //Spinner Kategori
        ArrayAdapter adapter_bulan = new ArrayAdapter(this, R.layout.support_simple_spinner_dropdown_item, list_bulan);
        adapter_bulan.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        sp_bulan.setAdapter(adapter_bulan);

        btn_masuk = findViewById(R.id.btn_masuk);
        btn_regis = findViewById(R.id.btn_regis);
        btn_regis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, NotFound.class);
                startActivity(intent);
            }
        });

        btn_masuk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nik = et_nik.getText().toString().trim();
                tanggal = et_tanggal.getText().toString().trim();
                tahun = et_tahun.getText().toString().trim();

                if (nik.isEmpty()) {
                    et_nik.setError("NIK Belum diisi");
                    et_nik.requestFocus();
                    return;
                }

                if (tanggal.isEmpty()) {
                    et_tanggal.setError("Belum Memilih Tanggal");
                    et_tanggal.requestFocus();
                    return;
                }
                if (tahun.isEmpty()) {
                    et_tahun.setError("Belum Memilih Tahun");
                    et_tahun.requestFocus();
                    return;
                }else{
                    if(tv_bulan.getText().toString().equals("Januari")){
                        bulanlahir.setText("01");
                        Sbulanlahir = bulanlahir.getText().toString();
                    }if(tv_bulan.getText().toString().equals("Februari")){
                        bulanlahir.setText("02");
                        Sbulanlahir = bulanlahir.getText().toString();
                    }if(tv_bulan.getText().toString().equals("Maret")){
                        bulanlahir.setText("03");
                        Sbulanlahir = bulanlahir.getText().toString();
                    }if(tv_bulan.getText().toString().equals("April")){
                        bulanlahir.setText("04");
                        Sbulanlahir = bulanlahir.getText().toString();
                    }if(tv_bulan.getText().toString().equals("Mei")){
                        bulanlahir.setText("05");
                        Sbulanlahir = bulanlahir.getText().toString();
                    }if(tv_bulan.getText().toString().equals("Juni")){
                        bulanlahir.setText("06");
                        Sbulanlahir = bulanlahir.getText().toString();
                    }if(tv_bulan.getText().toString().equals("Juli")){
                        bulanlahir.setText("07");
                        Sbulanlahir = bulanlahir.getText().toString();
                    }if(tv_bulan.getText().toString().equals("Agustus")){
                        bulanlahir.setText("08");
                        Sbulanlahir = bulanlahir.getText().toString();
                    }if(tv_bulan.getText().toString().equals("September")){
                        bulanlahir.setText("09");
                        Sbulanlahir = bulanlahir.getText().toString();
                    }if(tv_bulan.getText().toString().equals("Oktober")){
                        bulanlahir.setText("10");
                        Sbulanlahir = bulanlahir.getText().toString();
                    }if(tv_bulan.getText().toString().equals("November")){
                        bulanlahir.setText("11");
                        Sbulanlahir = bulanlahir.getText().toString();
                    }if(tv_bulan.getText().toString().equals("Desember")){
                        bulanlahir.setText("12");
                        Sbulanlahir = bulanlahir.getText().toString();
                    }
                        Sdate = tahun+"-"+Sbulanlahir+"-"+tanggal;
                        date.setText(Sdate);
                        proses_login(nik,Sdate);

                }

            }
        });

    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(LoginActivity.this, Homepage.class);
        startActivity(intent);
        finish();
    }

    private void proses_login(String nik, String tanggal) {

        mApiInterface = RetroServer.getClient().create(APIRequestData.class);
        Call<ResponseModelPenduduk> loginCall = mApiInterface.userLogin(nik,tanggal);
        loginCall.enqueue(new Callback<ResponseModelPenduduk>() {
            @Override
            public void onResponse(Call<ResponseModelPenduduk> call, Response<ResponseModelPenduduk> response) {
                ResponseModelPenduduk loginResponse = response.body();

                if (response.body() != null && !loginResponse.isError()) {

                    // Ini untuk menyimpan sesi
                    sessionManager = new SessionManager(LoginActivity.this);
                    ModelPenduduk modelPenduduk = response.body().getModelPenduduk();
                    sessionManager.createLoginSession(modelPenduduk);

                    //Ini untuk pindah
                    Toast.makeText(LoginActivity.this, "Login Berhasil " +response.body().getModelPenduduk().getNama(), Toast.LENGTH_SHORT).show();
//                    Toast.makeText(LoginActivity.this, response.body().getModelPenduduk().getNama(), Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(LoginActivity.this, Beranda.class);
                    startActivity(intent);
                    finish();

                } else {
                    Toast.makeText(LoginActivity.this, response.body().getMessage(), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<ResponseModelPenduduk> call, Throwable t) {

                Toast.makeText(LoginActivity.this, t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
            }
        });

    }

}
