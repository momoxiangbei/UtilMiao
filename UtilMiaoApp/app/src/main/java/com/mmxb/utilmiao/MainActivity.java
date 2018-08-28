package com.mmxb.utilmiao;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.ViewGroup;
import android.widget.TextView;

import com.mmxb.utilmiao.mvvm.MvvmSimpleActivity;
import com.mmxb.utilmiao.view.flowlayout.FlowLayout;

public class MainActivity extends AppCompatActivity {

    private Context context;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        context = this;

        findViewById(R.id.home_tv).setOnClickListener(v -> {
            Intent intent = new Intent(context, HomeActivity.class);
            startActivity(intent);
        });

        findViewById(R.id.mvvm_tv).setOnClickListener(v -> {
            Intent intent = new Intent(context, MvvmSimpleActivity.class);
            startActivity(intent);
        });
    }
}
