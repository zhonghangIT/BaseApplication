package com.education.baseapplication.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import butterknife.ButterKnife;

/**
 * Created by zhonghang on 16/8/1.
 */

public abstract class BaseActivity extends AppCompatActivity implements IBaseView{
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());
        ButterKnife.bind(this);
        initView();
        initData();
    }

    @Override
    protected void onResume() {
        super.onResume();
        //
    }

    @Override
    protected void onPause() {
        super.onPause();
        //
    }

}
