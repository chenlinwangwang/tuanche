package com.bwf.tuanche.details.fragment;

import android.content.Context;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.provider.DocumentsContract;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.bwf.framwork.base.BaseFragment;
import com.bwf.framwork.bean.CarDetailBean;
import com.bwf.framwork.bean.TcbzDesc;
import com.bwf.framwork.image.ImageLoader;
import com.bwf.framwork.utils.DisplayUtil;
import com.bwf.framwork.utils.IntentUtils;
import com.bwf.framwork.utils.ToastUtil;
import com.bwf.tuanche.MainActivity;
import com.bwf.tuanche.R;
import com.bwf.tuanche.details.adapter.PromiseReccleViewAdapter;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

public class CarDetailFragment1 extends BaseFragment {
    private TextView tv_people, tv_saving, tv_tuanTime, tv_tuanAddress,et_carType;
    private EditText et_phone, et_name;
    private Button btn_apply;
    private RecyclerView rv_promise;
    private ImageView img_car_question;
    private SimpleDraweeView sdv_carPhoto;
    private CarDetailBean carDetailBean;
    private PromiseReccleViewAdapter adapter;
    private Bundle mBundle;
    private PopupWindow popupWindow;
    private CarListPopuWindow carListPopuWindow;
    private View myview;


    public void setCarDetailBean(CarDetailBean carDetailBean) {
        this.carDetailBean = carDetailBean;
        initData();
    }

    @Override
    protected int getResource() {
        return R.layout.fragment_car_detail_fragment1;
    }

    @Override
    protected void beforeInitView() {
    }

    @Override
    protected void initView(View rootView) {
        tv_people = findViewByIdNoCast(R.id.tv_people);
        tv_saving = findViewByIdNoCast(R.id.tv_saving);
        tv_tuanTime = findViewByIdNoCast(R.id.tv_tuanTime);
        tv_tuanAddress = findViewByIdNoCast(R.id.tv_tuanAddress);
        et_carType = findViewByIdNoCast(R.id.et_carType);
        et_phone = findViewByIdNoCast(R.id.et_phone);
        et_name = findViewByIdNoCast(R.id.et_name);
        btn_apply = findViewByIdNoCast(R.id.btn_apply);
        img_car_question = findViewByIdNoCast(R.id.img_car_question);
        sdv_carPhoto = findViewByIdNoCast(R.id.sdv_carPhoto);
        myview = findViewByIdNoCast(R.id.myview);
        rv_promise = findViewByIdNoCast(R.id.rv_promise);
        setOnClick(et_carType,img_car_question, btn_apply);
    }

    @Override
    protected void initData() {
        if (carDetailBean != null) {
            tv_people.setText(carDetailBean.manNumDesc);
            tv_saving.setText(carDetailBean.saveUpMoney);
            tv_tuanTime.setText(carDetailBean.groupbuyDate + "(" + carDetailBean.groupbuyWeek + ")");
            tv_tuanAddress.setText(carDetailBean.styleId + carDetailBean.regular4sShop);
            if (carDetailBean.styleId != null) {
                et_carType.setVisibility(View.VISIBLE);
                et_carType.setText(carDetailBean.styleId);
            }
            ImageLoader.getInstance().disPlayImage(sdv_carPhoto, carDetailBean.logo);

            //团车保证
            adapter = new PromiseReccleViewAdapter(getContext());
            adapter.setTcbzDescList(carDetailBean);
            GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(), 2);
            rv_promise.setLayoutManager(gridLayoutManager);
            rv_promise.setAdapter(adapter);
            adapter.notifyDataSetChanged();
        }
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_apply:
                String name = et_name.getText().toString();
                String phone = et_phone.getText().toString();
                if (name.isEmpty() && phone.isEmpty()) {
                    mBundle = new Bundle();
                    mBundle.putString("name", et_name.getText().toString());
                    mBundle.putString("phone", et_phone.getText().toString());
                    IntentUtils.openActivity(getContext(), MainActivity.class, mBundle);
                }
                break;
            case R.id.et_carType:
                Bundle bundle = new Bundle();
                bundle.putString("cityId", "156");
                bundle.putString("brandId", carDetailBean.brandId);
                bundle.putString("styleId", carDetailBean.styleId);
                carListPopuWindow = new CarListPopuWindow(getContext(), bundle);
                carListPopuWindow.setAnimationStyle(R.style.AnimationRightFade);
                carListPopuWindow.showAsDropDown(myview, DisplayUtil.getDensity_Width(getContext()),0);
                break;
            case R.id.img_car_question:
                showPopupWindow(img_car_question);
                break;
        }
    }

    /**
     * showPopupWindow Text
     */
    private void showPopupWindow(View view) {
        if (popupWindow == null) {
            View contentView = View.inflate(getContext(), R.layout.pop_window, null);
            popupWindow = new PopupWindow(contentView, ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
            popupWindow.setFocusable(true);//设置为ture，表示可以聚焦
            popupWindow.setBackgroundDrawable(new BitmapDrawable(getResources()));//设置背景，用物理键返回的时候
            popupWindow.setOutsideTouchable(true);

            contentView.setOnTouchListener(new View.OnTouchListener() {// 需要设置，点击之后取消popupview，即使点击外面，也可以捕获事件
                public boolean onTouch(View v, MotionEvent event) {
                    if (popupWindow.isShowing()) {
                        popupWindow.dismiss();
                    }
                    return false;
                }
            });
        }

        if (popupWindow.isShowing()) {
            popupWindow.dismiss();
        } else {
            popupWindow.showAsDropDown(view);// 显示再指定控件的下面
        }
    }

}
