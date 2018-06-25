package com.mmxb.utilmiao;

import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.DecodeFormat;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;
import com.mmxb.utilmiao.lifecycle.LifecycleObserverDemo;
import com.mmxb.utilmiao.utils.ImageUtil;
import com.mmxb.utilmiao.utils.ScreenDensityUtil;

import java.util.Iterator;
import java.util.TreeSet;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        ScreenDensityUtil.setActivityCustomDensity(this, 380);
        setContentView(R.layout.activity_main);
        imageView = findViewById(R.id.image_view);
        imageView.setImageBitmap(ImageUtil.decodeSampledBitmapFromResource(getResources(), R.drawable.circle, 100, 100));
    }
}
