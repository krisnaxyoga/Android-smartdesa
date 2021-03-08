package com.smartdesa.demo.riwayat;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.smartdesa.demo.Adapter.RiwayatPage;
import com.smartdesa.demo.R;
import com.smartdesa.demo.Util.SessionManager;

public class RiwayatActivity extends AppCompatActivity {

    ViewPager viewPager;
    SessionManager sessionManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_riwayat);

        sessionManager = new SessionManager(RiwayatActivity.this);
        viewPager = findViewById(R.id.viewPager);

        RiwayatPage adapter = new RiwayatPage(getSupportFragmentManager());
        viewPager.setAdapter(adapter);
    }
}