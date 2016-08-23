package com.bwf.tuanche.home_page.fragment;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.bwf.framwork.base.BaseFragment;
import com.bwf.tuanche.R;
import com.bwf.tuanche.home_page.Bean.BannerBean;
import com.bwf.tuanche.home_page.adapter.Fragment_1_Banner_Adaptere;

import java.util.List;

public class Fragment_1_Banner extends BaseFragment {
    private List<BannerBean.Header_banner> header_banner;
    private Fragment_1_Banner_Adaptere adapter;
    private RecyclerView recycleview_fragment1_banner;
    private LinearLayoutManager manager;


    public void setHeader_banner(List<BannerBean.Header_banner> header_banner) {
        this.header_banner = header_banner;
        adapter.setHeader_banner(header_banner);
        adapter.notifyDataSetChanged();
    }

    @Override
    protected int getResource() {
        return R.layout.fragment_fragment_1__banner;
    }

    @Override
    protected void beforeInitView() {

        adapter=new Fragment_1_Banner_Adaptere(getContext());
        recycleview_fragment1_banner=findViewByIdNoCast(R.id.recycleview_fragment1_banner);
         manager=new LinearLayoutManager(getContext());
        manager.setOrientation(LinearLayoutManager.HORIZONTAL);
        recycleview_fragment1_banner.setLayoutManager(manager);
        recycleview_fragment1_banner.setAdapter(adapter);
    }

    @Override
    protected void initView(View rootView) {

    }

    @Override
    protected void initData() {

    }

    @Override
    public void onClick(View view) {

    }

}
