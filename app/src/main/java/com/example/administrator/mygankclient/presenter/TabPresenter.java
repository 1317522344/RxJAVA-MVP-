package com.example.administrator.mygankclient.presenter;

import com.example.administrator.mygankclient.model.TabSelectSource;
import com.example.administrator.mygankclient.view.AndroidFragment;
import com.example.administrator.mygankclient.view.IOSFragment;
import com.example.administrator.mygankclient.view.MeizhiFragment;

/**
 * Created by Administrator on 2017/6/16.
 */

public class TabPresenter {

    TabSelectSource mainActivity;
    public TabPresenter(TabSelectSource mainActivity){
        this.mainActivity = mainActivity;
    }
    public void addTab(){
        mainActivity.addTab("Android", AndroidFragment.getinstance());
        mainActivity.addTab("IOS", IOSFragment.getinstance());
        mainActivity.addTab("福利", MeizhiFragment.getinstance());
    }
    public void setPaper(){
        mainActivity.setPaper();
    }
}
