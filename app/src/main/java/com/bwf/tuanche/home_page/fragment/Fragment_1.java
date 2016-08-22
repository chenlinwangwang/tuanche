package com.bwf.tuanche.home_page.fragment;

import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.bwf.framwork.base.BaseFragment;
import com.bwf.framwork.utils.ToastUtil;
import com.bwf.tuanche.R;
import com.bwf.tuanche.home_page.Bean.ResultBean;
import com.bwf.tuanche.home_page.adapter.Fragment_1_Adapter;

import java.util.List;

//低价购车、汽车贴膜。。。。
public class Fragment_1 extends BaseFragment implements Fragment_1_Adapter.CallBack_1{
    private List<ResultBean.Nc> ncs;
    private Fragment_1_Adapter adapter;
    private RecyclerView recyclerView;
    private View headView;
    private GridLayoutManager layoutManager;

    public void setNcs(List<ResultBean.Nc> ncs) {
        this.ncs = ncs;
        adapter.setNcs(ncs);
        adapter.notifyDataSetChanged();
    }


    @Override
    protected int getResource() {
        return R.layout.fragment_fragment_1;
    }

    @Override
    protected void beforeInitView() {
        adapter = new Fragment_1_Adapter(getContext());
        headView = View.inflate(getContext(), R.layout.headview_listview, null);
        adapter.setCallBack_1(this);

    }

    @Override
    protected void initView(View rootView) {

    }

    @Override
    protected void initData() {
        recyclerView = findViewByIdNoCast(R.id.recycleview);
        layoutManager = new GridLayoutManager(getContext(), 4);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void onClick(View view) {

    }

    @Override
    public void onClick(int position) {
        switch (position){
            case 0:
                ToastUtil.showToast("position:  "+position);
                break;
            case 1:
                ToastUtil.showToast("position:  "+position);
                break;
            case 2:
                ToastUtil.showToast("position:  "+position);
                break;
            case 3:
                ToastUtil.showToast("position:  "+position);
                break;
        }
    }
}
