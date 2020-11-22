package com.assignment.almusbah.utils;

import android.util.TypedValue;
import android.widget.ImageView;

import androidx.databinding.BindingAdapter;

import com.assignment.almusbah.R;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestOptions;

import static com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions.withCrossFade;


public class BindingUtils {

    @BindingAdapter({"imageUrl"})
    public static void loadRoundedImage(ImageView view, String url) {
        Glide.with(view)
                .load(url)
                .apply(new RequestOptions()
                        .diskCacheStrategy(DiskCacheStrategy.AUTOMATIC)
                .placeholder(R.drawable.placeholder))
                .transition(withCrossFade())
                .into(view);
    }

    @BindingAdapter({"imageUrl", "radius"})
    public static void loadRoundedImage(ImageView view, String url, int radius) {
        float pixelRadius = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,
                radius, view.getResources().getDisplayMetrics());
        Glide.with(view)
                .load(url)
                .apply(new RequestOptions()
                        .transforms(new RoundedCorners((int) pixelRadius))
                        .diskCacheStrategy(DiskCacheStrategy.AUTOMATIC))
                .transition(withCrossFade())
                .into(view);
    }
}
