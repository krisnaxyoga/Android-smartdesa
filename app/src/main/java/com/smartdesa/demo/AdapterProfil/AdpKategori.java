package com.smartdesa.demo.AdapterProfil;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.smartdesa.demo.Model.pengaduan.ModelKat;
import com.smartdesa.demo.R;

import java.util.List;

public class AdpKategori extends RecyclerView.Adapter<AdpKategori.KatData> {

    private Context ctx;
    private List<ModelKat> listkategori;

    public AdpKategori(Context ctx, List<ModelKat> listkategori){
        this.ctx = ctx;
        this.listkategori = listkategori;

    }

    @NonNull
    @Override
    public KatData onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View layout = LayoutInflater.from(parent.getContext()).inflate(R.layout.cd_kat,parent,false);
        KatData holder = new KatData(layout);

        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull KatData holder, int position) {
        final ModelKat mp = listkategori.get(position);

        holder.name.setText(mp.getName());

    }
    @Override
    public int getItemCount() {
        return listkategori.size();
    }

    public class KatData extends RecyclerView.ViewHolder {

        TextView name;

        public KatData(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.name);

        }
    }

}
