package com.mmxb.manimation;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.mmxb.animationlib.util.ActivityAnimUtil;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClick1(View view) {
        Intent intent = new Intent(this, SecondActivity.class);
        startActivity(intent);
        // 参数：第一个参数入场动画 SecondActivity进入的动画，第二个是出场的动画 MainActivity退出的动画
        overridePendingTransition(android.R.anim.slide_in_left, android.R.anim.slide_out_right);
        // 问题：入场动画会黑屏，因为开始动画时MainActivity会立刻变成不可见状态，所以出场动画最好传一个静止的动画，比如透明度100到100，时间参数要一致。
//        overridePendingTransition(android.R.anim.slide_in_left, R.anim.anim_activity_non);
    }

    public void onClick2(View view) {
        Intent intent = new Intent(this, SecondActivity.class);
        ActivityAnimUtil.CustomAnim(this, intent);
    }

    public void onClick3(View view) {
        Intent intent = new Intent(this, SecondActivity.class);
        ActivityAnimUtil.AnimScale(this, intent, view);
    }
}