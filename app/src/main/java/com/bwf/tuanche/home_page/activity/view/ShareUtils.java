package com.bwf.tuanche.home_page.activity.view;

import android.app.Activity;

import com.umeng.socialize.ShareAction;
import com.umeng.socialize.UMShareListener;
import com.umeng.socialize.bean.SHARE_MEDIA;
import com.umeng.socialize.media.UMImage;

/**
 * Created by admin on 2016/8/10.
 */
public class ShareUtils {

    public static void ShareToQQ(Activity activity, SHARE_MEDIA plateform, String title, String Content
                        , String TargetUrl, int imgurl, UMShareListener umShareListener ){
        new ShareAction(activity)
                .setPlatform(plateform)
                .withTitle(title)
                .withText(Content)
                .withTargetUrl(TargetUrl)
                .withMedia(new UMImage(activity,imgurl))
                .setCallback(umShareListener)
                .share();
    }
}
