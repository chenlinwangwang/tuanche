package com.bwf.tuanche.details.adapter;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bwf.framwork.bean.Carstyle;
import com.bwf.framwork.bean.StyleList;
import com.bwf.framwork.image.ImageLoader;
import com.bwf.framwork.utils.IntentUtils;
import com.bwf.tuanche.R;
import com.bwf.tuanche.details.DetailsActivity;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

/**
 * 作者/日期: admin on 2016/8/20.
 * 描述:
 */
public class CarListAdapter extends RecyclerView.Adapter<CarListAdapter.ViewHolder> {
    private Context context;
    private List<StyleList> styleList;
    private StyleList style;
    private Bundle mBundle;
    private MyCallBack MyCallBack;

    public void setMyCallBack(MyCallBack MyCallBack) {
        this.MyCallBack = MyCallBack;
    }

    public CarListAdapter(Context context, List<StyleList> styleList, Bundle mBundle) {
        this.context = context;
        this.styleList = styleList;
        this.mBundle = mBundle;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = View.inflate(context, R.layout.item_rv_carlist, null);
        ViewHolder viewHolder = new ViewHolder(view);
        viewHolder.sdv_carlist_photo = (SimpleDraweeView) view.findViewById(R.id.sdv_carlist_photo);
        viewHolder.tv_cartype = (TextView) view.findViewById(R.id.tv_cartype);
        viewHolder.tv_carjiage = (TextView) view.findViewById(R.id.tv_carjiage);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        style = styleList.get(position);
        ImageLoader.getInstance().disPlayImage(holder.sdv_carlist_photo, styleList.get(position).logo);
        holder.tv_cartype.setText(styleList.get(position).styleName);
        holder.tv_carjiage.setText(styleList.get(position).pricePrefix +
                styleList.get(position).price + styleList.get(position).priceSuffix);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (MyCallBack != null) {
                    MyCallBack.onClick(position);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return styleList == null ? 0 : styleList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        SimpleDraweeView sdv_carlist_photo;
        TextView tv_cartype, tv_carjiage;

        public ViewHolder(View itemView) {
            super(itemView);
        }
    }

    public interface MyCallBack {
        void onClick(int position);
    }
}
