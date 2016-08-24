package com.bwf.tuanche.selectcity.citylistresultbean;

import com.bwf.framwork.base.BaseBean;

/**
 * Created by ZWP on 2016/8/16.
 * Explain:城市bean
 */
public class CityBean {
    public String code ;// 10000
    public String msg ;//  "调用成功"
    public String result ;// 返回如果

    @Override
    public String toString() {
        return "CityResultBean{" +
                "code='" + code + '\'' +
                ", msg='" + msg + '\'' +
                ", result='" + result + '\'' +
                '}';
    }
}
