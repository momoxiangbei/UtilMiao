package com.mmxb.animationlib.util;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.ActivityOptionsCompat;
import android.view.View;

public class ActivityAnimUtil {

    public static void CustomAnim(Context context, Intent intent) {
        ActivityCompat.startActivity(context, intent,
                ActivityOptionsCompat.makeCustomAnimation(context,
                        android.R.anim.slide_in_left, android.R.anim.slide_out_right).toBundle());
    }

    public static void AnimScale(Context context, Intent intent, View view) {
        ActivityOptionsCompat options = ActivityOptionsCompat.makeScaleUpAnimation(view,
                view.getWidth() / 2, view.getHeight() / 2, 0, 0);
        ActivityCompat.startActivity(context, intent, options.toBundle());
    }
}
