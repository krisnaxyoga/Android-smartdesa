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

import com.smartdesa.demo.Model.pengaduan.ModelPengaduan;
import com.smartdesa.demo.R;
import com.smartdesa.demo.pengaduan.DetailPengaduan;

import java.util.List;

public class AdapterListPengaduan extends RecyclerView.Adapter<AdapterListPengaduan.PengaduanData> {

    private Context ctx;
    private List<ModelPengaduan> listpengaduan;

    public AdapterListPengaduan(Context ctx, List<ModelPengaduan> listpengaduan){
        this.ctx = ctx;
        this.listpengaduan = listpengaduan;
    }
    @NonNull
    @Override
    public PengaduanData onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View layout = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_pengaduan,parent,false);
        PengaduanData holder = new PengaduanData(layout);

        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull PengaduanData holder, int position) {
        final ModelPengaduan mn = listpengaduan.get(position);

        holder.id_pengaduan.setText(mn.getId());
        holder.name.setText(mn.getName());

        holder.cv_pengaduan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ctx, DetailPengaduan.class );
                intent.putExtra("id_pengaduan", mn.getId());
                intent.putExtra("name", mn.getName());
                ctx.startActivity(intent);
            }
        });

    }
    @Override
    public int getItemCount() {
        return listpengaduan.size();
    }

    public class PengaduanData extends RecyclerView.ViewHolder {
        public CardView cv_pengaduan;
        TextView id_pengaduan,name;

        public PengaduanData(@NonNull View itemView) {
            super(itemView);
            id_pengaduan = itemView.findViewById(R.id.id_pengaduan);
            name = itemView.findViewById(R.id.name);
            cv_pengaduan = itemView.findViewById(R.id.cv_pengaduan);
        }
    }
}
