package com.smartdesa.demo.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.smartdesa.demo.Model.pengumuman.ModelPengumuman;
import com.smartdesa.demo.R;
import com.smartdesa.demo.pengumuman.DetailPengumuman;
import com.squareup.picasso.Picasso;

import java.util.List;

public class AdapterPopPengumuman extends RecyclerView.Adapter<AdapterPopPengumuman.PengumumanData>{

    private Context ctx;
    private List<ModelPengumuman> listpengumuman;

    public AdapterPopPengumuman(Context ctx, List<ModelPengumuman> listpengumuman){
        this.ctx = ctx;
        this.listpengumuman = listpengumuman;

    }

    @NonNull
    @Override
    public PengumumanData onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View layout = LayoutInflater.from(parent.getContext()).inflate(R.layout.popup_pengumuman,parent,false);
        PengumumanData holder = new PengumumanData(layout);

        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull PengumumanData holder, int position) {
        final ModelPengumuman mn = listpengumuman.get(position);

        holder.id.setText(String.valueOf(mn.getId()));
        holder.title.setText(mn.getTitle());

        holder.cardlayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ctx, DetailPengumuman.class );
                intent.putExtra("id", mn.getId());
                intent.putExtra("desa_id", mn.getDesa_id());
                intent.putExtra("title", mn.getTitle());
                intent.putExtra("description", mn.getDescription());
                intent.putExtra("photo", mn.getPhoto());
                intent.putExtra("created_at", mn.getCreated_at());
                intent.putExtra("updated_at", mn.getUpdated_at());
                intent.putExtra("type", mn.getType());
                ctx.startActivity(intent);
            }
        });

        Picasso.with(ctx).
                load(listpengumuman.get(position).getPhoto()).
                placeholder(R.drawable.progress_animation).
                error(R.drawable.icon).
                fit().
                into(holder.photo);

        holder.close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                holder.cardlayout.setVisibility(View.GONE);
            }
        });
    }

    @Override
    public int getItemCount() {
        return listpengumuman.size();
    }

    public class PengumumanData extends RecyclerView.ViewHolder {
        TextView id,title;
        ImageView photo;
        public Button close;
        public CardView cardlayout;

        public PengumumanData(@NonNull View itemView){
            super(itemView);

            id = itemView.findViewById(R.id.id);
            title = itemView.findViewById(R.id.title);
            photo = itemView.findViewById(R.id.photo);
            cardlayout = itemView.findViewById(R.id.cardlayout);
            close = itemView.findViewById(R.id.close);

        }
    }

}
