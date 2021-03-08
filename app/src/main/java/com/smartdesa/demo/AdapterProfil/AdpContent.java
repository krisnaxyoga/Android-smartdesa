package com.smartdesa.demo.AdapterProfil;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.smartdesa.demo.Model.pengaduan.ModelCon;
import com.smartdesa.demo.R;

import java.util.List;

public class AdpContent extends RecyclerView.Adapter<AdpContent.ConData> {

    private Context ctx;
    private List<ModelCon> listcon;

    public AdpContent(Context ctx, List<ModelCon> listcon){
        this.ctx = ctx;
        this.listcon = listcon;

    }

    @NonNull
    @Override
    public ConData onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View layout = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_con,parent,false);
        ConData holder = new ConData(layout);

        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ConData holder, int position) {
        final ModelCon mp = listcon.get(position);

        holder.name.setText(mp.getContent());

    }
    @Override
    public int getItemCount() {
        return listcon.size();
    }

    public class ConData extends RecyclerView.ViewHolder {

        TextView name;

        public ConData(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.name);

        }
    }


}
