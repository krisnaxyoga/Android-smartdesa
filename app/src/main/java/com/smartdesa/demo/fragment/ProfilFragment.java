package com.smartdesa.demo.fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.smartdesa.demo.API.APIRequestData;
import com.smartdesa.demo.API.RetroServer;
import com.smartdesa.demo.AdapterProfil.AdpAgama;
import com.smartdesa.demo.AdapterProfil.AdpKawin;
import com.smartdesa.demo.AdapterProfil.AdpKerja;
import com.smartdesa.demo.AdapterProfil.AdpSex;
import com.smartdesa.demo.Model.kependudukan.ModelKawin;
import com.smartdesa.demo.Model.kependudukan.ResponseGolonganDarah;
import com.smartdesa.demo.Model.kependudukan.ResponseKawin;
import com.smartdesa.demo.Model.kependudukan.ResponsePendWni;
import com.smartdesa.demo.dialog.FotoDialog;
import com.smartdesa.demo.homepage.Homepage;
import com.smartdesa.demo.Model.kependudukan.ModelAgama;
import com.smartdesa.demo.Model.kependudukan.ModelKerja;
import com.smartdesa.demo.Model.kependudukan.ModelPendSex;
import com.smartdesa.demo.R;
import com.smartdesa.demo.Model.kependudukan.ResponseAgama;
import com.smartdesa.demo.Model.kependudukan.ResponseKerja;
import com.smartdesa.demo.Model.kependudukan.ResponsePendSex;
import com.smartdesa.demo.Util.SessionManager;
import com.smartdesa.demo.pengumuman.DetailPengumuman;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 */
public class ProfilFragment extends Fragment {

    APIRequestData mApiInterface;
    private RecyclerView rc_sex, rc_agama, rc_kerja, rc_kawin, rc_wni, rc_golongan;
    private RecyclerView.Adapter ad_sex,ad_agama, ad_kerja, ad_kawin, ad_wni, ad_golongan;
    private RecyclerView.LayoutManager la_sex, la_agama, la_kerja, la_kawin, la_wni, la_golongan;
    SessionManager sessionManager;
    TextView lbnama,lbnik,tv_nama,tv_tmplahir, tv_tgllahir, tv_jk,tv_alamat,tv_ayah,tv_ibu,tv_pekerjaan ;
    String Snama, Snik, Stmplahir, Stgllahir, Sjk,Sdarah,Salamat,Sayah,Sibu,Sagama,Skawin,Spekerjaan,Snegara, Sfoto;
    Button btn_logout, btn_profil;
    ImageView profilphoto;
    private List<ModelPendSex> listsex = new ArrayList<>();
    private List<ModelAgama> listagama = new ArrayList<>();
    private List<ModelKerja> listkerja = new ArrayList<>();
    private List<ModelKawin> listkawin = new ArrayList<>();

    public ProfilFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View view = inflater.inflate(R.layout.fragment_profil, container, false);

        //Deklarasi Variable
        lbnama = view.findViewById(R.id.lb_nama);
        lbnik = view.findViewById(R.id.lb_nik);
        tv_nama = view.findViewById(R.id.tv_nama);
        tv_tmplahir = view.findViewById(R.id.tv_tmplahir);
        tv_tgllahir = view.findViewById(R.id.tv_tgllahir);
        tv_jk = view.findViewById(R.id.tv_jk);
        tv_alamat = view.findViewById(R.id.tv_alamat);
        tv_ayah = view.findViewById(R.id.tv_ayah);
        tv_ibu = view.findViewById(R.id.tv_ibu);
        tv_pekerjaan = view.findViewById(R.id.tv_pekerjaan);
        profilphoto = view.findViewById(R.id.profilphoto);

        btn_profil = view.findViewById(R.id.btn_profil);
        btn_logout = view.findViewById(R.id.btn_logout);
        mApiInterface = RetroServer.getClient().create(APIRequestData.class);
        sessionManager = new SessionManager(getContext());

        Snama = sessionManager.getUserDetail().get(SessionManager.NAMA);
        Snik = sessionManager.getUserDetail().get(SessionManager.NIK);
        Stmplahir = sessionManager.getUserDetail().get(SessionManager.TEMPATLAHIR);
        Stgllahir = sessionManager.getUserDetail().get(SessionManager.TANGGALLAHIR);
        Sjk = sessionManager.getUserDetail().get(SessionManager.SEX);
        Sdarah = sessionManager.getUserDetail().get(SessionManager.GOLONGANDARAH);
        Salamat = sessionManager.getUserDetail().get(SessionManager.ALAMAT);
        Sayah = sessionManager.getUserDetail().get(SessionManager.AYAH);
        Sibu = sessionManager.getUserDetail().get(SessionManager.IBU);
        Sfoto = sessionManager.getUserDetail().get(SessionManager.FOTO);
        Sagama = sessionManager.getUserDetail().get(SessionManager.AGAMA);
        Skawin = sessionManager.getUserDetail().get(SessionManager.KAWIN);
        Spekerjaan = sessionManager.getUserDetail().get(SessionManager.PEKERJAAN);
        Snegara = sessionManager.getUserDetail().get(SessionManager.WARGANEGARA);

        lbnama.setText(Snama);
        lbnik.setText(Snik);
        tv_nama.setText(Snama);
        tv_tmplahir.setText(Stmplahir);
        tv_tgllahir.setText(Stgllahir);
        tv_jk.setText(Sjk);
        tv_alamat.setText(Salamat);
        tv_ayah.setText(Sayah);
        tv_ibu.setText(Sibu);
        tv_pekerjaan.setText(Spekerjaan);

        //Recycler Sex
        rc_sex = view.findViewById(R.id.rc_sex);
        la_sex = new LinearLayoutManager(getContext());
        rc_sex.setLayoutManager(la_sex);

        //Recycler Golongan
        rc_golongan = view.findViewById(R.id.rc_golongan);
        la_golongan = new LinearLayoutManager(getContext());
        rc_golongan.setLayoutManager(la_golongan);

        //Recycler Warganegara
        rc_wni = view.findViewById(R.id.rc_wni);
        la_wni = new LinearLayoutManager(getContext());
        rc_wni.setLayoutManager(la_wni);

        //Recycler Agama
        rc_agama = view.findViewById(R.id.rc_agama);
        la_agama = new LinearLayoutManager(getContext());
        rc_agama.setLayoutManager(la_agama);

        //Recycler Pekerjaan
        rc_kerja = view.findViewById(R.id.rc_kerja);
        la_kerja = new LinearLayoutManager(getContext());
        rc_kerja.setLayoutManager(la_kerja);

        //Recycler Kawin
        rc_kawin = view.findViewById(R.id.rc_kawin);
        la_kawin = new LinearLayoutManager(getContext());
        rc_kawin.setLayoutManager(la_kawin);

        if(Sfoto==null){

        }else{
            Picasso.with(getContext()).
                    load(Sfoto).
                    placeholder(R.drawable.progress_animation).
                    error(R.drawable.icon).
                    fit().
                    into(profilphoto);
        }

        btn_logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sessionManager.logoutSession();
                moveToLogout();
            }
        });

        btn_profil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FotoDialog fotoDialog = new FotoDialog();
                fotoDialog.show(getActivity().getSupportFragmentManager(), "example dialog");
            }
        });

        return view;
    }
    private void moveToLogout() {
        Intent intent = new Intent(getContext(), Homepage.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NO_HISTORY);
        startActivity(intent);
        getActivity().finish();
    }

    @Override
    public void onResume() {
        super.onResume();
        loadsex(Sjk);
        loadagama(Sagama);
        loadkerja(Spekerjaan);
        loadkawin(Skawin);
        loadgolongan(Sdarah);
        loadwni(Snegara);
    }

    private void loadsex(String sex){

        Call<ResponsePendSex> data = mApiInterface.getModelPendSex(sex);
        data.enqueue(new Callback<ResponsePendSex>() {
            @Override
            public void onResponse(Call<ResponsePendSex> call, Response<ResponsePendSex> response) {

                if(response.body().getKode()==1){

                    listsex = response.body().getData();
                    ad_sex = new AdpSex(getActivity(), listsex);
                    rc_sex.setAdapter(ad_sex);
                    ad_sex.notifyDataSetChanged();


                }else{
                }
            }
            @Override
            public void onFailure(Call<ResponsePendSex> call, Throwable t) {
//                Toast.makeText(getContext(),"Gagal Menghubungi Server", Toast.LENGTH_SHORT).show();
            }
        });
    }
    private void loadagama(String agama){

        Call<ResponseAgama> data = mApiInterface.getModelPendAgama(agama);
        data.enqueue(new Callback<ResponseAgama>() {
            @Override
            public void onResponse(Call<ResponseAgama> call, Response<ResponseAgama> response) {

                if(response.body().getKode()==1){

                    listagama = response.body().getData();
                    ad_agama = new AdpAgama(getActivity(), listagama);
                    rc_agama.setAdapter(ad_agama);
                    ad_agama.notifyDataSetChanged();


                }else{

                }
            }
            @Override
            public void onFailure(Call<ResponseAgama> call, Throwable t) {
//                Toast.makeText(getContext(),"Gagal Menghubungi Server", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void loadkerja(String kerja){

        Call<ResponseKerja> data = mApiInterface.getModelPendKerja(kerja);
        data.enqueue(new Callback<ResponseKerja>() {
            @Override
            public void onResponse(Call<ResponseKerja> call, Response<ResponseKerja> response) {

                if(response.body().getKode()==1){

                    listkerja = response.body().getData();
                    ad_kerja = new AdpKerja(getActivity(), listkerja);
                    rc_kerja.setAdapter(ad_kerja);
                    ad_kerja.notifyDataSetChanged();


                }else{

                }
            }
            @Override
            public void onFailure(Call<ResponseKerja> call, Throwable t) {
//                Toast.makeText(getContext(),"Gagal Menghubungi Server", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void loadkawin(String kawin){

        Call<ResponseKawin> data = mApiInterface.getModelPendKawin(kawin);
        data.enqueue(new Callback<ResponseKawin>() {
            @Override
            public void onResponse(Call<ResponseKawin> call, Response<ResponseKawin> response) {

                if(response.body().getKode()==1){

                    listkawin = response.body().getData();
                    ad_kawin = new AdpKawin(getActivity(), listkawin);
                    rc_kawin.setAdapter(ad_kawin);
                    ad_kawin.notifyDataSetChanged();


                }else{

                }
            }
            @Override
            public void onFailure(Call<ResponseKawin> call, Throwable t) {
//                Toast.makeText(getContext(),"Gagal Menghubungi Server", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void loadgolongan(String golongan){

        Call<ResponseGolonganDarah> data = mApiInterface.getModelGolongan(golongan);
        data.enqueue(new Callback<ResponseGolonganDarah>() {
            @Override
            public void onResponse(Call<ResponseGolonganDarah> call, Response<ResponseGolonganDarah> response) {

                if(response.body().getKode()==1){

                    listagama = response.body().getData();
                    ad_golongan = new AdpAgama(getActivity(), listagama);
                    rc_golongan.setAdapter(ad_golongan);
                    ad_golongan.notifyDataSetChanged();

                }else{

                }
            }
            @Override
            public void onFailure(Call<ResponseGolonganDarah> call, Throwable t) {
//                Toast.makeText(getContext(),"Gagal Menghubungi Server", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void loadwni(String wni){

        Call<ResponsePendWni> data = mApiInterface.getModelPendWNI(wni);
        data.enqueue(new Callback<ResponsePendWni>() {
            @Override
            public void onResponse(Call<ResponsePendWni> call, Response<ResponsePendWni> response) {

                if(response.body().getKode()==1){

                    listagama = response.body().getData();
                    ad_wni = new AdpAgama(getActivity(), listagama);
                    rc_wni.setAdapter(ad_wni);
                    ad_wni.notifyDataSetChanged();


                }else{

                }
            }
            @Override
            public void onFailure(Call<ResponsePendWni> call, Throwable t) {
//                Toast.makeText(getContext(),"Gagal Menghubungi Server", Toast.LENGTH_SHORT).show();
            }
        });
    }
}