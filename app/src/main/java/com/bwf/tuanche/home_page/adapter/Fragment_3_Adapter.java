package com.bwf.tuanche.home_page.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bwf.framwork.image.ImageLoader;
import com.bwf.framwork.utils.LogUtils;
import com.bwf.tuanche.R;
import com.bwf.tuanche.home_page.Bean.HotTypeBean;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

/**
 * Created by admin on 2016/8/17.
 * 热门车型
 */
public class Fragment_3_Adapter extends RecyclerView.Adapter<Fragment_3_Adapter.ViewHolder> {
    private List<HotTypeBean> result;
    private Context context;
    private CallBack_3 callBack_3;

    public void setCallBack_3(CallBack_3 callBack_3) {
        this.callBack_3 = callBack_3;
    }

    public void setResult(List<HotTypeBean> result) {
        this.result = result;
    }

    public Fragment_3_Adapter(Context context) {
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view=View.inflate(context, R.layout.item_fragment3_adapter,null);
            ViewHolder viewHolder=new ViewHolder(view);
        viewHolder.img_typelogo= (SimpleDraweeView) view.findViewById(R.id.img_typelogo);
        viewHolder.tv_type_CarName= (TextView) view.findViewById(R.id.tv_type_CarName);
        viewHolder.tv_price_range= (TextView) view.findViewById(R.id.tv_price_range);
        viewHolder.tv_sign_up= (TextView) view.findViewById(R.id.tv_sign_up);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        if (result!=null){
            ImageLoader.getInstance().disPlayImage(holder.img_typelogo,result.get(position).getLogo());
//            if (holder.tv_type_CarName==null)
//                LogUtils.e("nulllllllllll");
            holder.tv_type_CarName.setText(result.get(position).getStyleName());
            holder.tv_price_range.setText("指导价："+result.get(position).getFactoryPrice());
            holder.tv_sign_up.setText(result.get(position).getContent());
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (callBack_3!=null){
                        callBack_3.onClick(position);
                    }
                }
            });
        }

    }

    @Override
    public int getItemCount() {
        return result==null?0:result.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private SimpleDraweeView img_typelogo;
        private TextView tv_type_CarName;
        private TextView tv_sign_up;
        private TextView tv_price_range;

        public ViewHolder(View itemView) {
            super(itemView);
        }
    }
    public  interface CallBack_3{
        void onClick(int position);
    }
}
