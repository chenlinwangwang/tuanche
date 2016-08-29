package com.bwf.framwork.bean;

import java.util.List;

/**
 * 作者/日期: admin on 2016/8/20.
 * 描述:
 */
public class CarBeanList {

    public String brandId;

    public String brandName;

    public String brandPic;

    public List<StyleList> styleList ;

    @Override
    public String toString() {
        return "CarList{" +
                "brandId='" + brandId + '\'' +
                ", brandName='" + brandName + '\'' +
                ", brandPic='" + brandPic + '\'' +
                ", styleList=" + styleList +
                '}';
    }
}

