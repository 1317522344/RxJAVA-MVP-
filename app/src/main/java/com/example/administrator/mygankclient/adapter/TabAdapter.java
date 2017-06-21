package com.example.administrator.mygankclient.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.administrator.mygankclient.bean.TabPaperBean;

import java.util.List;

/**
 * Created by Administrator on 2017/6/16.
 */

public class TabAdapter extends FragmentPagerAdapter {
    private List<TabPaperBean> list;
    public TabAdapter(FragmentManager fm,List<TabPaperBean> list) {
        super(fm);
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Fragment getItem(int position) {
        TabPaperBean bean = list.get(position);
        return bean.getPaperTab();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return list.get(position).getTabName();
    }
}
