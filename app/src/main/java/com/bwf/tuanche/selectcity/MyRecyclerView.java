package com.bwf.tuanche.selectcity;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;


/**
 * Created by ZWP on 2016/8/23.
 * Explain:
 */
public class MyRecyclerView extends RecyclerView {
    public MyRecyclerView(Context context) {
        this(context,null);
    }

    public MyRecyclerView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs,0);
    }

    public MyRecyclerView(Context context, @Nullable AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        initView();
    }

    //初始化view
    private void initView() {

//        //加载布局
//        View view = View.inflate(getContext(), R.layout.my_rescycle_item,null);
//        LayoutParams layoutParams = new LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
//        view.setLayoutParams(layoutParams);
//        this.addView(view);


    }
}
