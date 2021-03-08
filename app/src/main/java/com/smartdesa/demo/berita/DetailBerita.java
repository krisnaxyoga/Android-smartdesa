package com.smartdesa.demo.berita;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.RelativeLayout;

import com.smartdesa.demo.API.APIRequestData;
import com.smartdesa.demo.API.RetroServer;

import com.smartdesa.demo.R;

public class DetailBerita extends AppCompatActivity {

    //Deklarasi Variable
    APIRequestData mApiInterface;
    private WebView webView;
    private String Sslug="";
    private RelativeLayout ln_opening;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_berita);

        //Deklarasi
        webView = findViewById(R.id.webview);
        ln_opening = findViewById(R.id.ln_opening);

        mApiInterface = RetroServer.getClient().create(APIRequestData.class);

        Sslug = getIntent().getStringExtra("slug");

        webView.setWebViewClient(new myWebclient());
        webView.getSettings().setJavaScriptEnabled(true);
        webView.loadUrl(RetroServer.URL_BERITA+Sslug);

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
            webView.goBack();
            return true;
        }

        return super.onKeyDown(keyCode, event);
    }

}