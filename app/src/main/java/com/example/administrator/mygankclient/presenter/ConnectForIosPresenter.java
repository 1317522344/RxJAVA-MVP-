package com.example.administrator.mygankclient.presenter;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.example.administrator.mygankclient.bean.IOSBean;
import com.example.administrator.mygankclient.bean.RootBean;
import com.example.administrator.mygankclient.model.ConnectGank;
import com.example.administrator.mygankclient.view.AndroidResource;
import com.example.administrator.mygankclient.view.IOSResource;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/6/20.
 */

public class ConnectForIosPresenter implements ConnectGank.ConnectResult{
    ConnectGank connectGank;
    Context context;
    List<IOSBean> list = new ArrayList<>();
    IOSResource iosResource = null;
    public ConnectForIosPresenter(Context context, IOSResource iosResource){
        this.context = context;
        this.iosResource = iosResource;
        connectGank = new ConnectGank();
        connectGank.Connect("2017","06","15",context,this);
    }
    @Override
    public void ConnectSuccess(RootBean rootBean) {
        this.list = rootBean.getResults().getiOS();
        iosResource.setList(rootBean.getResults().getiOS());
        iosResource.setAdapter();
    }
    public String getUrl(int position){
        return list.get(position).getUrl();
    }
    @Override
    public void ConnectError(Throwable e) {
        Log.v("IOSERROR",e.toString());
        Toast.makeText(context,e.toString(),Toast.LENGTH_SHORT).show();
    }
}
