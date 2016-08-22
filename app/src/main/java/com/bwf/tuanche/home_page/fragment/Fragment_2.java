package com.bwf.tuanche.home_page.fragment;

import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.AdapterView;

import com.bwf.framwork.base.BaseFragment;
import com.bwf.framwork.utils.ToastUtil;
import com.bwf.tuanche.R;
import com.bwf.tuanche.home_page.Bean.HotBrandBean;
import com.bwf.tuanche.home_page.adapter.Fragment_2_Adapter;

import java.util.ArrayList;
import java.util.List;

//热门品牌
public class Fragment_2 extends BaseFragment implements Fragment_2_Adapter.CallBack_2 {
    private List<HotBrandBean.ListBean> list;
    private Fragment_2_Adapter adapter;
    private RecyclerView fragment_2_recycleView;


    public void setList(List<HotBrandBean.ListBean> list) {
        this.list = list;
        adapter.setList(list);
        adapter.notifyDataSetChanged();
    }

    @Override
    protected int getResource() {
        return R.layout.fragment_fragment_2;
    }

    @Override
    protected void beforeInitView() {
        adapter = new Fragment_2_Adapter(getContext());
        fragment_2_recycleView = findViewByIdNoCast(R.id.fragment_2_recycleView);
        adapter.setCallBack_2(this);

    }

    @Override
    protected void initView(View rootView) {

    }

    @Override
    protected void initData() {
        GridLayoutManager layoutManager = new GridLayoutManager(getContext(), 3);
        fragment_2_recycleView.setLayoutManager(layoutManager);
        fragment_2_recycleView.setAdapter(adapter);
    }

    @Override
    public void onClick(View view) {

    }

    @Override
    public void onClick(int position) {
        ToastUtil.showToast("点击了：　　" + position);
    }
}
