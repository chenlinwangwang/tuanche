package com.bwf.tuanche.selectcity;

import android.support.v7.widget.LinearLayoutManager;
import android.view.View;

import com.bwf.framwork.base.BaseActivity;
import com.bwf.tuanche.R;
import com.bwf.tuanche.selectcity.cityadapter.MyRecycleviewAdapter;

public class ScanRecordActivity extends BaseActivity {
    private MyRecyclerView myRecyclerView;
    private MyRecycleviewAdapter recycleviewAdapter;
    @Override
    public int getContentViewId() {
        return R.layout.activity_scan_record;
    }

    @Override
    public void beforeInitView() {

    }

    @Override
    public void initView() {
        myRecyclerView = findViewByIdNoCast(R.id.record_MyRecyclerView);
        recycleviewAdapter = new MyRecycleviewAdapter(this);
        //实例化一个layout布局（用于表示是那种布局  有LinerLayout，GridLayoutManager）
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,true);
//        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        myRecyclerView.setLayoutManager(linearLayoutManager);//加载布局
        myRecyclerView.setAdapter(recycleviewAdapter);
    }

    @Override
    public void initData() {

    }

    @Override
    public void onClick(View view) {

    }
}
