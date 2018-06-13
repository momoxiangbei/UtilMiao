package com.mmxb.utilmiao.lifecycle;

import android.arch.lifecycle.Lifecycle;
import android.arch.lifecycle.LifecycleObserver;
import android.arch.lifecycle.LifecycleOwner;
import android.arch.lifecycle.OnLifecycleEvent;
import android.util.Log;

import static com.mmxb.utilmiao.config.AppConfig.LOG_TAG;


/**
 * Created by xueying on 2018/5/2.
 */

public class LifecycleObserverDemo implements LifecycleObserver {

    @OnLifecycleEvent(Lifecycle.Event.ON_ANY)
    void onAny(LifecycleOwner owner, Lifecycle.Event event) {
        Log.d(LOG_TAG, "onAny: " + owner.getClass().getSimpleName() + " " + event.name());
    }


    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    void onCreate() {
        Log.d(LOG_TAG, "onCreate: ");
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    void onDestroy() {
        Log.d(LOG_TAG, "onDestroy: ");
    }
}
