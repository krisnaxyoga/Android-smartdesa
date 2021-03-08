package com.smartdesa.demo.arsip;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.airbnb.lottie.LottieAnimationView;
import com.smartdesa.demo.API.APIRequestData;
import com.smartdesa.demo.API.RetroServer;
import com.smartdesa.demo.Adapter.AdapterArsSurat;
import com.smartdesa.demo.Model.permohonan.ModelPermohonan;
import com.smartdesa.demo.Model.permohonan.ResponseListPermohonan;
import com.smartdesa.demo.R;
import com.smartdesa.demo.Util.SessionManager;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ArsipSurat extends AppCompatActivity {

    APIRequestData mApiInterface;
    private RecyclerView mRecycler;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private List<ModelPermohonan> listcetak = new ArrayList<>();
    SessionManager sessionManager;
    EditText et_tanggal, et_tahun;
    ImageView btn_search;
    TextView tv_bulan,bulanlahir,date;
    private Spinner sp_bulan;
    private String[] list_bulan = {"-Bulan-","Januari","Februari","Maret","April","Mei",
            "Juni","Juli","Agustus","September","Oktober","November","Desember"};
    String Sid;
    String tanggal, tahun, Sdate, Sbulanlahir;
    LottieAnimationView gambar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_arsip_surat);

        et_tanggal = findViewById(R.id.et_tanggal);
        et_tahun = findViewById(R.id.et_tahun);
        tv_bulan = findViewById(R.id.tv_bulan);
        bulanlahir = findViewById(R.id.bulanlahir);
        mRecycler = findViewById(R.id.recycle_view);
        mLayoutManager = new LinearLayoutManager(ArsipSurat.this);
        mRecycler.setLayoutManager(mLayoutManager);
        mApiInterface = RetroServer.getClient().create(APIRequestData.class);
        gambar = findViewById(R.id.gambar);
        date = findViewById(R.id.date);
        btn_search = findViewById(R.id.btn_search);
        sp_bulan = findViewById(R.id.sp_bulan);

        sessionManager = new SessionManager(ArsipSurat.this);
        Sid = sessionManager.getUserDetail().get(SessionManager.ID);

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

        btn_search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                tanggal = et_tanggal.getText().toString().trim();
                tahun = et_tahun.getText().toString().trim();

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

                    Intent intent = new Intent(ArsipSurat.this, ResultArsipSurat.class);
                    intent.putExtra("keyword", date.getText().toString());
                    startActivity(intent);
                }
            }
        });
    }
    @Override
    public void onResume() {
        super.onResume();
        loadjenis(Sid);
    }
    public void loadjenis(String id) {
        Call<ResponseListPermohonan> data = mApiInterface.getResponseCetak(id);
        data.enqueue(new Callback<ResponseListPermohonan>() {
            @Override
            public void onResponse(Call<ResponseListPermohonan> call, Response<ResponseListPermohonan> response) {

                if(response.body().getKode()==1){
                    gambar.setVisibility(View.GONE);

                    listcetak = response.body().getData();

                    mAdapter = new AdapterArsSurat(ArsipSurat.this, listcetak);
                    mRecycler.setAdapter(mAdapter);
                    mAdapter.notifyDataSetChanged();

                }else{
                    Toast.makeText(ArsipSurat.this, "Belum Ada Surat Dicetak", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<ResponseListPermohonan> call, Throwable t) {
                Toast.makeText(ArsipSurat.this,"Gagal Menghubungi Server", Toast.LENGTH_SHORT).show();

            }
        });

    }
}