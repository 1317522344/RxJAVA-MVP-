package com.example.administrator.mygankclient.bean;

import android.support.v4.app.Fragment;

/**
 * Created by Administrator on 2017/6/16.
 */

public class TabPaperBean {
    Fragment paperTab;
    String tabName;
    public Fragment getPaperTab() {
        return paperTab;
    }

    public void setPaperTab(Fragment paperTab) {
        this.paperTab = paperTab;
    }

    public String getTabName() {
        return tabName;
    }

    public void setTabName(String tabName) {
        this.tabName = tabName;
    }


}
