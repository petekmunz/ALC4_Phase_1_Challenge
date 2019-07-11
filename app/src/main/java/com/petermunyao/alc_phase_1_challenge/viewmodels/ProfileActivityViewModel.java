package com.petermunyao.alc_phase_1_challenge.viewmodels;

import android.app.Application;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.petermunyao.alc_phase_1_challenge.R;

public class ProfileActivityViewModel extends AndroidViewModel {
    public ProfileActivityViewModel(@NonNull Application application) {
        super(application);
    }

    public void loadImage(ImageView imageView) {
        Glide.with(getApplication())
                .load(R.drawable.stickman)
                .apply(RequestOptions.circleCropTransform())
                .into(imageView);
    }
}
