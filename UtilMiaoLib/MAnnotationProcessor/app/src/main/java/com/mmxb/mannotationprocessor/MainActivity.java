package com.mmxb.mannotationprocessor;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.mmxb.mannolib.MAnnotation;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @MAnnotation(name = "momo")
    public void getName() {

    }
}
