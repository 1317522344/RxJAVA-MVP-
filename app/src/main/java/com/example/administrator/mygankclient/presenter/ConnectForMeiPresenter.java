package com.example.administrator.mygankclient.presenter;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.example.administrator.mygankclient.bean.RootBean;
import com.example.administrator.mygankclient.bean.TimeBean;
import com.example.administrator.mygankclient.model.ConnectGank;
import com.example.administrator.mygankclient.model.GetLastTime;
import com.example.administrator.mygankclient.model.GetLastTimer;
import com.example.administrator.mygankclient.view.AndroidResource;
import com.example.administrator.mygankclient.view.MeizhiResource;

import java.util.Calendar;
import java.util.Date;

/**
 * Created by Administrator on 2017/6/21.
 */

public class ConnectForMeiPresenter implements ConnectGank.ConnectResult ,GetLastTimer.GetResult{
    ConnectGank connectGank;
    GetLastTime getLastTime;
    Context context;
    MeizhiResource meizhiResource = null;
    public RootBean rootBean;
    public ConnectForMeiPresenter(Context context, MeizhiResource meizhiResource){
        this.context = context;
        this.meizhiResource = meizhiResource;
        getLastTime = new GetLastTimer();
        getLastTime.GetTime(context,this);
    }
    @Override
    public void ConnectSuccess(RootBean rootBean) {
        this.rootBean =rootBean;
        meizhiResource.setList(rootBean.getResults().getMeiZhi());
        meizhiResource.setAdapter();
    }

    @Override
    public void ConnectError(Throwable e) {
        Log.v("TKG",e.toString());
        Toast.makeText(context, e.toString()+"这里", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void GetSuccess(TimeBean timeBean) {
        Date date = timeBean.getResults().get(0);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH)+1;
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        //Toast.makeText(context,+"__"+calendar.get(Calendar.MONTH)+1+"__"++"__",Toast.LENGTH_SHORT).show();
        connectGank = new ConnectGank();
        connectGank.Connect(year+"",month+"",day+"",context,this);
    }

    @Override
    public void GetError(Throwable e) {
    }
}
