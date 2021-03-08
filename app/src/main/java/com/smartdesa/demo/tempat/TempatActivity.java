package com.smartdesa.demo.tempat;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import android.app.AlertDialog;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.smartdesa.demo.R;
import com.smartdesa.demo.fragment.Beranda;

public class TempatActivity extends AppCompatActivity {

    private WebView webView;
    private RelativeLayout ln_opening;
    TextView teks;
    private String Sslug="";
    AlertDialog.Builder dialog;
    LayoutInflater inflater;
    View dialogView;
//    ImageView back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tempat);

        //Deklarasi
        ln_opening = findViewById(R.id.ln_opening);
        webView = findViewById(R.id.webview);

        webView.setWebViewClient(new myWebclient());
        webView.getSettings().setJavaScriptEnabled(true);
        webView.loadUrl("https://1tempat.id/");

    }

    public class myWebclient extends WebViewClient {
        @Override
        public void onPageFinished(WebView view, String url) {
            super.onPageFinished(view, url);
            ln_opening.setVisibility(View.GONE);
        }

        @Override
        public void onPageStarted(WebView view, String url, Bitmap favicon) {
            super.onPageStarted(view, url, favicon);
        }

        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
//            view.loadUrl(url);
//            return super.shouldOverrideUrlLoading(view, url);
            if(url.startsWith("tel:") || url.startsWith("whatsapp:")) {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(url));
                startActivity(intent);
                return true;
            }
            return false;
        }
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if((keyCode==KeyEvent.KEYCODE_BACK) && webView.canGoBack()){
//            webView.goBack();
            DialogForm();
            return true;
        }

        return super.onKeyDown(keyCode, event);
    }
    // untuk menampilkan dialog
    private void DialogForm() {
        dialog = new AlertDialog.Builder(TempatActivity.this);
        inflater = getLayoutInflater();
        dialogView = inflater.inflate(R.layout.dialog_apps, null);
        dialog.setView(dialogView);
        dialog.setCancelable(true);
        dialog.setTitle("Apakah Anda Ingin Keluar dari Toko Masyarakat?");

        dialog.setPositiveButton("Keluar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                finish();
            }
        });

        dialog.setNegativeButton("Kembali", new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
                webView.goBack();
            }
        });
        dialog.show();
    }
}