package com.bwf.framwork.bean;

import java.util.List;

/**
 * 作者/日期: admin on 2016/8/18.
 * 描述:
 */
public class CommentList {
    public String userName;

    public String commentDate;

    public String score;

    public String content;

    public String memberPic;

    public List<CommentPicList> commentPicList ;

    public String fine;

    @Override
    public String toString() {
        return "CommentList{" +
                "userName='" + userName + '\'' +
                ", commentDate='" + commentDate + '\'' +
                ", score='" + score + '\'' +
                ", content='" + content + '\'' +
                ", memberPic='" + memberPic + '\'' +
                ", commentPicList=" + commentPicList +
                ", fine='" + fine + '\'' +
                '}';
    }
}
