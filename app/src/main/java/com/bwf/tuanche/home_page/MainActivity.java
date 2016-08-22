package com.bwf.tuanche.home_page;

import android.os.Handler;
import android.os.Message;
import android.support.v4.widget.SwipeRefreshLayout;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.View;
import android.widget.RelativeLayout;

import com.bwf.framwork.base.BaseActivity;
import com.bwf.framwork.base.BaseBean;
import com.bwf.framwork.http.HttpArrayCallBack;
import com.bwf.framwork.http.HttpCallBack;
import com.bwf.framwork.http.HttpHelper;
import com.bwf.framwork.utils.LogUtils;
import com.bwf.framwork.utils.ToastUtil;
import com.bwf.framwork.utils.UrlUtils;
import com.bwf.tuanche.R;
import com.bwf.tuanche.home_page.Bean.BannerBean;
import com.bwf.tuanche.home_page.Bean.HotBrandBean;
import com.bwf.tuanche.home_page.Bean.HotTypeBean;
import com.bwf.tuanche.home_page.Bean.ResultBean;
import com.bwf.tuanche.home_page.View.BottomView;
import com.bwf.tuanche.home_page.activity.MyActivity;
import com.bwf.tuanche.home_page.fragment.Fragment_1;
import com.bwf.tuanche.home_page.fragment.Fragment_1_Banner;
import com.bwf.tuanche.home_page.fragment.Fragment_2;
import com.bwf.tuanche.home_page.fragment.Fragment_3;
import com.bwf.tuanche.home_page.fragment.Fragment_4;
import com.bwf.tuanche.home_page.fragment.Fragment_5;

import java.util.List;

public class MainActivity extends BaseActivity implements SwipeRefreshLayout.OnRefreshListener, Handler.Callback {

    private Fragment_1 fragment_1;
    private Fragment_2 fragment_2;
    private Fragment_3 fragment_3;
    private Fragment_4 fragment_4;
    private Fragment_5 fragment_5;
    private Fragment_1_Banner fragment_1_banner;
    private SwipeRefreshLayout refreshLayout;
    private Handler handler = new Handler(this);
    private BottomView bottomView;
    private RelativeLayout relativeLayout;

    @Override
    public int getContentViewId() {
        return R.layout.activity_main;
    }

    @Override
    public void beforeInitView() {
        fragment_1 = (Fragment_1) getSupportFragmentManager().findFragmentById(R.id.fragment_1);
        fragment_2 = (Fragment_2) getSupportFragmentManager().findFragmentById(R.id.fragment_2);
        fragment_3 = (Fragment_3) getSupportFragmentManager().findFragmentById(R.id.fragment_3);
        fragment_4 = (Fragment_4) getSupportFragmentManager().findFragmentById(R.id.fragment_4);
        fragment_5 = (Fragment_5) getSupportFragmentManager().findFragmentById(R.id.fragment_5);
        fragment_1_banner = (Fragment_1_Banner) getSupportFragmentManager().findFragmentById(R.id.fragment_1_banner);


        bottomView = (BottomView) findViewById(R.id.bottomview_main);
        relativeLayout = findViewByIdNoCast(R.id.rl_bottomview);
//        View view=relativeLayout.getChildAt(0);
        if (!MainActivity.this.isFinishing()){
            bottomView.setSelect(0);
        }


        refreshLayout = findViewByIdNoCast(R.id.SwipeRefreshLayout);
        refreshLayout.setOnRefreshListener(this);
        refreshLayout.setProgressViewOffset(false, 0,
                (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()

                ));
    }

    @Override
    public void initView() {
        getDataType();
        getData();
        getBannerData();


    }

    @Override
    public void initData() {
        HttpHelper.getDetail_1(UrlUtils.BUY_CAR, "156", new HttpCallBack<ResultBean>() {
            @Override
            public void onSuccess(ResultBean result) {
//                LogUtils.e("tag", "result:　" + result.getNc());
                if (result.nc != null) {
                    fragment_1.setNcs(result.nc);
                }
            }

            @Override
            public void onFail(String errMsg) {

            }
        });
    }

    public void getData() {//获取热门品牌数据
        showPogressbar();
        HttpHelper.getHotBrand(UrlUtils.HOT_BRAND, "2", "156", new HttpCallBack<HotBrandBean>() {
            @Override
            public void onSuccess(HotBrandBean result) {
                LogUtils.e("Tag", "热门品牌：" + result.getList());
                List<HotBrandBean.ListBean> newList = result.list;
//                newList.add(new HotBrandBean.ListBean("更多","more"));
                fragment_2.setList(newList);
                dissmissProgressbar();
            }

            @Override
            public void onFail(String errMsg) {
                dissmissProgressbar();
            }
        });

    }

    public void getDataType() {//获取热门车型数据
        HttpHelper.getHotType(UrlUtils.HOT_TYPE, "20", "10", "156", new HttpArrayCallBack<HotTypeBean>() {

            @Override
            public void onSuccess(List<HotTypeBean> result) {
//                LogUtils.e("Tag","热门车型: "+""+result);
                fragment_3.setResult(result);
            }

            @Override
            public void onFail(String errMsg) {

            }
        });
    }

    public void getBannerData() {//获取横幅广告数据
        HttpHelper.getBannerData(UrlUtils.BANNER, "156", new HttpCallBack<BannerBean>() {


            @Override
            public void onSuccess(BannerBean result) {
                LogUtils.e("Tag", "广告横幅1：　　" + result);
                LogUtils.e("Tag", "广告横幅2：　　" + result.header_banner);
                LogUtils.e("Tag", "广告横幅3：　　" + result.position_banner);
                fragment_1_banner.setHeader_banner(result.header_banner);
                fragment_4.setCenter_banner(result.center_banner);
                fragment_5.setPosition_banner(result.position_banner);
            }

            @Override
            public void onFail(String errMsg) {

            }
        });

    }

    @Override
    public void onClick(View view) {

    }

    @Override
    public void onRefresh() {
                ToastUtil.showToast("更新数据");
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        refreshLayout.setVisibility(View.INVISIBLE);//
                    }
                });
            }
        });
    }

    private static final int TIMES = 2000;
    private boolean isBack = true;

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (event.getAction() == KeyEvent.ACTION_DOWN && keyCode == KeyEvent.KEYCODE_BACK) {//按下返回键
            if (isBack) {
                ToastUtil.showToast("再次点击退出");
                isBack = false;
                handler.sendEmptyMessageDelayed(1, 2000);
            } else {
                System.exit(0);//退出应用
            }
            return false;
        }

        return super.onKeyDown(keyCode, event);
    }

    @Override
    public boolean handleMessage(Message message) {
        switch (message.what) {
            case 1:
                isBack = true;
                break;
        }
        return false;
    }
}
