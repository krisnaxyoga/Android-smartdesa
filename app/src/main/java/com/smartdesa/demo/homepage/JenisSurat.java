package com.smartdesa.demo.homepage;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.smartdesa.demo.API.APIRequestData;
import com.smartdesa.demo.API.RetroServer;
import com.smartdesa.demo.Adapter.AdapterJenisSurat;
import com.smartdesa.demo.Model.surat.ModelJenisSurat;
import com.smartdesa.demo.Model.surat.ResponseJenisSurat;

import com.smartdesa.demo.R;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class JenisSurat extends AppCompatActivity {

    APIRequestData mApiInterface;
    private RecyclerView mRecycler;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    public static JenisSurat js;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jenis_surat);

        mRecycler = findViewById(R.id.recycle_view);
        mLayoutManager = new LinearLayoutManager(this);
        mRecycler.setLayoutManager(mLayoutManager);
        mApiInterface = RetroServer.getClient().create(APIRequestData.class);
        js=this;
        loadjenis();

    }
    public void loadjenis() {
        Call<ResponseJenisSurat> data = mApiInterface.getResponseJenisSurat();
        data.enqueue(new Callback<ResponseJenisSurat>() {
            @Override
            public void onResponse(Call<ResponseJenisSurat> call, Response<ResponseJenisSurat>
                    response) {
                List<ModelJenisSurat> mItems = response.body().getData();
                Log.d("Retrofit Get", "Jumlah data Kontak: " +
                        String.valueOf(mItems.size()));
                mAdapter = new AdapterJenisSurat(JenisSurat.this, mItems);
                mRecycler.setAdapter(mAdapter);
            }

            @Override
            public void onFailure(Call<ResponseJenisSurat> call, Throwable t) {
                Log.e("Retrofit Get Error", t.toString());
            }
        });
    }
}