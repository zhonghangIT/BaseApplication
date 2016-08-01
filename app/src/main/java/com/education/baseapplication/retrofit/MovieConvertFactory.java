package com.education.baseapplication.retrofit;

import com.education.baseapplication.bean.Movies;
import com.google.gson.Gson;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;

import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Converter;
import retrofit2.Retrofit;

/**
 * Created by zhonghang on 16/8/1.
 */

public class MovieConvertFactory extends Converter.Factory {

    @Override
    public Converter<ResponseBody, ?> responseBodyConverter(Type type, Annotation[] annotations, Retrofit retrofit) {
        return new MovieConvert();
    }

    @Override
    public Converter<?, RequestBody> requestBodyConverter(Type type, Annotation[] parameterAnnotations, Annotation[] methodAnnotations, Retrofit retrofit) {
        return super.requestBodyConverter(type, parameterAnnotations, methodAnnotations, retrofit);
    }

    static class MovieConvert implements Converter<ResponseBody, Movies> {

        @Override
        public Movies convert(ResponseBody value) throws IOException {
            String result = value.string();
            Gson gson = new Gson();
            Movies movies = gson.fromJson(result, Movies.class);
            return movies;
        }
    }
}
