package com.smartdesa.demo.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.smartdesa.demo.berita.DetailBerita;
import com.smartdesa.demo.Model.berita.ModelBerita;
import com.smartdesa.demo.R;
import com.squareup.picasso.Picasso;

import java.util.List;

    public class AdapterData extends RecyclerView.Adapter<AdapterData.HolderData> {

        private Context ctx;
        private List<ModelBerita> listberita;

        public AdapterData(Context ctx, List<ModelBerita> listberita) {
            this.ctx = ctx;
            this.listberita = listberita;
        }

        @NonNull
        @Override
        public HolderData onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View layout = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_news, parent, false);
            HolderData holderData = new HolderData(layout);
            return holderData;
        }


        public void onBindViewHolder(@NonNull HolderData holder, int position) {
            final ModelBerita mn = listberita.get(position);

            holder.id_berita.setText(String.valueOf(mn.getId()));
            holder.judul.setText(mn.getJudul());
            holder.created_at.setText(mn.getCreated_at());
            holder.updated_at.setText(mn.getUpdated_at());
            holder.slug.setText(mn.getSlug());
            holder.link.setText(mn.getGambar());
            holder.konten.setText(mn.getKonten());
            holder.type.setText(mn.getType());

            holder.cardlayout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(ctx, DetailBerita.class );
                    intent.putExtra("id", mn.getId());
                    intent.putExtra("judul", mn.getJudul());
                    intent.putExtra("created_at", mn.getCreated_at());
                    intent.putExtra("updated_at", mn.getUpdated_at());
                    intent.putExtra("slug", mn.getSlug());
                    intent.putExtra("konten", mn.getKonten());
                    intent.putExtra("gambar", mn.getGambar());
                    intent.putExtra("type", mn.getType());
                    ctx.startActivity(intent);
                }
            });

            Picasso.with(ctx).
                    load(listberita.get(position).getGambar()).
                    placeholder(R.drawable.progress_animation).
                    error(R.drawable.icon).
                    fit().
                    into(holder.gambar);

        }

        @Override
        public int getItemCount() {
            return listberita.size();
        }

        public class HolderData extends RecyclerView.ViewHolder {
            TextView id_berita, judul, konten, slug,link,created_at,updated_at, type;
            ImageView gambar;
            public CardView cardlayout;

            public HolderData(@NonNull View itemView){
                super(itemView);

                id_berita = itemView.findViewById(R.id.id_berita);
                judul = itemView.findViewById(R.id.judul);
                slug = itemView.findViewById(R.id.slug);
                link = itemView.findViewById(R.id.link);
                created_at = itemView.findViewById(R.id.created_at);
                updated_at = itemView.findViewById(R.id.updated_at);
                gambar = itemView.findViewById(R.id.gambar);
                konten = itemView.findViewById(R.id.konten);
                type = itemView.findViewById(R.id.type);
                cardlayout = itemView.findViewById(R.id.cardlayout);

            }

        }
    }
