package com.example.administrator.mygankclient.view;

import com.example.administrator.mygankclient.bean.IOSBean;

import java.util.List;

/**
 * Created by Administrator on 2017/6/19.
 */

public interface IOSResource {
    void setList(List<IOSBean> list);
    int getID();
    void setAdapter();
}
