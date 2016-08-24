package com.bwf.framwork;

import com.bwf.framwork.db.model.BusInfoModel;

/**
 * Created by Lizhangfeng on 2016/7/13 0013.
 * Description: 常量类
 */
public class Constants {

    public static final String DB_NAME = "tuanche_db";//数据库名称

    public static final int DB_VERSION = 1;//数据库版本

    //新增一张车辆信息表
    public static final String BUS_TABLE_NAME = "bus_table";

    //数据库所有的表
    public static String[] TABLES = new String[]{BusInfoModel.class.getName()};//DBhelper中可以根据类名那到类的对象

}
