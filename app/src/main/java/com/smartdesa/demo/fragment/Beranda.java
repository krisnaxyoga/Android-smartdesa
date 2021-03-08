package com.smartdesa.demo.fragment;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.smartdesa.demo.R;
import com.smartdesa.demo.homepage.SplashActivity;
import com.smartdesa.demo.Util.SessionManager;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class Beranda extends AppCompatActivity {

    SessionManager sessionManager;
    AlertDialog.Builder dialog;
    LayoutInflater inflater;
    View dialogView;
    TextView teks;

    private long exitTime = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_beranda);

        sessionManager = new SessionManager(Beranda.this);
        if(!sessionManager.isLoggedIn()){
            moveToLogin();
        }

       BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNavigationView);
       bottomNavigationView.setOnNavigationItemSelectedListener(navListener);

       getSupportFragmentManager().beginTransaction().replace(R.id.fragment,new BerandaFragment()).commit();

    }

    private void moveToLogin() {
        Intent intent = new Intent(Beranda.this, SplashActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NO_HISTORY);
        startActivity(intent);
        finish();
    }

    @Override
    public void onBackPressed() {
//        super.onBackPressed();
        DialogForm();
    }

    private BottomNavigationView.OnNavigationItemSelectedListener navListener =
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                    Fragment selectedFragment = null;

                    switch (item.getItemId()){
                        case R.id.berandaFragment:
                            selectedFragment = new BerandaFragment();
                            break;
                        case R.id.riwayatFragment:
                            selectedFragment = new RiwayatFragment();
                            break;
                        case R.id.kontakFragment:
                            selectedFragment = new KontakFragment();
                            break;
                        case R.id.profilFragment:
                            selectedFragment = new ProfilFragment();
                            break;

                    }
                    getSupportFragmentManager().beginTransaction().replace(R.id.fragment,selectedFragment).commit();
                    return true;
                }
            };
    // untuk menampilkan dialog
    private void DialogForm() {

        dialog = new AlertDialog.Builder(Beranda.this);
        inflater = getLayoutInflater();
        dialogView = inflater.inflate(R.layout.dialog_konfirm, null);
        dialog.setView(dialogView);
        dialog.setCancelable(true);
//        dialog.setIcon(R.drawable.logodesa);
//        dialog.setTitle("Toko Masyarakat");

        teks = (TextView) dialogView.findViewById(R.id.teks);
        teks.setText("Apakah anda ingin keluar dari Aplikasi?");

        dialog.setPositiveButton("Keluar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
//                Intent intent = new Intent(TempatActivity.this, Beranda.class);
//                startActivity(intent);
//                getActivity().onBackPressed();
                  finish();
            }
        });

        dialog.setNegativeButton("Tidak", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        dialog.show();
    }
}