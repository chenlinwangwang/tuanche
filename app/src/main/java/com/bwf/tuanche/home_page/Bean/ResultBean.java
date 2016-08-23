package com.bwf.tuanche.home_page.Bean;

import com.bwf.framwork.base.BaseBean;
import com.bwf.framwork.utils.LogUtils;

import java.util.List;

/**
 * Created by admin on 2016/8/16.
 * 低价购车
 */
public class ResultBean extends BaseBean{

    public List<Nc> nc;


    public List<Nc> getNc() {
        return nc;
    }


    public class Nc {
        public int weight;

        public String name;

        public String pic;

        public boolean show;

        public int type;

        public int modules;

        public int is_ng;

        public int is_login;

        public void setWeight(int weight) {
            this.weight = weight;
        }

        public int getWeight() {
            return this.weight;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getName() {
            return this.name;
        }

        public void setPic(String pic) {
            this.pic = pic;
        }

        public String getPic() {
            return this.pic;
        }

        public void setShow(boolean show) {
            this.show = show;
        }

        public boolean getShow() {
            return this.show;
        }

        public void setType(int type) {
            this.type = type;
        }

        public int getType() {
            return this.type;
        }

        public void setModules(int modules) {
            this.modules = modules;
        }

        public int getModules() {
            return this.modules;
        }

        public void setIs_ng(int is_ng) {
            this.is_ng = is_ng;
        }

        public int getIs_ng() {
            return this.is_ng;
        }

        public void setIs_login(int is_login) {
            this.is_login = is_login;
        }

        public int getIs_login() {
            return this.is_login;
        }

        @Override
        public String toString() {
            return "Nc{" +
                    "weight=" + weight +
                    ", name='" + name + '\'' +
                    ", pic='" + pic + '\'' +
                    ", show=" + show +
                    ", type=" + type +
                    ", modules=" + modules +
                    ", is_ng=" + is_ng +
                    ", is_login=" + is_login +
                    '}';
        }
    }


}
