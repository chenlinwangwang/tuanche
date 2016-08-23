package com.bwf.tuanche.details.fragment;

import android.content.Context;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.bwf.framwork.bean.CarBeanList;
import com.bwf.framwork.bean.StyleList;
import com.bwf.framwork.http.HttpArrayCallBack;
import com.bwf.framwork.http.HttpCallBack;
import com.bwf.framwork.http.HttpHelper;
import com.bwf.framwork.utils.DisplayUtil;
import com.bwf.framwork.utils.IntentUtils;
import com.bwf.framwork.utils.ToastUtil;
import com.bwf.framwork.utils.UrlUtils;
import com.bwf.tuanche.MyApplication;
import com.bwf.tuanche.R;
import com.bwf.tuanche.details.DetailsActivity;
import com.bwf.tuanche.details.adapter.CarListAdapter;
import com.bwf.tuanche.details.adapter.DividerItemDecoration;

import java.util.List;

/**
 * 作者/日期: admin on 2016/8/20.
 * 描述:
 */
public class CarListPopuWindow extends PopupWindow {
    private TextView tv_car_type;
    private RecyclerView rv_carlist;
    private String type, cityId, brandId, styleId;
    private CarListAdapter carListAdapter;
    private List<StyleList> styleLists;
    private Context context;
    private Bundle mBundle;

    public CarListPopuWindow(Context context, Bundle mBundle) {
        super(context);
        this.context = context;
        this.mBundle = mBundle;
//        type = mBundle.getString("type");
//        cityId = mBundle.getString("cityId");
//        brandId = mBundle.getString("brandId");
        type = "0";
        cityId = "156";
        brandId = "25";
        init(this.context);
    }

    public void init(final Context context) {
        View view = View.inflate(context, R.layout.item_carbrandstyle, null);
        //popWindow相关设置
        this.setContentView(view);
        this.setWidth(DisplayUtil.getDensity_Width(context) / 4 * 3);
        this.setHeight(DisplayUtil.getDensity_Height(context));
        this.setFocusable(true);
        this.setTouchable(true);
        this.isOutsideTouchable();
        this.setBackgroundDrawable(new BitmapDrawable());
        this.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN);
        tv_car_type = (TextView) view.findViewById(R.id.tv_car_type);
        rv_carlist = (RecyclerView) view.findViewById(R.id.rv_carlist);
        rv_carlist.addItemDecoration(new DividerItemDecoration(context,LinearLayoutManager.VERTICAL));
        getCarListData();
    }

    public void getCarListData() {
        HttpHelper.getCarList(UrlUtils.CAR_BUY_LIST, type, cityId, brandId, new HttpArrayCallBack<CarBeanList>() {
            @Override
            public void onSuccess(List<CarBeanList> result) {
                if (result != null) {
                    for (int i = 0; i < result.size(); i++) {
                        tv_car_type.setText(result.get(i).brandName);
                        styleLists = result.get(i).styleList;
                        Log.e("TAG", "styleList:---------------------------------------- " + styleLists.size());
                        if (styleLists != null) {
                            rv_carlist.setLayoutManager(new LinearLayoutManager(MyApplication.getAppContext()));
                            DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(context, LinearLayoutManager.VERTICAL);
                            rv_carlist.addItemDecoration(dividerItemDecoration);
                            carListAdapter = new CarListAdapter(MyApplication.getAppContext(), styleLists, mBundle);
                            carListAdapter.setMyCallBack(new CarListAdapter.MyCallBack() {
                                @Override
                                public void onClick(int position) {
                                    Bundle bundle = new Bundle();
                                    bundle.putString("styleId", mBundle.getString("styleId"));
                                    bundle.putString("cityId", mBundle.getString("cityId"));
                                    bundle.putString("brandId", styleLists.get(position).brandId);
                                    IntentUtils.openActivity(context, DetailsActivity.class, bundle);
                                }
                            });
                            rv_carlist.setAdapter(carListAdapter);
                        }
                    }

                }
            }

            @Override
            public void onFail(String errMsg) {
                Log.e("TAG", "errMsg: " + errMsg);
            }
        });
    }


}
