package com.smartdesa.demo.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.smartdesa.demo.API.APIRequestData;
import com.smartdesa.demo.API.RetroServer;
import com.smartdesa.demo.Adapter.AdapterKadus;
import com.smartdesa.demo.Model.kadus.ModelKadus;
import com.smartdesa.demo.Model.kadus.ResponseKadus;
import com.smartdesa.demo.R;
import com.smartdesa.demo.Util.SessionManager;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 */
public class KontakFragment extends Fragment {

    APIRequestData mApiInterface;
    private RecyclerView mRecycler;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private List<ModelKadus> listkadus = new ArrayList<>();
    private LinearLayout ln_kadus;
    ImageView profiluser;
    String Sfoto;

//    private RecyclerView rc_wilayah;
//    private RecyclerView.Adapter ad_wilayah;
//    private RecyclerView.LayoutManager la_wilayah;
//    private List<ModelWilayah> listwilayah = new ArrayList<>();
//    ModelWilayah modelWilayah;


    SessionManager sessionManager;
    String Sdusun;
    TextView tv_dusun;


    public KontakFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View view = inflater.inflate(R.layout.fragment_kontak, container, false);

        mRecycler = view.findViewById(R.id.recycle_view);
        mLayoutManager = new LinearLayoutManager(getContext());
        mRecycler.setLayoutManager(mLayoutManager);
        tv_dusun = view.findViewById(R.id.tv_dusun);
        ln_kadus = view.findViewById(R.id.ln_kadus);
        profiluser = view.findViewById(R.id.profiluser);

        //Recycler Dusun
//        rc_wilayah = view.findViewById(R.id.rc_dusun);
//        la_wilayah = new LinearLayoutManager(getContext());
//        rc_wilayah.setLayoutManager(la_wilayah);

        mApiInterface = RetroServer.getClient().create(APIRequestData.class);

        sessionManager = new SessionManager(getContext());

        Sdusun = sessionManager.getUserDetail().get(SessionManager.DUSUN_ID);
        Sfoto = sessionManager.getUserDetail().get(SessionManager.FOTO);

//        String img = RetroServer.URL_IMG_PROFIL + Sfoto;

        if(Sfoto==null){

        }else {
            Picasso.with(getContext()).
                    load(Sfoto).
                    placeholder(R.drawable.progress_animation).
                    error(R.drawable.icon).
                    fit().
                    into(profiluser);
        }

        return view;
    }
    @Override
    public void onResume() {
        super.onResume();
        loadjenis(Sdusun);
        loaddusun(Sdusun);
    }

    public void loaddusun(String dusun) {
        Call<ResponseKadus> data = mApiInterface.getModelKadus(dusun);
        data.enqueue(new Callback<ResponseKadus>() {
            @Override
            public void onResponse(Call<ResponseKadus> call, Response<ResponseKadus> response) {

//                tv_dusun.setText(modelWilayah.getDusun());
            }

            @Override
            public void onFailure(Call<ResponseKadus> call, Throwable t) {
                Toast.makeText(getContext(),"Gagal Menghubungi Server", Toast.LENGTH_SHORT).show();
            }
        });

    }

//private void loaddusun(String ddusun){
//
//    Call<ResponseWilayah> data = mApiInterface.getModelWilayah(ddusun);
//    data.enqueue(new Callback<ResponseWilayah>() {
//        @Override
//        public void onResponse(Call<ResponseWilayah> call, Response<ResponseWilayah> response) {
//
//            if(response.body().getKode()==1){
//
//                listwilayah = response.body().getData();
//                ad_wilayah = new AdpWilayah(getActivity(), listwilayah);
//                rc_wilayah.setAdapter(ad_wilayah);
//                ad_wilayah.notifyDataSetChanged();
//
//            }else{
//                Toast.makeText(getActivity(), "Data Kosong", Toast.LENGTH_SHORT).show();
//            }
//        }
//        @Override
//        public void onFailure(Call<ResponseWilayah> call, Throwable t) {
//            Toast.makeText(getActivity(),"Gagal Menghubungi Server", Toast.LENGTH_SHORT).show();
//        }
//    });
//}
    public void loadjenis(String dusun) {
        Call<ResponseKadus> data = mApiInterface.getModelKadus(dusun);
        data.enqueue(new Callback<ResponseKadus>() {
            @Override
            public void onResponse(Call<ResponseKadus> call, Response<ResponseKadus> response) {

                if(response.body().getKode()==1){
                    ln_kadus.setVisibility(View.GONE);

                    listkadus = response.body().getData();
                    mAdapter = new AdapterKadus(getActivity(), listkadus);
                    mRecycler.setAdapter(mAdapter);
                    mAdapter.notifyDataSetChanged();

                }else{

                }
            }

            @Override
            public void onFailure(Call<ResponseKadus> call, Throwable t) {
                Toast.makeText(getContext(),"Gagal Menghubungi Server", Toast.LENGTH_SHORT).show();
            }
        });

    }

}