package com.bwf.tuanche.home_page.activity.fragment;

import android.view.View;
import android.widget.ImageView;

import com.bwf.framwork.base.BaseFragment;
import com.bwf.tuanche.R;

public class MyFragment extends BaseFragment {
    private int postion;


    public static MyFragment newInstance(int position) {
        MyFragment fragment = new MyFragment();
        fragment.postion = position;
        if (position==1){
        }
        return fragment;
    }
    @Override
    protected int getResource() {
        return R.layout.fragment_my;
    }

    @Override
    protected void beforeInitView() {


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
