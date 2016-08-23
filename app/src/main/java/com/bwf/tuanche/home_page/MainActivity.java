package com.bwf.tuanche.home_page;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.widget.SwipeRefreshLayout;
import android.util.Log;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Switch;
import android.widget.TextView;

import com.baidu.location.LocationClient;
import com.baidu.location.LocationClientOption;
import com.bwf.framwork.base.BaseActivity;
import com.bwf.framwork.http.HttpArrayCallBack;
import com.bwf.framwork.http.HttpHelper;
import com.bwf.framwork.utils.IntentUtils;
import com.bwf.framwork.utils.LogUtils;
import com.bwf.framwork.utils.ToastUtil;
import com.bwf.framwork.utils.UrlUtils;
import com.bwf.tuanche.Login.LoginActivity;
import com.bwf.tuanche.R;
import com.bwf.tuanche.home_page.Bean.BannerBean;
import com.bwf.tuanche.home_page.Bean.HotBrandBean;
import com.bwf.tuanche.home_page.Bean.HotTypeBean;
import com.bwf.tuanche.home_page.Bean.ResultBean;
import com.bwf.tuanche.home_page.View.BottomView;
import com.bwf.tuanche.home_page.fragment.Fragment_1;
import com.bwf.tuanche.home_page.fragment.Fragment_1_Banner;
import com.bwf.tuanche.home_page.fragment.Fragment_2;
import com.bwf.tuanche.home_page.fragment.Fragment_3;
import com.bwf.tuanche.home_page.fragment.Fragment_4;
import com.bwf.tuanche.home_page.fragment.Fragment_5;
import com.bwf.tuanche.selectcity.SelectCityActivity;
import com.bwf.tuanche.selectcity.baidumap.BaiDuLocationListener;
import com.bwf.tuanche.selectcity.citylistresultbean.NowCityBean;
import com.bwf.tuanche.update.UpdatePopupWindow;

import java.util.List;

public class MainActivity extends BaseActivity implements SwipeRefreshLayout.OnRefreshListener, Handler.Callback,BaiDuLocationListener.LocalCityListener {

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
    private TextView select_city_chick,tv_order;
    private View main_view;
    //百度定位
    private LocationClient mLocationClient;
    //百度定位返回参数类
    private BaiDuLocationListener baiDuLocationListener = new BaiDuLocationListener(this);
    private String cityId;
    private String cityName;


    @Override
    public int getContentViewId() {
        return R.layout.activity_main;
    }

    @Override
    public void beforeInitView() {
        String nowcityId = getIntent().getStringExtra("cityid");
        String nowcityname = getIntent().getStringExtra("cityname");
//        Log.e("taa",nowcityId + nowcityname+"+++++++++++++++");
        if (nowcityId != null && nowcityname != null){
            cityId = nowcityId;
            cityName = nowcityname;

        }
        handler.sendEmptyMessageDelayed(2,1000);
    }




    /**
     * 初始化百度定位参数
     */
    private void initLocation(){
        LocationClientOption option = new LocationClientOption();
        option.setLocationMode(LocationClientOption.LocationMode.Hight_Accuracy);//可选，默认高精度，设置定位模式，高精度，低功耗，仅设备
        option.setCoorType("bd09ll");//可选，默认gcj02，设置返回的定位结果坐标系
//        int span=1000;
//        option.setScanSpan(span);//可选，默认0，即仅定位一次，设置发起定位请求的间隔需要大于等于1000ms才是有效的
        option.setIsNeedAddress(true);//可选，设置是否需要地址信息，默认不需要
        option.setOpenGps(true);//可选，默认false,设置是否使用gps
        option.setLocationNotify(true);//可选，默认false，设置是否当gps有效时按照1S1次频率输出GPS结果
        option.setIsNeedLocationDescribe(true);//可选，默认false，设置是否需要位置语义化结果，可以在BDLocation.getLocationDescribe里得到，结果类似于“在北京天安门附近”
        option.setIsNeedLocationPoiList(true);//可选，默认false，设置是否需要POI结果，可以在BDLocation.getPoiList里得到
        option.setIgnoreKillProcess(false);//可选，默认true，定位SDK内部是一个SERVICE，并放到了独立进程，设置是否在stop的时候杀死这个进程，默认不杀死
        option.SetIgnoreCacheException(false);//可选，默认false，设置是否收集CRASH信息，默认收集
        option.setEnableSimulateGps(false);//可选，默认false，设置是否需要过滤gps仿真结果，默认需要
        mLocationClient.setLocOption(option);
    }


    @Override
    public void initView() {
        main_view = findViewByIdNoCast(R.id.main_view);
        select_city_chick = findViewByIdNoCast(R.id.select_city_chick);
        tv_order = findViewByIdNoCast(R.id.tv_order);
        setOnClick(select_city_chick,tv_order);
        fragment_1 = (Fragment_1) getSupportFragmentManager().findFragmentById(R.id.fragment_1);
        fragment_2 = (Fragment_2) getSupportFragmentManager().findFragmentById(R.id.fragment_2);
        fragment_3 = (Fragment_3) getSupportFragmentManager().findFragmentById(R.id.fragment_3);
        fragment_4 = (Fragment_4) getSupportFragmentManager().findFragmentById(R.id.fragment_4);
        fragment_5 = (Fragment_5) getSupportFragmentManager().findFragmentById(R.id.fragment_5);
        fragment_1_banner = (Fragment_1_Banner) getSupportFragmentManager().findFragmentById(R.id.fragment_1_banner);


        bottomView = (BottomView) findViewById(R.id.bottomview_main);
        relativeLayout = findViewByIdNoCast(R.id.rl_bottomview);
//        View view=relativeLayout.getChildAt(0);
        if (!MainActivity.this.isFinishing()) {
            bottomView.setSelect(0);
        }


        refreshLayout = findViewByIdNoCast(R.id.SwipeRefreshLayout);
        refreshLayout.setOnRefreshListener(this);
        refreshLayout.setProgressViewOffset(false, 0,
                (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()

                ));
    }

    @Override
    public void initData() {

        baiDuLocation();

        //设置当前城市
        select_city_chick.setText(cityName);
        getBuyCar();
        getDataType();
        getData();
        getBannerData();


    }

    public void baiDuLocation(){
        if (cityId != null)
            return;
        //百度定位
        showPogressbar();
        //初始化百度定位对象
        mLocationClient = new LocationClient(getApplicationContext());     //声明LocationClient类
        //实现监听接口
        mLocationClient.registerLocationListener( baiDuLocationListener );    //注册监听函数
        //设置百度定位的参数
        initLocation();
        //开启定位（获取当前位置的参数（只需经纬度））
        mLocationClient.start();
    }

    public void getBuyCar(){
        HttpHelper.getDetail_1(UrlUtils.BUY_CAR, cityId, new com.bwf.framwork.db.HttpCallBack<ResultBean>() {
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

        HttpHelper.getHotBrand(UrlUtils.HOT_BRAND, "2", cityId, new com.bwf.framwork.db.HttpCallBack<HotBrandBean>() {
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
        HttpHelper.getHotType(UrlUtils.HOT_TYPE, "20", "10", cityId, new HttpArrayCallBack<HotTypeBean>() {

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
        HttpHelper.getBannerData(UrlUtils.BANNER, cityId, new com.bwf.framwork.db.HttpCallBack<BannerBean>() {
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
        }
        );
    }

    @Override
    public void onClick(View view) {
        switch(view.getId()){
            case R.id.select_city_chick://选择城市
                String nowcoty = (String) select_city_chick.getText();
                Bundle bundle = new Bundle();
                bundle.putString("nowcity",nowcoty);
                IntentUtils.openActivity(this, SelectCityActivity.class,bundle);
            break;
            case R.id.tv_order://
                UpdatePopupWindow update = new UpdatePopupWindow(this);
                update.setShowAtLocation(main_view, Gravity.CENTER,0,0);
            break;

        }

    }

    @Override
    public void onRefresh() {

        refreshLayout.postDelayed(new Runnable() {
            @Override
            public void run() {
                refreshLayout.setRefreshing(false);
            }
        },1000);
        getBuyCar();
        getDataType();
        getData();
        getBannerData();
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
            case 2:
                //更新
                UpdatePopupWindow update = new UpdatePopupWindow(this);
                update.setShowAtLocation(main_view, Gravity.CENTER,0,0);
                break;
        }
        return false;
    }

    //
    @Override
    public void longitudeAndLatitude(String longitude, String Latitude) {
        //拿到回调回来的经纬度,并请求数据
        addNowCity(longitude,Latitude);
        //拿到数据之后就关闭当前定位
        mLocationClient.stop();
    }

    private NowCityBean nowCityBean;
    //加载当前城市与相关数据
    public void addNowCity(String longitude,String latitude){
        //根据当前位置的经纬度去请求当前的城市
        HttpHelper.getNowCity(UrlUtils.QueryCityByLatitude, longitude, latitude, new com.bwf.framwork.db.HttpCallBack<NowCityBean>() {
            @Override
            public void onSuccess(NowCityBean result) {
//                Log.e("nowcity",result.name+"");
                nowCityBean = result;
                //设置当前城市
                select_city_chick.setText(result.name);
                cityId = result.id+"";
                dissmissProgressbar();

                getBuyCar();
                getDataType();
                getData();
                getBannerData();

            }

            @Override
            public void onFail(String errMsg) {

            }
        });

    }

    @Override
    protected void onResume() {
        super.onResume();

    }
}
