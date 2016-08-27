package com.bwf.tuanche.selectcity;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bwf.tuanche.R;


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

        //因为在xml中已经加载了recyclerView所以这里不用在加载recyclerView的布局了，但是可以在recycleview的布局中载添加控件



        //加载布局
//        View view = View.inflate(getContext(), R.layout.my_rescycle_item,null);
//        LayoutParams layoutParams = new LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
//        view.setLayoutParams(layoutParams);
//        this.addView(view);



    }
}
