package com.bwf.tuanche.selectcity.citylistresultbean;

import android.os.Parcel;
import android.os.Parcelable;

import com.bwf.framwork.base.BaseBean;

/**
 * Created by ZWP on 2016/8/17.
 * Explain:
 */
public class NowCityBean extends BaseBean implements Parcelable {
    public int id;

    public String name;

    public String pinyin;

    public String py;

    public int openStatus;

    @Override
    public String toString() {
        return "NowCityBean{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", pinyin='" + pinyin + '\'' +
                ", py='" + py + '\'' +
                ", openStatus=" + openStatus +
                '}';
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.id);
        dest.writeString(this.name);
        dest.writeString(this.pinyin);
        dest.writeString(this.py);
        dest.writeInt(this.openStatus);
    }

    public NowCityBean() {
    }

    protected NowCityBean(Parcel in) {
        this.id = in.readInt();
        this.name = in.readString();
        this.pinyin = in.readString();
        this.py = in.readString();
        this.openStatus = in.readInt();
    }

    public static final Parcelable.Creator<NowCityBean> CREATOR = new Parcelable.Creator<NowCityBean>() {
        @Override
        public NowCityBean createFromParcel(Parcel source) {
            return new NowCityBean(source);
        }

        @Override
        public NowCityBean[] newArray(int size) {
            return new NowCityBean[size];
        }
    };
}
