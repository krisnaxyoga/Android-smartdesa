package com.smartdesa.demo.arsip;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.smartdesa.demo.API.APIRequestData;
import com.smartdesa.demo.API.RetroServer;
import com.smartdesa.demo.Adapter.AdapterArsPengaduan;
import com.smartdesa.demo.Model.pengaduan.ModelDisposisi;
import com.smartdesa.demo.Model.search.ResponseSearchPengaduan;
import com.smartdesa.demo.R;
import com.smartdesa.demo.Util.SessionManager;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ResultArsipPengaduan extends AppCompatActivity {

    //Deklarasi Variable
    APIRequestData mApiInterface;
    private RecyclerView mRecycler;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayout;
    private List<ModelDisposisi> listreply = new ArrayList<>();
    public static ResultArsipPengaduan rap;
    TextView notpengaduan,tv_hasil;
    Button btn_back;
    String keyword,Sid;
    SessionManager sessionManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result_arsip_pengaduan);

        mApiInterface = RetroServer.getClient().create(APIRequestData.class);
        mRecycler = findViewById(R.id.recycle_pengaduan);
        mLayout = new LinearLayoutManager(this);
        mRecycler.setLayoutManager(mLayout);
        tv_hasil = findViewById(R.id.tv_hasil);
        btn_back = findViewById(R.id.btn_back);
        notpengaduan = findViewById(R.id.notpengaduan);

        sessionManager = new SessionManager(ResultArsipPengaduan.this);
        Sid = sessionManager.getUserDetail().get(SessionManager.ID);

        keyword = getIntent().getStringExtra("keyword");

        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        tv_hasil.setText(keyword);
        rap=this;
        searching(Sid,keyword);

    }
    public void searching(String penduduk_id, String keyword){
        Call<ResponseSearchPengaduan> data = mApiInterface.getResponseSearchPengaduan(penduduk_id,keyword);
        data.enqueue(new Callback<ResponseSearchPengaduan>() {
            @Override
            public void onResponse(Call<ResponseSearchPengaduan> call, Response<ResponseSearchPengaduan> response) {

                if(response.body().getKode()==1){
                    notpengaduan.setVisibility(View.GONE);
                    listreply = response.body().getData();

                    mAdapter = new AdapterArsPengaduan(ResultArsipPengaduan.this, listreply);
                    mRecycler.setAdapter(mAdapter);
                    mAdapter.notifyDataSetChanged();

                }else{
                }

            }

            @Override
            public void onFailure(Call<ResponseSearchPengaduan> call, Throwable t) {
                Toast.makeText(ResultArsipPengaduan.this,"Gagal Menghubungi Server", Toast.LENGTH_SHORT).show();
            }
        });
    }
}