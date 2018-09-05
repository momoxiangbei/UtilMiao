package com.mmxb.utilmiao;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;

import com.mmxb.utilmiao.mvvm.MvvmSimpleActivity;
import com.mmxb.utilmiao.utils.BadgeUtil;
import com.mmxb.utilmiao.utils.NotificationUtil;

import static com.mmxb.utilmiao.utils.NotificationUtil.buildNotification;

public class MainActivity extends AppCompatActivity {

    private Context context;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        context = this;

        findViewById(R.id.home_tv).setOnClickListener(v -> {
//            Intent intent = new Intent(context, HomeActivity.class);
//            startActivity(intent);

            // todo test
//        BadgeUtil.getLauncherClassName(this);
            buildNotification(this, "test", "test22", "test222");
        });

        findViewById(R.id.mvvm_tv).setOnClickListener(v -> {
            Intent intent = new Intent(context, MvvmSimpleActivity.class);
            startActivity(intent);
        });


    }
}
