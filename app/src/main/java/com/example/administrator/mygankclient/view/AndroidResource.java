package com.example.administrator.mygankclient.view;

import com.example.administrator.mygankclient.bean.AndroidBean;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Administrator on 2017/6/19.
 */

public interface AndroidResource {
    void setList(List<AndroidBean> list);
    int getID();
    void setAdapter();
}
