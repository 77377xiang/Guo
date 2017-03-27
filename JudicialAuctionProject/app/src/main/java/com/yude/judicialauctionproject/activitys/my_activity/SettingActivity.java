package com.yude.judicialauctionproject.activitys.my_activity;

import android.Manifest;
import android.app.NotificationManager;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Vibrator;
import android.support.v4.content.ContextCompat;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

import com.yude.judicialauctionproject.R;
import com.yude.judicialauctionproject.activitys.LoginActivity;
import com.yude.judicialauctionproject.base.BaseActivity;


/**
 * Created by hexiang on 17/3/4.
 */
public class SettingActivity extends BaseActivity implements View.OnClickListener {
    TextView tile_tv;
    Button exit_tv;
    ImageView l_title_iv, modify_iv, r_title_iv;
    ToggleButton new_TogBtn, sound_TogBtn, vibrated_TogBtn;

    NotificationManager objNotificationManager;
    Vibrator vibrator;
   // PackageManager pm = getPackageManager();

    @Override
    public int getContentViewId() {
        return R.layout.activity_my_setting;
    }

    @Override
    protected void initViews(Bundle bundle) {


        new_TogBtn = (ToggleButton) findViewById(R.id.new_TogBtn);
        sound_TogBtn = (ToggleButton) findViewById(R.id.sound_TogBtn);
        vibrated_TogBtn = (ToggleButton) findViewById(R.id.vibrated_TogBtn);
        modify_iv = (ImageView) findViewById(R.id.modify_iv);
        exit_tv = (Button) findViewById(R.id.exit_btn);
        initTitle();

        new_TogBtn.setOnClickListener(this);
        sound_TogBtn.setOnClickListener(this);
        vibrated_TogBtn.setOnClickListener(this);
        l_title_iv.setOnClickListener(this);
        modify_iv.setOnClickListener(this);
        exit_tv.setOnClickListener(this);


        new_TogBtn.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(CompoundButton buttonView,
                                         boolean isChecked) {
                // TODO Auto-generated method stub
                if (isChecked) {
                    Toast.makeText(SettingActivity.this, "开", Toast.LENGTH_LONG).show();
                } else {

                    Toast.makeText(SettingActivity.this, "关", Toast.LENGTH_LONG).show();

                }
            }
        });


        sound_TogBtn.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(CompoundButton buttonView,
                                         boolean isChecked) {
                // TODO Auto-generated method stub
                if (isChecked) {
                    Toast.makeText(SettingActivity.this, "开", Toast.LENGTH_LONG).show();
                } else {

                    Toast.makeText(SettingActivity.this, "关", Toast.LENGTH_LONG).show();

                }
            }
        });

        vibrated_TogBtn.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(CompoundButton buttonView,
                                         boolean isChecked) {
                // TODO Auto-generated method stub
                if (isChecked) {
                    Toast.makeText(SettingActivity.this, "开", Toast.LENGTH_LONG).show();
                    getVibrator();
                } else {

                    vibrator.cancel();
                    Toast.makeText(SettingActivity.this, "关", Toast.LENGTH_LONG).show();

                }
            }
        });

    }

    //开启通知
    private void getNotificationManager() {

        //声明通知（message）管理器只需知道它是用来管理通知消息的就行了
        objNotificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);


    }


    ////震动效果的系统服务
    private void getVibrator() {

//需要的权限
        String[] permissions = {Manifest.permission.VIBRATE};

        int i = ContextCompat.checkSelfPermission(this, permissions[0]);

        // 版本判断。当手机系统大于 23 时，才有必要去判断权限是否获取
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            // 检查该权限是否已经获取
            // 权限是否已经 授权 GRANTED---授权  DINIED---拒绝
            if (i != PackageManager.PERMISSION_GRANTED) {
                // 如果没有授予该权限，就去提示用户请求
                Toast.makeText(this,"需要开启震动权限",Toast.LENGTH_LONG).show();

            }

        }else {

            vibrator = (Vibrator) getSystemService(VIBRATOR_SERVICE);
            long[] patyern = {170,100};
            vibrator.vibrate(patyern,-1);
        }

    }


    private void initTitle() {
        tile_tv = (TextView) findViewById(R.id.tile_tv);
        l_title_iv = (ImageView) findViewById(R.id.l_title_iv);
        r_title_iv = (ImageView) findViewById(R.id.r_title_iv);
        tile_tv.setText("设置");
        l_title_iv.setImageResource(R.mipmap.h_fanhui);
        l_title_iv.setVisibility(View.VISIBLE);
        r_title_iv.setVisibility(View.INVISIBLE);


    }

    @Override
    protected void initData() {

    }


    @Override
    public void onClick(View view) {

        switch (view.getId()) {

            //  改密码
            case R.id.modify_iv:
                Intent intent = new Intent(this, ChangePasswordActivity.class);
                startActivity(intent);

                break;
            //  退出
            case R.id.exit_btn:

                finish();
                startActivity(new Intent(this, LoginActivity.class));

                Toast.makeText(SettingActivity.this, "点击了退出", Toast.LENGTH_SHORT).show();

                break;

            case R.id.l_title_iv:
                finish();

                break;

        }


    }
}
