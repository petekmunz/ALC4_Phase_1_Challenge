package com.petermunyao.alc_phase_1_challenge.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;
import android.view.MenuItem;

import com.petermunyao.alc_phase_1_challenge.R;
import com.petermunyao.alc_phase_1_challenge.databinding.ActivityProfileBinding;
import com.petermunyao.alc_phase_1_challenge.viewmodels.ProfileActivityViewModel;

import java.util.Objects;

public class ProfileActivity extends AppCompatActivity {

    private ProfileActivityViewModel mProfileActivityViewModel;
    //DataBinding.
    ActivityProfileBinding mProfileBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mProfileBinding = DataBindingUtil.setContentView(this, R.layout.activity_profile);
        mProfileBinding.setLifecycleOwner(this);
        mProfileActivityViewModel = ViewModelProviders.of(this).get(ProfileActivityViewModel.class);

        setSupportActionBar(mProfileBinding.toolbar);
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);

        mProfileActivityViewModel.loadImage(mProfileBinding.imgPortrait);
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
