package com.bwf.tuanche;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import com.bwf.framwork.base.ReccleViewAdapter;
import com.bwf.framwork.bean.UserBean;
import com.bwf.framwork.http.HttpCallBack;
import com.bwf.framwork.http.HttpHelper;
import com.bwf.framwork.utils.IntentUtils;
import com.bwf.tuanche.selectcity.SelectCityActivity;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private TextView tv_test;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv_test = (TextView) findViewById(R.id.tv_main_test);
        tv_test.setText(getIntent().getStringExtra("cityid"));

        findViewById(R.id.btn_test).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                IntentUtils.openActivity(MainActivity.this, SelectCityActivity.class);
            }
        });







    }



}
