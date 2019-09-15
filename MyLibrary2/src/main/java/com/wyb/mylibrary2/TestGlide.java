package com.wyb.mylibrary2;

import android.app.Activity;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

public class TestGlide  {

    public void SetImageView( Activity activity,ImageView imageView)
    {
        String url = "http://cn.bing.com/az/hprichbg/rb/Dongdaemun_ZH-CN10736487148_1920x1080.jpg";
        Glide.with(activity).load(url).into(imageView);
        Toast toast = Toast.makeText(activity,"MyGradle2.TestGlide",Toast.LENGTH_SHORT);
        toast.show();
    }
}
