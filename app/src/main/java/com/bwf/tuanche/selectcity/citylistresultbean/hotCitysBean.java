package com.bwf.tuanche.selectcity.citylistresultbean;

/**
 * Created by ZWP on 2016/8/16.
 * Explain:热度城市
 */
public class hotCitysBean {
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
}
