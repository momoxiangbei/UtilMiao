package com.mmxb.mannotationprocessor;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.helloworld.MomoClass;
import com.mmxb.mannolib.MAnnotation;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        MomoClass momoClass = new MomoClass();

        Intent intent = new Intent(this, com.mmxb.mannotationprocessor.test.SecondActivity.class);
        startActivity(intent);
    }

    @MAnnotation(1)
    public void getName() {

    }
}
