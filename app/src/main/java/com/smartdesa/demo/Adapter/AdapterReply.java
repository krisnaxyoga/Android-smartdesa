package com.smartdesa.demo.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.smartdesa.demo.Model.pengaduan.ModelDisposisi;
import com.smartdesa.demo.R;
import com.smartdesa.demo.pengaduan.PengaduanActivity;

import java.util.List;

public class AdapterReply extends RecyclerView.Adapter<AdapterReply.ReplyData>{

    private Context ctx;
    private List<ModelDisposisi> listreply;

    public AdapterReply(Context ctx, List<ModelDisposisi> listreply){
        this.ctx = ctx;
        this.listreply = listreply;
    }
    @NonNull
    @Override
    public ReplyData onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View layout = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_reply,parent,false);
        ReplyData holder = new ReplyData(layout);

        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ReplyData holder, int position) {
        final ModelDisposisi mn = listreply.get(position);

        holder.no_pengaduan.setText(mn.getNo_pengaduan());
        holder.tv_title.setText(mn.getTitle());
        holder.tv_disposisi.setText(mn.getUser_type());
        holder.tv_content.setText(mn.getContent());

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

        holder.close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                holder.cv_reply.setVisibility(View.GONE);
            }
        });

    }
    @Override
    public int getItemCount() {
        return listreply.size();
    }

    public class ReplyData extends RecyclerView.ViewHolder {
        public CardView cv_reply;
        TextView no_pengaduan,tv_title, tv_disposisi, tv_content;
        public Button close;

        public ReplyData(@NonNull View itemView) {
            super(itemView);
            no_pengaduan = itemView.findViewById(R.id.no_pengaduan);
            tv_title = itemView.findViewById(R.id.tv_title);
            tv_disposisi = itemView.findViewById(R.id.tv_disposisi);
            tv_content = itemView.findViewById(R.id.tv_content);
            cv_reply = itemView.findViewById(R.id.cv_reply);
            close = itemView.findViewById(R.id.close);

        }
    }

}
