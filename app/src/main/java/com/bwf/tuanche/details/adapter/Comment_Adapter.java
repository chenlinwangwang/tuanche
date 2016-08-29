package com.bwf.tuanche.details.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.bwf.framwork.bean.CarDetailBean;
import com.bwf.framwork.bean.CommentList;
import com.bwf.framwork.image.ImageLoader;
import com.bwf.tuanche.R;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

/**
 * 作者/日期: admin on 2016/8/18.
 * 描述:
 */
public class Comment_Adapter extends RecyclerView.Adapter<Comment_Adapter.ViewHolder> {
    private Context context;
    private List<CommentList> commentList;

    public Comment_Adapter(Context context) {
        this.context = context;
    }

    public void setCarDetailBean(CarDetailBean carDetailBean) {
        if (carDetailBean != null)
            commentList = carDetailBean.comment.commentList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) { // view
        View view = View.inflate(context, R.layout.item_rv_comment, null);
        ViewHolder viewHolder = new ViewHolder(view);
        viewHolder.tv_member_name = (TextView) view.findViewById(R.id.tv_member_name);
        viewHolder.tv_evaluate_time = (TextView) view.findViewById(R.id.tv_evaluate_time);
        viewHolder.tv_content = (TextView) view.findViewById(R.id.tv_content);
        viewHolder.ratingBar = (RatingBar) view.findViewById(R.id.ratingBar);
        viewHolder.img_renzhen = (ImageView) view.findViewById(R.id.img_renzhen);
        viewHolder.sdv_member_photo = (SimpleDraweeView) view.findViewById(R.id.sdv_member_photo);
        viewHolder.sdv_phpto1 = (SimpleDraweeView) view.findViewById(R.id.sdv_phpto1);
        viewHolder.sdv_phpto2 = (SimpleDraweeView) view.findViewById(R.id.sdv_phpto2);
        viewHolder.sdv_phpto3 = (SimpleDraweeView) view.findViewById(R.id.sdv_phpto3);
        viewHolder.sdv_phpto4 = (SimpleDraweeView) view.findViewById(R.id.sdv_phpto4);
        viewHolder.sdv_phpto5 = (SimpleDraweeView) view.findViewById(R.id.sdv_phpto5);
        viewHolder.sdv_phpto6 = (SimpleDraweeView) view.findViewById(R.id.sdv_phpto6);
        viewHolder.sdv_imgs = new SimpleDraweeView[]{viewHolder.sdv_phpto1, viewHolder.sdv_phpto2, viewHolder.sdv_phpto3,
                viewHolder.sdv_phpto4, viewHolder.sdv_phpto5, viewHolder.sdv_phpto6,};
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {//数据逻辑
        if (commentList != null) {
            holder.tv_member_name.setText(commentList.get(position).userName);
            holder.tv_evaluate_time.setText(commentList.get(position).commentDate);
            holder.tv_content.setText(commentList.get(position).content);
            holder.ratingBar.setRating(Float.parseFloat(commentList.get(position).score));
            ImageLoader.getInstance().disPlayImage(holder.sdv_member_photo, commentList.get(position).memberPic);
            if (commentList.get(position).fine.equals("true"))
                holder.img_renzhen.setVisibility(View.VISIBLE);
            if (commentList.get(position).commentPicList != null) {
                for (int i = 0; i < commentList.get(position).commentPicList.size(); i++) {
                    holder.sdv_imgs[i].setVisibility(View.VISIBLE);
                    ImageLoader.getInstance().disPlayImage(holder.sdv_imgs[i],
                            commentList.get(position).commentPicList.get(i).uri);
                }
            }
        }
    }

    @Override
    public int getItemCount() {
        return commentList == null ? 0 : 3;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView tv_member_name, tv_evaluate_time, tv_content;
        public RatingBar ratingBar;
        public ImageView img_renzhen;
        public SimpleDraweeView sdv_member_photo, sdv_phpto1, sdv_phpto2, sdv_phpto3, sdv_phpto4, sdv_phpto5, sdv_phpto6;
        public SimpleDraweeView[] sdv_imgs;

        public ViewHolder(View itemView) {
            super(itemView);
        }
    }
}
