package com.bwf.tuanche.home_page.fragment;

import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bwf.framwork.base.BaseFragment;
import com.bwf.framwork.image.ImageLoader;
import com.bwf.framwork.utils.IntentUtils;
import com.bwf.framwork.utils.LogUtils;
import com.bwf.framwork.utils.ToastUtil;
import com.bwf.tuanche.R;
import com.bwf.tuanche.details.HJiaDetailActivity;
import com.bwf.tuanche.home_page.Bean.BannerBean;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;
//婚姻座驾
public class Fragment_5 extends BaseFragment {
    private TextView tv_hunyin, tv_zuihao, tv_gouche,
            tv_wenxin, tv_lvxing, tv_zou, tv_shangwu, tv_yilu, tv_bailing, tv_zizai,
            tv_daibu, tv_sheng;
    private SimpleDraweeView img_hunyin, img_gouche, img_lvxing,
            img_shangwu, img_bailing, img_daibu;
    private List<BannerBean.Position_banner> position_banner;
    private RelativeLayout rl_hunyinzuojia;
    private RelativeLayout rl_mamigouche;
    private RelativeLayout rl_zijialvxing;
    private RelativeLayout rl_shangwuzhuangxiang;
    private RelativeLayout rl_bailingEzu;
    private RelativeLayout rl_daibuyoudao;

    public void setPosition_banner(List<BannerBean.Position_banner> position_banner) {
        this.position_banner = position_banner;
        initData();
    }

    @Override
    protected int getResource() {
        return R.layout.fragment_fragment_5;
    }

    @Override
    protected void beforeInitView() {
        tv_hunyin = findViewByIdNoCast(R.id.tv_hunyin);
        tv_zuihao = findViewByIdNoCast(R.id.tv_zuihao);
        tv_gouche = findViewByIdNoCast(R.id.tv_gouche);
        tv_wenxin = findViewByIdNoCast(R.id.tv_wenxin);
        tv_lvxing = findViewByIdNoCast(R.id.tv_lvxing);
        tv_zou = findViewByIdNoCast(R.id.tv_zou);
        tv_shangwu = findViewByIdNoCast(R.id.tv_shangwu);
        tv_yilu = findViewByIdNoCast(R.id.tv_yilu);
        tv_bailing = findViewByIdNoCast(R.id.tv_bailing);
        tv_zizai = findViewByIdNoCast(R.id.tv_zizai);
        tv_daibu = findViewByIdNoCast(R.id.tv_daibu);
        tv_sheng = findViewByIdNoCast(R.id.tv_sheng);
        img_hunyin = findViewByIdNoCast(R.id.img_hunyin);
        img_gouche = findViewByIdNoCast(R.id.img_gouche);
        img_lvxing = findViewByIdNoCast(R.id.img_lvxing);
        img_shangwu = findViewByIdNoCast(R.id.img_shangwu);
        img_bailing = findViewByIdNoCast(R.id.img_bailing);
        img_daibu = findViewByIdNoCast(R.id.img_daibu);

        rl_hunyinzuojia=findViewByIdNoCast(R.id.rl_hunyinzuojia);
        rl_mamigouche=findViewByIdNoCast(R.id.rl_mamigouche);
        rl_zijialvxing=findViewByIdNoCast(R.id.rl_zijialvxing);
        rl_shangwuzhuangxiang=findViewByIdNoCast(R.id.rl_shangwuzhuangxiang);
        rl_bailingEzu=findViewByIdNoCast(R.id.rl_bailingEzu);
        rl_daibuyoudao=findViewByIdNoCast(R.id.rl_daibuyoudao);
        rl_hunyinzuojia.setOnClickListener(this);
        rl_mamigouche.setOnClickListener(this);
        rl_zijialvxing.setOnClickListener(this);
        rl_shangwuzhuangxiang.setOnClickListener(this);
        rl_bailingEzu.setOnClickListener(this);
        rl_daibuyoudao.setOnClickListener(this);
    }

    @Override
    protected void initView(View rootView) {


    }

    @Override
    protected void initData() {
        if (position_banner != null) {
            tv_hunyin.setText(position_banner.get(0).bigTitle);
            tv_zuihao.setText(position_banner.get(0).subTitle);
            ImageLoader.getInstance().disPlayImage(img_hunyin, position_banner.get(0).iconUrl);
            tv_gouche.setText(position_banner.get(1).bigTitle);
            tv_wenxin.setText(position_banner.get(1).subTitle);
            ImageLoader.getInstance().disPlayImage(img_gouche, position_banner.get(1).iconUrl);

            tv_lvxing.setText(position_banner.get(5).bigTitle);
            tv_zou.setText(position_banner.get(5).subTitle);
            ImageLoader.getInstance().disPlayImage(img_lvxing, position_banner.get(5).iconUrl);

            tv_shangwu.setText(position_banner.get(2).bigTitle);
            tv_yilu.setText(position_banner.get(2).subTitle);
            ImageLoader.getInstance().disPlayImage(img_shangwu, position_banner.get(2).iconUrl);

            tv_bailing.setText(position_banner.get(3).bigTitle);
            tv_zizai.setText(position_banner.get(3).subTitle);
            ImageLoader.getInstance().disPlayImage(img_bailing, position_banner.get(3).iconUrl);
            tv_daibu.setText(position_banner.get(4).bigTitle);
            tv_sheng.setText(position_banner.get(4).subTitle);
            ImageLoader.getInstance().disPlayImage(img_daibu, position_banner.get(4).iconUrl);


        }
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.rl_hunyinzuojia:
                Bundle bundle = new Bundle();
                bundle.putString("cityId","156");
                IntentUtils.openActivity(getContext(), HJiaDetailActivity.class,bundle);
                break;
            case R.id.rl_mamigouche:

                break;
            case R.id.rl_zijialvxing:

                break;
            case R.id.rl_shangwuzhuangxiang:

                break;
            case R.id.rl_bailingEzu:

                break;
            case R.id.rl_daibuyoudao:
                break;
        }
    }
}
