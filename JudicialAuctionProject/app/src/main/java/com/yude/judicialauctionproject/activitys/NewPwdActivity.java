package com.yude.judicialauctionproject.activitys;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.yude.judicialauctionproject.R;
import com.yude.judicialauctionproject.base.BaseActivity;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * 找回密码
 */
public class NewPwdActivity extends BaseActivity {

    @BindView(R.id.back_iv)
    ImageView back_iv;

    @BindView(R.id.phone_number_et)
    EditText phone_number_et;

    @BindView(R.id.input_code_et)
    EditText input_code_et;

    @BindView(R.id.input_newpwd_et)
    EditText input_newpwd_et;

    @BindView(R.id.account_login_btn)
    Button account_login_btn;

    @BindView(R.id.code_btn)
    Button code_btn;


    @Override
    public int getContentViewId() {
        return R.layout.activiry_newpwd;
    }

    @Override
    protected void initViews(Bundle bundle) {

    }

    @Override
    protected void initData() {

    }


    @OnClick({R.id.back_iv, R.id.account_login_btn, R.id.code_btn})
    void click(View v) {
        switch (v.getId()) {
            case R.id.back_iv:
                finish();
                break;
            case R.id.account_login_btn:
                Toast.makeText(this, "点击啦完成", Toast.LENGTH_SHORT).show();
                finish();

                break;
            case R.id.code_btn:
                Toast.makeText(this, "验证码", Toast.LENGTH_SHORT).show();
                    handler.postDelayed(runnable, 1000);
                break;


        }
    }


    //
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
