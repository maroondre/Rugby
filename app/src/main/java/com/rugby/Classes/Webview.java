package com.rugby.Classes;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.example.rugby.R;

public class Webview extends AppCompatActivity {

    WebView webView;
    String weburl;
    private ProgressDialog pdLoading;

    @SuppressLint("RestrictedApi")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_webview);
        getSupportActionBar().setTitle("Team Website");
        getSupportActionBar().setDefaultDisplayHomeAsUpEnabled(true);
        pdLoading = new ProgressDialog(Webview.this);
        pdLoading.setMessage("\tPlease Wait...");
        pdLoading.setCancelable(true);
        pdLoading.show();
        web();

    }


    public void web()
    {
        webView = findViewById(R.id.teamWeb);
        weburl = getIntent().getStringExtra("link");
        webView.loadUrl(weburl);

        webView.setWebViewClient(new WebViewClient(){
            @Override
            public void onPageFinished(WebView view, String url)
            {

            }
        });
        pdLoading.dismiss();


    }
}