package com.petermunyao.alc_phase_1_challenge.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.os.Bundle;

import com.petermunyao.alc_phase_1_challenge.R;
import com.petermunyao.alc_phase_1_challenge.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    //Data Binding.
    ActivityMainBinding mMainBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        setSupportActionBar(mMainBinding.toolbar);

        mMainBinding.btnAbout.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, AboutActivity.class);
            startActivity(intent);
        });

        mMainBinding.btnProfile.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, ProfileActivity.class);
            startActivity(intent);
        });
    }
}
