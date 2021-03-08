package com.smartdesa.demo.AdapterProfil;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.smartdesa.demo.Model.kependudukan.ModelAgama;
import com.smartdesa.demo.R;

import java.util.List;

public class AdpAgama extends RecyclerView.Adapter<AdpAgama.AgamaData> {

    private Context ctx;
    private List<ModelAgama> listagama;

    public AdpAgama(Context ctx, List<ModelAgama> listagama){
        this.ctx = ctx;
        this.listagama = listagama;

    }

    @NonNull
    @Override
    public AgamaData onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View layout = LayoutInflater.from(parent.getContext()).inflate(R.layout.cd_sex,parent,false);
        AgamaData holder = new AgamaData(layout);

        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull AgamaData holder, int position) {
        final ModelAgama mp = listagama.get(position);

        holder.nama.setText(mp.getNama());

    }
    @Override
    public int getItemCount() {
        return listagama.size();
    }

    public class AgamaData extends RecyclerView.ViewHolder {

        TextView nama;

        public AgamaData(@NonNull View itemView) {
            super(itemView);
            nama = itemView.findViewById(R.id.nama);

        }
    }
}
