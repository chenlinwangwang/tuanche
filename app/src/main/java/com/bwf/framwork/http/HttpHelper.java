package com.bwf.framwork.http;


import com.bwf.framwork.bean.AllCommentBean;
import com.bwf.framwork.bean.CarDetailBean;
import com.bwf.framwork.bean.HJiaBean;
import com.bwf.framwork.db.HttpCallBack;
import com.bwf.tuanche.home_page.Bean.BannerBean;
import com.bwf.tuanche.home_page.Bean.HotTypeBean;
import com.zhy.http.okhttp.OkHttpUtils;

/**
 * Created by Lizhangfeng on 2016/7/13 0013.
 * Description:
 */
public class HttpHelper {

//<<<<<<< HEAD
//    public static void getDetail(String url,String pageNo,String pageSize,HttpCallBack callBack){
//        OkHttpUtils
//                .get()
//                .url(url)
//                .addParams("pageNo", pageNo)
//                .addParams("pageSize", pageSize)
//                .build()
//                .execute(callBack);
//    }
//=======


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
//>>>>>>> ccf2ba2db449a64a64016fb74c5fad692d968087
        OkHttpUtils
                .get()
                .addParams("cityId",cityId)
                .url(url)
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
    public static void getCarDetail(String url, String styleId, String cityId, String brandId, com.bwf.framwork.http.HttpCallBack<CarDetailBean> callBack){
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
    public static void getHotCarDetail(String url, String cityId, String firmbrandId, com.bwf.framwork.http.HttpCallBack<CarDetailBean> callBack){
        OkHttpUtils
                .post()
                .url(url)
                .addParams("cityId", cityId)
                .addParams("firmbrandId", firmbrandId)
                .build()
                .execute(callBack);
    }
    //汽车详情 全部评价   count=10&offset=1&cityId=156&brandId=31
    public static void getAllComment(String url, String count, String offset, String cityId, String brandId, com.bwf.framwork.http.HttpCallBack<AllCommentBean> callBack){
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
    public static void getHJiaData(String url, com.bwf.framwork.http.HttpCallBack<HJiaBean> callBack){
        OkHttpUtils
                .post()
                .url(url)
                .build()
                .execute(callBack);
    }


}
