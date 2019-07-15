package com.petermunyao.alc_phase_1_challenge.viewmodels;

import android.app.Application;
import android.content.Context;
import android.net.http.SslError;
import android.webkit.SslErrorHandler;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.lifecycle.AndroidViewModel;

public class AboutActivityViewModel extends AndroidViewModel {

    public AboutActivityViewModel(@NonNull Application application) {
        super(application);
    }

    public WebViewClient getWebViewClient(Context context) {
        return new WebViewClient() {
            @Override
            public void onReceivedSslError(WebView view, SslErrorHandler handler, SslError error) {
                androidx.appcompat.app.AlertDialog.Builder builder = new androidx.appcompat.app.AlertDialog.Builder(context);
                builder.setTitle("SSL CERTIFICATE ERROR")
                        .setMessage("The security certificate presented by this website is not trusted or valid" + "\n\nDo you want to continue anyway?")
                        .setPositiveButton("Yes", (dialog, which) -> handler.proceed())
                        .setNegativeButton("NO", (dialog, which) -> handler.cancel());
                AlertDialog alertDialog = builder.create();
                alertDialog.show();
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
