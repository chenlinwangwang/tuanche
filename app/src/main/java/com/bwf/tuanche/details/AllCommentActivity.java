package com.bwf.tuanche.details;

import android.view.View;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.bwf.framwork.base.BaseActivity;
import com.bwf.framwork.bean.AllCommentBean;
import com.bwf.framwork.bean.CommentList;
import com.bwf.framwork.http.HttpCallBack;
import com.bwf.framwork.http.HttpHelper;
import com.bwf.framwork.utils.IntentUtils;
import com.bwf.framwork.utils.ToastUtil;
import com.bwf.framwork.utils.UrlUtils;
import com.bwf.tuanche.R;
import com.bwf.tuanche.details.adapter.AllCommentAdapter;
import com.bwf.tuanche.details.adapter.RefreshListView;
import com.bwf.tuanche.home_page.MainActivity;

import java.util.ArrayList;
import java.util.List;

public class AllCommentActivity extends BaseActivity {
    private RefreshListView addMore;
    private AllCommentAdapter adapter;
    private ImageView img_title_back;
    public String count, cityId, brandId;
    private RatingBar ratingBar_all;
    private TextView tv_all_comment, tv_all_price, tv_colonel_service, tv_4S_service;
    private int offset;
    private List<CommentList> totallist;

    @Override
    public int getContentViewId() {
        return R.layout.activity_all_comment;
    }

    @Override
    public void beforeInitView() {
        showPogressbar();
        cityId = getIntent().getStringExtra("cityId");
        brandId = getIntent().getStringExtra("brandId");
        //count=10&offset=1&cityId=156&brandId=31
        count = "10";
        offset = 1;
        totallist = new ArrayList<>();
    }

    @Override
    public void initView() {
        img_title_back = findViewByIdNoCast(R.id.img_title_back);
        ratingBar_all = findViewByIdNoCast(R.id.ratingBar_all);
        tv_all_comment = findViewByIdNoCast(R.id.tv_all_comment);
        tv_all_price = findViewByIdNoCast(R.id.tv_all_price);
        tv_colonel_service = findViewByIdNoCast(R.id.tv_colonel_service);
        tv_4S_service = findViewByIdNoCast(R.id.tv_4S_service);
        addMore = findViewByIdNoCast(R.id.addMore);
        setOnClick(img_title_back);
    }

    @Override
    public void initData() {

        adapter = new AllCommentAdapter(this);
        addMore.setAdapter(adapter);
        addMore.setOnLoadMoreListener(new RefreshListView.OnLoadMoreListener() {
            @Override
            public void loadMore() {
                offset++;
                getData();
            }

            @Override
            public void onRefresh() {
                offset = 1;
                totallist.clear();
                getData();
            }
        });
        getData();
    }

    public void getData() {
        HttpHelper.getAllComment(UrlUtils.CAR_BUY_EVALUATE, count, offset + "", cityId, brandId,
                new HttpCallBack<AllCommentBean>() {
                    @Override
                    public void onSuccess(AllCommentBean result) {
                        dissmissProgressbar();
                        addMore.setOnComplete();//加载完成动画消失
                        if (result != null) {
                            setAllCommentText(result);//设置文字内容
                            totallist.addAll(result.commentList);
                            adapter.setCommentList(totallist);
                            adapter.notifyDataSetChanged();
                        }
                    }

                    @Override
                    public void onFail(String errMsg) {
                        dissmissProgressbar();
                        addMore.setOnComplete();
                    }
                }
        );
    }

    public void setAllCommentText(AllCommentBean allComment) {
        ratingBar_all.setRating(Float.parseFloat(allComment.commentTotal));
        tv_all_comment.setText(allComment.commentTotal);
        tv_all_price.setText(allComment.priceScore);
        tv_colonel_service.setText(allComment.salerScore);
        tv_4S_service.setText(allComment.shopScore);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.img_title_back:
                IntentUtils.openActivity(this, MainActivity.class);
                break;
        }
    }
}
