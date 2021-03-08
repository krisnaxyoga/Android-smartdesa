package com.smartdesa.demo.berita;

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
import com.smartdesa.demo.Adapter.AdapterBerita;
import com.smartdesa.demo.Model.berita.ModelBerita;
import com.smartdesa.demo.Model.search.ResponseSearchBerita;
import com.smartdesa.demo.R;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ResultSearching extends AppCompatActivity {

    //Deklarasi Variable
    APIRequestData mApiInterface;
    private RecyclerView mRecycler;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayout;
    private List<ModelBerita> listberita = new ArrayList<>();
    public static ResultSearching rs;
    TextView notberita,tv_hasil;
    Button btn_back;
    String keyword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result_searching);

        mApiInterface = RetroServer.getClient().create(APIRequestData.class);
        mRecycler = findViewById(R.id.recycle_berita);
        mLayout = new LinearLayoutManager(this);
        mRecycler.setLayoutManager(mLayout);
        tv_hasil = findViewById(R.id.tv_hasil);
        btn_back = findViewById(R.id.btn_back);
        notberita = findViewById(R.id.notberita);

        keyword = getIntent().getStringExtra("keyword");

        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        tv_hasil.setText(keyword);
        rs=this;
        searching(keyword);

    }
    public void searching(String keyword){
        Call<ResponseSearchBerita> data = mApiInterface.getResponseSearchBerita(keyword);
        data.enqueue(new Callback<ResponseSearchBerita>() {
            @Override
            public void onResponse(Call<ResponseSearchBerita> call, Response<ResponseSearchBerita> response) {

                if(response.body().getKode()==1){
                    notberita.setVisibility(View.GONE);
                    listberita = response.body().getData();

                    mAdapter = new AdapterBerita(ResultSearching.this, listberita);
                    mRecycler.setAdapter(mAdapter);
                    mAdapter.notifyDataSetChanged();


                }else{
                }

            }

            @Override
            public void onFailure(Call<ResponseSearchBerita> call, Throwable t) {
                Toast.makeText(ResultSearching.this,"Gagal Menghubungi Server", Toast.LENGTH_SHORT).show();

            }
        });
    }

}