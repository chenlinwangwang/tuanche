package com.bwf.tuanche.home_page.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bwf.framwork.image.ImageLoader;
import com.bwf.tuanche.R;
import com.bwf.tuanche.home_page.Bean.BannerBean;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

/**
 * Created by admin on 2016/8/18.
 */
public class Fragment_1_Banner_Adaptere extends RecyclerView.Adapter<Fragment_1_Banner_Adaptere.ViewHolder> {
    private Context context;
    private List<BannerBean.Header_banner> header_banner;

    public Fragment_1_Banner_Adaptere(Context context) {
        this.context = context;
    }
    public void setHeader_banner(List<BannerBean.Header_banner> header_banner) {
        this.header_banner = header_banner;
    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = View.inflate(context, R.layout.item_fragment_1_banner_adapter, null);
        ViewHolder viewHolder = new ViewHolder(view);
        viewHolder.img_guangao = (SimpleDraweeView) view.findViewById(R.id.img_guanggao);
        viewHolder.img_guangao.setScaleType(ImageView.ScaleType.CENTER_CROP);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        ImageLoader.getInstance().disPlayImage(holder.img_guangao,header_banner.get(position).adImgUrl);
    }

    @Override
    public int getItemCount() {
        return header_banner==null?0:header_banner.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        SimpleDraweeView img_guangao;

        public ViewHolder(View itemView) {
            super(itemView);
        }
    }
}
