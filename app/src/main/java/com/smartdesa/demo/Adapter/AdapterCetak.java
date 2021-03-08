package com.smartdesa.demo.Adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import com.smartdesa.demo.Model.permohonan.ModelPermohonan;
import com.smartdesa.demo.surat.NotifSuratSelesai;
import com.smartdesa.demo.R;

public class AdapterCetak extends RecyclerView.Adapter<AdapterCetak.CetakData> {

    private Context ctx;
    private List<ModelPermohonan> listcetak;

    public AdapterCetak(Context ctx, List<ModelPermohonan> listcetak){
        this.ctx = ctx;
        this.listcetak = listcetak;
    }

    @NonNull
    @Override
    public CetakData onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View layout = LayoutInflater.from(parent.getContext()).inflate(R.layout.cd_cetak,parent,false);
        CetakData holder = new CetakData(layout);

        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull CetakData holder, int position) {
        final ModelPermohonan mp = listcetak.get(position);

        holder.id.setText(mp.getId());
        holder.judul.setText(mp.getJenis_acara());
        holder.keperluan.setText(mp.getKeperluan());
        holder.tanggal_cetak.setText(mp.getTanggal_cetak());

        holder.cv_cetak.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ctx, NotifSuratSelesai.class );
                intent.putExtra("id", mp.getId());
                intent.putExtra("track_number", mp.getTrack_number());
                intent.putExtra("keperluan", mp.getKeperluan());
                intent.putExtra("nomor_surat", mp.getNomor_surat());
                intent.putExtra("jenis_acara", mp.getJenis_acara());
                intent.putExtra("tanggal_cetak", mp.getTanggal_cetak());
                ctx.startActivity(intent);
                ((Activity) ctx).finish();
            }
        });

        holder.close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                holder.cv_cetak.setVisibility(View.GONE);
            }
        });

    }
    @Override
    public int getItemCount() {
        return listcetak.size();
    }

    public class CetakData extends RecyclerView.ViewHolder {
        public Button close;
        public CardView cv_cetak;
        TextView id,judul,keperluan,tanggal_cetak;

        public CetakData(@NonNull View itemView) {
            super(itemView);
            id = itemView.findViewById(R.id.id);
            judul = itemView.findViewById(R.id.judul);
            keperluan = itemView.findViewById(R.id.keperluan);
            tanggal_cetak = itemView.findViewById(R.id.tanggal_cetak);
            cv_cetak = itemView.findViewById(R.id.cv_cetak);
            close = itemView.findViewById(R.id.close);
        }
    }
}
