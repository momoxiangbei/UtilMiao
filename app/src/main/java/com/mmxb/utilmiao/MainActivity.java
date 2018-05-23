package com.mmxb.utilmiao;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;
import com.mmxb.utilmiao.lifecycle.LifecycleObserverDemo;

import java.util.Iterator;
import java.util.TreeSet;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {
    @BindView(R.id.weather_tv)
    TextView weatherTv;
    @BindView(R.id.image_view)
    ImageView imageView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        getLifecycle().addObserver(new LifecycleObserverDemo());

        TreeSet<String> hashSet = new TreeSet<>();

        Iterator<String> iterator = hashSet.iterator();
        while (iterator.hasNext()) {
            iterator.next();
        }

        for (String a : hashSet) {

        }
    }


    @OnClick(R.id.weather_tv)
    public void onViewClicked() {
        String url = "http://cn.bing.com/az/hprichbg/rb/Dongdaemun_ZH-CN10736487148_1920x1080.jpg";

        RequestOptions options = new RequestOptions()
                .placeholder(R.drawable.header)
                .fitCenter()
                .diskCacheStrategy(DiskCacheStrategy.NONE);

        Glide.with(this).load(url).apply(options).into(imageView);

    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
