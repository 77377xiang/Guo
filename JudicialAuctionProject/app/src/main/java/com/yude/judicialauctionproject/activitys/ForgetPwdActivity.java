package com.yude.judicialauctionproject.activitys;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import com.yude.judicialauctionproject.R;

/**
 * 忘记密码   透明
 */
public class ForgetPwdActivity extends Activity implements View.OnClickListener {

    TextView forget_pwd_tv;
    TextView Phone_verification_tv;
    TextView exit_tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.acvtivity_forgetpwd);
        // ForgetPwdActivity.this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        unTransparent();
        forget_pwd_tv = (TextView) findViewById(R.id.forget_pwd_tv);
        Phone_verification_tv = (TextView) findViewById(R.id.Phone_verification_tv);
        exit_tv = (TextView) findViewById(R.id.exit_tv);

        forget_pwd_tv.setOnClickListener(this);
        Phone_verification_tv.setOnClickListener(this);
        exit_tv.setOnClickListener(this);

    }

    private void unTransparent() {

        if (android.os.Build.VERSION.SDK_INT >= 14) {
            getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LOW_PROFILE);
            getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_HIDE_NAVIGATION);
        } else if (android.os.Build.VERSION.SDK_INT >= 16) {
            getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_FULLSCREEN);
            getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);
        }
    }


    @Override
    public void onClick(View view) {

        switch (view.getId()) {
            case R.id.forget_pwd_tv:

                startActivity(new Intent(ForgetPwdActivity.this, NewPwdActivity.class));
                Toast.makeText(ForgetPwdActivity.this, "点击了找回密码", Toast.LENGTH_SHORT).show();
                finish();
                break;

            case R.id.Phone_verification_tv:

                startActivity(new Intent(ForgetPwdActivity.this, PhoneVerificationActivity.class));
                Toast.makeText(ForgetPwdActivity.this, "点击了短息验证", Toast.LENGTH_SHORT).show();
                finish();
                break;
            case R.id.exit_tv:
                finish();
                break;


        }
    }
}
