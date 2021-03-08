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
import com.smartdesa.demo.riwayat.RiwayatActivity;

import java.util.List;

public class AdapterRiwayat extends RecyclerView.Adapter<AdapterRiwayat.RiwayatData> {

    private Context ctx;
    private List<ModelPermohonan> listriwayat;

    public AdapterRiwayat(Context ctx, List<ModelPermohonan> listriwayat){
        this.ctx = ctx;
        this.listriwayat = listriwayat;
    }

    @NonNull
    @Override
    public RiwayatData onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View layout = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_riwayat,parent,false);
        RiwayatData holder = new RiwayatData(layout);

        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull RiwayatData holder, int position) {
        final ModelPermohonan mp = listriwayat.get(position);

        holder.id.setText(mp.getId());
        holder.judul.setText(mp.getJenis_acara());
        holder.keperluan.setText(mp.getKeperluan());
        holder.diajukan.setText(mp.getTanggal_pengajuan());
        holder.track.setText(mp.getTrack_number());
        holder.surat_pengantar.setText(mp.getNo_surat_pengantar());


        holder.cv_riwayat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ctx, RiwayatActivity.class );
                intent.putExtra("id", mp.getId());
                intent.putExtra("jenis_acara", mp.getJenis_acara());
                intent.putExtra("keperluan", mp.getKeperluan());
                intent.putExtra("tanggal_pengajuan", mp.getTanggal_pengajuan());
                intent.putExtra("track_number", mp.getTrack_number());
                intent.putExtra("surat_pengantar", mp.getNo_surat_pengantar());
                ctx.startActivity(intent);
            }
        });

    }
    @Override
    public int getItemCount() {
        return listriwayat.size();
    }

    public class RiwayatData extends RecyclerView.ViewHolder {
        public CardView cv_riwayat;
        TextView id,judul,keperluan,diajukan,status,track,surat_pengantar;

        public RiwayatData(@NonNull View itemView) {
            super(itemView);
            id = itemView.findViewById(R.id.id);
            judul = itemView.findViewById(R.id.judul);
            keperluan = itemView.findViewById(R.id.keperluan);
            diajukan = itemView.findViewById(R.id.diajukan);
            status = itemView.findViewById(R.id.status);
            track = itemView.findViewById(R.id.track);
            surat_pengantar = itemView.findViewById(R.id.surat_pengantar);

            cv_riwayat = itemView.findViewById(R.id.cv_riwayat);
        }
    }

}
