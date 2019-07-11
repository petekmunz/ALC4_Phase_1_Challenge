package com.petermunyao.alc_phase_1_challenge.viewmodels;

import android.app.Application;
import android.net.http.SslError;
import android.webkit.SslErrorHandler;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;

public class AboutActivityViewModel extends AndroidViewModel {

    public AboutActivityViewModel(@NonNull Application application) {
        super(application);
    }

    public WebViewClient getWebClient() {
        return new WebViewClient() {
            @Override
            public void onReceivedSslError(WebView view, SslErrorHandler handler, SslError error) {
                handler.proceed();
            }
        };

    }

    public String getUrl() {
        return "https://andela.com/alc/";
    }

    public WebSettings getWebSettings(WebView webView) {
        return webView.getSettings();
    }
}
