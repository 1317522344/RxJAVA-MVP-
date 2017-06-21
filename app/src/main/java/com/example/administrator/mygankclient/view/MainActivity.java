package com.example.administrator.mygankclient.view;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.administrator.mygankclient.R;
import com.example.administrator.mygankclient.adapter.TabAdapter;
import com.example.administrator.mygankclient.bean.RootBean;
import com.example.administrator.mygankclient.bean.TabPaperBean;
import com.example.administrator.mygankclient.model.TabSelectSource;
import com.example.administrator.mygankclient.presenter.ConnectPresenter;
import com.example.administrator.mygankclient.presenter.TabPresenter;
import com.example.administrator.mygankclient.retrofitservice.EveryDayGank;
import com.example.administrator.mygankclient.util.HttpUtil;
import com.wega.library.loadingDialog.LoadingDialog;

import java.util.ArrayList;
import java.util.List;

import rx.Subscriber;

public class MainActivity extends AppCompatActivity implements TabSelectSource,WaitDialog{
    TabLayout tabLayout;
    Toolbar toolbar;
    ViewPager viewPager;
    List<TabPaperBean> tabList;
    TabAdapter tabAdapter;
    ConnectPresenter connectPresenter;
    LoadingDialog loadingDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        //showDialog();
        //connectPresenter =new ConnectPresenter(MainActivity.this,this);
    }
    void initView(){
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("一点干货");
        toolbar.setSubtitle("每天一点就够了");
        toolbar.setSubtitleTextColor(Color.GRAY);
        setSupportActionBar(toolbar);
        tabLayout = (TabLayout) findViewById(R.id.tab_main);
        viewPager = (ViewPager) findViewById(R.id.viewpager_main);
        tabList = new ArrayList<>();
        TabPresenter tabPresent = new TabPresenter(this);
        tabPresent.addTab();
        tabPresent.setPaper();
        loadingDialog = new LoadingDialog(MainActivity.this);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void addTab(String tabName, Fragment paperTab) {
        TabPaperBean tabPaperBean = new TabPaperBean();
        tabPaperBean.setTabName(tabName);
        tabPaperBean.setPaperTab(paperTab);
        tabList.add(tabPaperBean);
    }

    @Override
    public void setPaper() {
        tabAdapter = new TabAdapter(getSupportFragmentManager(),tabList);
        viewPager.setAdapter(tabAdapter);
        tabLayout.setupWithViewPager(viewPager);
    }

    @Override
    public void showDialog() {
        loadingDialog.loading("加载中");
    }

    @Override
    public void LoadSuccess() {
        loadingDialog.loadSuccess("加载成功");
    }

    @Override
    public void LoadFail() {
        loadingDialog.loadFail("加载失败");
    }

}
