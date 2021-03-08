package com.smartdesa.demo.berita;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import com.smartdesa.demo.API.APIRequestData;
import com.smartdesa.demo.API.RetroServer;
import com.smartdesa.demo.Adapter.AdapterData;
import com.smartdesa.demo.Model.berita.ModelBerita;
import com.smartdesa.demo.Model.berita.ResponseBerita;

import com.smartdesa.demo.R;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class NewsActivity extends AppCompatActivity {

    APIRequestData mApiInterface;
    private RecyclerView mRecycler;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    public static NewsActivity na;
    ImageView btn_search;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news);

        btn_search = findViewById(R.id.btn_search);
        mRecycler = findViewById(R.id.recycle_view);
        mLayoutManager = new LinearLayoutManager(this);
        mRecycler.setLayoutManager(mLayoutManager);
        mApiInterface = RetroServer.getClient().create(APIRequestData.class);
        na=this;
        refresh();

        btn_search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(NewsActivity.this, SearchActivity.class);
                startActivity(intent);
            }
        });

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
            mAdapter = new AdapterData(NewsActivity.this,listberita);
            mRecycler.setAdapter(mAdapter);
        }

        @Override
        public void onFailure(Call<ResponseBerita> call, Throwable t) {
            Log.e("Retrofit Get Error", t.toString());
        }
    });
}

}
