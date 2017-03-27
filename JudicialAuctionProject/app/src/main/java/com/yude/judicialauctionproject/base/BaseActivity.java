package com.yude.judicialauctionproject.base;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Window;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by hexiang on 17/3/2.
 */
public abstract class BaseActivity extends AppCompatActivity{


    private Unbinder unbinder;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(getContentViewId());
        unbinder = ButterKnife.bind(this);
        initViews(savedInstanceState);
        initData();
    }

    public abstract int getContentViewId();
    protected abstract void initViews(Bundle bundle);
    protected abstract void initData();


    @Override
    protected void onDestroy() {
        super.onDestroy();
        unbinder.unbind();
    }








}
