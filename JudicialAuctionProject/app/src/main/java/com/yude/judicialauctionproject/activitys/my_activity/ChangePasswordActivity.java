package com.yude.judicialauctionproject.activitys.my_activity;

import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.yude.judicialauctionproject.R;
import com.yude.judicialauctionproject.base.BaseActivity;
import com.yude.judicialauctionproject.utils.TickerUtil;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * 修改密码
 */
public class ChangePasswordActivity extends BaseActivity {

    @BindView(R.id.l_title_iv)
    ImageView l_title_iv;
    @BindView(R.id.r_title_iv)
    ImageView r_title_iv;
    @BindView(R.id.tile_tv)
    TextView tile_tv;
    // 账号
    @BindView(R.id.account_number_tv)
    TextView account_number_tv;
    // 当前密码
    @BindView(R.id.now_pwd_et)
    EditText now_pwd_et;
    //  新密码
    @BindView(R.id.new_pwd_et)
    EditText new_pwd_et;
    //  手机号码
    @BindView(R.id.ptone_number_et)
    EditText ptone_number_et;
    //  验证码按键
    @BindView(R.id.verification_code_btn)
    Button verification_code_btn;
    //  验证码
    @BindView(R.id.verification_code_et)
    EditText verification_code_et;
    //   确认提交
    @BindView(R.id.submit_btn)
    Button submit_btn;
// 快熟清楚原密码
    @BindView(R.id.clean_now_pwd_iv)
    ImageView clean_now_pwd_iv;
// 快速清除 新密码
    @BindView(R.id.clean_new_pwd_iv)
    ImageView clean_new_pwd_iv;


    @Override
    public int getContentViewId() {
        return R.layout.activity_my_change_password;
    }

    @Override
    protected void initViews(Bundle bundle) {
        initTitle();
        setCodeBorder();
        editTextListener();

        /*GradientDrawable drawable = new GradientDrawable();
        drawable.setShape(GradientDrawable.RECTANGLE); // 画框
        drawable.setStroke(1, 0xffc82015); // 边框粗细及颜色
        drawable.setColor(0x22FFFFFF); // 边框内部颜色
        verification_code_btn.setBackgroundDrawable(drawable);*/
    }






    private void initTitle() {
        l_title_iv.setVisibility(View.VISIBLE);
        r_title_iv.setVisibility(View.INVISIBLE);
        tile_tv.setText("修改密码");

    }


    @Override
    protected void initData() {
        account_number_tv.setText(m_account_number);

    }


    // 设置 返回验证码边框
    private void setCodeBorder() {

        GradientDrawable drawable = new GradientDrawable();
        drawable.setShape(GradientDrawable.RECTANGLE); // 画框
        drawable.setStroke(1, 0xffc82015); // 边框粗细及颜色
        drawable.setColor(0x22FFFFFF); // 边框内部颜色
        verification_code_btn.setBackgroundDrawable(drawable);


    }


    // 默认当前账号和密码
    String m_account_number = "123456";
    String m_pwd = "1";
    String m_code = "1";

    String now_pwd;
    String new_pwd;
    String ptone_number;
    String verification_code;

    @OnClick({R.id.l_title_iv, R.id.verification_code_btn, R.id.submit_btn , R.id.clean_now_pwd_iv ,R.id.clean_new_pwd_iv})
    void click(View v) {
        switch (v.getId()) {
            case R.id.l_title_iv:
                finish();
                break;
            case R.id.verification_code_btn:
                Toast.makeText(this, "点击了获取验证码", Toast.LENGTH_SHORT).show();
                new TickerUtil(6 * 1000, 1000, verification_code_btn, 1, this).start();

                break;
            case R.id.submit_btn:
                Toast.makeText(this, "点击了提交", Toast.LENGTH_SHORT).show();
                getTextAll();

                if (now_pwd.equals(m_pwd) && now_pwd != null) {

                    if (verification_code.equals(m_code) && verification_code != null) {

                        //   这里写请求网络

                        finish();

                    } else {

                        Toast.makeText(this, "验证码不正确，请重新输入", Toast.LENGTH_SHORT).show();
                    }


                } else {
                    Toast.makeText(this, "当前密码不正确，请重新输入", Toast.LENGTH_SHORT).show();
                }


                break;

            case  R.id.clean_now_pwd_iv :
                now_pwd_et.setText("");

             break;
            case R.id.clean_new_pwd_iv:
                new_pwd_et.setText("");
            break;


        }
    }


    private  void  editTextListener(){

        now_pwd_et.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            // 输入中
            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                if (charSequence.length()>0){
                    clean_now_pwd_iv.setVisibility(View.VISIBLE);
                } else {
                    clean_now_pwd_iv.setVisibility(View.GONE);
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });


        new_pwd_et.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                if (charSequence.length()>0){
                    clean_new_pwd_iv.setVisibility(View.VISIBLE);
                } else {
                    clean_new_pwd_iv.setVisibility(View.GONE);
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
    }




    //拿到输入
    private void getTextAll() {
        now_pwd = now_pwd_et.getText().toString().trim();
        new_pwd = new_pwd_et.getText().toString().trim();
        ptone_number = ptone_number_et.getText().toString().trim();
        verification_code = verification_code_et.getText().toString().trim();

    }


}
