package com.smartdesa.demo.pengaduan;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.smartdesa.demo.API.APIRequestData;
import com.smartdesa.demo.API.RetroServer;
import com.smartdesa.demo.Adapter.AdapterReply;
import com.smartdesa.demo.Model.pengaduan.ModelDisposisi;
import com.smartdesa.demo.Model.pengaduan.ResponseDisposisi;
import com.smartdesa.demo.R;
import com.smartdesa.demo.Util.SessionManager;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ReplyPengaduan extends AppCompatActivity {

    APIRequestData mApiInterface;
    private RecyclerView mRecycler;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    public static ReplyPengaduan rp;
    SessionManager sessionManager;
    String Spenduduk_id;
    private List<ModelDisposisi> listreply = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reply_pengaduan);

        mRecycler = findViewById(R.id.recycle_view);
        mLayoutManager = new LinearLayoutManager(this);
        mRecycler.setLayoutManager(mLayoutManager);
        mApiInterface = RetroServer.getClient().create(APIRequestData.class);
        sessionManager = new SessionManager(ReplyPengaduan.this);

        Spenduduk_id = sessionManager.getUserDetail().get(SessionManager.ID);
        rp=this;
        loadjenis(Spenduduk_id);

    }

    private void loadjenis(String penduduk_id){

    Call<ResponseDisposisi> data = mApiInterface.getResponseDisposisi(penduduk_id);
    data.enqueue(new Callback<ResponseDisposisi>() {
        @Override
        public void onResponse(Call<ResponseDisposisi> call, Response<ResponseDisposisi> response) {

            if(response.body().getKode()==1){

                listreply = response.body().getData();
                mAdapter = new AdapterReply(ReplyPengaduan.this, listreply);
                mRecycler.setAdapter(mAdapter);
                mAdapter.notifyDataSetChanged();

            }else{
                Toast.makeText(ReplyPengaduan.this,"Data Belum Tersedia", Toast.LENGTH_SHORT).show();
            }
        }
        @Override
        public void onFailure(Call<ResponseDisposisi> call, Throwable t) {
            Toast.makeText(ReplyPengaduan.this,"Gagal Menghubungi Server", Toast.LENGTH_SHORT).show();
        }
    });
}
}