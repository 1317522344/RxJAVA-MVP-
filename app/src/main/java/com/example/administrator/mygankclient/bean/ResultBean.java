package com.example.administrator.mygankclient.bean;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Administrator on 2017/6/17.
 */

public class ResultBean {
    private List<AndroidBean> Android ;

    private List<IOSBean> iOS ;

    @SerializedName("\u798f\u5229")
    private List<MeizhiBean> meiZhi ;

    public List<AndroidBean> getAndroid() {
        return Android;
    }

    public void setAndroid(List<AndroidBean> android) {
        Android = android;
    }

    public List<IOSBean> getiOS() {
        return iOS;
    }

    public void setiOS(List<IOSBean> iOS) {
        this.iOS = iOS;
    }

    public List<MeizhiBean> getMeiZhi() {
        return meiZhi;
    }

    public void setMeiZhi(List<MeizhiBean> meiZhi) {
        this.meiZhi = meiZhi;
    }




}
