package com.bwf.tuanche.selectcity.cityadapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bwf.framwork.image.ImageLoader;
import com.bwf.tuanche.R;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.view.SimpleDraweeView;

/**
 * Created by ZWP on 2016/8/23.
 * Explain:
 */
public class MyRecycleviewAdapter extends RecyclerView.Adapter<MyRecycleviewAdapter.MyRecyclerViewHolder> {
    private Context context;
    private String[] imgUrl = {"http://pic.tuanche.com/car/20150420/14295244097434751_s.jpg","http://pic.tuanche.com/car/20150420/14295243876577141_s.jpg",
            "http://pic.tuanche.com/car/20150420/14295247615226375_s.jpg","http://pic.tuanche.com/car/20150420/14295247494442177_s.jpg",
            "http://pic.tuanche.com/car/20150420/14295247951369762_s.jpg","http://pic.tuanche.com/car/20150420/14295243711442986_s.jpg",
            "http://pic.tuanche.com/car/20150420/14295247170072375_s.jpg"};

    public MyRecycleviewAdapter(Context context) {
        this.context = context;
    }

    public void setImgUrl(String[] imgUrl) {
        this.imgUrl = imgUrl;
    }

    @Override
    public MyRecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //初始化ViewHolder
        View view = View.inflate(context, R.layout.my_rescycle_item,null);
        MyRecyclerViewHolder myRecyclerViewHolder = new MyRecyclerViewHolder(view);
        myRecyclerViewHolder.img_record = (SimpleDraweeView) view.findViewById(R.id.img_record);
        myRecyclerViewHolder.tv_record_name = (TextView) view.findViewById(R.id.tv_record_name);
        myRecyclerViewHolder.tv_record_price = (TextView) view.findViewById(R.id.tv_record_price);
        myRecyclerViewHolder.tv_test = (TextView) view.findViewById(R.id.tv_test);
        return myRecyclerViewHolder;

    }

    @Override
    public void onBindViewHolder(MyRecyclerViewHolder holder, int position) {
        //ViewHolder的执行操作
        ImageLoader.getInstance().disPlayImage(holder.img_record,imgUrl[position]);//加载图片
    }

    @Override
    public int getItemCount() {
        return imgUrl == null ? 0 : imgUrl.length;
    }


    public class MyRecyclerViewHolder extends RecyclerView.ViewHolder{
        public TextView tv_record_name,tv_record_price,tv_test;
        public SimpleDraweeView img_record;;

        public MyRecyclerViewHolder(View itemView) {
            super(itemView);
        }
    }

}
