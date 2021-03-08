package com.smartdesa.demo.Adapter;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.smartdesa.demo.Model.kadus.ModelKadus;

import com.smartdesa.demo.R;

import com.smartdesa.demo.Util.SessionManager;

import java.util.List;

public class AdapterKadus extends RecyclerView.Adapter<AdapterKadus.KadusData> {

    private Context ctx;
    private List<ModelKadus> listkadus;
    SessionManager sessionManager;

    public AdapterKadus(Context ctx, List<ModelKadus> listkadus){
        this.ctx = ctx;
        this.listkadus = listkadus;
    }

    @NonNull
    @Override
    public KadusData onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View layout = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_kadus,parent,false);
        KadusData holder = new KadusData(layout);

        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull KadusData holder, int position) {
        final ModelKadus mp = listkadus.get(position);

        holder.tv_kadus.setText(mp.getName());
        holder.nomor.setText(mp.getPhone());

    }
    @Override
    public int getItemCount() {
        return listkadus.size();
    }

    public class KadusData extends RecyclerView.ViewHolder {
        TextView tv_kadus,tv_alamat, nomor;
        Button btn_telp, btn_wa;
        String Salamat;

        public KadusData(@NonNull View itemView) {
            super(itemView);
            sessionManager = new SessionManager(itemView.getContext());

            tv_kadus = itemView.findViewById(R.id.tv_kadus);
            tv_alamat = itemView.findViewById(R.id.tv_alamat);
            btn_telp = itemView.findViewById(R.id.btn_telp);
            btn_wa = itemView.findViewById(R.id.btn_wa);
            nomor = itemView.findViewById(R.id.nomor);

            Salamat = sessionManager.getUserDetail().get(SessionManager.ALAMAT);
            tv_alamat.setText(Salamat);

            btn_telp.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String phoneNo = nomor.getText().toString();
                if(!TextUtils.isEmpty(phoneNo)) {
                    String dial = "tel:" + phoneNo;
                    ctx.startActivity(new Intent(Intent.ACTION_DIAL, Uri.parse(dial)));
                }else {
                    Toast.makeText(ctx, "Invalid Phone Number", Toast.LENGTH_SHORT).show();
                }
                }
            });

            btn_wa.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String phoneNo = nomor.getText().toString();
                    Uri webpage = Uri.parse("http://api.whatsapp.com/send?phone=62"+phoneNo);
                Intent intent = new Intent(Intent.ACTION_VIEW, webpage);
                if (intent.resolveActivity(ctx.getPackageManager()) != null) {
                    ctx.startActivity(intent);
                }
                }
            });
        }
    }

}
