package com.bwf.tuanche.test;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bwf.framwork.base.BaseActivity;
import com.bwf.framwork.base.BaseModel;
import com.bwf.framwork.bean.BusBean;
import com.bwf.framwork.db.DBHelper;
import com.bwf.framwork.db.model.BusInfoModel;
import com.bwf.framwork.db.model.UserModel;
import com.bwf.tuanche.R;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ScanRecordActivity extends BaseActivity {

    private TextView scan1,scan2,scan3,scan4,tv_scn;
    private Button btn_scce;
    private int[] imgs = {R.mipmap.pic_liucheng_1,R.mipmap.pic_liucheng_2,R.mipmap.pic_liucheng_3,R.mipmap.pic_liucheng_4};
    private String[] names = {"车型1","车型2","车型3","车型4"};
    private BusInfoModel busInfoModel =  new BusInfoModel();;

    @Override
    public int getContentViewId() {
        return R.layout.activity_scan_record;
    }

    @Override
    public void beforeInitView() {


    }

    @Override
    public void initView() {
        scan1 = (TextView) findViewById(R.id.scan1);
        scan2 = (TextView) findViewById(R.id.scan2);
        scan3 = (TextView) findViewById(R.id.scan3);
        scan4 = (TextView) findViewById(R.id.scan4);
        tv_scn = (TextView) findViewById(R.id.tv_scn);
        btn_scce = (Button) findViewById(R.id.btn_scre);

        setOnClick(scan1,scan2,scan3,scan4,btn_scce);
    }

    @Override
    public void initData() {

       //

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.scan1:
                //加入数据到浏览记录的数据库
                //插入数据
                busInfoModel.insertUser(new BusBean("1","奔驰1号","图片地址1","指导价格1"));
                break;
            case R.id.scan2:
                busInfoModel.insertUser(new BusBean("2","奔驰2号","图片地址2","指导价格2"));
                break;
            case R.id.scan3:
                busInfoModel.insertUser(new BusBean("3","奔驰3号","图片地址3","指导价格3"));
                break;
            case R.id.scan4:
                busInfoModel.insertUser(new BusBean("4","奔驰4号","图片地址4","指导价格4"));
                break;
            case R.id.btn_scre:
                //查詢數據需要時間  所以在加载数据的时候进不逊延时加载  确保万一
//                tv_scn.postDelayed(new Runnable() {
//                    @Override
//                    public void run() {
//                        //查询数据
//                        BusBean busBean = busInfoModel.getBusById("4");//查询bueid为1的数据
//
//                        tv_scn.setText(busBean.busname);
//                    }
//                },2000);//延时两秒
                tv_scn.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        //查询数据
                        List<BusBean> busBean = busInfoModel.getAllBusById();//查询所有的数据

                        tv_scn.setText("dear "+busBean.toString());
                    }
                },2000);//延时两秒

                break;
        }
    }

    public void insertdata(){
        //同时插入多条数据
        busInfoModel.insertmore();
    }
}
