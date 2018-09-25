package com.mmxb.utilmiao.notification;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

/**
 * Created by wxy on 2018/9/3
 */
public class NotificationReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        if (intent.getExtras() != null) {
            Toast.makeText(context, "notify click ：" + intent.getStringExtra("NotificationExtra"), Toast.LENGTH_LONG).show();
        }
    }
}
