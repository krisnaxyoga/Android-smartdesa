package com.smartdesa.demo.AdapterProfil;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import com.smartdesa.demo.Model.kependudukan.ModelWilayah;
import com.smartdesa.demo.R;

public class AdpWilayah extends RecyclerView.Adapter<AdpWilayah.WilayahData> {

    private Context ctx;
    private List<ModelWilayah> listwilayah;

    public AdpWilayah(Context ctx, List<ModelWilayah> listwilayah){
        this.ctx = ctx;
        this.listwilayah = listwilayah;

    }

    @NonNull
    @Override
    public WilayahData onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View layout = LayoutInflater.from(parent.getContext()).inflate(R.layout.cd_dusun,parent,false);
        WilayahData holder = new WilayahData(layout);

        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull AdpWilayah.WilayahData holder, int position) {
        final ModelWilayah mp = listwilayah.get(position);

        holder.dusun.setText(mp.getDusun());

    }
    @Override
    public int getItemCount() {
        return listwilayah.size();
    }

    public class WilayahData extends RecyclerView.ViewHolder {

        TextView dusun;

        public WilayahData(@NonNull View itemView) {
            super(itemView);
            dusun = itemView.findViewById(R.id.dusun);

        }
    }
}
