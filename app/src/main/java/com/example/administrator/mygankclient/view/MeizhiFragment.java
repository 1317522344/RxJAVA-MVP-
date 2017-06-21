package com.example.administrator.mygankclient.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.administrator.mygankclient.R;
import com.example.administrator.mygankclient.adapter.MeiZhiAdapter;
import com.example.administrator.mygankclient.bean.MeizhiBean;
import com.example.administrator.mygankclient.presenter.ConnectForMeiPresenter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/6/21.
 */

public class MeizhiFragment extends Fragment implements MeizhiResource{
    RecyclerView recyclerView;
    RecyclerView.LayoutManager manager;
    public static MeizhiFragment meizhiFragment;
    MeiZhiAdapter adapter;
    List<MeizhiBean> list = new ArrayList<>();
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_meizhi,container,false);
        recyclerView = (RecyclerView) view.findViewById(R.id.recyclerview_meizhi);
        return view;
    }
    public static MeizhiFragment getinstance(){
        if(meizhiFragment == null)
            synchronized (AndroidFragment.class){
                if (meizhiFragment ==null)
                    meizhiFragment = new MeizhiFragment();
            }
        return meizhiFragment;
    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onStart() {
        super.onStart();
        new ConnectForMeiPresenter(getActivity(),this);
    }

    @Override
    public void setList(List<MeizhiBean> list) {
        this.list = list;
    }

    @Override
    public void setAdapter() {
        adapter = new MeiZhiAdapter(list,getActivity());
        manager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false){
            @Override
            public boolean canScrollVertically() {
                return false;
            }
        };
        recyclerView.setLayoutManager(manager);
        recyclerView.setAdapter(adapter);
    }
}
