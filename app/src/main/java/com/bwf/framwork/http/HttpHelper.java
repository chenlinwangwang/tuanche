package com.bwf.framwork.http;


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


}
