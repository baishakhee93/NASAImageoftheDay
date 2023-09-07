package com.baishakhee.nasaimageoftheday;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.baishakhee.nasaimageoftheday.databinding.ActivityWebViewVedioBinding;

public class WebViewVedioActivity extends AppCompatActivity {
ActivityWebViewVedioBinding binding;
WebSettings webSettings;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding= DataBindingUtil.setContentView(this,R.layout.activity_web_view_vedio);


        String url=getIntent().getStringExtra("vedioUrl");

        webSettings = binding.webView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webSettings.setCacheMode(WebSettings.LOAD_CACHE_ELSE_NETWORK);



        binding.webView.setWebViewClient(new WebViewClient());

        // Enable autoplay by injecting JavaScript code
        binding.webView.setWebChromeClient(new WebChromeClient() {
            @Override
            public void onProgressChanged(WebView view, int newProgress) {
                super.onProgressChanged(view, newProgress);
                if (newProgress == 100) {
                    // Page loading is complete, now trigger video autoplay
                    view.loadUrl("javascript:(function() { document.getElementsByTagName('video')[0].play(); })()");
                }
            }
        });

        binding.webView.loadUrl(url);
    }
}