package com.mmxb.manimation;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity{

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();

        // todo finish动画无效
//        ActivityCompat.finishAfterTransition(this);
//        finish();
//        overridePendingTransition(0, android.R.anim.slide_out_right);
    }
}
