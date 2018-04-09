package com.mmxb.utilmiao;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;


import com.mmxb.netmodulelib.TestMomo;

import rx.subscriptions.CompositeSubscription;

public class MainActivity extends AppCompatActivity {
    private TextView textView;
    private CompositeSubscription mCompositeSubscription;

    TestMomo testMomo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.weather_tv);

    }
}
