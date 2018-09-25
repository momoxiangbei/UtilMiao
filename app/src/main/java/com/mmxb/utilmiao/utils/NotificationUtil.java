package com.mmxb.utilmiao.utils;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.os.Build;
import android.support.v4.app.NotificationCompat;

import com.mmxb.utilmiao.R;

/**
 * Created by wxy on 2018/9/3
 */
public class NotificationUtil {
    private static int notifyId = 0;

    public static void buildNotification(Context context, String title, String content, String customContent) {
        notifyId++;
        String channelId = "1234";
        String channelName = "myChannelName";
        String channelDescription = "myChannelDescription";

        NotificationManager notificationManager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationChannel channel = new NotificationChannel(channelId, channelName, NotificationManager.IMPORTANCE_HIGH);
            channel.setDescription(channelDescription);
            channel.enableLights(true);  //闪光
            channel.setLightColor(Color.RED);  //指定闪光是的灯光颜色
            channel.setShowBadge(true);    //桌面launcher消息角标
            channel.setBypassDnd(true);   //设置可以绕过，请勿打扰模式
            channel.setLockscreenVisibility(Notification.VISIBILITY_SECRET);//锁屏显示通知
            if (notificationManager != null) {
                notificationManager.createNotificationChannel(channel);
            }
        }

        Intent resultIntent = new Intent("NotificationReceiver");
        resultIntent.putExtra("NotificationExtra", "hahaha");
        notifyId++;
        PendingIntent resultPendingIntent = PendingIntent.getBroadcast(
                context,
                notifyId,
                resultIntent,
                PendingIntent.FLAG_UPDATE_CURRENT
        );
        int smallIcon;  // sdk21开始，Google要求，通知栏图标，要纯色。
        if (Build.VERSION.SDK_INT >= 21 && "google".equals(Build.BRAND)) {
            smallIcon = R.drawable.ic_bottom_arrow;
        } else {
            smallIcon = R.drawable.header;
        }
        NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(context, channelId)
                .setAutoCancel(true)// 点击通知后，状态栏自动删除通知
                .setContentTitle(title)
                .setContentText(content)
                .setSmallIcon(smallIcon)
                .setLargeIcon(BitmapFactory.decodeResource(context.getResources(), R.mipmap.ic_launcher))
                .setContentIntent(resultPendingIntent) // 点击后要启动的程序组件对应的PendingIntent
                .setDefaults(Notification.DEFAULT_ALL);  // 显示带有默认铃声、震动、呼吸灯效果的通知

        if (notificationManager != null) {
            notificationManager.notify(notifyId, mBuilder.build());
        }

    }

}
