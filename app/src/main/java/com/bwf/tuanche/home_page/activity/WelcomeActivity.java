package com.bwf.tuanche.home_page.activity;

import android.os.Handler;
import android.os.Message;
import android.view.View;

import com.bwf.framwork.base.BaseActivity;
import com.bwf.framwork.share.SharePrefreceHelper;
import com.bwf.framwork.utils.IntentUtils;
import com.bwf.tuanche.R;
import com.bwf.tuanche.home_page.MainActivity;

public class WelcomeActivity extends BaseActivity implements Handler.Callback {

    private Handler mHandler;

    @Override
    public int getContentViewId() {
        return R.layout.activity_welcome;
    }

    @Override
    public void beforeInitView() {
        mHandler = new Handler(this);
    }

    @Override
    public void initView() {
        mHandler.sendEmptyMessageDelayed(1, 3000);
    }

    @Override
    public void initData() {

    }

    @Override
    public void onClick(View view) {

    }

    @Override
    public boolean handleMessage(Message message) {

        switch (message.what) {
            case 1:
                if (SharePrefreceHelper.getInstence(WelcomeActivity.this).isFirst()){//是第一次进入则进入引导页面
                    IntentUtils.openActivity(this,GuideActivity.class);
                    finish();
                }else {
                    IntentUtils.openActivity(this, MainActivity.class);
                    finish();
                }

                break;
        }
        return false;
    }
}
