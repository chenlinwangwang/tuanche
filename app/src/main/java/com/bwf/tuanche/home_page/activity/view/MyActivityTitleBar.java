package com.bwf.tuanche.home_page.activity.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.bwf.tuanche.R;

/**
 * Created by admin on 2016/8/20.
 */
public class MyActivityTitleBar extends LinearLayout {
    public MyActivityTitleBar(Context context) {
        this(context, null);
    }

    public MyActivityTitleBar(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public MyActivityTitleBar(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    public void init(Context context) {
        LayoutParams params=new LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        View view=View.inflate(context, R.layout.myactivityt_itlebar,null);
        view.setLayoutParams(params);
        addView(view);
    }
}
