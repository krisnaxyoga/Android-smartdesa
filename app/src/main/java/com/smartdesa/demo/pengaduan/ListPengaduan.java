package com.smartdesa.demo.pengaduan;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.smartdesa.demo.API.APIRequestData;
import com.smartdesa.demo.API.RetroServer;
import com.smartdesa.demo.Adapter.AdapterListPengaduan;
import com.smartdesa.demo.Model.pengaduan.ModelPengaduan;
import com.smartdesa.demo.Model.pengaduan.ResponseModelPengaduan;
import com.smartdesa.demo.R;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ListPengaduan extends AppCompatActivity {

    APIRequestData mApiInterface;
    private RecyclerView mRecycler;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    public static ListPengaduan lp;
    ImageButton btn_reply;
    LinearLayout notif;
    TextView angka_notif;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_pengaduan);

        mRecycler = findViewById(R.id.recycle_view);
        mLayoutManager = new LinearLayoutManager(this);
        mRecycler.setLayoutManager(mLayoutManager);
        mApiInterface = RetroServer.getClient().create(APIRequestData.class);
        btn_reply = findViewById(R.id.btn_reply);
        notif = findViewById(R.id.notif);
        angka_notif = findViewById(R.id.angka_notif);
        lp=this;
        loadjenis();

        btn_reply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ListPengaduan.this, ReplyPengaduan.class);
                startActivity(intent);
            }
        });
    }
    public void loadjenis() {
        Call<ResponseModelPengaduan> data = mApiInterface.getResponseModelPengaduan();
        data.enqueue(new Callback<ResponseModelPengaduan>() {
            @Override
            public void onResponse(Call<ResponseModelPengaduan> call, Response<ResponseModelPengaduan>
                    response) {
                List<ModelPengaduan> mItems = response.body().getData();
                Log.d("Retrofit Get", "Jumlah data Kontak: " +
                        String.valueOf(mItems.size()));
                mAdapter = new AdapterListPengaduan(ListPengaduan.this, mItems);
                mRecycler.setAdapter(mAdapter);
            }

            @Override
            public void onFailure(Call<ResponseModelPengaduan> call, Throwable t) {
                Log.e("Retrofit Get Error", t.toString());
            }
        });

    }
//    public void loadangka() {
//        Call<ResponseModelReply> data = mApiInterface.getResponseModelReply();
//        data.enqueue(new Callback<ResponseModelReply>() {
//            @Override
//            public void onResponse(Call<ResponseModelReply> call, Response<ResponseModelReply>
//                    response) {
//                    List<ModelReply> mItems = response.body().getData();
//                    Log.d("Retrofit Get", "Jumlah data Kontak: " +
//                            String.valueOf(mItems.size()));
//                    angka_notif.setText(String.valueOf(mItems.size()));
//            }
//
//            @Override
//            public void onFailure(Call<ResponseModelReply> call, Throwable t) {
//                Log.e("Retrofit Get Error", t.toString());
//            }
//        });
//
//    }

    @Override
    protected void onResume() {
        super.onResume();
//        loadangka();
    }
}