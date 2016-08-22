package com.bwf.tuanche.home_page.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import com.bwf.framwork.image.ImageLoader;
import com.bwf.tuanche.R;
import com.bwf.tuanche.home_page.Bean.BannerBean;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

/**
 * Created by admin on 2016/8/18.
 */
public class Fragment_4_Adapter extends RecyclerView.Adapter<Fragment_4_Adapter.ViewHolder> {
    private Context context;
    private List<BannerBean.Center_banner> center_banner;
    private CallBack_4 callBack_4;

    public void setCallBack_4(CallBack_4 callBack_4) {
        this.callBack_4 = callBack_4;
    }

    public Fragment_4_Adapter(Context context) {
        this.context = context;
    }

    public void setCenter_banner(List<BannerBean.Center_banner> center_banner) {
        this.center_banner = center_banner;
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = View.inflate(context, R.layout.item_fragment4_adapter, null);
        ViewHolder viewHolder = new ViewHolder(view);
        viewHolder.img_carinsurence = (SimpleDraweeView) view.findViewById(R.id.img_car_insurence);
        viewHolder.img_baozhengjin = (SimpleDraweeView) view.findViewById(R.id.img_baozhengjin);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder,final int position) {
        ImageLoader.getInstance().disPlayImage(holder.img_carinsurence, center_banner.get(position).adImgUrl);
        ImageLoader.getInstance().disPlayImage(holder.img_baozhengjin, center_banner.get(position).shareUrl);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (callBack_4 != null) {
                    callBack_4.onClick(position);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return center_banner == null ? 0 : center_banner.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        SimpleDraweeView img_carinsurence;
        SimpleDraweeView img_baozhengjin;

        public ViewHolder(View itemView) {
            super(itemView);
        }
    }

    public interface CallBack_4 {
        void onClick(int position);
    }
}
