package com.yance.utils;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;

import androidx.databinding.BindingAdapter;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CircleCrop;

/**
 * ImageView加载网络图片的Adapter，内部使用Glide
 *
 * Created by chenyouyu on 2020/11/5 2:43 PM
 */
public class ImageViewAttrAdapter {
    @BindingAdapter("android:src")
    public static void setSrc(ImageView view, Bitmap bitmap) {
        view.setImageBitmap(bitmap);
    }

    @BindingAdapter("android:src")
    public static void setSrc(ImageView view, int resId) {
        view.setImageResource(resId);
    }

    /**
     * 这里loadImage()绑定了多个属性，"app:imageUrl"、“app:placeHolder”、"app:error"属性。
     * 分别表示要加载的图片路径，占位图片，和加载出错时加载的图片。
     *
     * @param imageView
     * @param url
     * @param holderDrawable
     * @param errorDrawable
     */
    @BindingAdapter({"app:imageUrl", "app:placeHolder", "app:error"})
    public static void loadImage(ImageView imageView, String url, Drawable holderDrawable, Drawable errorDrawable) {
        Glide.with(imageView.getContext())
                .load(url)
                .transform(new CircleCrop())
                .placeholder(holderDrawable)
                .error(errorDrawable)
                .into(imageView);
    }
}
