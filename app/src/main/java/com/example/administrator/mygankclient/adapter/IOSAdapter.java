package com.example.administrator.mygankclient.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.administrator.mygankclient.R;
import com.example.administrator.mygankclient.bean.AndroidBean;
import com.example.administrator.mygankclient.bean.IOSBean;

import java.util.List;

/**
 * Created by Administrator on 2017/6/19.
 */

public class IOSAdapter extends RecyclerView.Adapter<IOSAdapter.IViewHolder>implements View.OnClickListener{

    List<IOSBean> list;
    private OnItemClickListener onItemClickListener = null;

    public IOSAdapter(List<IOSBean> list){
        this.list = list;
    }

    @Override
    public IViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_item,parent,false);
        IViewHolder viewHolder = new IViewHolder(v);
        v.setOnClickListener(this);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(IViewHolder holder, int position) {
        holder.Name.setText(list.get(position).getDesc()+"");
        holder.Time.setText(list.get(position).getCreatedAt()+"");
        holder.itemView.setTag(position);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
    class IViewHolder extends RecyclerView.ViewHolder {
        View itemView;
        TextView Name;
        TextView Time;

        public IViewHolder(View itemView) {
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

