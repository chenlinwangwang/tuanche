package com.bwf.tuanche.home_page.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bwf.framwork.base.ReccleViewAdapter;
import com.bwf.framwork.image.ImageLoader;
import com.bwf.tuanche.R;
import com.bwf.tuanche.home_page.Bean.BannerBean;
import com.bwf.tuanche.home_page.Bean.ResultBean;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

/**
 * Created by admin on 2016/8/16.
 */
public class Fragment_1_Adapter extends RecyclerView.Adapter<Fragment_1_Adapter.ViewHolder> {

    private Context context;
    private List<ResultBean.Nc> ncs;

    private CallBack_1 callBack_1;

    public void setCallBack_1(CallBack_1 callBack_1) {
        this.callBack_1 = callBack_1;
    }

    public void setNcs(List<ResultBean.Nc> ncs) {
        this.ncs = ncs;
    }

    public Fragment_1_Adapter(Context context) {
        this.context = context;
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = View.inflate(context, R.layout.item_fragment1_adapter, null);
        ViewHolder viewHolder = new ViewHolder(view);
        viewHolder.img_buycar = (SimpleDraweeView) view.findViewById(R.id.img_buycar);
        viewHolder.img_guanggao = (SimpleDraweeView) view.findViewById(R.id.img_guanggao);
        viewHolder.tv_buycar = (TextView) view.findViewById(R.id.tv_buycar);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        holder.tv_buycar.setText(ncs.get(position).getName());
        ImageLoader.getInstance().disPlayImage(holder.img_buycar, ncs.get(position).getPic());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (callBack_1!=null){
                    callBack_1.onClick(position);
                }
            }
        });

    }

    @Override
    public int getItemCount() {
        return ncs == null ? 0 : ncs.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tv_buycar;
        SimpleDraweeView img_buycar;
        SimpleDraweeView img_guanggao;


        public ViewHolder(View itemView) {
            super(itemView);
        }
    }

    public interface CallBack_1 {
        void onClick(int position);
    }
}
