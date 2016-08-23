package com.bwf.tuanche.home_page.Bean;

import com.bwf.framwork.base.BaseBean;

import java.util.List;

/**
 * Created by admin on 2016/8/18.
 */
public class BannerBean extends BaseBean{
    public List<Header_banner> header_banner ;

    public List<Center_banner> center_banner ;

    public List<Position_banner> position_banner ;

    

    public class Header_banner {
        public String id;

        public String adName;

        public String channelType;

        public String beginVersion;

        public String position;

        public String priority;

        public String adImgUrl;

        public String description;

        public String shareTitle;

        public String shareImgUrl;

        public String shareUrl;

        public String city;

        public String begStringime;

        public String endTime;

        public String adType;

        public String pageType;

        public String adParam;

        public String adInfoUrl;

        public String adStatus;

        public String isDelete;

        public String createTime;

        public String createUserId;

        public String updateTime;

        public String updateUserId;

        public String picShowType;

        @Override
        public String toString() {
            return "Header_banner{" +
                    "id='" + id + '\'' +
                    ", adName='" + adName + '\'' +
                    ", channelType='" + channelType + '\'' +
                    ", beginVersion='" + beginVersion + '\'' +
                    ", position='" + position + '\'' +
                    ", priority='" + priority + '\'' +
                    ", adImgUrl='" + adImgUrl + '\'' +
                    ", description='" + description + '\'' +
                    ", shareTitle='" + shareTitle + '\'' +
                    ", shareImgUrl='" + shareImgUrl + '\'' +
                    ", shareUrl='" + shareUrl + '\'' +
                    ", city='" + city + '\'' +
                    ", begStringime='" + begStringime + '\'' +
                    ", endTime='" + endTime + '\'' +
                    ", adType='" + adType + '\'' +
                    ", pageType='" + pageType + '\'' +
                    ", adParam='" + adParam + '\'' +
                    ", adInfoUrl='" + adInfoUrl + '\'' +
                    ", adStatus='" + adStatus + '\'' +
                    ", isDelete='" + isDelete + '\'' +
                    ", createTime='" + createTime + '\'' +
                    ", createUserId='" + createUserId + '\'' +
                    ", updateTime='" + updateTime + '\'' +
                    ", updateUserId='" + updateUserId + '\'' +
                    ", picShowType='" + picShowType + '\'' +
                    '}';
        }
    }
  
    public class Center_banner {
        public String id;

        public String adName;

        public String channelType;

        public String beginVersion;

        public String position;

        public String priority;

        public String adImgUrl;

        public String description;

        public String shareTitle;

        public String shareImgUrl;

        public String shareUrl;

        public String city;

        public String begStringime;

        public String endTime;

        public String adType;

        public String pageType;

        public String adParam;

        public String adInfoUrl;

        public String adStatus;

        public String isDelete;

        public String createTime;

        public String createUserId;

        public String updateTime;

        public String updateUserId;

        public String picShowType;

        @Override
        public String toString() {
            return "Center_banner{" +
                    "id='" + id + '\'' +
                    ", adName='" + adName + '\'' +
                    ", channelType='" + channelType + '\'' +
                    ", beginVersion='" + beginVersion + '\'' +
                    ", position='" + position + '\'' +
                    ", priority='" + priority + '\'' +
                    ", adImgUrl='" + adImgUrl + '\'' +
                    ", description='" + description + '\'' +
                    ", shareTitle='" + shareTitle + '\'' +
                    ", shareImgUrl='" + shareImgUrl + '\'' +
                    ", shareUrl='" + shareUrl + '\'' +
                    ", city='" + city + '\'' +
                    ", begStringime='" + begStringime + '\'' +
                    ", endTime='" + endTime + '\'' +
                    ", adType='" + adType + '\'' +
                    ", pageType='" + pageType + '\'' +
                    ", adParam='" + adParam + '\'' +
                    ", adInfoUrl='" + adInfoUrl + '\'' +
                    ", adStatus='" + adStatus + '\'' +
                    ", isDelete='" + isDelete + '\'' +
                    ", createTime='" + createTime + '\'' +
                    ", createUserId='" + createUserId + '\'' +
                    ", updateTime='" + updateTime + '\'' +
                    ", updateUserId='" + updateUserId + '\'' +
                    ", picShowType='" + picShowType + '\'' +
                    '}';
        }
    }
    public class Position_banner {
        public String subTitle;

        public String bigTitle;

        public String adpInfoUrl;

        public String positionId;

        public String iconUrl;

        public String positionType;

        public String adType;

        @Override
        public String toString() {
            return "Position_banner{" +
                    "subTitle='" + subTitle + '\'' +
                    ", bigTitle='" + bigTitle + '\'' +
                    ", adpInfoUrl='" + adpInfoUrl + '\'' +
                    ", positionId='" + positionId + '\'' +
                    ", iconUrl='" + iconUrl + '\'' +
                    ", positionType='" + positionType + '\'' +
                    ", adType='" + adType + '\'' +
                    '}';
        }
    }
    }

//public class Root {
//    public String code;
//
//    public String msg;
//
//    public Result result;
//}
