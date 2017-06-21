package com.example.administrator.mygankclient.model;

import android.content.Context;
import android.widget.Toast;

import com.example.administrator.mygankclient.bean.TimeBean;
import com.example.administrator.mygankclient.retrofitservice.EveryDayGank;
import com.example.administrator.mygankclient.util.HttpUtil;

import rx.Subscriber;
import rx.observers.SafeSubscriber;

/**
 * Created by Administrator on 2017/6/21.
 */

public class GetLastTimer implements GetLastTime{
    @Override
    public void GetTime(final Context context, final GetResult result) {
        HttpUtil.init(HttpUtil.getService(EveryDayGank.class).getTime(),new Subscriber<TimeBean>(){

            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {
                result.GetError(e);
            }

            @Override
            public void onNext(TimeBean timeBean) {
                result.GetSuccess(timeBean);
            }
        });
    }
    public interface GetResult{
        void GetSuccess(TimeBean timeBean);
        void GetError(Throwable e);
    }
}
