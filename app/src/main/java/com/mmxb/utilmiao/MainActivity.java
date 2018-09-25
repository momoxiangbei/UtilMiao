package com.mmxb.utilmiao;

import android.app.Notification;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.mmxb.utilmiao.mvvm.MvvmSimpleActivity;
import com.mmxb.utilmiao.utils.NotificationUtil;

import static com.mmxb.utilmiao.utils.NotificationUtil.buildNotification;

public class MainActivity extends AppCompatActivity {

    private Context context;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        context = this;

        findViewById(R.id.notify_tv).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NotificationUtil.buildNotification(context, "title", "content", "wakaka");
            }
        });

        findViewById(R.id.home_tv).setOnClickListener(v -> {
//            Intent intent = new Intent(context, HomeActivity.class);
//            startActivity(intent);

            // todo test
//        BadgeUtil.getLauncherClassName(this);

        });

        findViewById(R.id.mvvm_tv).setOnClickListener(v -> {
            Intent intent = new Intent(context, MvvmSimpleActivity.class);
            startActivity(intent);
        });


    }
}
