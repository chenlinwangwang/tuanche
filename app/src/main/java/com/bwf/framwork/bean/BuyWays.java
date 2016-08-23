package com.bwf.framwork.bean;

import java.util.List;

/**
 * 作者/日期: admin on 2016/8/18.
 * 描述:
 */
public class BuyWays {
    public List<BuyWayList> buyWayList ;

    public String showWhere;

    public String isMust;

    @Override
    public String toString() {
        return "BuyWays{" +
                "buyWayList=" + buyWayList +
                ", showWhere='" + showWhere + '\'' +
                ", isMust='" + isMust + '\'' +
                '}';
    }
}
