package com.smartdesa.demo.fragment;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.FragmentManager;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;

import androidx.cardview.widget.CardView;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import com.smartdesa.demo.API.APIRequestData;
import com.smartdesa.demo.API.RetroServer;
import com.smartdesa.demo.Adapter.AdapterPopPengumuman;
import com.smartdesa.demo.Model.pengumuman.ModelPengumuman;
import com.smartdesa.demo.Model.pengumuman.ResponseModelPengumuman;
import com.smartdesa.demo.arsip.ArsipPengaduan;
import com.smartdesa.demo.arsip.ArsipSurat;
import com.smartdesa.demo.surat.CetakSurat;
import com.smartdesa.demo.Model.permohonan.ModelPermohonan;
import com.smartdesa.demo.cctv.CctvActivity;
import com.smartdesa.demo.dialog.LainnyaDialog;
import com.smartdesa.demo.dialog.MekanismeDialog;
import com.smartdesa.demo.homepage.Homepage;
import com.smartdesa.demo.homepage.JenisSurat;
import com.smartdesa.demo.Model.permohonan.ResponseListPermohonan;
import com.smartdesa.demo.berita.NewsActivity;
import com.smartdesa.demo.R;
import com.smartdesa.demo.Util.SessionManager;
import com.smartdesa.demo.pengaduan.ListPengaduan;
import com.smartdesa.demo.pengumuman.ListPengumuman;
import com.smartdesa.demo.tempat.TempatActivity;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 */
public class BerandaFragment extends Fragment {

    private CardView info, permohonan, riwayat_pengajuan, pengumuman,pengaduan,riwayat_pengaduan,cctv,lainnya;
    APIRequestData mApiInterface;
    ImageView profilphoto;
    TextView nama, angka_notif;
    String Snama, Salamat, Sfoto;
    RelativeLayout tv_panduan, tv_mekanisme, tv_logout;
    LinearLayout notif;
    ImageButton cetak;
    SessionManager sessionManager;
    String Sid;
    private List<ModelPermohonan> listcetak = new ArrayList<>();

    private RecyclerView RecyclerPengumuman;
    private RecyclerView.Adapter mAdapterPengumuman;
    private RecyclerView.LayoutManager mLayoutPengumuman;
    private List<ModelPengumuman> listpengumuman = new ArrayList<>();

    AlertDialog.Builder dialog;
    LayoutInflater inflater;
    View dialogView;
    TextView teks;

    private long exitTime = 0;

    public BerandaFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View view = inflater.inflate(R.layout.fragment_beranda, container, false);

        //Deklarasi CardView
        info = view.findViewById(R.id.info);
        permohonan = view.findViewById(R.id.permohonan);
        riwayat_pengajuan = view.findViewById(R.id.riwayat_pengajuan);
        riwayat_pengaduan = view.findViewById(R.id.riwayat_pengaduan);
        pengumuman = view.findViewById(R.id.pengumuman);
        pengaduan = view.findViewById(R.id.pengaduan);
        cctv = view.findViewById(R.id.cctv);
        profilphoto = view.findViewById(R.id.profilphoto);
        nama = view.findViewById(R.id.nama);
        cetak = view.findViewById(R.id.btn_cetak);
        angka_notif = view.findViewById(R.id.angka_notif);
        tv_panduan = view.findViewById(R.id.tv_panduan);
        tv_mekanisme = view.findViewById(R.id.tv_mekanisme);
        tv_logout = view.findViewById(R.id.tv_logout);
        lainnya = view.findViewById(R.id.lainnya);
        notif = view.findViewById(R.id.notif);

        mApiInterface = RetroServer.getClient().create(APIRequestData.class);
        sessionManager = new SessionManager(getContext());

        Snama = sessionManager.getUserDetail().get(SessionManager.NAMA);
        Salamat = sessionManager.getUserDetail().get(SessionManager.ALAMAT);
        Sfoto = sessionManager.getUserDetail().get(SessionManager.FOTO);

        nama.setText(Snama);

        createNotificationChannel();

        String img = RetroServer.URL_IMG_PROFIL + Sfoto;

        if(Sfoto==null){

        }else {
            Glide.with(getContext())
                    .load(img)
                    .circleCrop()
                    .into(profilphoto);
        }

        RecyclerPengumuman = view.findViewById(R.id.recycle_pengumuman);
        mLayoutPengumuman = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL,false);
        RecyclerPengumuman.setLayoutManager(mLayoutPengumuman);

        info.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(view.getContext(), NewsActivity.class);
                view.getContext().startActivity(intent);
            }
        });

        cetak.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(view.getContext(), CetakSurat.class);
                view.getContext().startActivity(intent);
            }
        });
        permohonan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(view.getContext(), JenisSurat.class);
                view.getContext().startActivity(intent);
            }
        });

        pengaduan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(view.getContext(), ListPengaduan.class);
                view.getContext().startActivity(intent);
            }
        });

        pengumuman.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(view.getContext(), ListPengumuman.class);
                view.getContext().startActivity(intent);
            }
        });

        cctv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(view.getContext(), CctvActivity.class);
                view.getContext().startActivity(intent);
            }
        });

        lainnya.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LainnyaDialog lainnyaDialog = new LainnyaDialog();
                lainnyaDialog.show(getActivity().getSupportFragmentManager(), "example dialog");
            }
        });

        riwayat_pengajuan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(view.getContext(), ArsipSurat.class);
                view.getContext().startActivity(intent);
            }
        });

        riwayat_pengaduan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(view.getContext(), ArsipPengaduan.class);
                view.getContext().startActivity(intent);
            }
        });

        tv_panduan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(),"Panduan Belum Tersedia", Toast.LENGTH_SHORT).show();
            }
        });

        tv_mekanisme.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MekanismeDialog mekanismeDialog = new MekanismeDialog();
                mekanismeDialog.show(getActivity().getSupportFragmentManager(), "example dialog");
            }
        });

        tv_logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sessionManager.logoutSession();
                moveToLogout();
            }
        });

        sessionManager = new SessionManager(getContext());

        Sid = sessionManager.getUserDetail().get(SessionManager.ID);
        loadjenis(Sid);
        return view;
    }

    public void loadjenis(String id) {
        Call<ResponseListPermohonan> data = mApiInterface.getResponseNotif(id);
        data.enqueue(new Callback<ResponseListPermohonan>() {
            @Override
            public void onResponse(Call<ResponseListPermohonan> call, Response<ResponseListPermohonan> response) {

                if(response.body().getKode()==1){

//                    Intent intent = new Intent(getContext(), CetakSurat.class);
//                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
//                    PendingIntent pendingIntent = PendingIntent.getActivity(getContext(), 0, intent, 0);

                    NotificationCompat.Builder builder = new NotificationCompat.Builder(getContext(), "Notif1")
                            .setSmallIcon(R.drawable.logodesa)
                            .setContentTitle("Periksa Surat yang telah Dicetak")
                            .setContentText("Ketuk logo lonceng sebelah kiri atas")
                            .setPriority(NotificationCompat.PRIORITY_DEFAULT)
//                            .setContentIntent(pendingIntent)
                            .setAutoCancel(true);

                    NotificationManagerCompat notificationManagerCompat = NotificationManagerCompat.from(getContext());

                    notificationManagerCompat.notify(100, builder.build());

                }else{
//                    alert.setVisibility(View.GONE);
                }
            }

            @Override
            public void onFailure(Call<ResponseListPermohonan> call, Throwable t) {
//                Toast.makeText(getContext(),"Gagal Menghubungi Server", Toast.LENGTH_SHORT).show();

            }
        });

    }
    private void createNotificationChannel() {
        // Create the NotificationChannel, but only on API 26+ because
        // the NotificationChannel class is new and not in the support library
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            CharSequence name = "Periksa Surat yang telah Dicetak";
            String description = "Ketuk logo lonceng sebelah kiri atas";
            int importance = NotificationManager.IMPORTANCE_DEFAULT;
            NotificationChannel channel = new NotificationChannel("Notif1", name, importance);
            channel.setDescription(description);
            // Register the channel with the system; you can't change the importance
            // or other notification behaviors after this
            NotificationManager notificationManager = getContext().getSystemService(NotificationManager.class);
            notificationManager.createNotificationChannel(channel);
        }
    }
    public void loadangka(String ids) {
        Call<ResponseListPermohonan> data = mApiInterface.getResponseNotif(ids);
        data.enqueue(new Callback<ResponseListPermohonan>() {
            @Override
            public void onResponse(Call<ResponseListPermohonan> call, Response<ResponseListPermohonan>
                    response) {

                if(response.body().getKode()==1){

                listcetak = response.body().getData();
                angka_notif.setText(String.valueOf(listcetak.size()));
                }else{
                notif.setVisibility(View.GONE);
                }
            }

            @Override
            public void onFailure(Call<ResponseListPermohonan> call, Throwable t) {
                Log.e("Retrofit Get Error", t.toString());
            }
        });

    }

    @Override
    public void onResume() {
        super.onResume();
        loadangka(Sid);
        loadpengumuman();
    }

    private void moveToLogout() {
        Intent intent = new Intent(getContext(), Homepage.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NO_HISTORY);
        startActivity(intent);
        getActivity().finish();
    }
    public void loadpengumuman() {
        Call<ResponseModelPengumuman> data = mApiInterface.getResponseModelPengumuman();
        data.enqueue(new Callback<ResponseModelPengumuman>() {
            @Override
            public void onResponse(Call<ResponseModelPengumuman> call, Response<ResponseModelPengumuman>
                    response) {

                if(response.body().getKode()==1){

                    listpengumuman = response.body().getData();

                    mAdapterPengumuman = new AdapterPopPengumuman(getActivity(), listpengumuman);
                    RecyclerPengumuman.setAdapter(mAdapterPengumuman);
                    mAdapterPengumuman.notifyDataSetChanged();

                }else{
                    RecyclerPengumuman.setVisibility(View.GONE);
                }

            }

            @Override
            public void onFailure(Call<ResponseModelPengumuman> call, Throwable t) {
                Log.e("Retrofit Get Error", t.toString());
                Toast.makeText(getContext(),"Kesalahan Server", Toast.LENGTH_SHORT).show();
            }
        });
    }
}