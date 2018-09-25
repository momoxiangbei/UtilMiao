package com.mmxb.utilmiao.utils;

import android.app.Activity;
import android.app.Application;
import android.content.ComponentCallbacks;
import android.content.res.Configuration;
import android.support.annotation.NonNull;
import android.util.DisplayMetrics;

public class ScreenDensityUtil {

    private static float sNonCompatDensity;
    private static float sNonCompatScaledDensity;


    /**
     * @param activity
     * @param application
     * @param designWidthDp 设计图的图宽度，以宽维度来适配。
     */
    public static void setCustomDensity(@NonNull Activity activity, @NonNull Application application, int designWidthDp) {
        final DisplayMetrics appDisplayMetrics = application.getResources().getDisplayMetrics();

        if (sNonCompatDensity == 0) {
            sNonCompatDensity = appDisplayMetrics.density;
            sNonCompatScaledDensity = appDisplayMetrics.scaledDensity;
            application.registerComponentCallbacks(new ComponentCallbacks() {
                @Override
                public void onConfigurationChanged(Configuration newConfig) {
                    // todo yuayuan
                    if (newConfig != null || newConfig.fontScale > 0) {
                        sNonCompatScaledDensity = application.getResources().getDisplayMetrics().scaledDensity;
                    }
                }

                @Override
                public void onLowMemory() {

                }
            });
        }

        // px = density * dp;   density = dpi / 160;   px = dp * (dpi / 160);
        final float targetDensity = (float) appDisplayMetrics.widthPixels / designWidthDp;
        final float targetScaledDensity = targetDensity * (sNonCompatScaledDensity / sNonCompatDensity);
        final int targetDensityDpi = (int) (160 * targetDensity);

        appDisplayMetrics.density = targetDensity;
        appDisplayMetrics.scaledDensity = targetScaledDensity;
        appDisplayMetrics.densityDpi = targetDensityDpi;

        final DisplayMetrics activityDisplayMetrics = activity.getResources().getDisplayMetrics();
        activityDisplayMetrics.density = targetDensity;
        activityDisplayMetrics.scaledDensity = targetScaledDensity;
        activityDisplayMetrics.densityDpi = targetDensityDpi;
    }


    public static void setActivityCustomDensity(@NonNull Activity activity, int designWidthDp) {
        final DisplayMetrics activityDisplayMetrics = activity.getResources().getDisplayMetrics();

        if (sNonCompatDensity == 0) {
            sNonCompatDensity = activityDisplayMetrics.density;
            sNonCompatScaledDensity = activityDisplayMetrics.scaledDensity;
            activity.registerComponentCallbacks(new ComponentCallbacks() {
                @Override
                public void onConfigurationChanged(Configuration newConfig) {
                    if (newConfig != null || newConfig.fontScale > 0) {
                        sNonCompatScaledDensity = activity.getResources().getDisplayMetrics().scaledDensity;
                    }
                }

                @Override
                public void onLowMemory() {

                }
            });
        }

        // px = density * dp;   density = dpi / 160;   px = dp * (dpi / 160);
        final float targetDensity = (float) activityDisplayMetrics.widthPixels / designWidthDp;
        final float targetScaledDensity = targetDensity * (sNonCompatScaledDensity / sNonCompatDensity);
        final int targetDensityDpi = (int) (160 * targetDensity);

        activityDisplayMetrics.density = targetDensity;
        activityDisplayMetrics.scaledDensity = targetScaledDensity;
        activityDisplayMetrics.densityDpi = targetDensityDpi;
    }

}





















