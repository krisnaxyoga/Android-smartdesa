package com.smartdesa.demo.pengumuman;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
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

public class ListPengumuman extends AppCompatActivity {

    APIRequestData mApiInterface;
    private RecyclerView RecyclerPengumuman;
    private RecyclerView.Adapter mAdapterPengumuman;
    private RecyclerView.LayoutManager mLayoutPengumuman;
    private List<ModelPengumuman> listpengumuman = new ArrayList<>();
    TextView notpengumuman;
    EditText et_search;
    Button btn_search;
    String Ssearch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_pengumuman);

        notpengumuman = findViewById(R.id.notpengumuman);
        RecyclerPengumuman = findViewById(R.id.recycle_pengumuman);
        mLayoutPengumuman = new LinearLayoutManager(this);
        RecyclerPengumuman.setLayoutManager(mLayoutPengumuman);
        mApiInterface = RetroServer.getClient().create(APIRequestData.class);
        et_search = findViewById(R.id.et_search);
        btn_search = findViewById(R.id.btn_search);

        btn_search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Ssearch = et_search.getText().toString().trim();
                if (Ssearch.isEmpty()) {
                    et_search.setError("Teks Belum diisi");
                    et_search.requestFocus();
                    return;
                }else{
                    Intent intent = new Intent(ListPengumuman.this, ResultPengumuman.class);
                    intent.putExtra("keyword", et_search.getText().toString());
                    startActivity(intent);
                }
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        loadpengumuman();
    }
    public void loadpengumuman() {
        Call<ResponseModelPengumuman> data = mApiInterface.getResponseModelPengumuman();
        data.enqueue(new Callback<ResponseModelPengumuman>() {
            @Override
            public void onResponse(Call<ResponseModelPengumuman> call, Response<ResponseModelPengumuman>
                    response) {

                if(response.body().getKode()==1){

                    notpengumuman.setVisibility(View.GONE);
                    listpengumuman = response.body().getData();

                    mAdapterPengumuman = new AdapterListPengumuman(ListPengumuman.this, listpengumuman);
                    RecyclerPengumuman.setAdapter(mAdapterPengumuman);
                    mAdapterPengumuman.notifyDataSetChanged();

                }else{
                }

            }
            @Override
            public void onFailure(Call<ResponseModelPengumuman> call, Throwable t) {
                Log.e("Retrofit Get Error", t.toString());
                Toast.makeText(ListPengumuman.this,"Kesalahan Server", Toast.LENGTH_SHORT).show();
            }
        });
    }
}