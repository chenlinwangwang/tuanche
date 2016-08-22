package com.bwf.tuanche.selectcity;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.baidu.location.LocationClient;
import com.baidu.location.LocationClientOption;
import com.bwf.framwork.base.BaseActivity;
import com.bwf.framwork.base.BaseBean;
import com.bwf.framwork.http.HttpCallBack;
import com.bwf.framwork.http.HttpHelper;
import com.bwf.framwork.utils.IntentUtils;
import com.bwf.framwork.utils.ListViewUtils;
import com.bwf.framwork.utils.StringUtils;
import com.bwf.framwork.utils.UrlUtils;
import com.bwf.tuanche.MainActivity;
import com.bwf.tuanche.R;
import com.bwf.tuanche.selectcity.baidumap.BaiDuLocationListener;
import com.bwf.tuanche.selectcity.cityadapter.AllCityAdapter;
import com.bwf.tuanche.selectcity.citylistresultbean.CityResultBean;
import com.bwf.tuanche.selectcity.citylistresultbean.NowCityBean;
import com.bwf.tuanche.selectcity.citylistresultbean.openCitysBean;

import java.util.ArrayList;
import java.util.List;

public class SelectCityActivity extends BaseActivity implements BaiDuLocationListener.LocalCityListener{

    //百度定位
    private LocationClient mLocationClient;
    //百度定位返回参数类
    private BaiDuLocationListener baiDuLocationListener = new BaiDuLocationListener(this);

    private String longitude;//经度
    private String latitude;//纬度
    private TextView select_city_title;//title当前城市
    private TextView tv_NowCity;//当前城市
    private TextView select_city_rim_city1,select_city_rim_city2,select_city_rim_city3,select_city_rim_city4;//周边城市
    //热门城市
    private TextView select_city_hot_city1,select_city_hot_city2,select_city_hot_city3,select_city_hot_city4,select_city_hot_city5,select_city_hot_city6,select_city_hot_city7,select_city_hot_city8;
    private LinearLayout ll_city_list;
    private CityResultBean cityResultBean;
    private AllCityAdapter allCityAdapter;
    private NowCityBean nowCityBean;

    @Override
    public int getContentViewId() {
        return R.layout.activity_select_city;
    }

    @Override
    public void beforeInitView() {
        //初始化百度定位对象
        mLocationClient = new LocationClient(getApplicationContext());     //声明LocationClient类
        //实现监听接口
        mLocationClient.registerLocationListener( baiDuLocationListener );    //注册监听函数
        //设置百度定位的参数
        initLocation();
        //开启定位（获取当前位置的参数（只需经纬度））
        mLocationClient.start();
    }

    @Override
    public void initView() {

        select_city_title = findViewByIdNoCast(R.id.select_city_title);
        tv_NowCity = findViewByIdNoCast(R.id.tv_NowCity);


        ll_city_list = findViewByIdNoCast(R.id.ll_city_list);
        //周边城市
        select_city_rim_city1 = findViewByIdNoCast(R.id.select_city_rim_city1);
        select_city_rim_city2 = findViewByIdNoCast(R.id.select_city_rim_city2);
        select_city_rim_city3 = findViewByIdNoCast(R.id.select_city_rim_city3);
        select_city_rim_city4 = findViewByIdNoCast(R.id.select_city_rim_city4);
        //热门城市
        select_city_hot_city1 = findViewByIdNoCast(R.id.select_city_hot_city1);
        select_city_hot_city2 = findViewByIdNoCast(R.id.select_city_hot_city2);
        select_city_hot_city3 = findViewByIdNoCast(R.id.select_city_hot_city3);
        select_city_hot_city4 = findViewByIdNoCast(R.id.select_city_hot_city4);
        select_city_hot_city5 = findViewByIdNoCast(R.id.select_city_hot_city5);
        select_city_hot_city6 = findViewByIdNoCast(R.id.select_city_hot_city6);
        select_city_hot_city7 = findViewByIdNoCast(R.id.select_city_hot_city7);
        select_city_hot_city8 = findViewByIdNoCast(R.id.select_city_hot_city8);

        //设置监听
        setOnClick(select_city_rim_city1,select_city_rim_city2,select_city_rim_city3,select_city_rim_city4);
        setOnClick(select_city_hot_city1,select_city_hot_city2,select_city_hot_city3,select_city_hot_city4);
        setOnClick(select_city_hot_city5,select_city_hot_city6,select_city_hot_city7,select_city_hot_city8);

    }

    @Override
    public void initData() {


        //请求城市数据
        HttpHelper.getSelsctCityDetail(UrlUtils.Getcitys, new HttpCallBack<CityResultBean>() {
            @Override
            public void onSuccess(CityResultBean result) {
                Log.e("result",result+"");
                cityResultBean = result;
                //加载热门城市
                addHotCity();
                List<openCitysBean> openCitysBean = cityResultBean.openCitys;
                String firstpy = openCitysBean.get(0).py;
                String fir = firstpy.substring(0,1);
                addAllCity(fir);//加载第一个位置
                for (int i = 0 ; i < openCitysBean.size();i++){
                    String nextpy = openCitysBean.get(i).py;
                    String nex = nextpy.substring(0,1);
                    if (!fir.equals(nex)){
                        fir = nex;
                        //加载同一类的城市
                        addAllCity(fir);
                    }
                }
            }

            @Override
            public void onFail(String errMsg) {
                Log.e("errMsg",errMsg);
            }
        });





    }

    //加载周边城市
    public void addRimCity(String longitude,String latitude){
        //根据当前位置的经纬度去请求当前的城市
        HttpHelper.getNowCity(UrlUtils.QueryCityByLatitude, longitude, latitude, new HttpCallBack<NowCityBean>() {
            @Override
            public void onSuccess(NowCityBean result) {
                Log.e("nowcity",result.name+"");
                nowCityBean = result;
                //设置当前城市
                String LocalCityName = String.format("当前城市-%s",result.name);
                select_city_title.setText(LocalCityName);
                tv_NowCity.setText(result.name);
                //定死几个周边城市


            }

            @Override
            public void onFail(String errMsg) {

            }
        });

    }

    //加载热门城市
    public void addHotCity(){

        if (cityResultBean!=null){
            select_city_hot_city1.setText(cityResultBean.hotCitys.get(0).name);
            select_city_hot_city2.setText(cityResultBean.hotCitys.get(1).name);
            select_city_hot_city3.setText(cityResultBean.hotCitys.get(2).name);
            select_city_hot_city4.setText(cityResultBean.hotCitys.get(3).name);
            select_city_hot_city5.setText(cityResultBean.hotCitys.get(4).name);
            select_city_hot_city6.setText(cityResultBean.hotCitys.get(5).name);
            select_city_hot_city7.setText(cityResultBean.hotCitys.get(6).name);
            select_city_hot_city8.setText(cityResultBean.hotCitys.get(7).name);
        }
    }

    //加载所有城市列表
    public void addAllCity(String firstpy){
        //加载分类标题
        TextView textView = new TextView(this);
        textView.setText(StringUtils.lowerToUper(firstpy));
        textView.setTextSize(20);
        textView.setPadding(15,0,0,0);
        textView.setBackgroundColor(getResources().getColor(R.color.gray));
        ll_city_list.addView(textView);

        //判断相同的有几个
        final List<openCitysBean> newoneList = new ArrayList<>();
        for (openCitysBean cc : cityResultBean.openCitys){
            if (firstpy.equals(cc.py.substring(0,1))){
                newoneList.add(cc);//所有相同的都加入到一个集合中
            }
        }
//        Log.e("allcity",newone.size()+"");
        //加载listview
        ListView listView = new ListView(this);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,LinearLayout.LayoutParams.WRAP_CONTENT);
        listView.setLayoutParams(layoutParams);
        allCityAdapter = new AllCityAdapter(this,newoneList);
        listView.setAdapter(allCityAdapter);
        //计算ListView的高度  在ScrollView中的ListView必须计算高度才能显示完成
        ListViewUtils.measureListViewHeight(listView);
        ll_city_list.addView(listView);

        //设置listview监听
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                //跳转
                Bundle bundle1 = new Bundle();
                bundle1.putString("cityid",newoneList.get(i).name+"");//把城市id传过去
                IntentUtils.openActivity(SelectCityActivity.this, MainActivity.class,bundle1);
            }
        });
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

    /**
     * 经纬度的回调
     * @param longitude
     * @param Latitude
     */
    @Override
    public void longitudeAndLatitude(String longitude, String Latitude) {
        //拿到回调回来的经纬度,并请求数据
        addRimCity(longitude,Latitude);
        //拿到数据之后就关闭当前定位
        mLocationClient.stop();

    }

    @Override
    public void onClick(View view) {
        switch(view.getId()){
            case R.id.select_city_hot_city1://热门1
                select_city_title.setText(String.format("当前城市-%s",select_city_hot_city1.getText()));
                //跳转
                Bundle bundle1 = new Bundle();
                bundle1.putString("cityid",cityResultBean.hotCitys.get(0).name+"");//把城市id传过去
                IntentUtils.openActivity(this, MainActivity.class,bundle1);
            break;
            case R.id.select_city_hot_city2://热门2
                select_city_title.setText(String.format("当前城市-%s",select_city_hot_city2.getText()));
                Bundle bundle2 = new Bundle();
                bundle2.putString("cityid",cityResultBean.hotCitys.get(1).name+"");//把城市id传过去
                IntentUtils.openActivity(this, MainActivity.class,bundle2);
                break;
            case R.id.select_city_hot_city3://热门3
                select_city_title.setText(String.format("当前城市-%s",select_city_hot_city3.getText()));
                Bundle bundle3 = new Bundle();
                bundle3.putString("cityid",cityResultBean.hotCitys.get(2).name+"");//把城市id传过去
                IntentUtils.openActivity(this, MainActivity.class,bundle3);
                break;
            case R.id.select_city_hot_city4://热门4
                select_city_title.setText(String.format("当前城市-%s",select_city_hot_city4.getText()));
                Bundle bundle4 = new Bundle();
                bundle4.putString("cityid",cityResultBean.hotCitys.get(3).name+"");//把城市id传过去
                IntentUtils.openActivity(this, MainActivity.class,bundle4);
                break;
            case R.id.select_city_hot_city5://热门5
                select_city_title.setText(String.format("当前城市-%s",select_city_hot_city5.getText()));
                Bundle bundle5 = new Bundle();
                bundle5.putString("cityid",cityResultBean.hotCitys.get(4).name+"");//把城市id传过去
                IntentUtils.openActivity(this, MainActivity.class,bundle5);
                break;
            case R.id.select_city_hot_city6://热门6
                select_city_title.setText(String.format("当前城市-%s",select_city_hot_city6.getText()));
                Bundle bundle6 = new Bundle();
                bundle6.putString("cityid",cityResultBean.hotCitys.get(5).name+"");//把城市id传过去
                IntentUtils.openActivity(this, MainActivity.class,bundle6);
                break;
            case R.id.select_city_hot_city7://热门7
                select_city_title.setText(String.format("当前城市-%s",select_city_hot_city7.getText()));
                Bundle bundle7 = new Bundle();
                bundle7.putString("cityid",cityResultBean.hotCitys.get(6).name+"");//把城市id传过去
                IntentUtils.openActivity(this, MainActivity.class,bundle7);
                break;
            case R.id.select_city_hot_city8://热门8
                select_city_title.setText(String.format("当前城市-%s",select_city_hot_city8.getText()));
                Bundle bundle8 = new Bundle();
                bundle8.putString("cityid",cityResultBean.hotCitys.get(7).name+"");//把城市id传过去
                IntentUtils.openActivity(this, MainActivity.class,bundle8);
                break;


        }

    }
}
