package com.bwf.tuanche.home_page.View;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bwf.framwork.utils.IntentUtils;
import com.bwf.tuanche.R;
import com.bwf.tuanche.selectcity.SelectCityActivity;


/**
 * Created by admin on 2016/8/17.
 */
public class TitleBar extends LinearLayout implements View.OnClickListener {

    private TextView select_city_chick;
    public TitleBar(Context context) {
        this(context,null);
    }

    public TitleBar(Context context, AttributeSet attrs) {
        this(context, attrs,0);
    }

    public TitleBar(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

public void init(Context context){



    LayoutParams layoutParams=new LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
    View view=View.inflate(context, R.layout.titlebar,null);
    view.setLayoutParams(layoutParams);
    addView(view);

    initView();


}

    public void initView(){
        select_city_chick = (TextView) findViewById(R.id.select_city_chick);
        select_city_chick.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.select_city_chick:
//                IntentUtils.openActivity(getContext(), SelectCityActivity.class);
            break;
        }
    }
}
