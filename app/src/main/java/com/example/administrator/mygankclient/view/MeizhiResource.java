package com.example.administrator.mygankclient.view;

import com.example.administrator.mygankclient.bean.AndroidBean;
import com.example.administrator.mygankclient.bean.MeizhiBean;

import java.util.List;

/**
 * Created by Administrator on 2017/6/21.
 */

public interface MeizhiResource {
    void setList(List<MeizhiBean> list);
    void setAdapter();
}
