package com.bwf.tuanche.update;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.bwf.framwork.base.BaseBean;
import com.bwf.framwork.http.HttpCallBack;
import com.bwf.framwork.http.HttpHelper;
import com.bwf.framwork.utils.ToastUtil;
import com.bwf.framwork.utils.UrlUtils;
import com.bwf.tuanche.R;
import com.bwf.tuanche.update.updateBean.UpdateResult;

/**
 * Created by ZWP on 2016/8/18.
 * Explain:版本更新的pop
 */
public class UpdatePopupWindow extends PopupWindow implements View.OnClickListener{

    private TextView tv_update_neirong,tv_update_banben;//更新内容  更新版本
    private ImageView img_update_back;//取消
    private Button btu_update;//立即跟新
    private Context context;

    public UpdatePopupWindow(Context context) {
        super(context);
        this.context = context;
        initView();
    }

    public UpdatePopupWindow(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public UpdatePopupWindow(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }


    public void initView(){
        //加载pop布局
        View view = View.inflate(context, R.layout.pop_update,null);
        //设置pop参数
        this.setContentView(view);//加载布局
        this.setFocusable(true);//可获取焦点
        this.setWidth(ViewGroup.LayoutParams.MATCH_PARENT);
        this.setHeight(ViewGroup.LayoutParams.MATCH_PARENT);
//        this.setOutsideTouchable(true);//设置可以点击外部

        //初始化里面控件
        tv_update_neirong = (TextView) view.findViewById(R.id.tv_update_neirong);
        tv_update_banben = (TextView) view.findViewById(R.id.tv_update_banben);
        img_update_back = (ImageView) view.findViewById(R.id.img_update_back);
        btu_update = (Button) view.findViewById(R.id.btu_update);
         //设置监听
        img_update_back.setOnClickListener(this);
        btu_update.setOnClickListener(this);

        //更新获取
        getUpdateDate();

    }

    //pop显示位置
    @Override
    public void showAtLocation(View parent, int gravity, int x, int y) {
        super.showAtLocation(parent, gravity, x, y);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.img_update_back://取消
                //取消pop
                this.dismiss();
                break;
            case R.id.btu_update://立即更新
                ToastUtil.showToast("开始下载！");
                this.dismiss();
                break;
        }
    }

    /**
     * 请求更新数据
     */
    public void getUpdateDate(){
        HttpHelper.getNewVersion(UrlUtils.VersionUpadteServlet, new com.bwf.framwork.db.HttpCallBack<UpdateResult>() {
            @Override
            public void onSuccess(UpdateResult result) {
//                Log.e("UpdateResult","UpdateResult " +result.toString());
                //设置更新内容的显示
                tv_update_neirong.setText(result.description);
                //设置更新版本
                tv_update_banben.setText(result.versionName);
            }

            @Override
            public void onFail(String errMsg) {

            }
        });


    }
}
