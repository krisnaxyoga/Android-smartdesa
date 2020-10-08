package com.example.desagls;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

    public class AdapterData extends RecyclerView.Adapter<AdapterData.HolderData> {
        private List<ModelNews> mItems;
        private Context context;

        public AdapterData(Context context, List<ModelNews> items) {
            this.mItems = items;
            this.context = context;
        }

        @NonNull
        @Override
        public HolderData onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View layout = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_news, parent, false);
            HolderData holderData = new HolderData(layout);
            return holderData;
        }


        public void onBindViewHolder(@NonNull HolderData holder, int position) {
            ModelNews md = mItems.get(position);

            holder.tv_judul.setText(md.getJudul());
            holder.tv_tanggal.setText(md.getTanggal());
            holder.tv_kategori.setText(md.getKategori());
            holder.tv_teks.setText(md.getTeks());

        }

        @Override
        public int getItemCount() {
            return mItems.size();
        }

        class HolderData extends RecyclerView.ViewHolder {

            TextView tv_judul, tv_tanggal, tv_kategori, tv_teks;


            public HolderData(final View view) {
                super(view);
                tv_judul = view.findViewById(R.id.judul);
                tv_tanggal = view.findViewById(R.id.tanggal);
                tv_kategori = view.findViewById(R.id.kategori);
                tv_teks = view.findViewById(R.id.teks);

            }

        }
    }
