package com.petermunyao.alc_phase_1_challenge.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProviders;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.MenuItem;

import com.petermunyao.alc_phase_1_challenge.R;
import com.petermunyao.alc_phase_1_challenge.databinding.ActivityAboutBinding;
import com.petermunyao.alc_phase_1_challenge.viewmodels.AboutActivityViewModel;

import java.util.Objects;

public class AboutActivity extends AppCompatActivity {

    private AboutActivityViewModel mAboutActivityViewModel;
    //DataBinding.
    ActivityAboutBinding mAboutBinding;

    @SuppressLint("SetJavaScriptEnabled")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mAboutBinding = DataBindingUtil.setContentView(this, R.layout.activity_about);
        mAboutBinding.setLifecycleOwner(this);
        mAboutActivityViewModel = ViewModelProviders.of(this).get(AboutActivityViewModel.class);

        setSupportActionBar(mAboutBinding.toolbar);
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);

        mAboutBinding.webView.setWebViewClient(mAboutActivityViewModel.getWebViewClient(AboutActivity.this));
        mAboutBinding.webView.loadUrl(mAboutActivityViewModel.getUrl());
        mAboutActivityViewModel.getWebSettings(mAboutBinding.webView).setJavaScriptEnabled(true);
    }

    @Override
    public void onBackPressed() {
        if (mAboutBinding.webView.canGoBack()) {
            mAboutBinding.webView.goBack();
        } else {
            super.onBackPressed();
        }

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            onBackPressed();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
