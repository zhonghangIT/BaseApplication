package com.education.baseapplication.main;

import android.graphics.Movie;

import com.education.baseapplication.bean.MovieBean;
import com.education.baseapplication.bean.Movies;
import com.education.baseapplication.config.UrlConfig;
import com.education.baseapplication.retrofit.HttpHelper;
import com.education.baseapplication.retrofit.IMovieService;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

/**
 * Created by zhonghang on 16/8/1.
 */

public class MainModel implements MainContract.Model {

    @Override
    public void getData(String path, HashMap<String, String> params, Callback<Movies> callback) {
        HttpHelper.newInstance().getService().getMovieList("movie", params).enqueue(callback);
    }
}
