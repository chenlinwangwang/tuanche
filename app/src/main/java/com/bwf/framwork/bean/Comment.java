package com.bwf.framwork.bean;

import java.util.List;

/**
 * 作者/日期: admin on 2016/8/18.
 * 描述:
 */
public class Comment {

    public String count;

    public String commentTotal;

    public List<CommentList> commentList ;

    @Override
    public String toString() {
        return "Comment{" +
                "count='" + count + '\'' +
                ", commentTotal='" + commentTotal + '\'' +
                ", commentList=" + commentList +
                '}';
    }

}
