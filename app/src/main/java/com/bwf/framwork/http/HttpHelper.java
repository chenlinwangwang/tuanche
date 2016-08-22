package com.bwf.framwork.http;


import com.bwf.framwork.db.HttpCallback;
import com.bwf.tuanche.home_page.Bean.BannerBean;
import com.bwf.tuanche.home_page.Bean.HotTypeBean;
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
