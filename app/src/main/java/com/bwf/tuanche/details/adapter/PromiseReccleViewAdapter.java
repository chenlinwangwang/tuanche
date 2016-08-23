package com.bwf.tuanche.details.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.bwf.framwork.base.BaseListAdpter;
import com.bwf.framwork.base.ReccleViewAdapter;
import com.bwf.framwork.bean.CarDetailBean;
import com.bwf.framwork.bean.TcbzDesc;
import com.bwf.framwork.image.ImageLoader;
import com.bwf.tuanche.R;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

/**
 * 作者/日期: admin on 2016/8/17.
 * 描述:团车保证
 */
public class PromiseReccleViewAdapter extends RecyclerView.Adapter<PromiseReccleViewAdapter.MyViewHolder> {
    private Context context;
    private List<TcbzDesc> tcbzDescList;

    public PromiseReccleViewAdapter(Context context) {
        this.context = context;
    }

    public void setTcbzDescList(CarDetailBean carDetailBean) {
        if (carDetailBean != null)
            tcbzDescList = JSON.parseArray(carDetailBean.tcbzDesc, TcbzDesc.class);
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {//View
        View view = View.inflate(context, R.layout.item_rv_promiss, null);
        MyViewHolder myViewHolder = new MyViewHolder(view);
        myViewHolder.sdv_promise = (SimpleDraweeView) view.findViewById(R.id.sdv_promise);
        myViewHolder.tv_promiss_big = (TextView) view.findViewById(R.id.tv_promiss_big);
        myViewHolder.tv_promiss_small = (TextView) view.findViewById(R.id.tv_promiss_small);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {//数据逻辑层
        if (tcbzDescList != null && !tcbzDescList.isEmpty()) {
            ImageLoader.getInstance().disPlayImage(holder.sdv_promise, tcbzDescList.get(position).imgurl);
            holder.tv_promiss_big.setText(tcbzDescList.get(position).title);
            holder.tv_promiss_small.setText(tcbzDescList.get(position).describe);
        }
    }

    @Override
    public int getItemCount() {
        return tcbzDescList == null ? 0 : tcbzDescList.size();
    }


    public class MyViewHolder extends RecyclerView.ViewHolder {
        public SimpleDraweeView sdv_promise;
        public TextView tv_promiss_big, tv_promiss_small;

        public MyViewHolder(View itemView) {
            super(itemView);
        }
    }

}
