package com.smartdesa.demo.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.smartdesa.demo.Model.pengaduan.ModelDisposisi;
import com.smartdesa.demo.R;
import com.smartdesa.demo.pengaduan.PengaduanActivity;

import java.util.List;

public class AdapterArsPengaduan extends RecyclerView.Adapter<AdapterArsPengaduan.ReplyData> {

    private Context ctx;
    private List<ModelDisposisi> listreply;

    public AdapterArsPengaduan(Context ctx, List<ModelDisposisi> listreply){
        this.ctx = ctx;
        this.listreply = listreply;
    }
    @NonNull
    @Override
    public AdapterArsPengaduan.ReplyData onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View layout = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_arsip_pengaduan,parent,false);
        AdapterArsPengaduan.ReplyData holder = new AdapterArsPengaduan.ReplyData(layout);

        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterArsPengaduan.ReplyData holder, int position) {
        final ModelDisposisi mn = listreply.get(position);

        holder.id.setText(mn.getId());
        holder.no_pengaduan.setText(mn.getNo_pengaduan());
        holder.title.setText(mn.getTitle());
        holder.created_at.setText(mn.getCreated_at());

        holder.cv_reply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ctx, PengaduanActivity.class );
                intent.putExtra("no_pengaduan", mn.getNo_pengaduan());
                intent.putExtra("user_type", mn.getUser_type());
                intent.putExtra("created_at", mn.getCreated_at());
                intent.putExtra("updated_at", mn.getUpdated_at());
                intent.putExtra("content", mn.getContent());
                intent.putExtra("photo", mn.getPhoto());
                intent.putExtra("pengaduan_category_id", mn.getPengaduan_category_id());
                intent.putExtra("start_date", mn.getStart_date());
                intent.putExtra("id", mn.getId());
                ctx.startActivity(intent);
            }
        });
    }
    @Override
    public int getItemCount() {
        return listreply.size();
    }

    public class ReplyData extends RecyclerView.ViewHolder {
        public CardView cv_reply;
        TextView id,no_pengaduan,title, created_at;

        public ReplyData(@NonNull View itemView) {
            super(itemView);
            id = itemView.findViewById(R.id.id);
            no_pengaduan = itemView.findViewById(R.id.no_pengaduan);
            title = itemView.findViewById(R.id.title);
            created_at = itemView.findViewById(R.id.created_at);
            cv_reply = itemView.findViewById(R.id.cv_reply);

        }
    }

}
