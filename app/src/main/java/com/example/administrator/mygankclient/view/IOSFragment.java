package com.example.administrator.mygankclient.view;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.administrator.mygankclient.R;
import com.example.administrator.mygankclient.adapter.IOSAdapter;
import com.example.administrator.mygankclient.bean.IOSBean;
import com.example.administrator.mygankclient.presenter.ConnectForIosPresenter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/6/16.
 */

public class IOSFragment extends Fragment implements IOSResource{
    RecyclerView recyclerView;
    IOSAdapter adapter;
    RecyclerView.LayoutManager manager;
    List<IOSBean> list = new ArrayList<>();
    ConnectForIosPresenter connectForIosPresenter ;
    private static IOSFragment iosFragment = new IOSFragment();
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragement_ios,container,false);
        recyclerView = (RecyclerView) view.findViewById(R.id.recyclerview_ios);
        return view;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onStart() {
        super.onStart();

        connectForIosPresenter = new ConnectForIosPresenter(getActivity(),this);
    }

    public static IOSFragment getinstance(){
        if (iosFragment==null)
            synchronized (IOSFragment.class) {
                if (iosFragment == null)
                    iosFragment = new IOSFragment();
            }
        return iosFragment;
    }

    @Override
    public void setList(List<IOSBean> list) {
        this.list = list;

    }


    @Override
    public int getID() {
        return 1;
    }

    @Override
    public void setAdapter(){

        //Log.v("IOSERROR",ConnectPresenter.rootBean.getResults().getiOS().toString()+"111");
        adapter = new IOSAdapter(list);
        adapter.setOnItemClickListener(new IOSAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                Uri uri = Uri.parse(connectForIosPresenter.getUrl(position));
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
