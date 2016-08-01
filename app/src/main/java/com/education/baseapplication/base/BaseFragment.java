package com.education.baseapplication.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;

/**
 * Created by zhonghang on 16/8/1.
 */

public abstract class BaseFragment extends Fragment implements IBaseView{
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View fragmentView=inflater.inflate(getLayoutId(),null);
        ButterKnife.bind(this,fragmentView);
        initView();
        initData();
        return fragmentView;
    }
}
