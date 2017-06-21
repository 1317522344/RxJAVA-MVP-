package com.example.administrator.mygankclient.model;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.example.administrator.mygankclient.bean.RootBean;
import com.example.administrator.mygankclient.retrofitservice.EveryDayGank;
import com.example.administrator.mygankclient.util.HttpUtil;

import rx.Subscriber;

/**
 * Created by Administrator on 2017/6/18.
 */

public class ConnectGank implements ConnectGankIO {

    @Override
    public void Connect(String year, String month, String day, final Context context, final ConnectResult result) {
        HttpUtil.init(HttpUtil.getService(EveryDayGank.class).getinfo(year,month,day), new Subscriber<RootBean>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {
                result.ConnectError(e);
            }
            @Override
            public void onNext(RootBean rootBean) {
                result.ConnectSuccess(rootBean);
            }
        });
    }
    public interface ConnectResult{
        void ConnectSuccess(RootBean rootBean);
        void ConnectError(Throwable e);
    }

}
