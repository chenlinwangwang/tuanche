package com.bwf.tuanche.home_page.activity.view;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.PaintDrawable;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

import com.bwf.framwork.utils.DisplayUtil;
import com.bwf.tuanche.R;
import com.umeng.socialize.UMShareAPI;
import com.umeng.socialize.UMShareListener;
import com.umeng.socialize.bean.SHARE_MEDIA;


/**
 * Created by admin on 2016/8/25.
 */
public class sharePopupWindow extends PopupWindow implements View.OnClickListener {
    private Context context;
    private UMShareAPI shareAPI;
    public sharePopupWindow(Context context) {
        super(context);
        initView(context);

    }

    public void initView(final Context context) {
        shareAPI = UMShareAPI.get(context);
        View view = View.inflate(context, R.layout.share_popwindow, null);
        Button btn = (Button) view.findViewById(R.id.btn_dismiss);
        View background_pop = view.findViewById(R.id.background_pop);
        TextView tv_QQshare = (TextView) view.findViewById(R.id.tv_QQshare);
        TextView tv_QQZoneshare = (TextView) view.findViewById(R.id.tv_QQZoneshare);
        TextView tv_weiboShare = (TextView) view.findViewById(R.id.tv_weiboShare);
        btn.setOnClickListener(this);
        background_pop.setOnClickListener(this);
        tv_QQshare.setOnClickListener(this);
        tv_QQZoneshare.setOnClickListener(this);
        tv_weiboShare.setOnClickListener(this);
        this.setFocusable(true);
        this.setAnimationStyle(R.style.PopupAnimation);
        this.setWidth(ViewGroup.LayoutParams.MATCH_PARENT);
        this.setHeight(DisplayUtil.getDensity_Height(context));
        this.setBackgroundDrawable(new PaintDrawable());
        this.setContentView(view);
        tv_QQshare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ShareUtils.ShareToQQ((Activity) context, SHARE_MEDIA.QQ, "团车", "您身边的购车助手",
                        "http://www.tuanche.com/?c=3s09PENC", R.mipmap.ic_launcher, new UMShareListener() {
                    @Override
                    public void onResult(SHARE_MEDIA share_media) {
                        Toast.makeText(context, "分享成功", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onError(SHARE_MEDIA share_media, Throwable throwable) {
                        Toast.makeText(context, "分享失败", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onCancel(SHARE_MEDIA share_media) {
                        Toast.makeText(context, "分享取消", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });
        tv_QQZoneshare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ShareUtils.ShareToQQ((Activity) context, SHARE_MEDIA.QZONE, "团车", "您身边的购车助手",
                        "http://www.tuanche.com/?c=3s09PENC", R.mipmap.ic_launcher, new UMShareListener() {
                            @Override
                            public void onResult(SHARE_MEDIA share_media) {
                                Toast.makeText(context, "分享成功", Toast.LENGTH_SHORT).show();
                            }

                            @Override
                            public void onError(SHARE_MEDIA share_media, Throwable throwable) {
                                Toast.makeText(context, "分享失败", Toast.LENGTH_SHORT).show();
                            }

                            @Override
                            public void onCancel(SHARE_MEDIA share_media) {
                                Toast.makeText(context, "分享取消", Toast.LENGTH_SHORT).show();
                            }
                        });
            }
        });
    }

    public void showPopWindow(View view) {
        if (!isShowing()) {
//            this.showAsDropDown(view);//显示在view下方
            this.showAtLocation(view, Gravity.BOTTOM, 0, 0);
        }
    }
    //复写onActivityResult方法，会有返回结果

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_dismiss:
                sharePopupWindow.this.dismiss();
                break;
            case R.id.background_pop:
                sharePopupWindow.this.dismiss();
                break;
            case R.id.tv_weiboShare:

                break;
        }
    }

}
