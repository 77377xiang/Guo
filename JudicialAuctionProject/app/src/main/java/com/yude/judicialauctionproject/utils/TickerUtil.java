package com.yude.judicialauctionproject.utils;

import android.content.Context;
import android.graphics.Color;
import android.os.CountDownTimer;
import android.widget.Button;
import com.yude.judicialauctionproject.R;


/**
 * 定时器工具类
 * Created by PersonalFolder on 16/11/2.
 */
public class TickerUtil extends CountDownTimer {

    private Button button;
    private int color;
    private Context context;


    public TickerUtil(long millisInFuture, long countDownInterval, Button button) {
        super(millisInFuture, countDownInterval);
        this.button = button;


    }

    // color==1 为 b0b0b0
    public TickerUtil(long millisInFuture, long countDownInterval, Button button, int color, Context context) {
        super(millisInFuture, countDownInterval);
        this.button = button;
        this.color = color;
        this.context = context;

    }


    @Override
    public void onFinish() {// 计时完毕
        button.setText("获取验证码");

        if (color == 1) {
            button.setTextColor(context.getResources().getColor(R.color._b0b0b0_word));
            button.setTextSize(10);

        } else {
            button.setTextColor(Color.WHITE);
        }


        // button.setBackgroundResource(R.drawable.thirdlogin_btn1_bg);
        button.setClickable(true);
    }

    @Override
    public void onTick(long millisUntilFinished) {// 计时过程
        button.setClickable(false);//防止重复点击
        button.setText(millisUntilFinished / 1000 + " s重新获取");
        button.setTextColor(Color.BLACK);
        // button.setBackgroundResource(R.drawable.thirdlogin_btn2_bg);
        button.setTextSize(9);

    }


}
