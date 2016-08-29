package com.bwf.tuanche.details.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.bwf.framwork.bean.Carstyle;
import com.bwf.framwork.bean.HJiaBean;
import com.bwf.framwork.image.ImageLoader;
import com.bwf.tuanche.R;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

/**
 * 作者/日期: admin on 2016/8/19.
 * 描述:ReccleViewAdapter
 */
public class HJiaReccleViewAdapter extends RecyclerView.Adapter<HJiaReccleViewAdapter.ViewHolder> {
    private Context context;
    private List<Carstyle> carstyleList;
    private MyHJCallBack myHJCallBack;

    public HJiaReccleViewAdapter(Context context) {
        this.context = context;
    }

    public void setCarstyleList(HJiaBean hJiaBean) {
        if (hJiaBean != null)
            carstyleList = hJiaBean.carstyleList;
    }

    public void setMyHJCallBack(MyHJCallBack myHJCallBack) {
        this.myHJCallBack = myHJCallBack;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = View.inflate(context, R.layout.item_rv_hjia, null);
        ViewHolder viewHolder = new ViewHolder(view);
        viewHolder.sdv_carphoto = (SimpleDraweeView) view.findViewById(R.id.sdv_carphoto);
        viewHolder.tv_promiss_big = (TextView) view.findViewById(R.id.tv_promiss_big);
        viewHolder.tv_promiss_small = (TextView) view.findViewById(R.id.tv_promiss_small);
        viewHolder.tv_hj_big = (TextView) view.findViewById(R.id.tv_hj_big);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        ImageLoader.getInstance().disPlayImage(holder.sdv_carphoto, carstyleList.get(position).logo);
        holder.tv_promiss_big.setText(carstyleList.get(position).styleName);
        holder.tv_promiss_small.setText(carstyleList.get(position).factoryPrice);
        holder.tv_hj_big.setText(carstyleList.get(position).content);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (myHJCallBack != null)
                    myHJCallBack.OnClick(position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return carstyleList == null ? 0 : carstyleList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public SimpleDraweeView sdv_carphoto;
        public TextView tv_promiss_big, tv_promiss_small, tv_hj_big;

        public ViewHolder(View itemView) {
            super(itemView);
        }
    }

    public interface MyHJCallBack{
        void OnClick(int position);
    }

}
