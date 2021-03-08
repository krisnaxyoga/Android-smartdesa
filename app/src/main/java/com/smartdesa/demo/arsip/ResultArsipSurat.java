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
import com.smartdesa.demo.Adapter.AdapterArsSurat;
import com.smartdesa.demo.Model.permohonan.ModelPermohonan;
import com.smartdesa.demo.Model.search.ResponseSearchSurat;
import com.smartdesa.demo.R;
import com.smartdesa.demo.Util.SessionManager;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ResultArsipSurat extends AppCompatActivity {

    //Deklarasi Variable
    APIRequestData mApiInterface;
    private RecyclerView mRecycler;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayout;
    private List<ModelPermohonan> listcetak = new ArrayList<>();
    public static ResultArsipSurat ras;
    TextView notsurat,tv_hasil;
    Button btn_back;
    String keyword,Sid;
    SessionManager sessionManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result_arsip_surat);

        mApiInterface = RetroServer.getClient().create(APIRequestData.class);
        mRecycler = findViewById(R.id.recycle_surat);
        mLayout = new LinearLayoutManager(this);
        mRecycler.setLayoutManager(mLayout);
        tv_hasil = findViewById(R.id.tv_hasil);
        btn_back = findViewById(R.id.btn_back);
        notsurat = findViewById(R.id.notsurat);

        sessionManager = new SessionManager(ResultArsipSurat.this);
        Sid = sessionManager.getUserDetail().get(SessionManager.ID);

        keyword = getIntent().getStringExtra("keyword");

        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        tv_hasil.setText(keyword);
        ras=this;
        searching(Sid,keyword);

    }
    public void searching(String id, String keyword){
        Call<ResponseSearchSurat> data = mApiInterface.getResponseSearchSurat(id,keyword);
        data.enqueue(new Callback<ResponseSearchSurat>() {
            @Override
            public void onResponse(Call<ResponseSearchSurat> call, Response<ResponseSearchSurat> response) {

                if(response.body().getKode()==1){
                    notsurat.setVisibility(View.GONE);
                    listcetak = response.body().getData();

                    mAdapter = new AdapterArsSurat(ResultArsipSurat.this, listcetak);
                    mRecycler.setAdapter(mAdapter);
                    mAdapter.notifyDataSetChanged();

                }else{
                }

            }

            @Override
            public void onFailure(Call<ResponseSearchSurat> call, Throwable t) {
                Toast.makeText(ResultArsipSurat.this,"Gagal Menghubungi Server", Toast.LENGTH_SHORT).show();
            }
        });
    }
}