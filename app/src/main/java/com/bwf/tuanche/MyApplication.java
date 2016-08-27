package com.bwf.tuanche;

import android.app.Application;
import android.content.Context;

import com.baidu.location.LocationClient;
import com.baidu.location.LocationClientOption;
import com.bwf.tuanche.selectcity.baidumap.BaiDuLocationListener;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.umeng.socialize.PlatformConfig;
import com.zhy.http.okhttp.OkHttpUtils;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;

/**
 * Created by Lizhangfeng on 2016/8/16 0016.
 * Description:
 */
public class MyApplication extends Application {

    private static MyApplication myApplication;
    private static String cityId;
    @Override
    public void onCreate() {
        super.onCreate();
        myApplication = this;
        PlatformConfig.setSinaWeibo("3921700954", "04b48b094faeb16683c32669824ebdad");
        //新浪微博 appkey appsecret
        PlatformConfig.setQQZone("100424468", "c7394704798a158208a74ab60104f0ba");
        // QQ和Qzone appid appkey
        //初始化facebook
        Fresco.initialize(this);
        //初始化okhttp
        initOkhttp();
        //初始化百度定位


    }

    /**
     * 初始化okhttp
     */
    public void initOkhttp(){
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .connectTimeout(10000L, TimeUnit.MILLISECONDS)
                .readTimeout(10000L, TimeUnit.MILLISECONDS)
                //其他配置
                .build();

        OkHttpUtils.initClient(okHttpClient);
    }

    public static MyApplication getMyApplication() {
        return myApplication;
    }

    public static Context getAppContext(){
        return myApplication.getApplicationContext();
    }

    public static void setCityId(String cityId) {
        MyApplication.cityId = cityId;
    }

    public static String getCityId() {
        return cityId;
    }
}
