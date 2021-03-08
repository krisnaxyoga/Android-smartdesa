package com.smartdesa.demo.berita;

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
import com.smartdesa.demo.Adapter.AdapterBerita;
import com.smartdesa.demo.Model.berita.ModelBerita;
import com.smartdesa.demo.Model.berita.ResponseBerita;
import com.smartdesa.demo.R;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SearchActivity extends AppCompatActivity {

    //Deklarasi Variable
    APIRequestData mApiInterface;
    private RecyclerView mRecycler;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayout;
    private List<ModelBerita> listberita = new ArrayList<>();
    public static SearchActivity sa;
    TextView notberita;
    EditText et_search;
    Button btn_search;
    String Ssearch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        mApiInterface = RetroServer.getClient().create(APIRequestData.class);
        notberita = findViewById(R.id.notberita);
        et_search = findViewById(R.id.et_search);
        btn_search = findViewById(R.id.btn_search);
        mRecycler = findViewById(R.id.recycle_berita);
        mLayout = new LinearLayoutManager(this);
        mRecycler.setLayoutManager(mLayout);
        sa=this;

        refresh();

        btn_search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Ssearch = et_search.getText().toString().trim();
                if (Ssearch.isEmpty()) {
                    et_search.setError("Teks Belum diisi");
                    et_search.requestFocus();
                    return;
                }else{
                Intent intent = new Intent(SearchActivity.this, ResultSearching.class);
                intent.putExtra("keyword", et_search.getText().toString());
                startActivity(intent);
                }
            }
        });

    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    public void refresh() {
        Call<ResponseBerita> data = mApiInterface.getResponseBerita();
        data.enqueue(new Callback<ResponseBerita>() {
            @Override
            public void onResponse(Call<ResponseBerita> call, Response<ResponseBerita>
                    response) {

                if(response.body().getKode()==1){

                    notberita.setVisibility(View.GONE);
                    listberita = response.body().getData();

                    mAdapter = new AdapterBerita(SearchActivity.this, listberita);
                    mRecycler.setAdapter(mAdapter);
                    mAdapter.notifyDataSetChanged();

                }else{
                }
            }

            @Override
            public void onFailure(Call<ResponseBerita> call, Throwable t) {
                Log.e("Retrofit Get Error", t.toString());
                Toast.makeText(SearchActivity.this,"Kesalahan Server", Toast.LENGTH_SHORT).show();
            }
        });
    }
}