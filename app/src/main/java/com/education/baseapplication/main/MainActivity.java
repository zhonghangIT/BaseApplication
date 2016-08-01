package com.education.baseapplication.main;

import android.Manifest;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.education.baseapplication.R;
import com.education.baseapplication.base.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends BaseActivity implements MainContract.View {
    @BindView(R.id.btn_get)
    Button btnGet;
    @BindView(R.id.textview_content)
    TextView textviewContent;
    private MainContract.Presenter presenter;
    private MainContract.Model model;
    private Handler handler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        model = new MainModel();
        presenter = new MainPresenter(model, this);
        //初始化方法
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    public void initView() {
        btnGet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.getData();
            }
        });
    }

    @Override
    public void initData() {

    }

    @Override
    public void onSucess(final String content) {
        handler.post(new Runnable() {
            @Override
            public void run() {
                textviewContent.setText(content);
            }
        });
    }

    @Override
    public void onFail(final String msg) {
        handler.post(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(MainActivity.this, msg, Toast.LENGTH_SHORT).show();
            }
        });

    }

}
