package com.bwf.tuanche.home_page.fragment;

import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.bwf.framwork.base.BaseFragment;
import com.bwf.framwork.utils.IntentUtils;
import com.bwf.framwork.utils.ToastUtil;
import com.bwf.tuanche.R;
import com.bwf.tuanche.details.DetailsActivity;
import com.bwf.tuanche.home_page.Bean.HotTypeBean;
import com.bwf.tuanche.home_page.adapter.Fragment_3_Adapter;

import java.util.List;

//热门车型
public class Fragment_3 extends BaseFragment implements Fragment_3_Adapter.CallBack_3{

    private List<HotTypeBean> result;
    private Fragment_3_Adapter adapter;
    private RecyclerView fragment_3_recycleview;

    public void setResult(List<HotTypeBean> result) {
        this.result = result;
        adapter.setResult(result);
        adapter.notifyDataSetChanged();

    }

    @Override
    protected int getResource() {
        return R.layout.fragment_fragment_3;
    }

    @Override
    protected void beforeInitView() {
        adapter=new Fragment_3_Adapter(getContext());
        fragment_3_recycleview=findViewByIdNoCast(R.id.fragment_3_recycleview);
        adapter.setCallBack_3(this);

    }

    @Override
    protected void initView(View rootView) {
        GridLayoutManager layoutManager=new GridLayoutManager(getContext(),2);
        fragment_3_recycleview.setLayoutManager(layoutManager);
        fragment_3_recycleview.setAdapter(adapter);

    }

    @Override
    protected void initData() {

    }

    @Override
    public void onClick(View view) {

    }

    @Override
    public void onClick(int position) {
        Bundle bundle = new Bundle();
        bundle.putString("styleId",result.get(position).id + "");
        bundle.putString("brandId",result.get(position).brandId + "");
        IntentUtils.openActivity(getContext(), DetailsActivity.class,bundle);
    }
}
