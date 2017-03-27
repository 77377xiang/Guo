package com.yude.judicialauctionproject.activitys;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.yude.judicialauctionproject.MainActivity;
import com.yude.judicialauctionproject.R;
import com.yude.judicialauctionproject.base.BaseActivity;
import com.yude.judicialauctionproject.entity.response.UserResponse;
import com.yude.judicialauctionproject.interfaces.HttpService;
import com.yude.judicialauctionproject.consts.ConstUtil;
import com.yude.judicialauctionproject.utils.DensityUtil;
import com.yude.judicialauctionproject.utils.RetrofitUtil;
import com.yude.judicialauctionproject.views.dialog.FailDialog;
import com.yude.judicialauctionproject.views.dialog.VerificationCodeDialog;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by hexiang on 17/3/2.
 */
public class LoginActivity extends BaseActivity implements View.OnClickListener {

    EditText account_login_input_tel_et, input_password_et;
    Button account_login_btn;
    TextView forget_pwd_tv;

    ImageView clean_number_iv,clean_pwd_iv;
    private String user_input_userName;
    private String uesr_input_password;
    VerificationCodeDialog verificationCodeDialog;
    FailDialog failDialog;

    @Override
    public int getContentViewId() {
        return R.layout.activiry_longin;
    }


    @Override
    protected void initViews(Bundle bundle) {

        account_login_input_tel_et = (EditText) findViewById(R.id.account_login_input_tel_et);
        input_password_et = (EditText) findViewById(R.id.input_password_et);
        account_login_btn = (Button) findViewById(R.id.account_login_btn);
        forget_pwd_tv = (TextView) findViewById(R.id.forget_pwd_tv);
        clean_number_iv = (ImageView) findViewById(R.id.clean_number_iv);
        clean_pwd_iv = (ImageView) findViewById(R.id.clean_pwd_iv);

        editTextListener();
        clean_number_iv.setOnClickListener(this);
        clean_pwd_iv.setOnClickListener(this);
        account_login_btn.setOnClickListener(this);
        forget_pwd_tv.setOnClickListener(this);

    }



    // 输入框的动态监听
    private  void  editTextListener(){

        account_login_input_tel_et.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            // 输入中
            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                if (charSequence.length()>0){
                    clean_number_iv.setVisibility(View.VISIBLE);
                } else {
                    clean_number_iv.setVisibility(View.GONE);
                }


            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });


        input_password_et.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                if (charSequence.length()>0){
                    clean_pwd_iv.setVisibility(View.VISIBLE);
                } else {
                    clean_pwd_iv.setVisibility(View.GONE);
                }

            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });


    }



    @Override
    protected void initData() {
        uesr_input_password = input_password_et.getText().toString().trim();
        user_input_userName = account_login_input_tel_et.getText().toString().trim();


    }

    //点击登陆 弹出验证码对话框，输入手机验证号码，点击确定登陆。
    @Override
    public void onClick(View view) {

        switch (view.getId()) {
            case R.id.account_login_btn:
                initData();
                login();

                if (user_input_userName != null && uesr_input_password != null && user_input_userName.equals("1") && uesr_input_password.equals("1")) {
                    dialogListener();
                    verificationCodeDialog.show();
                    //startActivity(new Intent(LoginActivity.this, MainActivity.class));
                    Toast.makeText(LoginActivity.this, "登陆成功正在加载", Toast.LENGTH_SHORT).show();
                    // finish();

                } else {
                    Toast.makeText(LoginActivity.this, "账号或密码不能为空", Toast.LENGTH_SHORT).show();
                    failDialog = new FailDialog(this, new FailDialog.FailDialogListener() {
                        @Override
                        public void onClick(View view) {
                            Toast.makeText(LoginActivity.this, "点击了确定", Toast.LENGTH_SHORT).show();
                            failDialog.dismiss();
                        }
                    });

                    failDialog.show();
                }

                break;

            case R.id.forget_pwd_tv:

                startActivity(new Intent(LoginActivity.this, ForgetPwdActivity.class));
                break;


            case R.id.clean_number_iv :
                account_login_input_tel_et.setText("");
                break;

            case R.id.clean_pwd_iv :
                input_password_et.setText("");

                break;

        }
    }


    private void dialogListener() {

        verificationCodeDialog = new VerificationCodeDialog(this, new VerificationCodeDialog.VerificationCodeDialogListener() {
            @Override
            public void onClick(View view, String getVerificationCode) {

                Toast.makeText(LoginActivity.this, "点击了对话框", Toast.LENGTH_SHORT).show();
                if (getVerificationCode.equals("1")) {
                    verificationCodeDialog.dismiss();
                    startActivity(new Intent(LoginActivity.this, MainActivity.class));

                } else {

                    //这里有问题，拿到到验证码
                    Toast.makeText(LoginActivity.this, "验证码不正确" + "", Toast.LENGTH_SHORT).show();
                    Toast.makeText(LoginActivity.this, "getVerificationCode" + "", Toast.LENGTH_SHORT).show();

                }

            }
        });
    }


    //登陆的网路请求
    private void login() {


       /*
        //死的不用改变
        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient httpClient = new OkHttpClient.Builder()
                .addInterceptor(logging)//添加打印拦截器
                .connectTimeout(30, TimeUnit.SECONDS)//设置请求超时时间
                .retryOnConnectionFailure(true)//设置出现错误进行重新连接。
                .build();
//获得 retrofit并与baseUrl 进行跑拼接，
        Retrofit retrofit = new Retrofit.Builder().baseUrl(ConstUtil.BAIDU).client(httpClient).addConverterFactory(GsonConverterFactory.create()).build();
        //  Retrofit retrofit = new Retrofit.Builder().baseUrl(ConstUtil.WEB_URL).addConverterFactory(GsonConverterFactory.create()).build();
        HttpService httpService = retrofit.create(HttpService.class);

*/
        //需要请求的东西
        // String account = "sc";
        // String passwordKey = MD5Utils.getMD5Str("123456");
        //向服务器发送请求，

        Call<UserResponse> call = RetrofitUtil.initRatrofit().getBaidu();


      //  Call<UserResponse> call = httpService.getBaidu();

        call.enqueue(new Callback<UserResponse>() {
            @Override//请求成功
            public void onResponse(Call<UserResponse> call, Response<UserResponse> response) {

                //  token = response.body().getResult().getJSESSIONID();
                // Toast.makeText(TsetActivity.this, token, Toast.LENGTH_LONG).show();
                // Toast.makeText(MainActivity.this, "respone" + response.body().getData().getUser().getImagpath(), Toast.LENGTH_LONG).show();
            }

            @Override//请求失败
            public void onFailure(Call<UserResponse> call, Throwable t) {


            }

        });
    }





}


