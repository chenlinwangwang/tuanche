package com.bwf.tuanche.home_page.activity;

import android.view.View;
import android.widget.TextView;

import com.bwf.framwork.base.BaseActivity;
import com.bwf.framwork.utils.IntentUtils;
import com.bwf.framwork.utils.ToastUtil;
import com.bwf.tuanche.R;
import com.bwf.tuanche.home_page.View.BottomView;
import com.bwf.tuanche.selectcity.ScanRecordActivity;

public class MyActivity extends BaseActivity {

    private BottomView bottomView;
    private TextView tv_my_record;
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
        tv_my_record = findViewByIdNoCast(R.id.tv_my_record);
        setOnClick(tv_my_record);
    }

    @Override
    public void initData() {

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.tv_my_record:
                IntentUtils.openActivity(this, ScanRecordActivity.class);
            break;
        }
    }
}
