package com.bwf.framwork.http;

//<<<<<<< HEAD
import android.text.TextUtils;
import android.util.Log;
//=======
import android.util.Log;

//>>>>>>> ccf2ba2db449a64a64016fb74c5fad692d968087
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONException;
import com.bwf.framwork.base.BaseBean;
import com.zhy.http.okhttp.callback.StringCallback;
import java.lang.reflect.ParameterizedType;
import okhttp3.Call;

/**
 * Created by Lizhangfeng on 2016/8/16 0016.
 * Description: http回调
 */
public abstract class HttpCallBack<T> extends StringCallback {

    private Class<T> tClass;

    public HttpCallBack() {
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

//<<<<<<< HEAD
            Log.e("tag","服务器返回结果: " + response);

            try {

                BaseBean baseBean = JSON.parseObject(response, BaseBean.class);

                if ("10000".equals(baseBean.code)) {

                    if (!TextUtils.isEmpty(baseBean.result))
                        onSuccess(JSON.parseObject(baseBean.result, tClass));
                    else
                        onFail("result is empty");

                } else {
                    onFail(baseBean.msg);
                }
            } catch (JSONException e) {
//=======
            try{

                BaseBean baseBean = JSON.parseObject(response, BaseBean.class);
//                ToastUtil.showToastLong(response);
                if ("10000".equals(baseBean.code)){
//                    Log.e("tag",baseBean.toString());
                    Log.e("tag",response+"");
                    onSuccess(JSON.parseObject(baseBean.result,tClass));
                }else {
                    onFail(baseBean.msg);
                }
            }catch (JSONException j){
                j.printStackTrace();
//>>>>>>> ccf2ba2db449a64a64016fb74c5fad692d968087
                onFail("解析异常");
            }
        } }else
            onFail("服务器返回内容为空");

    }

    public abstract void onSuccess(T result);

    public abstract void onFail(String errMsg);

}
