package com.bwf.tuanche.selectcity.citylistresultbean;

import com.bwf.framwork.base.BaseBean;

/**
 * Created by ZWP on 2016/8/17.
 * Explain:
 */
public class NowCityBean extends BaseBean {
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
}
