package com.smartdesa.demo.AdapterProfil;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.smartdesa.demo.R;
import com.smartdesa.demo.Model.kependudukan.ModelKerja;

import java.util.List;

public class AdpKerja extends RecyclerView.Adapter<AdpKerja.KerjaData>{

    private Context ctx;
    private List<ModelKerja> listkerja;

    public AdpKerja(Context ctx, List<ModelKerja> listkerja){
        this.ctx = ctx;
        this.listkerja = listkerja;

    }

    @NonNull
    @Override
    public KerjaData onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View layout = LayoutInflater.from(parent.getContext()).inflate(R.layout.cd_sex,parent,false);
        KerjaData holder = new KerjaData(layout);

        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull KerjaData holder, int position) {
        final ModelKerja mp = listkerja.get(position);

        holder.nama.setText(mp.getNama());

    }
    @Override
    public int getItemCount() {
        return listkerja.size();
    }

    public class KerjaData extends RecyclerView.ViewHolder {

        TextView nama;

        public KerjaData(@NonNull View itemView) {
            super(itemView);
            nama = itemView.findViewById(R.id.nama);

        }
    }
}
