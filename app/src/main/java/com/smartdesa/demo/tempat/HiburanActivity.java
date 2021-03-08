package com.smartdesa.demo.tempat;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.smartdesa.demo.R;

public class HiburanActivity extends AppCompatActivity {

        private WebView webView;
        private RelativeLayout ln_opening;
        TextView teks;
        private String Sslug="";
        AlertDialog.Builder dialog;
        LayoutInflater inflater;
        View dialogView;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_hiburan);

            //Deklarasi
            ln_opening = findViewById(R.id.ln_opening);
            webView = findViewById(R.id.webview);

            webView.setWebViewClient(new myWebclient());
            webView.getSettings().setJavaScriptEnabled(true);
            webView.loadUrl("https://www.youtube.com/channel/UCplA4OsXVeeydgSdOU6bprg/featured");

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
            view.loadUrl(url);
            return super.shouldOverrideUrlLoading(view, url);
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
        dialog = new AlertDialog.Builder(HiburanActivity.this);
        inflater = getLayoutInflater();
        dialogView = inflater.inflate(R.layout.dialog_apps, null);
        dialog.setView(dialogView);
        dialog.setCancelable(true);
        dialog.setTitle("Apakah Anda Ingin Keluar dari Video Desa?");


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