package com.bwf.tuanche.details;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.bwf.framwork.base.BaseActivity;
import com.bwf.framwork.bean.HJiaBean;
import com.bwf.framwork.http.HttpCallBack;
import com.bwf.framwork.http.HttpHelper;
import com.bwf.framwork.image.ImageLoader;
import com.bwf.framwork.utils.IntentUtils;
import com.bwf.framwork.utils.ToastUtil;
import com.bwf.framwork.utils.UrlUtils;
import com.bwf.tuanche.MyApplication;
import com.bwf.tuanche.R;
import com.bwf.tuanche.details.adapter.DividerItemDecoration;
import com.bwf.tuanche.details.adapter.HJiaReccleViewAdapter;
import com.bwf.tuanche.home_page.MainActivity;
import com.facebook.drawee.view.SimpleDraweeView;

public class HJiaDetailActivity extends BaseActivity {
    private TextView tv_hj_back, tv_hj_share, tv_hj_brand;
    private SimpleDraweeView sdv_hjia;
    private RecyclerView rv_hjia;
    private HJiaReccleViewAdapter hJiaReccleViewAdapter;
    private DividerItemDecoration itemDecoration;
    private String cityId;

    @Override
    public int getContentViewId() {
        return R.layout.activity_hjia_detail;
    }

    @Override
    public void beforeInitView() {
        cityId = MyApplication.getCityId();
    }

    @Override
    public void initView() {
        showPogressbar();
        tv_hj_back = findViewByIdNoCast(R.id.tv_hj_back);
        tv_hj_share = findViewByIdNoCast(R.id.tv_hj_share);
        tv_hj_brand = findViewByIdNoCast(R.id.tv_hj_brand);
        sdv_hjia = findViewByIdNoCast(R.id.sdv_hjia);
        rv_hjia = findViewByIdNoCast(R.id.rv_hjia);
        setOnClick(tv_hj_back, tv_hj_share);
        itemDecoration = new DividerItemDecoration(HJiaDetailActivity.this, LinearLayoutManager.VERTICAL, R.drawable.divider_item);
    }

    @Override
    public void initData() {
        HttpHelper.getHJiaData(UrlUtils.CAR_BUY_HJia, new HttpCallBack<HJiaBean>() {
            @Override
            public void onSuccess(final HJiaBean result) {
                dissmissProgressbar();
                if (result != null){
                    tv_hj_brand.setText(result.adpTitle);
                    ImageLoader.getInstance().disPlayImage(sdv_hjia, result.adpLogo);
                    hJiaReccleViewAdapter = new HJiaReccleViewAdapter(MyApplication.getAppContext());
                    hJiaReccleViewAdapter.setCarstyleList(result);
                    hJiaReccleViewAdapter.setMyHJCallBack(new HJiaReccleViewAdapter.MyHJCallBack() {
                        @Override
                        public void OnClick(int position) {
                            Bundle bundle = new Bundle();
                            bundle.putString("styleId", result.carstyleList.get(position).brandId);
                            bundle.putString("cityId", cityId);
                            bundle.putString("brandId", result.carstyleList.get(position).brandId);
                            IntentUtils.openActivity(HJiaDetailActivity.this, DetailsActivity.class, bundle);
                        }
                    });
                    LinearLayoutManager manager = new LinearLayoutManager(MyApplication.getAppContext());
                    rv_hjia.setLayoutManager(manager);
                    rv_hjia.setAdapter(hJiaReccleViewAdapter);
                    rv_hjia.addItemDecoration(itemDecoration);
                }
            }

            @Override
            public void onFail(String errMsg) {
                dissmissProgressbar();
                ToastUtil.showToast("数据加载失败");
            }
        });
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.tv_hj_back:
                IntentUtils.openActivity(this, MainActivity.class);
                break;
            case R.id.tv_hj_share:
                IntentUtils.openActivity(this, MainActivity.class);
                break;
        }
    }
}
