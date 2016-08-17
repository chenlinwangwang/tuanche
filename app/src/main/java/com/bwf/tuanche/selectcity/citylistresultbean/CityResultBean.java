package com.bwf.tuanche.selectcity.citylistresultbean;

import android.os.Parcel;
import android.os.Parcelable;

import com.bwf.framwork.base.BaseBean;

import java.util.List;

/**
 * Created by ZWP on 2016/8/16.
 * Explain:result的集合bean
 */
public class CityResultBean extends BaseBean {

    public List<hotCitysBean> hotCitys;
    public List<openCitysBean> openCitys;


    @Override
    public String toString() {
        return "CityResultBean{" +
                "hotCitysList=" + hotCitys +
                ", openCitysList=" + openCitys +
                '}';
    }


}
