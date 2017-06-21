package com.example.administrator.mygankclient.model;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;

import com.example.administrator.mygankclient.bean.TabPaperBean;

import java.util.List;

/**
 * Created by Administrator on 2017/6/16.
 */

public interface TabSelectSource {
    void addTab(String tabName, Fragment paperTab);
    void setPaper();
}
