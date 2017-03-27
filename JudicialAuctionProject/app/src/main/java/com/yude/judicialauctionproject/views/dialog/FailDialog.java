package com.yude.judicialauctionproject.views.dialog;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.yude.judicialauctionproject.R;

/**
 * 登陆失败的对话框
 */
public class FailDialog extends Dialog implements View.OnClickListener{


    TextView ok_tv;
    private String getVerificationCode;
    private  Context context;

    FailDialogListener listener;

    public FailDialog(Context context, FailDialogListener listener) {
        super(context);
        this.context = context;
        this.listener = listener;
    }




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        Window window = getWindow();
        window.setGravity(Gravity.CENTER);
        View view = LayoutInflater.from(context).inflate(R.layout.dialog_login_fail_code, null);
        setContentView(view);
        initViews(view);
        WindowManager.LayoutParams params = window.getAttributes();
        params.width = ((Activity) context).getWindowManager()
                .getDefaultDisplay().getWidth() * 5 / 6;
        window.setAttributes(params);

    }

    public interface FailDialogListener {
        void onClick(View view);
    }


    @Override
    public void onClick(View v) {
        listener.onClick(v);

    }


    private void initViews(View view) {
        ok_tv = (TextView) view.findViewById(R.id.ok_tv);
        ok_tv.setOnClickListener(this);

    }





}