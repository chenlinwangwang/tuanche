package com.bwf.tuanche.home_page.Bean;

import com.bwf.framwork.base.BaseBean;

import java.util.List;

/**
 * Created by admin on 2016/8/17.
 * 热门品牌
 */
public class HotBrandBean extends BaseBean {
    public List<ListBean> list;

    public void setList(List<ListBean> list) {
        this.list = list;
    }

    public List<ListBean> getList() {
        return this.list;
    }

    public static class ListBean {
        public String id;

        public String name;

        public String logo;

        public String baseNum;

        public String modelType;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getLogo() {
            return logo;
        }

        public void setLogo(String logo) {
            this.logo = logo;
        }

        public String getBaseNum() {
            return baseNum;
        }

        public void setBaseNum(String baseNum) {
            this.baseNum = baseNum;
        }

        public String getModelType() {
            return modelType;
        }

        public void setModelType(String modelType) {
            this.modelType = modelType;
        }

        @Override
        public String toString() {
            return "ListBean{" +
                    "id='" + id + '\'' +
                    ", name='" + name + '\'' +
                    ", logo='" + logo + '\'' +
                    ", baseNum='" + baseNum + '\'' +
                    ", modelType='" + modelType + '\'' +
                    '}';
        }
    }
}
