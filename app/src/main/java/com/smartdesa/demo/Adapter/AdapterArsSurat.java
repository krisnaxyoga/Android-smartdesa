package com.smartdesa.demo.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.smartdesa.demo.Model.permohonan.ModelPermohonan;
import com.smartdesa.demo.R;
import com.smartdesa.demo.surat.DetailNotifSurat;

import java.util.List;

public class AdapterArsSurat extends RecyclerView.Adapter<AdapterArsSurat.CetakData>{

    private Context ctx;
    private List<ModelPermohonan> listcetak;

    public AdapterArsSurat(Context ctx, List<ModelPermohonan> listcetak){
        this.ctx = ctx;
        this.listcetak = listcetak;
    }

    @NonNull
    @Override
    public CetakData onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View layout = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_arsip_surat,parent,false);
        CetakData holder = new CetakData(layout);

        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull CetakData holder, int position) {
        final ModelPermohonan mp = listcetak.get(position);

        holder.id.setText(mp.getId());
        holder.track.setText(mp.getTrack_number());
        holder.keperluan.setText(mp.getKeperluan());
        holder.no_surat.setText(mp.getNomor_surat());
        holder.jenis_acara.setText(mp.getJenis_acara());
        holder.tanggal_cetak.setText(mp.getTanggal_cetak());

        holder.cv_cetak.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ctx, DetailNotifSurat.class );
                intent.putExtra("id", mp.getId());
                intent.putExtra("track_number", mp.getTrack_number());
                intent.putExtra("keperluan", mp.getKeperluan());
                intent.putExtra("nomor_surat", mp.getNomor_surat());
                intent.putExtra("jenis_acara", mp.getJenis_acara());
                intent.putExtra("tanggal_cetak", mp.getTanggal_cetak());
                ctx.startActivity(intent);
            }
        });

    }
    @Override
    public int getItemCount() {
        return listcetak.size();
    }

    public class CetakData extends RecyclerView.ViewHolder {
        public CardView cv_cetak;
        TextView id,track,nama_pemohon,keperluan,no_surat,jenis_acara,tanggal_cetak;

        public CetakData(@NonNull View itemView) {
            super(itemView);
            id = itemView.findViewById(R.id.id);
            track = itemView.findViewById(R.id.track);
            nama_pemohon = itemView.findViewById(R.id.nama_pemohon);
            keperluan = itemView.findViewById(R.id.keperluan);
            no_surat = itemView.findViewById(R.id.no_surat);
            jenis_acara = itemView.findViewById(R.id.jenis_acara);
            tanggal_cetak = itemView.findViewById(R.id.tanggal_cetak);
            cv_cetak = itemView.findViewById(R.id.cv_cetak);
        }
    }



}
