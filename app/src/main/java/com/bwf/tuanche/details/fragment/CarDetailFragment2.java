package com.bwf.tuanche.details.fragment;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.webkit.WebView;
import android.widget.RatingBar;
import android.widget.TextView;
import com.bwf.framwork.base.BaseFragment;
import com.bwf.framwork.bean.CarDetailBean;
import com.bwf.framwork.utils.IntentUtils;
import com.bwf.framwork.utils.UrlUtils;
import com.bwf.tuanche.R;
import com.bwf.tuanche.details.AllCommentActivity;
import com.bwf.tuanche.details.adapter.Comment_Adapter;
import com.bwf.tuanche.details.adapter.DividerItemDecoration;

public class CarDetailFragment2 extends BaseFragment {
    private WebView webView1, webView2;
    private RatingBar ratingBar;
    private TextView tv_grade, tv_all_evaluate;
    private RecyclerView rv_comment;
    private CarDetailBean carDetailBean;
    private Comment_Adapter comment_Adapter;

    public void setCarDetailBean(CarDetailBean carDetailBean) {
        this.carDetailBean = carDetailBean;
        initData();
    }

    @Override
    protected int getResource() {
        return R.layout.fragment_car_detail_fragment2;
    }

    @Override
    protected void beforeInitView() {
    }

    @Override
    protected void initView(View rootView) {
        webView1 = findViewByIdNoCast(R.id.webView1);
        webView2 = findViewByIdNoCast(R.id.webView2);
        ratingBar = findViewByIdNoCast(R.id.ratingBar2);
        tv_grade = findViewByIdNoCast(R.id.tv_grade);
        tv_all_evaluate = findViewByIdNoCast(R.id.tv_all_evaluate);
        setOnClick(tv_all_evaluate);
        rv_comment = findViewByIdNoCast(R.id.rv_comment);
        rv_comment.addItemDecoration(new DividerItemDecoration(getContext(),LinearLayoutManager.VERTICAL));
    }

    @Override
    protected void initData() {
        webView1.loadUrl(UrlUtils.CAR_BUY_NOGROUP);
        webView2.loadUrl(UrlUtils.CAR_BUY_QUESTION);
        if (carDetailBean != null){
            tv_grade.setText(carDetailBean.comment.commentTotal + "分");
            ratingBar.setRating(Float.parseFloat(carDetailBean.comment.commentTotal));
            tv_all_evaluate.setText("查看全部" + carDetailBean.comment.count + "人评价");

            comment_Adapter = new Comment_Adapter(getContext());
            comment_Adapter.setCarDetailBean(carDetailBean);
            LinearLayoutManager manager = new LinearLayoutManager(getContext());
            rv_comment.setLayoutManager(manager);
            rv_comment.setAdapter(comment_Adapter);
            comment_Adapter.notifyDataSetChanged();
        }
    }

    @Override
    public void onClick(View view) {
        if (view == tv_all_evaluate) {
            Bundle bundle = new Bundle();
            bundle.putString("cityId","156");
            bundle.putString("brandId",carDetailBean.brandId);
            IntentUtils.openActivity(getActivity(), AllCommentActivity.class,bundle);
        }
    }

}
