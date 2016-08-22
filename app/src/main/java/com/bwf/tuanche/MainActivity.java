package com.bwf.tuanche;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bwf.framwork.utils.IntentUtils;
import com.bwf.tuanche.Login.LoginActivity;
import com.bwf.tuanche.selectcity.SelectCityActivity;
import com.bwf.tuanche.test.ScanRecordActivity;
import com.bwf.tuanche.test.WebActivity;
import com.bwf.tuanche.update.UpdatePopupWindow;


public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private TextView tv_main_test;
    private Button btn_test,btn_pop,btn_login,btn_webview,btn_test_scint;
    private RelativeLayout main_layout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv_main_test = (TextView) findViewById(R.id.tv_main_test);
        btn_test_scint = (Button) findViewById(R.id.btn_test_scint);
        btn_test = (Button) findViewById(R.id.btn_test);
        btn_pop = (Button) findViewById(R.id.btn_pop);
        btn_login = (Button) findViewById(R.id.btn_login);
        btn_webview = (Button) findViewById(R.id.btn_webview);
        btn_test_scint.setOnClickListener(this);
        btn_test.setOnClickListener(this);
        btn_pop.setOnClickListener(this);
        btn_login.setOnClickListener(this);
        btn_webview.setOnClickListener(this);


        if (getIntent().getStringExtra("cityid") != null)
            tv_main_test.setText(getIntent().getStringExtra("cityid"));

        main_layout = (RelativeLayout) findViewById(R.id.main_layout);

    }


    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn_test_scint:
                IntentUtils.openActivity(MainActivity.this, ScanRecordActivity.class);
            break;
            case R.id.btn_pop:
                //弹出pop
                UpdatePopupWindow updatePopupWindow = new UpdatePopupWindow(MainActivity.this);
                updatePopupWindow.showAtLocation(main_layout, Gravity.CENTER,0,0);
            break;
            case R.id.btn_login:
                //跳转login界面
                IntentUtils.openActivity(MainActivity.this, LoginActivity.class);
            break;
            case R.id.btn_webview:
                //跳转vebview界面
                IntentUtils.openActivity(MainActivity.this, WebActivity.class);
            break;
            case R.id.btn_test:
                //跳转选择城市界面
                IntentUtils.openActivity(MainActivity.this, SelectCityActivity.class);
            break;

        }
    }
}
