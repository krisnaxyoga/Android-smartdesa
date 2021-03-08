package com.smartdesa.demo.homepage;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import com.smartdesa.demo.R;

public class UpdateActivity extends AppCompatActivity {

    ImageButton btn_update;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);

        btn_update = findViewById(R.id.btn_update);
        btn_update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Uri webpage = Uri.parse("https://play.google.com/store/apps/details?id=com.smartdesa.karyasari");
//                Intent intent = new Intent(Intent.ACTION_VIEW, webpage);
//                if (intent.resolveActivity(UpdateActivity.this.getPackageManager()) != null) {
//                    startActivity(intent);
//                }
                Toast.makeText(UpdateActivity.this,"Pembaharuan Aplikasi Belum Tersedia", Toast.LENGTH_SHORT).show();
            }
        });
    }
}