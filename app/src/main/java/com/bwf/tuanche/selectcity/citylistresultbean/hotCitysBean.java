package com.bwf.tuanche.selectcity.citylistresultbean;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by ZWP on 2016/8/16.
 * Explain:热度城市
 */
public class hotCitysBean implements Parcelable {
    public String id ;// 10
    public String name ;// "北京"
    public String province ;// "直辖市"
    public String pinyin ;// "beijing"
    public String pname ;// "直辖市"
    public String py ;// "bj"
    public String openStatus ;// 1

    @Override
    public String toString() {
        return "hotCitysBean{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", province='" + province + '\'' +
                ", pinyin='" + pinyin + '\'' +
                ", pname='" + pname + '\'' +
                ", py='" + py + '\'' +
                ", openStatus='" + openStatus + '\'' +
                '}';
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.id);
        dest.writeString(this.name);
        dest.writeString(this.province);
        dest.writeString(this.pinyin);
        dest.writeString(this.pname);
        dest.writeString(this.py);
        dest.writeString(this.openStatus);
    }

    public hotCitysBean() {
    }

    protected hotCitysBean(Parcel in) {
        this.id = in.readString();
        this.name = in.readString();
        this.province = in.readString();
        this.pinyin = in.readString();
        this.pname = in.readString();
        this.py = in.readString();
        this.openStatus = in.readString();
    }

    public static final Parcelable.Creator<hotCitysBean> CREATOR = new Parcelable.Creator<hotCitysBean>() {
        @Override
        public hotCitysBean createFromParcel(Parcel source) {
            return new hotCitysBean(source);
        }

        @Override
        public hotCitysBean[] newArray(int size) {
            return new hotCitysBean[size];
        }
    };
}
