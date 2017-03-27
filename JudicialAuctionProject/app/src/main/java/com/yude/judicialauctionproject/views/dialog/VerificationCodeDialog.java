package com.yude.judicialauctionproject.views.dialog;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.text.Editable;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.yude.judicialauctionproject.R;
import com.yude.judicialauctionproject.activitys.LoginActivity;

/**
 * 验证码对话框
 */
public class VerificationCodeDialog extends Dialog implements View.OnClickListener {

    EditText verification_code_et;
    Button ok_btn;
    VerificationCodeDialogListener listener;
    private String getVerificationCode;
    private  Context context;

    public VerificationCodeDialog(Context context, VerificationCodeDialogListener listener) {
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
        View view = LayoutInflater.from(context).inflate(R.layout.dialog_login_verification_code, null);
        setContentView(view);
        initViews(view);
        WindowManager.LayoutParams params = window.getAttributes();
        params.width = ((Activity) context).getWindowManager()
                .getDefaultDisplay().getWidth() * 5 / 6;
        window.setAttributes(params);

    }

    public interface VerificationCodeDialogListener {
        void onClick(View view, String getVerificationCode);
    }

    private void initViews(View view) {
        ok_btn = (Button) view.findViewById(R.id.ok_btn);
        verification_code_et = (EditText) view.findViewById(R.id.code_et);
        getVerificationCode= verification_code_et.getText().toString();
        ok_btn.setOnClickListener(this);

    }



    @Override
    public void onClick(View v) {
        String str=verification_code_et.getText().toString();
        listener.onClick(v,str);

    }


}
