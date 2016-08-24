package com.bwf.tuanche.home_page.activity;

import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.widget.Button;

import com.bwf.framwork.base.BaseActivity;
import com.bwf.tuanche.R;
import com.bwf.tuanche.home_page.View.BottomView;

public class ServerActivity extends BaseActivity {
    private BottomView bottomview;
    private Button btn_dial;

    @Override
    public int getContentViewId() {
        return R.layout.activity_server;
    }

    @Override
    public void beforeInitView() {
        bottomview = findViewByIdNoCast(R.id.bottomview);
        bottomview.setSelect(2);
        btn_dial = findViewByIdNoCast(R.id.btn_dial);
        btn_dial.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + "4006969123"));
                startActivity(intent);
            }
        });
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
}
