package com.smartdesa.demo.pengaduan;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.smartdesa.demo.Adapter.PengaduanPage;
import com.smartdesa.demo.R;
import com.smartdesa.demo.Util.SessionManager;

public class PengaduanActivity extends AppCompatActivity {

    ViewPager viewPager;
    SessionManager sessionManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pengaduan);

        sessionManager = new SessionManager(PengaduanActivity.this);
        viewPager = findViewById(R.id.viewPager);

        PengaduanPage adapter = new PengaduanPage(getSupportFragmentManager());
        viewPager.setAdapter(adapter);
    }
}