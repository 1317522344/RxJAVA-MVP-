package com.example.administrator.mygankclient.model;

import android.content.Context;

import com.example.administrator.mygankclient.bean.RootBean;
import com.example.administrator.mygankclient.retrofitservice.EveryDayGank;

/**
 * Created by Administrator on 2017/6/18.
 */

public interface ConnectGankIO {
    void Connect(String year , String month , String day, Context context, ConnectGank.ConnectResult result);

}
