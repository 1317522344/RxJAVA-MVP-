package com.example.administrator.mygankclient.presenter;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.example.administrator.mygankclient.R;
import com.example.administrator.mygankclient.ShareData;
import com.example.administrator.mygankclient.bean.RootBean;
import com.example.administrator.mygankclient.bean.TimeBean;
import com.example.administrator.mygankclient.model.ConnectGank;
import com.example.administrator.mygankclient.model.GetLastTime;
import com.example.administrator.mygankclient.model.GetLastTimer;
import com.example.administrator.mygankclient.view.AndroidResource;
import com.example.administrator.mygankclient.view.IOSResource;
import com.example.administrator.mygankclient.view.WaitDialog;
import com.wega.library.loadingDialog.LoadingDialog;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2017/6/18.
 */

public class ConnectPresenter implements ConnectGank.ConnectResult ,GetLastTimer.GetResult{
    ConnectGank connectGank;
    GetLastTime getLastTime;
    Context context;
    AndroidResource androidResource = null;
    public RootBean rootBean = null;
    public ConnectPresenter(Context context, AndroidResource androidResource){
        this.context = context;
        this.androidResource = androidResource;
        if(rootBean==null) {
            getLastTime = new GetLastTimer();
            getLastTime.GetTime(context, this);
        }
        else {
            androidResource.setList(rootBean.getResults().getAndroid());
            androidResource.setAdapter();
        }
    }

    @Override
    public void ConnectSuccess(RootBean rootBean) {
        this.rootBean =rootBean;
        androidResource.setList(rootBean.getResults().getAndroid());
        androidResource.setAdapter();
    }

    @Override
    public void ConnectError(Throwable e) {
        Log.e("TAG",e.toString());
        Toast.makeText(context,e.toString(),Toast.LENGTH_SHORT).show();
    }
    public String getUrl(int position){
        return rootBean.getResults().getAndroid().get(position).getUrl();
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
        Toast.makeText(context,e.toString(),Toast.LENGTH_SHORT).show();
    }
}
