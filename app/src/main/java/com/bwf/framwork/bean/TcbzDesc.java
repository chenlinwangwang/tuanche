package com.bwf.framwork.bean;

/**
 * 作者/日期: admin on 2016/8/18.
 * 描述:
 */
public class TcbzDesc {
    public String id;
    public String createTime;
    public String status;
    public String sort;
    public String title;
    public String sourceId;
    public String versionCode;
    public String dataType;
    public String dataValue;
    public String describe;
    public String linkurl;
    public String imgurl;

    @Override
    public String toString() {
        return "TcbzDesc{" +
                "id='" + id + '\'' +
                ", createTime='" + createTime + '\'' +
                ", status='" + status + '\'' +
                ", sort='" + sort + '\'' +
                ", title='" + title + '\'' +
                ", sourceId='" + sourceId + '\'' +
                ", versionCode='" + versionCode + '\'' +
                ", dataType='" + dataType + '\'' +
                ", dataValue='" + dataValue + '\'' +
                ", describe='" + describe + '\'' +
                ", linkurl='" + linkurl + '\'' +
                ", imgurl='" + imgurl + '\'' +
                '}';
    }

}
