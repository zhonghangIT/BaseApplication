package com.education.baseapplication.retrofit;

import com.education.baseapplication.bean.MovieBean;
import com.education.baseapplication.bean.Movies;

import java.util.HashMap;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.QueryMap;

/**
 * Created by zhonghang on 16/8/1.
 */

public interface IMovieService {
    @GET("/")
    Call<ResponseBody> getHtml();
    @POST("m/{aaa}/list.html")
    Call<Movies> getMovieList(@Path("aaa")String path
            , @QueryMap()HashMap<String,String> params);

}
