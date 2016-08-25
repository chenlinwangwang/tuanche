package com.bwf.framwork.bean;

import com.bwf.framwork.base.BaseBean;

import java.util.List;

/**
 * 作者/日期: admin on 2016/8/18.
 * 描述:
 */
public class AllCommentBean extends BaseBean{
    public String count;

    public String commentTotal;

    public String priceScore;

    public String salerScore;

    public String shopScore;

    public String offset;

    public List<CommentList> commentList ;

    @Override
    public String toString() {
        return "AllCommentBean{" +
                "count='" + count + '\'' +
                ", commentTotal='" + commentTotal + '\'' +
                ", priceScore='" + priceScore + '\'' +
                ", salerScore='" + salerScore + '\'' +
                ", shopScore='" + shopScore + '\'' +
                ", offset='" + offset + '\'' +
                ", commentList=" + commentList +
                '}';
    }

}
