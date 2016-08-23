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

    //汽车详情 oneType
    public static void getCarList(String url, String type, String cityId, String brandId, HttpArrayCallBack callBack){
        OkHttpUtils
                .post()
                .url(url)
                .addParams("type", type)
                .addParams("cityId", cityId)
                .addParams("brandId", brandId)
                .build()
                .execute(callBack);
    }

    //汽车详情 oneType
    public static void getCarDetail(String url, String styleId, String cityId, String brandId, HttpCallBack callBack){
        OkHttpUtils
                .post()
                .url(url)
                .addParams("styleId", styleId)
                .addParams("cityId", cityId)
                .addParams("brandId", brandId)
                .build()
                .execute(callBack);
    }
    //汽车详情 HotCarType
    public static void getHotCarDetail(String url,String cityId,String firmbrandId,HttpCallBack callBack){
        OkHttpUtils
                .post()
                .url(url)
                .addParams("cityId", cityId)
                .addParams("firmbrandId", firmbrandId)
                .build()
                .execute(callBack);
    }
    //汽车详情 全部评价   count=10&offset=1&cityId=156&brandId=31
    public static void getAllComment(String url,String count,String offset,String cityId,String brandId,HttpCallBack callBack){
        OkHttpUtils
                .post()
                .url(url)
                .addParams("count", count)
                .addParams("offset", offset)
                .addParams("cityId", cityId)
                .addParams("brandId", brandId)
                .build()
                .execute(callBack);
    }

    //汽车详情 婚姻座驾
    public static void getHJiaData(String url,HttpCallBack callBack){
        OkHttpUtils
                .post()
                .url(url)
                .build()
                .execute(callBack);
    }


}
