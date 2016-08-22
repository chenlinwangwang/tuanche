package com.bwf.tuanche.Login;

import android.text.Editable;
import android.text.InputFilter;
import android.text.TextWatcher;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.Button;
import android.widget.CheckedTextView;
import android.widget.EditText;
import android.widget.ImageView;

import com.bwf.framwork.base.BaseActivity;
import com.bwf.framwork.utils.ToastUtil;
import com.bwf.tuanche.R;

/**
 * 登陆界面
 */
public class LoginActivity extends BaseActivity {
    private CheckedTextView ctv_login1, ctv_login2; //快速登录  账号登陆
    private ImageView img_login_back, img_login_clean1, img_login_clean2;//返回  清空1  清空2
    private EditText et_login_sjhm, et_login_yzm;//手机号码  验证码
    private Button btn_login_yzm, btn_login_logingin;//获取验证码  验证码登录
    private Boolean state1 = false;
    private Boolean state2 = false;
    private int position;
    private String phone = "";
    @Override
    public int getContentViewId() {
        return R.layout.activity_login;
    }

    @Override
    public void beforeInitView() {

    }

    @Override
    public void initView() {
        ctv_login1 = findViewByIdNoCast(R.id.ctv_login1);
        ctv_login2 = findViewByIdNoCast(R.id.ctv_login2);
        img_login_back = findViewByIdNoCast(R.id.img_login_back);
        img_login_clean1 = findViewByIdNoCast(R.id.img_login_clean1);
        img_login_clean2 = findViewByIdNoCast(R.id.img_login_clean2);
        et_login_sjhm = findViewByIdNoCast(R.id.et_login_sjhm);
        et_login_yzm = findViewByIdNoCast(R.id.et_login_yzm);
        btn_login_yzm = findViewByIdNoCast(R.id.btn_login_yzm);
        btn_login_logingin = findViewByIdNoCast(R.id.btn_login_logingin);
        //设置初始状态
        initState();
        //设置监听
        setOnClick(ctv_login1, ctv_login2, img_login_back, btn_login_yzm, btn_login_logingin, img_login_clean1, img_login_clean2);


    }

    @Override
    public void initData() {
        //设置输入框的长度监听
        setSJHMTextChangeListener();

        setYZMTextChangeListener();

    }


    /**
     * 初始状态
     */
    public void initState() {
        position = 1;//1是左边  2是右边  默认左边
        ctv_login1.setBackgroundResource(R.mipmap.round_red_left);//红色
        btn_login_yzm.setBackground(getResources().getDrawable(R.drawable.yzdl_nor));
        btn_login_logingin.setBackground(getResources().getDrawable(R.drawable.yzdl_nor));
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.ctv_login1://快速登录
                //设置快速登录为被选中状态
                ctv_login1.setBackgroundResource(R.mipmap.round_red_left);
                //账号登录为非选择状态
                ctv_login2.setBackgroundResource(R.mipmap.round_white_right);
                //隐藏获取验证码按钮
                btn_login_yzm.setVisibility(View.VISIBLE);
                //输入提示由输入验证码改变为输入密码
                et_login_yzm.setHint("请输入验证码");
                //改变登录提示为登陆
                btn_login_logingin.setText("验证登陆");

                break;
            case R.id.ctv_login2://账号登录
                //设置账号登录为被选中状态
                ctv_login2.setBackgroundResource(R.mipmap.round_red_right);
                //快速登录为非选择状态
                ctv_login1.setBackgroundResource(R.mipmap.round_white_left);
                //隐藏获取验证码按钮
                btn_login_yzm.setVisibility(View.GONE);
                //输入提示由输入验证码改变为输入密码
                et_login_yzm.setHint("请输入密码");
                //改变登录提示为登陆
                btn_login_logingin.setText("登陆");

                //设置状态
                position = 2;
                et_login_yzm.setFilters(new InputFilter[]{new InputFilter.LengthFilter(20)});//动态设置输入框的最大输入长度（密码最长20位）
                et_login_yzm.setTransformationMethod(PasswordTransformationMethod.getInstance());//动态设置文本框的输入类型（这里是密码）

                break;
            case R.id.img_login_back://返回

                break;
            case R.id.btn_login_yzm://获取验证码

                break;
            case R.id.btn_login_logingin://验证码登陆
                if (position == 1){//表示快速登陆

                }else{//账号登录

                }
                break;
            case R.id.img_login_clean1://清空手机号
                et_login_sjhm.setText("");
                break;
            case R.id.img_login_clean2://清空码登陆
                et_login_yzm.setText("");
                break;
        }

    }



    /**
     * 手机号码输入框的监听
     */
    public void setSJHMTextChangeListener() {


        et_login_sjhm.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                if (charSequence.length() > 0) {
                    img_login_clean1.setVisibility(View.VISIBLE);
                } else {
                    img_login_clean1.setVisibility(View.GONE);
                }
                if(charSequence.length() != 11){
                    //还原登陆按钮
                    btn_login_logingin.setBackgroundResource(R.drawable.yzdl_nor);
                }
                if (charSequence.length() == 11) {//当输入的手机号码达到11位的时候
                    //验证码按钮可以点击，颜色变红
//                    btn_login_yzm.setFocusable(true);
                    state1 = true;
                    btn_login_yzm.setBackgroundResource(R.drawable.yzm_login);
                    if (state2)
                        //登陆按钮变红
                        btn_login_logingin.setBackgroundResource(R.drawable.yzm_login);
                } else {
                    state1 = false;
                    btn_login_yzm.setBackgroundResource(R.drawable.yzdl_nor);

                }

            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
    }

    /**
     * 验证码输入框的监听
     */
    public void setYZMTextChangeListener() {
        et_login_yzm.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {


                    if (charSequence.length() > 0 ) {
                        state2 = true;
                        img_login_clean2.setVisibility(View.VISIBLE);
                        if (state1)
                            //登陆按钮变红
                            btn_login_logingin.setBackgroundResource(R.drawable.yzm_login);

                    } else {
                        btn_login_logingin.setBackgroundResource(R.drawable.yzdl_nor);
                        img_login_clean2.setVisibility(View.GONE);
                        state2 = false;
                    }

            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

    }
}
