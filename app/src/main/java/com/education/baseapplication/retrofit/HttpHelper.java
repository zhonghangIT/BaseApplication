package com.education.baseapplication.retrofit;

import com.education.baseapplication.config.UrlConfig;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by zhonghang on 16/8/1.
 */

public class HttpHelper {
    private static HttpHelper helper;
    private Retrofit retrofit;
    IMovieService service;

    private HttpHelper() {
        Gson gson = new GsonBuilder()
//                .enableComplexMapKeySerialization()
                .serializeNulls().create();
        retrofit = new Retrofit.Builder()
                //对提交的参数或者返回值进行预处理
                .addConverterFactory(new MovieConvertFactory())
                .baseUrl(UrlConfig.Path.BASE_URL)
                .build();
        service = retrofit.create(IMovieService.class);
    }

    public IMovieService getService() {
        return service;
    }

    public static synchronized HttpHelper newInstance() {
        if (helper == null) {
            helper = new HttpHelper();
        }
        return helper;
    }
}
