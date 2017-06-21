package com.example.administrator.mygankclient.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.administrator.mygankclient.R;
import com.example.administrator.mygankclient.bean.MeizhiBean;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/6/21.
 */

public class MeiZhiAdapter extends RecyclerView.Adapter<MeiZhiAdapter.MyViewHolder>{
    List<MeizhiBean> list = new ArrayList<>();
    Context context ;
    public MeiZhiAdapter(List<MeizhiBean> list, Context context){
        this.list = list;
        this.context =context;
    }
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.meizhi_item,parent,false);
        MyViewHolder viewHolder = new MyViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Glide.with(context).load(list.get(position).getUrl()).placeholder(R.drawable.timg).into(holder.img);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }


    class MyViewHolder extends RecyclerView.ViewHolder {
        View itemView;
        ImageView img;
        public MyViewHolder(View itemView) {
            super(itemView);
            this.itemView = itemView;
            img = (ImageView) itemView.findViewById(R.id.img_meizhi);
        }
    }
}
