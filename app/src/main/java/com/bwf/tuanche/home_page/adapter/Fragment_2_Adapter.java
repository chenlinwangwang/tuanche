package com.bwf.tuanche.home_page.adapter;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bwf.framwork.image.ImageLoader;
import com.bwf.framwork.utils.ToastUtil;
import com.bwf.tuanche.R;
import com.bwf.tuanche.home_page.Bean.HotBrandBean;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

/**
 * Created by admin on 2016/8/17.
 */
public class Fragment_2_Adapter extends RecyclerView.Adapter<Fragment_2_Adapter.ViewHolder> {
    private Context context;
    private List<HotBrandBean.ListBean> list;
    private CallBack_2 callBack_2;

    public void setCallBack_2(CallBack_2 callBack_2) {
        this.callBack_2 = callBack_2;
    }

    public Fragment_2_Adapter(Context context) {
        this.context = context;
    }

    public void setList(List<HotBrandBean.ListBean> list) {
        HotBrandBean.ListBean listBean = new HotBrandBean.ListBean();
        listBean.setLogo("测试");
        listBean.setName("更多");
        list.add(listBean);
        this.list = list;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = View.inflate(context, R.layout.item_fragment2_adapter, null);
        ViewHolder viewHolder_2 = new ViewHolder(view);
        viewHolder_2.img_logo = (SimpleDraweeView) view.findViewById(R.id.img_logo);
        viewHolder_2.tv_carName = (TextView) view.findViewById(R.id.tv_carName);
        viewHolder_2.tv_peopleCount = (TextView) view.findViewById(R.id.tv_peopleCount);
        return viewHolder_2;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final  int position) {
        if (list != null) {
            ImageLoader.getInstance().disPlayImage(holder.img_logo, list.get(position).getLogo());
            String str = "<font color='red'>" + list.get(position).getBaseNum() + "</font>";
            holder.tv_peopleCount.setText("有" + Html.fromHtml(str) + "人报名");
            holder.tv_carName.setText(list.get(position).getName());

            if (list.get(position).getName().equals("更多")) {
                holder.img_logo.setImageResource(R.mipmap.icon_more);
                holder.tv_carName.setText("更多");
                holder.tv_peopleCount.setVisibility(View.GONE);
            }
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (callBack_2!=null){
                        callBack_2.onClick(position);
                    }
                }
            });

        }
    }

    @Override
    public int getItemCount() {
        return list == null ? 0 : list.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        private SimpleDraweeView img_logo;
        private TextView tv_carName;
        private TextView tv_peopleCount;

        public ViewHolder(View itemView) {
            super(itemView);

        }
    }
    public  interface CallBack_2{
        void onClick(int position);
    }
}
