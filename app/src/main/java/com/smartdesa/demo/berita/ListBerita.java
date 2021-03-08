package com.smartdesa.demo.berita;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.smartdesa.demo.API.APIRequestData;
import com.smartdesa.demo.API.RetroServer;
import com.smartdesa.demo.Adapter.AdapterBerita;
import com.smartdesa.demo.Model.berita.ModelBerita;
import com.smartdesa.demo.Model.berita.ResponseBerita;

import com.smartdesa.demo.R;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ListBerita extends AppCompatActivity {

    APIRequestData mApiInterface;
    private RecyclerView recycle_view;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    public static ListBerita ma;
    Button btn_home;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_berita);

        btn_home = findViewById(R.id.btn_home);
        btn_home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        recycle_view = findViewById(R.id.recycle_view);
        mLayoutManager = new LinearLayoutManager(this);
        recycle_view.setLayoutManager(mLayoutManager);
        mApiInterface = RetroServer.getClient().create(APIRequestData.class);
        ma=this;
        refresh();

    }
    public void refresh() {
        Call<ResponseBerita> data = mApiInterface.getResponseBerita();
        data.enqueue(new Callback<ResponseBerita>() {
            @Override
            public void onResponse(Call<ResponseBerita> call, Response<ResponseBerita>
                    response) {
                List<ModelBerita> listberita = response.body().getData();
                Log.d("Retrofit Get", "Jumlah data Kontak: " +
                        String.valueOf(listberita.size()));
                mAdapter = new AdapterBerita(ListBerita.this, listberita);
                recycle_view.setAdapter(mAdapter);
            }

            @Override
            public void onFailure(Call<ResponseBerita> call, Throwable t) {
                Log.e("Retrofit Get Error", t.toString());
            }
        });
    }

}