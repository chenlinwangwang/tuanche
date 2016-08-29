package com.bwf.framwork.http;

//<<<<<<< HEAD
import android.text.TextUtils;
import android.util.Log;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONException;
import com.bwf.framwork.base.BaseBean;
//=======
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONException;
import com.bwf.framwork.base.BaseBean;
import com.bwf.framwork.utils.StringUtils;
import com.bwf.framwork.utils.ToastUtil;
//>>>>>>> ccf2ba2db449a64a64016fb74c5fad692d968087
import com.zhy.http.okhttp.callback.StringCallback;

import java.lang.reflect.ParameterizedType;
import java.util.List;
//<<<<<<< HEAD
//=======
//
//>>>>>>> ccf2ba2db449a64a64016fb74c5fad692d968087
import okhttp3.Call;

/**
 * Created by Lizhangfeng on 2016/8/16 0016.
 * Description: http回调
 */
public abstract class HttpArrayCallBack<T> extends StringCallback {

    private Class<T> tClass;

    public HttpArrayCallBack() {
        tClass = (Class<T>) ((ParameterizedType) getClass()
                .getGenericSuperclass()).getActualTypeArguments()[0];
    }

    @Override
    public void onError(Call call, Exception e, int id) {
        onFail("网络异常");
    }

    @Override
    public void onResponse(String response, int id) {

        if (!TextUtils.isEmpty(response)) {

            Log.e("tag", "服务器返回结果: " + response);

            try {

                BaseBean baseBean = JSON.parseObject(response, BaseBean.class);

                if ("10000".equals(baseBean.code)) {

                    if (!TextUtils.isEmpty(baseBean.result))
                        onSuccess(JSON.parseArray(baseBean.result, tClass));
                    else
                        onFail("result is empty");

                } else {
                    onFail(baseBean.msg);
                }
            } catch (JSONException e) {
//=======
                if (StringUtils.isNotEmpty(response)) {


                    try {

                        BaseBean baseBean = JSON.parseObject(response, BaseBean.class);
//                ToastUtil.showToastLong(response);
                        if ("10000".equals(baseBean.code)) {
                            onSuccess(JSON.parseArray(baseBean.result, tClass));
                        } else {
                            onFail(baseBean.msg);
                        }
                    } catch (JSONException j) {
                        j.printStackTrace();
//>>>>>>> ccf2ba2db449a64a64016fb74c5fad692d968087
                        onFail("解析异常");
                    }


//<<<<<<< HEAD
                } //else
//=======

            }}else
//>>>>>>> ccf2ba2db449a64a64016fb74c5fad692d968087
            onFail("服务器返回内容为空");
//        }
    }

    public abstract void onSuccess(List<T> result);

    public abstract void onFail(String errMsg);

}
