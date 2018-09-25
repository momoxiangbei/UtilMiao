package com.mmxb.utilmiao;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.mmxb.utilmiao.data.TestData;
import com.mmxb.utilmiao.view.flowlayout.FlowLayout;

import java.util.List;

/**
 * Created by wxy on 2018/8/17
 */
public class HomeActivity extends AppCompatActivity {
    private Context context;
    private FlowLayout flowLayout;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        context = this;

        flowLayout = findViewById(R.id.flowlayout);
        List<String> itemList = TestData.getTagList();
        for (int i = 0; i < itemList.size(); i++) {
            View view = LayoutInflater.from(this).inflate(R.layout.item_layout, flowLayout, false);
            TextView textView = view.findViewById(R.id.item_text);
//            if (i == 1) {
//                textView.setHeight(200);
//            }
            textView.setText(itemList.get(i));
            flowLayout.addView(textView);
        }
    }

}
