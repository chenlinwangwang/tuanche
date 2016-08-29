package com.bwf.tuanche.home_page.activity;

import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.ImageView;

import com.bwf.framwork.base.BaseActivity;
import com.bwf.framwork.share.SharePrefreceHelper;
import com.bwf.framwork.utils.IntentUtils;
import com.bwf.tuanche.R;
import com.bwf.tuanche.home_page.MainActivity;
import com.bwf.tuanche.home_page.activity.adapter.MyAdapter;

public class GuideActivity extends BaseActivity {
    private ImageView img;
    private ViewPager viewPager;
    Integer[] imgs = new Integer[]{R.mipmap.guide01, R.mipmap.guide02};
    private MyAdapter adapter;
    private FragmentManager fragmentManager;
    private ImageView img_start;

    @Override
    public int getContentViewId() {
        return R.layout.activity_guide;
    }

    @Override
    public void beforeInitView() {
        img=findViewByIdNoCast(R.id.img);
        viewPager=findViewByIdNoCast(R.id.viewpager);
        fragmentManager = this.getSupportFragmentManager();
        adapter=new MyAdapter(fragmentManager);
        img_start=findViewByIdNoCast(R.id.img_start);
        img_start.setOnClickListener(this);
    }

    @Override
    public void initView() {
        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                setcheck(position);
                if (position==1){
                    img_start.setVisibility(View.VISIBLE);
                }else {
                    img_start.setVisibility(View.INVISIBLE);
                }
            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        viewPager.setOffscreenPageLimit(2);
        viewPager.setAdapter(adapter);
        adapter.notifyDataSetChanged();
        setcheck(0);
    }

    @Override
    public void initData() {

    }

    @Override
    public void onClick(View view) {
        if (view==img_start){
            SharePrefreceHelper.getInstence(GuideActivity.this).setIsFirst(false);
            IntentUtils.openActivity(GuideActivity.this,MainActivity.class);
           finish();
        }

    }
    public void setcheck(int position) {
        img.setImageResource(imgs[position]);
    }
}
