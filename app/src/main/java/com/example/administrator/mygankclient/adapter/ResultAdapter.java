package com.example.administrator.mygankclient.adapter;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.administrator.mygankclient.R;
import com.example.administrator.mygankclient.bean.AndroidBean;

import java.util.List;

/**
 * Created by Administrator on 2017/6/18.
 */

public class ResultAdapter extends RecyclerView.Adapter<ResultAdapter.MyViewHolder> implements View.OnClickListener{
    List<AndroidBean> list;
    private OnItemClickListener onItemClickListener = null;
    public ResultAdapter(List<AndroidBean> list){
        this.list = list;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Log.v("TKG","执行啦");
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_item,parent,false);
        MyViewHolder viewHolder = new MyViewHolder(v);
        v.setOnClickListener(this);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.Name.setText(list.get(position).getDesc());
        String str = list.get(position).getCreatedAt().substring(0,10);
        holder.Time.setText(str);
        holder.itemView.setTag(position);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
    class MyViewHolder extends RecyclerView.ViewHolder {
        View itemView;
        TextView Name;
        TextView Time;
        public MyViewHolder(View itemView) {
            super(itemView);
            this.itemView = itemView;
            Name = (TextView) itemView.findViewById(R.id.gank_name);
            Time = (TextView) itemView.findViewById(R.id.gank_time);
        }

    }
    @Override
    public void onClick(View v) {
        if (onItemClickListener!=null){
            onItemClickListener.onItemClick(v, (int) v.getTag());
        }
    }
    public void setOnItemClickListener(OnItemClickListener onItemClickListener){
        this.onItemClickListener = onItemClickListener;
    }
    public interface OnItemClickListener {
        void onItemClick(View view , int position);
    }

}
