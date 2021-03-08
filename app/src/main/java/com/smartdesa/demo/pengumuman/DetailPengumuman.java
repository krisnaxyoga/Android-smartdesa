package com.smartdesa.demo.pengumuman;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.smartdesa.demo.R;
import com.squareup.picasso.Picasso;

public class DetailPengumuman extends AppCompatActivity {

    //Deklarasi Variable
    TextView tv_title,tv_titles, tv_description, tv_type, tv_created_at, tv_updated_at, tv_url_photo;
    ImageView photo;
    String Sid, Sdesa_id, Stitle, Sdescription, Stype, Screated_at, Supdated_at, Surl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_pengumuman);

        tv_title = findViewById(R.id.tv_title);
        tv_titles = findViewById(R.id.tv_titles);
        tv_description = findViewById(R.id.tv_description);
        tv_type = findViewById(R.id.tv_type);
        tv_created_at = findViewById(R.id.tv_created_at);
        tv_updated_at = findViewById(R.id.tv_updated_at);
        tv_url_photo = findViewById(R.id.tv_url_foto);
        photo = findViewById(R.id.photo);

        photo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Uri webpage = Uri.parse(Surl);
                Intent intent = new Intent(Intent.ACTION_VIEW, webpage);
                if (intent.resolveActivity(DetailPengumuman.this.getPackageManager()) != null) {
                    startActivity(intent);
                }
            }
        });

        Sid = getIntent().getStringExtra("id");
        Sdesa_id = getIntent().getStringExtra("desa_id");
        Stitle = getIntent().getStringExtra("title");
        Sdescription = getIntent().getStringExtra("description");
        Stype = getIntent().getStringExtra("type");
        Screated_at = getIntent().getStringExtra("created_at");
        Supdated_at = getIntent().getStringExtra("updated_at");
        Surl = getIntent().getStringExtra("photo");

        tv_title.setText(Stitle);
        tv_titles.setText(Stitle);
        tv_description.setText(Sdescription);
        tv_type.setText(Stype);
        tv_created_at.setText(Screated_at);
        tv_updated_at.setText(Supdated_at);
        tv_url_photo.setText(Surl);

        Picasso.with(DetailPengumuman.this).
                load(Surl).
                placeholder(R.drawable.progress_animation).
                error(R.drawable.icon).
                fit().
                into(photo);
    }
}