package com.example.administrator.mygankclient.view;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.administrator.mygankclient.R;
import com.example.administrator.mygankclient.adapter.ResultAdapter;
import com.example.administrator.mygankclient.bean.AndroidBean;
import com.example.administrator.mygankclient.presenter.ConnectPresenter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/6/16.
 */

public class AndroidFragment extends Fragment implements AndroidResource{
    RecyclerView recyclerView;
    RecyclerView.LayoutManager manager;
    List<AndroidBean> list = new ArrayList<>();
    private static AndroidFragment androidFragment;
    ConnectPresenter connectPresenter;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_android,container,false);
        recyclerView = (RecyclerView) view.findViewById(R.id.recyclerview_android);
        return view;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onStart() {
        super.onStart();
        connectPresenter = new ConnectPresenter(getActivity(),this);
    }

    public static AndroidFragment getinstance(){
        if(androidFragment == null)
            synchronized (AndroidFragment.class){
                if (androidFragment ==null)
                    androidFragment = new AndroidFragment();
            }
        return androidFragment;
    }
    @Override
    public void setList(List<AndroidBean> list) {
        this.list = list;
    }

    @Override
    public int getID() {
        return 0;
    }

    @Override
    public void setAdapter() {
        ResultAdapter adapter = new ResultAdapter(list);
        Log.v("TAKG",this.list.size()+"执行啦");
        adapter.setOnItemClickListener(new ResultAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                Uri uri = Uri.parse(connectPresenter.getUrl(position));
                Intent it = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(it);
            }
        });
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
