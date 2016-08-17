package com.bwf.framwork.http;


import com.zhy.http.okhttp.OkHttpUtils;

/**
 * Created by Lizhangfeng on 2016/7/13 0013.
 * Description:
 */
public class HttpHelper {


    public static void getDetail(String url,String pageNo,String pageSize,HttpCallBack callBack){
        OkHttpUtils
                .post()
                .url(url)
                .addParams("pageNo", pageNo)
                .addParams("pageSize", pageSize)
                .build()
                .execute(callBack);
    }
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


}
