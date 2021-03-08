package com.smartdesa.demo.pengumuman;

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
import com.smartdesa.demo.Adapter.AdapterListPengumuman;
import com.smartdesa.demo.Model.pengumuman.ModelPengumuman;
import com.smartdesa.demo.Model.pengumuman.ResponseModelPengumuman;
import com.smartdesa.demo.R;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ResultPengumuman extends AppCompatActivity {


    //Deklarasi Variable
    APIRequestData mApiInterface;
    private RecyclerView mRecycler;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayout;
    private List<ModelPengumuman> listpengumuman = new ArrayList<>();
    TextView notpengumuman,tv_hasil;
    Button btn_back;
    String keyword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result_pengumuman);

        mApiInterface = RetroServer.getClient().create(APIRequestData.class);
        mRecycler = findViewById(R.id.recycle_pengumuman);
        mLayout = new LinearLayoutManager(this);
        mRecycler.setLayoutManager(mLayout);
        tv_hasil = findViewById(R.id.tv_hasil);
        btn_back = findViewById(R.id.btn_back);
        notpengumuman = findViewById(R.id.notpengumuman);

        keyword = getIntent().getStringExtra("keyword");

        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        tv_hasil.setText(keyword);
        searching(keyword);
    }
    public void searching(String keyword){
        Call<ResponseModelPengumuman> data = mApiInterface.getResponseSearchPengumuman(keyword);
        data.enqueue(new Callback<ResponseModelPengumuman>() {
            @Override
            public void onResponse(Call<ResponseModelPengumuman> call, Response<ResponseModelPengumuman> response) {

                if(response.body().getKode()==1){
                    notpengumuman.setVisibility(View.GONE);
                    listpengumuman = response.body().getData();

                    mAdapter = new AdapterListPengumuman(ResultPengumuman.this, listpengumuman);
                    mRecycler.setAdapter(mAdapter);
                    mAdapter.notifyDataSetChanged();


                }else{
                }

            }

            @Override
            public void onFailure(Call<ResponseModelPengumuman> call, Throwable t) {
                Toast.makeText(ResultPengumuman.this,"Gagal Menghubungi Server", Toast.LENGTH_SHORT).show();

            }
        });
    }
}