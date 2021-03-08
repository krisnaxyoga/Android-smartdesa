package com.smartdesa.demo.homepage;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.airbnb.lottie.LottieAnimationView;
import com.smartdesa.demo.API.APIRequestData;
import com.smartdesa.demo.API.RetroServer;
import com.smartdesa.demo.Adapter.AdapterData;
import com.smartdesa.demo.Adapter.AdapterListPengumuman;
import com.smartdesa.demo.Adapter.AdapterPengumuman;
import com.smartdesa.demo.Model.pengumuman.ModelPengumuman;
import com.smartdesa.demo.Model.pengumuman.ResponseModelPengumuman;
import com.smartdesa.demo.NotFound;
import com.smartdesa.demo.berita.SearchActivity;
import com.smartdesa.demo.Model.berita.ModelBerita;
import com.smartdesa.demo.Model.berita.ResponseBerita;

import com.smartdesa.demo.R;

import com.smartdesa.demo.login.LoginActivity;
import com.smartdesa.demo.pengumuman.ListPengumuman;
import com.smartdesa.demo.register.RegisterActivity;
import com.smartdesa.demo.register.RegisterValidation;
import com.smartdesa.demo.tutorial.TutorialActivity;
import com.synnapps.carouselview.CarouselView;
import com.synnapps.carouselview.ImageListener;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Homepage extends AppCompatActivity {

    APIRequestData mApiInterface;
    private RecyclerView mRecycler1,RecyclerPengumuman;
    private RecyclerView.Adapter mAdapter, mAdapterPengumuman;
    private RecyclerView.LayoutManager mLayoutManager, mLayoutPengumuman;
    public static Homepage ma;
    CarouselView carouselView;
    TextView notpengumuman,notberita,lainnya,tampilkan_berita,tampilkan_pengumuman;
    EditText btn_search;
    private List<ModelPengumuman> listpengumuman = new ArrayList<>();
    private List<ModelBerita> listberita = new ArrayList<>();
    private CardView btn_tutorial, btn_login, btn_register;
    int[] sampleImages = {R.drawable.slide1, R.drawable.slide2, R.drawable.slide3};
    private LottieAnimationView update;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homepage);

        btn_login = findViewById(R.id.btn_login);
        btn_register = findViewById(R.id.btn_register);
        btn_search = findViewById(R.id.btn_search);
        carouselView = findViewById(R.id.carouselView);
        carouselView.setPageCount(sampleImages.length);
        carouselView.setImageListener(imageListener);
        btn_tutorial = findViewById(R.id.btn_tutorial);
        notpengumuman = findViewById(R.id.notpengumuman);
        notberita = findViewById(R.id.notberita);
        lainnya = findViewById(R.id.lainnya);
        update = findViewById(R.id.update);
//        tampilkan_berita = findViewById(R.id.tampilkan_berita);
        tampilkan_pengumuman = findViewById(R.id.tampilkan_pengumuman);
//        slider = findViewById(R.id.slider);

        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Homepage.this, LoginActivity.class);
                startActivity(intent);
                finish();
            }
        });

        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Homepage.this, UpdateActivity.class);
                startActivity(intent);

            }
        });

        btn_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Homepage.this, RegisterValidation.class);
                startActivity(intent);
            }
        });

        btn_search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Homepage.this, SearchActivity.class);
                startActivity(intent);
            }
        });

//        btn_menu.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                MainDialog mainDialog = new MainDialog();
//                mainDialog.show(getSupportFragmentManager(), "example dialog");
//            }
//        });

        lainnya.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Homepage.this, SearchActivity.class);
                startActivity(intent);
            }
        });

        tampilkan_pengumuman.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Homepage.this, ListPengumuman.class);
                startActivity(intent);
            }
        });

        btn_tutorial.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Homepage.this, TutorialActivity.class);
                startActivity(intent);
            }
        });

//        tampilkan_berita.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(Homepage.this, SearchActivity.class);
//                startActivity(intent);
//            }
//        });

        mRecycler1 = findViewById(R.id.recycle_berita_terbaru);
        RecyclerPengumuman = findViewById(R.id.recycle_pengumuman);
        mLayoutManager = new LinearLayoutManager(this);
        mLayoutPengumuman = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL,false);
        mRecycler1.setLayoutManager(mLayoutManager);
        RecyclerPengumuman.setLayoutManager(mLayoutPengumuman);
        mApiInterface = RetroServer.getClient().create(APIRequestData.class);
        ma=this;

    }
    ImageListener imageListener = new ImageListener() {
        @Override
        public void setImageForPosition(int position, ImageView imageView) {
            imageView.setImageResource(sampleImages[position]);
        }
    };

    @Override
    protected void onResume() {
        super.onResume();
        refresh();
        loadpengumuman();
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

                mAdapter = new AdapterData(Homepage.this, listberita);
                mRecycler1.setAdapter(mAdapter);
                mAdapter.notifyDataSetChanged();

            }else{
            }
        }

        @Override
        public void onFailure(Call<ResponseBerita> call, Throwable t) {
            Log.e("Retrofit Get Error", t.toString());
            Toast.makeText(Homepage.this,"Kesalahan Server", Toast.LENGTH_SHORT).show();
        }
    });
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

                    mAdapterPengumuman = new AdapterListPengumuman(Homepage.this, listpengumuman);
                    RecyclerPengumuman.setAdapter(mAdapterPengumuman);
                    mAdapterPengumuman.notifyDataSetChanged();

                }else{
                }

            }

            @Override
            public void onFailure(Call<ResponseModelPengumuman> call, Throwable t) {
                Log.e("Retrofit Get Error", t.toString());
                Toast.makeText(Homepage.this,"Kesalahan Server", Toast.LENGTH_SHORT).show();
            }
        });
    }
}