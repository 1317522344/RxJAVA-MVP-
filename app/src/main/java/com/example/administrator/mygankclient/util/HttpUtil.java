package com.example.administrator.mygankclient.util;

import com.example.administrator.mygankclient.ShareData;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
/**
 * Created by Administrator on 2017/6/17.
 */

public class HttpUtil {
    private static HttpUtil instance;

    private Retrofit retrofit;

    private HttpUtil() {
        this.instance = this;
        this.retrofit = new Retrofit.Builder()
                .baseUrl(ShareData.URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
    }

    private static HttpUtil getInstance() {
        if (instance == null) {
            synchronized (HttpUtil.class) {
                if (instance == null) {
                    return new HttpUtil();
                }
            }
        }
        return instance;
    }

    public static <T> T getService(Class<T> c) {
        return getInstance().retrofit.create(c);
    }

    public static <T> void init(Observable<T> observable, Subscriber<T> subscriber) {
        observable
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber);
    }
}
