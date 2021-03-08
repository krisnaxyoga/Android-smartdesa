package com.smartdesa.demo.AdapterProfil;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.smartdesa.demo.Model.kependudukan.ModelKawin;
import com.smartdesa.demo.R;

import java.util.List;

public class AdpKawin extends RecyclerView.Adapter<AdpKawin.KawinData>{

    private Context ctx;
    private List<ModelKawin> listkawin;

    public AdpKawin(Context ctx, List<ModelKawin> listkawin){
        this.ctx = ctx;
        this.listkawin = listkawin;

    }

    @NonNull
    @Override
    public KawinData onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View layout = LayoutInflater.from(parent.getContext()).inflate(R.layout.cd_sex,parent,false);
        KawinData holder = new KawinData(layout);

        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull KawinData holder, int position) {
        final ModelKawin mp = listkawin.get(position);

        holder.nama.setText(mp.getNama());

    }
    @Override
    public int getItemCount() {
        return listkawin.size();
    }

    public class KawinData extends RecyclerView.ViewHolder {

        TextView nama;

        public KawinData(@NonNull View itemView) {
            super(itemView);
            nama = itemView.findViewById(R.id.nama);

        }
    }
}
