package com.yude.judicialauctionproject.activitys;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.AlphaAnimation;
import android.widget.ImageView;

import com.yude.judicialauctionproject.MainActivity;
import com.yude.judicialauctionproject.R;
import com.yude.judicialauctionproject.base.BaseActivity;

import butterknife.BindView;

/**
 * Created by hexiang on 17/3/2.
 */
public class WelcomeActivity  extends BaseActivity{

    @BindView(R.id.welcome_iv)
    ImageView welcome_iv;


    @Override
    public int getContentViewId() {
        return R.layout.activity_welocm;
    }

    @Override
    protected void initViews(Bundle bundle) {
        backgroundAlpa();
        intentTheme();

    }

    @Override
    protected void initData() {

    }

    public void intentTheme() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(WelcomeActivity.this, LoginActivity.class);
                startActivity(intent);
                finish();
            }
        }, 2000);

    }

    private void backgroundAlpa() {
        final AlphaAnimation animation = new AlphaAnimation(0, 1);
        animation.setDuration(2000);//设置动画持续时间
        welcome_iv.setAnimation(animation);
    }


}
