package com.bwf.framwork.http;


import com.bwf.framwork.db.HttpCallBack;
import com.bwf.tuanche.home_page.Bean.BannerBean;
import com.bwf.tuanche.home_page.Bean.HotTypeBean;
import com.zhy.http.okhttp.OkHttpUtils;

/**
 * Created by Lizhangfeng on 2016/7/13 0013.
 * Description:
 */
public class HttpHelper {



    //获取城市列表
    public static void getSelsctCityDetail(String url,HttpCallBack callBack){
        OkHttpUtils
                .get()
                .url(url)
                .addParams("pageSize", "4")
                .build()
                .execute(callBack);
    }
    //获取当前城市
    public static void getNowCity(String url,String longitude,String latitude,HttpCallBack callBack){
        OkHttpUtils
                .get()
                .url(url)
                .addParams("longitude", longitude)
                .addParams("latitude", latitude)
                .build()
                .execute(callBack);
    }
    //获取最新版本
    public static void getNewVersion(String url,HttpCallBack callBack){
        OkHttpUtils
                .get()
                .url(url)
                .build()
                .execute(callBack);
    }
    public static void getDetail_1(String url,String cityId,HttpCallBack callBack){
        OkHttpUtils
                .get()
                .addParams("cityId","156")
                .url(url)
                .build()
                .execute(callBack);
    }
    public static void getHotBrand(String url,String isBuy,String cityId,HttpCallBack callBack) {
        OkHttpUtils
                .get()
                .addParams("isBuy", isBuy)
                .addParams("cityId", cityId)
                .url(url)
                .build()
                .execute(callBack);
    }
    public static void getHotType(String url, String count, String offset , String cityId, HttpArrayCallBack<HotTypeBean> callBack){
        OkHttpUtils
                .get()
                .addParams("count",count)
                .addParams("offset",offset)
                .addParams("cityId",cityId)
                .url(url)
                .build()
                .execute(callBack);
    }
    public static void getBannerData(String url, String cityId, HttpCallBack<BannerBean> callBack){
        OkHttpUtils
                .get()
                .addParams("cityId",cityId)
                .url(url)
                .build()
                .execute(callBack);
    }


}
