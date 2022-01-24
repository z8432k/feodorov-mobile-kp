package com.example.githubviewr;

import android.widget.ImageView;

import com.squareup.picasso.Picasso;

public class AvatarSetter {
    public void setImage(String url, ImageView imageView) {
        Picasso
                .get()
                .load(url)
                .into(imageView);
    }
}
