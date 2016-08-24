package com.bwf.tuanche.home_page.Bean;

import java.util.List;

/**
 * Created by admin on 2016/8/17.
 */
public class Root {
        public int code;

        public String msg;

        public List<Result> result ;

        public void setResult(List<Result> result){
            this.result = result;
        }
        public List<Result> getResult(){
            return this.result;
        }
        public class Result {
            public int id;

            public int brandId;

            public String logo;

            public String styleName;

            public String factoryPrice;

            public String content;

            public int isBuy;

            public int manNum;

            public int isNew;

            public String prefix;

            public String suffix;

            public String levelStr;

            public String brandName;

            public String carModelPrices;

            public int firmBrandId;

            public int identify;

            public String basePrice;

            public String pricePrefix;

            public String price;

            public String priceSuffix;

            public String adInfo;

            public String ecLable;

            public void setId(int id){
                this.id = id;
            }
            public int getId(){
                return this.id;
            }
            public void setBrandId(int brandId){
                this.brandId = brandId;
            }
            public int getBrandId(){
                return this.brandId;
            }
            public void setLogo(String logo){
                this.logo = logo;
            }
            public String getLogo(){
                return this.logo;
            }
            public void setStyleName(String styleName){
                this.styleName = styleName;
            }
            public String getStyleName(){
                return this.styleName;
            }
            public void setFactoryPrice(String factoryPrice){
                this.factoryPrice = factoryPrice;
            }
            public String getFactoryPrice(){
                return this.factoryPrice;
            }
            public void setContent(String content){
                this.content = content;
            }
            public String getContent(){
                return this.content;
            }
            public void setIsBuy(int isBuy){
                this.isBuy = isBuy;
            }
            public int getIsBuy(){
                return this.isBuy;
            }
            public void setManNum(int manNum){
                this.manNum = manNum;
            }
            public int getManNum(){
                return this.manNum;
            }
            public void setIsNew(int isNew){
                this.isNew = isNew;
            }
            public int getIsNew(){
                return this.isNew;
            }
            public void setPrefix(String prefix){
                this.prefix = prefix;
            }
            public String getPrefix(){
                return this.prefix;
            }
            public void setSuffix(String suffix){
                this.suffix = suffix;
            }
            public String getSuffix(){
                return this.suffix;
            }
            public void setLevelStr(String levelStr){
                this.levelStr = levelStr;
            }
            public String getLevelStr(){
                return this.levelStr;
            }
            public void setBrandName(String brandName){
                this.brandName = brandName;
            }
            public String getBrandName(){
                return this.brandName;
            }
            public void setCarModelPrices(String carModelPrices){
                this.carModelPrices = carModelPrices;
            }
            public String getCarModelPrices(){
                return this.carModelPrices;
            }
            public void setFirmBrandId(int firmBrandId){
                this.firmBrandId = firmBrandId;
            }
            public int getFirmBrandId(){
                return this.firmBrandId;
            }
            public void setIdentify(int identify){
                this.identify = identify;
            }
            public int getIdentify(){
                return this.identify;
            }
            public void setBasePrice(String basePrice){
                this.basePrice = basePrice;
            }
            public String getBasePrice(){
                return this.basePrice;
            }
            public void setPricePrefix(String pricePrefix){
                this.pricePrefix = pricePrefix;
            }
            public String getPricePrefix(){
                return this.pricePrefix;
            }
            public void setPrice(String price){
                this.price = price;
            }
            public String getPrice(){
                return this.price;
            }
            public void setPriceSuffix(String priceSuffix){
                this.priceSuffix = priceSuffix;
            }
            public String getPriceSuffix(){
                return this.priceSuffix;
            }
            public void setAdInfo(String adInfo){
                this.adInfo = adInfo;
            }
            public String getAdInfo(){
                return this.adInfo;
            }
            public void setEcLable(String ecLable){
                this.ecLable = ecLable;
            }
            public String getEcLable(){
                return this.ecLable;
            }

            @Override
            public String toString() {
                return "Result{" +
                        "id=" + id +
                        ", brandId=" + brandId +
                        ", logo='" + logo + '\'' +
                        ", styleName='" + styleName + '\'' +
                        ", factoryPrice='" + factoryPrice + '\'' +
                        ", content='" + content + '\'' +
                        ", isBuy=" + isBuy +
                        ", manNum=" + manNum +
                        ", isNew=" + isNew +
                        ", prefix='" + prefix + '\'' +
                        ", suffix='" + suffix + '\'' +
                        ", levelStr='" + levelStr + '\'' +
                        ", brandName='" + brandName + '\'' +
                        ", carModelPrices='" + carModelPrices + '\'' +
                        ", firmBrandId=" + firmBrandId +
                        ", identify=" + identify +
                        ", basePrice='" + basePrice + '\'' +
                        ", pricePrefix='" + pricePrefix + '\'' +
                        ", price='" + price + '\'' +
                        ", priceSuffix='" + priceSuffix + '\'' +
                        ", adInfo='" + adInfo + '\'' +
                        ", ecLable='" + ecLable + '\'' +
                        '}';
            }
        }
    }
