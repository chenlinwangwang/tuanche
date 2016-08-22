package com.bwf.tuanche.home_page.fragment;

import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.bwf.framwork.base.BaseFragment;
import com.bwf.framwork.utils.ToastUtil;
import com.bwf.tuanche.R;
import com.bwf.tuanche.home_page.Bean.BannerBean;
import com.bwf.tuanche.home_page.adapter.Fragment_4_Adapter;

import java.util.List;
//广告条（买团车车险、一亿元保障金）
public class Fragment_4 extends BaseFragment implements Fragment_4_Adapter.CallBack_4{
    private List<BannerBean.Center_banner> center_banner;
    private Fragment_4_Adapter adapter;
    private RecyclerView recycleView_fragment_4;

    public void setCenter_banner(List<BannerBean.Center_banner> center_banner) {
        this.center_banner = center_banner;
        adapter.setCenter_banner(center_banner);
        adapter.notifyDataSetChanged();
    }

    @Override
    protected int getResource() {
        return R.layout.fragment_fragment_4;
    }

    @Override
    protected void beforeInitView() {
        recycleView_fragment_4=findViewByIdNoCast(R.id.recycleView_fragment_4);
        adapter=new Fragment_4_Adapter(getContext());
        GridLayoutManager manager=new GridLayoutManager(getContext(),2);
        recycleView_fragment_4.setLayoutManager(manager);
        recycleView_fragment_4.setAdapter(adapter);
        adapter.setCallBack_4(this);

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

    @Override
    public void onClick(int position) {
        ToastUtil.showToast("点击了： "+position);
    }
}
