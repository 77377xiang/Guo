package com.yude.judicialauctionproject.activitys;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.yude.judicialauctionproject.R;
import com.yude.judicialauctionproject.base.BaseActivity;
import com.yude.judicialauctionproject.utils.TickerUtil;
import com.yude.judicialauctionproject.utils.ToastUtil;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * . 短信验证登陆
 */
public class PhoneVerificationActivity extends BaseActivity {

    @BindView(R.id.pwd_login_tv)
    TextView pwd_login_tv;

    @BindView(R.id.account_login_btn)
    Button account_login_btn;

    @BindView(R.id.code_btn)
    Button code_btn;

    @BindView(R.id.input_code_et)
    EditText input_code_et;

    @BindView(R.id.phone_number_et)
    EditText phone_number_et;

    private String phone_number = null;
    private  String Code_numebr = null;
    TickerUtil ticker;

    @Override
    public int getContentViewId() {
        return R.layout.activiry_phone_verification;
    }

    @Override
    protected void initViews(Bundle bundle) {

    }

    @Override
    protected void initData() {

    }


    @OnClick({R.id.code_btn, R.id.account_login_btn, R.id.pwd_login_tv,R.id.phone_number_et,R.id.input_code_et})
    void click(View v) {
        switch (v.getId()) {
            case R.id.code_btn:
               // getCodeNumebr();
                new TickerUtil(60*1000,1000,code_btn).start();
                //Toast.makeText(this,"点击啦返回码",Toast.LENGTH_SHORT).show();
               // handler.postDelayed(runnable, 1000);
                break;
            case R.id.account_login_btn:


                break;
            case R.id.pwd_login_tv:
                Toast.makeText(this,"点击啦登陆",Toast.LENGTH_SHORT).show();
                finish();

                break;

        }
    }

//判断登陆
    private  void getPwdLogin(){

        String telNum=phone_number_et.getText().toString().trim();
        String varCode=input_code_et.getText().toString().trim();


        if ((telNum==null||varCode==null) ||(telNum.equals("")||varCode.equals(""))) {
            ToastUtil.showToastLong(this,"请输入正确的手机号或验证码");
        }else {

            // 请求登陆
        }


    }

    //获取验证码
    private  void  getCodeNumebr(){

        phone_number=phone_number_et.getText().toString().trim();

        if (phone_number==null||phone_number.equals("")){

            ToastUtil.showToastLong(this,"请输入正确的手机号");
        }else {

            //请求网络拿到验证码    调用 做倒计时
            //  new TickerUtil(60*1000,1000,code_btn).start();
        }


    }



    public int recLen = 10;
    Handler handler = new Handler();
    Runnable runnable = new Runnable() {
        @Override
        public void run() {

            recLen--;
            if (recLen>=0){
                code_btn.setText("有效时间" + recLen+" s");
            }
            handler.postDelayed(this, 1000);

            if (recLen == 0){
                code_btn.setText("发送验证码");
            }

        }

    };





}
