package com.bwf.tuanche.home_page.activity;

import android.view.View;

import com.bwf.framwork.base.BaseActivity;
import com.bwf.framwork.utils.ToastUtil;
import com.bwf.tuanche.R;
import com.bwf.tuanche.home_page.View.BottomView;

public class MyActivity extends BaseActivity {

private BottomView bottomView;
    @Override
    public int getContentViewId() {
        return R.layout.activity_my;
    }

    @Override
    public void beforeInitView() {
        bottomView= (BottomView) findViewById(R.id.bottomview);
        bottomView.setSelect(3);
    }

    @Override
    public void initView() {
    }

    @Override
    public void initData() {

    }

    @Override
    public void onClick(View view) {

    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        finish();
    }
}
