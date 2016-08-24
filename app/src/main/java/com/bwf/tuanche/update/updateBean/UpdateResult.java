package com.bwf.tuanche.update.updateBean;

import android.os.Parcel;
import android.os.Parcelable;

import com.bwf.framwork.base.BaseBean;

/**
 * Created by ZWP on 2016/8/18.
 * Explain:
 */
public class UpdateResult extends BaseBean implements Parcelable {
    public String specificEdition;

    public String minVersion;

    public String upgradeText;

    public String textPic;

    public String upgradeIntervalWarn;

    public String isFourceUpGrade;

    public String isPromtUpGrade;

    public String titleText;

    public String giveUpText;

    public String md5file;

    public String isForce;

    public String versionName;

    public String description;

    public String url;

    public String versionCode;

    @Override
    public String toString() {
        return "UpdateResult{" +
                "specificEdition='" + specificEdition + '\'' +
                ", minVersion='" + minVersion + '\'' +
                ", upgradeText='" + upgradeText + '\'' +
                ", textPic='" + textPic + '\'' +
                ", upgradeIntervalWarn='" + upgradeIntervalWarn + '\'' +
                ", isFourceUpGrade='" + isFourceUpGrade + '\'' +
                ", isPromtUpGrade='" + isPromtUpGrade + '\'' +
                ", titleText='" + titleText + '\'' +
                ", giveUpText='" + giveUpText + '\'' +
                ", md5file='" + md5file + '\'' +
                ", isForce='" + isForce + '\'' +
                ", versionName='" + versionName + '\'' +
                ", description='" + description + '\'' +
                ", url='" + url + '\'' +
                ", versionCode='" + versionCode + '\'' +
                '}';
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.specificEdition);
        dest.writeString(this.minVersion);
        dest.writeString(this.upgradeText);
        dest.writeString(this.textPic);
        dest.writeString(this.upgradeIntervalWarn);
        dest.writeString(this.isFourceUpGrade);
        dest.writeString(this.isPromtUpGrade);
        dest.writeString(this.titleText);
        dest.writeString(this.giveUpText);
        dest.writeString(this.md5file);
        dest.writeString(this.isForce);
        dest.writeString(this.versionName);
        dest.writeString(this.description);
        dest.writeString(this.url);
        dest.writeString(this.versionCode);
    }

    public UpdateResult() {
    }

    protected UpdateResult(Parcel in) {
        this.specificEdition = in.readString();
        this.minVersion = in.readString();
        this.upgradeText = in.readString();
        this.textPic = in.readString();
        this.upgradeIntervalWarn = in.readString();
        this.isFourceUpGrade = in.readString();
        this.isPromtUpGrade = in.readString();
        this.titleText = in.readString();
        this.giveUpText = in.readString();
        this.md5file = in.readString();
        this.isForce = in.readString();
        this.versionName = in.readString();
        this.description = in.readString();
        this.url = in.readString();
        this.versionCode = in.readString();
    }

    public static final Parcelable.Creator<UpdateResult> CREATOR = new Parcelable.Creator<UpdateResult>() {
        @Override
        public UpdateResult createFromParcel(Parcel source) {
            return new UpdateResult(source);
        }

        @Override
        public UpdateResult[] newArray(int size) {
            return new UpdateResult[size];
        }
    };
}


