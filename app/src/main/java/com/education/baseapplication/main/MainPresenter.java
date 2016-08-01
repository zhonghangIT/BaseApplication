package com.education.baseapplication.main;

import android.util.Log;

import com.education.baseapplication.bean.MovieBean;
import com.education.baseapplication.bean.Movies;
import com.education.baseapplication.config.UrlConfig;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import okhttp3.Response;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;


/**
 * Created by zhonghang on 16/8/1.
 */

public class MainPresenter implements MainContract.Presenter {
    private MainContract.Model model;
    private MainContract.View view;

    public MainPresenter(MainContract.Model model, MainContract.View view) {
        this.model = model;
        this.view = view;
    }

    @Override
    public void getData() {
        HashMap<String, String> params = new HashMap<>();
        params.put(UrlConfig.KEY.APP_ID, "2");
        params.put(UrlConfig.KEY.VER, "2.5");
        params.put(UrlConfig.KEY.CHANNEL, "lede");
        params.put(UrlConfig.KEY.DEVICE_ID, "C1985DD9-0125-4AB5-B66B-B91A85824BBA");
        params.put(UrlConfig.KEY.API_VER, "11");
        params.put(UrlConfig.KEY.CITY, "110000");
        params.put(UrlConfig.KEY.MOBILE_TYPE, UrlConfig.VALUE.IPHONE);
        model.getData(UrlConfig.ThumbnailPath.MOVIE, params, new Callback<Movies>() {
            @Override
            public void onResponse(Call<Movies> call, retrofit2.Response<Movies> response) {
                Movies movies = response.body();
                List<MovieBean> movieBeanList = movies.getList();
                for (MovieBean bean : movieBeanList) {
                    Log.d("------", "" + bean.getName());
                }
                view.onSucess("加载成功");
            }

            @Override
            public void onFailure(Call<Movies> call, Throwable t) {
                view.onFail("加载失败");
            }
        });
    }
}
