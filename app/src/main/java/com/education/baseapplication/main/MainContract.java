package com.education.baseapplication.main;

import com.education.baseapplication.base.IBaseModel;
import com.education.baseapplication.base.IBasePresenter;
import com.education.baseapplication.base.IBaseView;
import com.education.baseapplication.bean.Movies;

import java.util.HashMap;

import retrofit2.Callback;


/**
 * Created by zhonghang on 16/8/1.
 */

public class MainContract {
    public interface View extends IBaseView {
        void onSucess(String content);

        void onFail(String msg);
    }

    public interface Presenter extends IBasePresenter {
        void getData();
    }

    public interface Model extends IBaseModel {
        void getData(String path, HashMap<String,String> params, Callback<Movies> callback);
    }
}
