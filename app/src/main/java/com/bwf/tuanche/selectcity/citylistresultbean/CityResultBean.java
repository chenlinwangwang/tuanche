package com.bwf.tuanche.selectcity.citylistresultbean;

import android.os.Parcel;
import android.os.Parcelable;

import com.bwf.framwork.base.BaseBean;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ZWP on 2016/8/16.
 * Explain:result的集合bean
 */
public class CityResultBean extends BaseBean implements Parcelable {

    public List<hotCitysBean> hotCitys;
    public List<openCitysBean> openCitys;


    @Override
    public String toString() {
        return "CityResultBean{" +
                "hotCitysList=" + hotCitys +
                ", openCitysList=" + openCitys +
                '}';
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeList(this.hotCitys);
        dest.writeList(this.openCitys);
    }

    public CityResultBean() {
    }

    protected CityResultBean(Parcel in) {
        this.hotCitys = new ArrayList<hotCitysBean>();
        in.readList(this.hotCitys, hotCitysBean.class.getClassLoader());
        this.openCitys = new ArrayList<openCitysBean>();
        in.readList(this.openCitys, openCitysBean.class.getClassLoader());
    }

    public static final Parcelable.Creator<CityResultBean> CREATOR = new Parcelable.Creator<CityResultBean>() {
        @Override
        public CityResultBean createFromParcel(Parcel source) {
            return new CityResultBean(source);
        }

        @Override
        public CityResultBean[] newArray(int size) {
            return new CityResultBean[size];
        }
    };
}
