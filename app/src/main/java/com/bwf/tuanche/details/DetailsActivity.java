package com.bwf.tuanche.details;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bwf.framwork.base.BaseActivity;
import com.bwf.framwork.bean.CarDetailBean;
import com.bwf.framwork.http.HttpCallBack;
import com.bwf.framwork.http.HttpHelper;
import com.bwf.framwork.utils.DisplayUtil;
import com.bwf.framwork.utils.IntentUtils;
import com.bwf.framwork.utils.ToastUtil;
import com.bwf.framwork.utils.UrlUtils;
import com.bwf.tuanche.MyApplication;
import com.bwf.tuanche.R;
import com.bwf.tuanche.details.fragment.CarDetailFragment1;
import com.bwf.tuanche.details.fragment.CarDetailFragment2;
import com.bwf.tuanche.details.fragment.CarListPopuWindow;
import com.bwf.tuanche.home_page.MainActivity;
import com.bwf.tuanche.home_page.activity.view.sharePopupWindow;

/**
 * 详情页
 */
public class DetailsActivity extends BaseActivity implements CarDetailFragment1.MyCallBack {
    private String styleId, cityId, brandId, firmbrandId;
    //标题View
    private TextView tv_back, tv_brand, tv_city, tv_share;
    private CarDetailFragment1 carDetailFragment1;
    private CarDetailFragment2 carDetailFragment2;
    private LinearLayout ll_layout;
    private CarListPopuWindow carListPopuWindow;

    @Override
    public int getContentViewId() {
        return R.layout.activity_details;
    }

    @Override
    public void beforeInitView() {
        showPogressbar();
        cityId = MyApplication.getCityId();
        styleId = getIntent().getExtras().getString("styleId");
        brandId = getIntent().getExtras().getString("brandId");
        firmbrandId = getIntent().getExtras().getString("firmbrandId");
        Log.e("TAG", "cityId: "+cityId+"  styleId: "+styleId+"  brandId: "+brandId+"  firmbrandId: "+firmbrandId);
    }

    @Override
    public void initView() {
        tv_back = findViewByIdNoCast(R.id.tv_back);
        tv_city = findViewByIdNoCast(R.id.tv_city);
        tv_share = findViewByIdNoCast(R.id.tv_share);
        tv_brand = findViewByIdNoCast(R.id.tv_brand);
        ll_layout = findViewByIdNoCast(R.id.ll_layout);
        dismissSoftKeyboard(this);
        setOnClick(tv_back, tv_city, tv_share);
        carDetailFragment1 = (CarDetailFragment1) getSupportFragmentManager().findFragmentById(R.id.detail_fragment1);
        carDetailFragment2 = (CarDetailFragment2) getSupportFragmentManager().findFragmentById(R.id.detail_fragment2);
        carDetailFragment1.setMyCallBack(this);
    }

    @Override
    public void initData() {
        if (cityId != null && !cityId.isEmpty()) {
            if (styleId != null && !styleId.isEmpty() && brandId != null && !brandId.isEmpty()) {
                formCarbrandId();
            } else if (firmbrandId != null && !firmbrandId.isEmpty()) {
                formCarfirmbrandId();
            } else if ((styleId == null && brandId == null) || firmbrandId == null) {
                dissmissProgressbar();
                IntentUtils.openActivity(this, MainActivity.class);
                ToastUtil.showToast("参数异常，数据加载失败");
            }
        }
    }

    public void formCarbrandId() {
        HttpHelper.getCarDetail(UrlUtils.CAR_BUY_DETAIL, styleId, cityId, brandId, new HttpCallBack<CarDetailBean>() {
            @Override
            public void onSuccess(CarDetailBean result) {
                dissmissProgressbar();
                Log.e("TAG", "onSuccess: " + result);
                if (result != null) {
                    tv_brand.setText(result.brandName);
                    tv_city.setText(cityId);
                    carDetailFragment1.setCarDetailBean(result);
                    carDetailFragment2.setCarDetailBean(result);
                }
            }

            @Override
            public void onFail(String errMsg) {
                dissmissProgressbar();
                ToastUtil.showToast("数据加载失败");
                Log.e("TAG", "errMsg: " + errMsg);
            }
        });
    }

    public void formCarfirmbrandId() {
        HttpHelper.getHotCarDetail(UrlUtils.CAR_BUY_DETAIL, cityId, firmbrandId, new HttpCallBack<CarDetailBean>() {
            @Override
            public void onSuccess(CarDetailBean result) {
                dissmissProgressbar();
                Log.e("TAG", "onSuccess: " + result);
                if (result != null) {
                    tv_brand.setText(result.brandName);
                    tv_city.setText(cityId);
                    carDetailFragment1.setCarDetailBean(result);
                    carDetailFragment2.setCarDetailBean(result);
                }
            }

            @Override
            public void onFail(String errMsg) {
                dissmissProgressbar();
                ToastUtil.showToast("数据加载失败");
                Log.e("TAG", "errMsg: " + errMsg);
            }
        });
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.tv_back:
                IntentUtils.openActivity(DetailsActivity.this, MainActivity.class);
                break;
            case R.id.tv_city:
                IntentUtils.openActivity(DetailsActivity.this, MainActivity.class);
                break;
            case R.id.tv_share:
                sharePopupWindow popupWindow = new sharePopupWindow(DetailsActivity.this);
                popupWindow.showPopWindow(view);
                break;
        }
    }

    @Override
    public void showPop() {
        Bundle bundle = new Bundle();
        bundle.putString("cityId", MyApplication.getCityId());
        bundle.putString("brandId", brandId);
        bundle.putString("styleId", styleId);
        bundle.putString("type", "0");
        carListPopuWindow = new CarListPopuWindow(DetailsActivity.this, bundle);
        carListPopuWindow.setAnimationStyle(R.style.AnimationRightFade);
        carListPopuWindow.showAsDropDown(ll_layout, DisplayUtil.getDensity_Width(DetailsActivity.this), 0);
    }
}
