package com.bwf.tuanche.home_page.View;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bwf.framwork.utils.DrawableUtils;
import com.bwf.framwork.utils.IntentUtils;
import com.bwf.framwork.utils.ToastUtil;
import com.bwf.tuanche.Login.LoginActivity;
import com.bwf.tuanche.R;
import com.bwf.tuanche.home_page.MainActivity;
import com.bwf.tuanche.home_page.activity.MyActivity;
import com.bwf.tuanche.home_page.activity.ServerActivity;

/**
 * Created by admin on 2016/8/17.
 */
public class BottomView extends LinearLayout implements View.OnClickListener {
    private TextView[] TextViews;
    private Integer[] normal_ids = new Integer[]{R.mipmap.nav_icon_home_nor, R.mipmap.nav_icon_order_nor, R.mipmap.nav_icon_server_nor, R.mipmap.nav_icon_my_nor};
    private Integer[] select_ids = new Integer[]{R.mipmap.nav_icon_home_sel, R.mipmap.nav_icon_order_sel, R.mipmap.nav_icon_server_sel, R.mipmap.nav_icon_my_sel};

    public BottomView(Context context) {
        this(context, null);
    }

    public BottomView(Context context, AttributeSet attrs)  {
        this(context, attrs, 0);
    }

    public BottomView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    public void init(Context context) {
        LayoutParams layoutParams = new LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        View view = View.inflate(context, R.layout.bottmview, null);
        view.setLayoutParams(layoutParams);
        addView(view);

        TextView tv_home = (TextView) view.findViewById(R.id.tv_home);
        TextView tv_order = (TextView) view.findViewById(R.id.tv_order);
        TextView tv_server = (TextView) view.findViewById(R.id.tv_server);
        TextView tv_mine = (TextView) view.findViewById(R.id.tv_mine);
        TextViews = new TextView[]{tv_home, tv_order, tv_server, tv_mine};
        tv_home.setOnClickListener(this);
        tv_order.setOnClickListener(this);
        tv_server.setOnClickListener(this);
        tv_mine.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.tv_home://首页
                IntentUtils.openActivity(getContext(), MainActivity.class);
                break;
            case R.id.tv_order://订单（登录页面）
                IntentUtils.openActivity(getContext(), LoginActivity.class);
                break;
            case R.id.tv_server://客服
                IntentUtils.openActivity(getContext(), ServerActivity.class);
                break;
            case R.id.tv_mine://我的
                IntentUtils.openActivity(getContext(), MyActivity.class);
                break;
        }
    }

    public void setSelect(int position) {
        for (int i = 0; i < TextViews.length; i++) {
            if (i == position) {
                TextViews[i].setTextColor(Color.RED);
                DrawableUtils.drawableTop(getContext(), TextViews[i], select_ids[i]);
            } else {
                TextViews[i].setTextColor(Color.BLACK);
                DrawableUtils.drawableTop(getContext(), TextViews[i], normal_ids[i]);
            }
        }
    }
}
