package com.example.administrator.mygankclient.retrofitservice;

import com.example.administrator.mygankclient.bean.RootBean;
import com.example.administrator.mygankclient.bean.TimeBean;

import retrofit2.http.GET;
import retrofit2.http.Path;
import rx.Observable;
import rx.observers.Observers;

/**
 * Created by Administrator on 2017/6/17.
 */

public interface EveryDayGank {
    @GET("/api/day/{year}/{month}/{day}")
    Observable<RootBean> getinfo(@Path("year") String year, @Path("month") String month, @Path("day") String day);

    @GET("/api/day/history")
    Observable<TimeBean> getTime();
}
