package com.smartdesa.demo.AdapterProfil;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.smartdesa.demo.Model.kependudukan.ModelPendSex;
import com.smartdesa.demo.R;

import java.util.List;

public class AdpSex extends RecyclerView.Adapter<AdpSex.SexData>{

    private Context ctx;
    private List<ModelPendSex> listsex;

    public AdpSex(Context ctx, List<ModelPendSex> listsex){
        this.ctx = ctx;
        this.listsex = listsex;

}

    @NonNull
    @Override
    public SexData onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View layout = LayoutInflater.from(parent.getContext()).inflate(R.layout.cd_sex,parent,false);
        SexData holder = new SexData(layout);

        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull SexData holder, int position) {
        final ModelPendSex mp = listsex.get(position);

        holder.nama.setText(mp.getNama());

    }
    @Override
    public int getItemCount() {
        return listsex.size();
    }

    public class SexData extends RecyclerView.ViewHolder {

        TextView nama;

        public SexData(@NonNull View itemView) {
            super(itemView);
            nama = itemView.findViewById(R.id.nama);

        }
    }

}
