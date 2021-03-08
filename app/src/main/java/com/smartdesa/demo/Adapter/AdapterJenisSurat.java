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

import com.smartdesa.demo.surat.DetailSurat;
import com.smartdesa.demo.Model.surat.ModelJenisSurat;
import com.smartdesa.demo.R;

import java.util.List;

public class AdapterJenisSurat extends RecyclerView.Adapter<AdapterJenisSurat.SuratData> {

    private Context ctx;
    private List<ModelJenisSurat> listsurat;

    public AdapterJenisSurat(Context ctx, List<ModelJenisSurat> listsurat){
        this.ctx = ctx;
        this.listsurat = listsurat;
    }
    @NonNull
    @Override
    public SuratData onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View layout = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_surat,parent,false);
        SuratData holder = new SuratData(layout);

        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull SuratData holder, int position) {
        final ModelJenisSurat mn = listsurat.get(position);

        holder.id.setText(mn.getId());
        holder.kode_surat.setText(mn.getKode_surat());
        holder.judul.setText(mn.getJudul());

        holder.cv_surat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ctx, DetailSurat.class );
                intent.putExtra("id", mn.getId());
                intent.putExtra("kode_surat", mn.getKode_surat());
                intent.putExtra("judul", mn.getJudul());
                ctx.startActivity(intent);
            }
        });

    }
    @Override
    public int getItemCount() {
        return listsurat.size();
    }

    public class SuratData extends RecyclerView.ViewHolder {
        public CardView cv_surat;
        TextView id,kode_surat,judul;

        public SuratData(@NonNull View itemView) {
            super(itemView);
            id = itemView.findViewById(R.id.id);
            kode_surat = itemView.findViewById(R.id.kode_surat);
            judul = itemView.findViewById(R.id.judul);
            cv_surat = itemView.findViewById(R.id.cv_surat);
        }
    }
}
