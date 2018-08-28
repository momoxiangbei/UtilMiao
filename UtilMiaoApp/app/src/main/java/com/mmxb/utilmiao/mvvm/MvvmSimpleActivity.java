package com.mmxb.utilmiao.mvvm;

import android.databinding.BindingAdapter;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.mmxb.utilmiao.R;
import com.mmxb.utilmiao.databinding.ActivityMvvmSampleBinding;
import com.mmxb.utilmiao.mvvm.module.ProductEntity;

/**
 * Created by wxy on 2018/8/21
 */
public class MvvmSimpleActivity extends AppCompatActivity {
    private ActivityMvvmSampleBinding mBinding;
    ProductEntity product;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_mvvm_sample);
        product = new ProductEntity();
        product.setSellOut(false);
        mBinding.setProduct(product);
        mBinding.setImageUrl(R.drawable.header);
        mBinding.setActivity(this);

        product.name.set("momotest");
    }

    @BindingAdapter({"headerImage"})
    public static void imageLoader(ImageView imageView, int resourceId) {   // 必须是 public static
        imageView.setImageResource(resourceId);
    }

    public void onClick(View view) {
        Toast.makeText(this, "test click", Toast.LENGTH_LONG).show();
        product.name.set("momotest click");
    }
}
