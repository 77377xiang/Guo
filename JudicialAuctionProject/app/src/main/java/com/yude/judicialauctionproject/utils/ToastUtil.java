package com.yude.judicialauctionproject.utils;

import android.content.Context;
import android.content.res.Resources;
import android.view.Gravity;
import android.widget.Toast;

/**
 * Created by hexiang on 17/3/16.
 */
public class ToastUtil {

    private static Toast mToast = null;

    public static void showToast(Context context, String text, int duration) {
        cancelToast();
        mToast = Toast.makeText(context, text, duration);
        mToast.show();
    }

    public static void showToastShort(Context context, String text) {
        showToast(context, text, Toast.LENGTH_SHORT);
    }

    public static void showToastShort(Context context, int resId) {
        showToastShort(context, context.getString(resId));
    }

    public static void showToastLong(Context context, String text) {
        showToast(context, text, Toast.LENGTH_LONG);
    }

    public static void showToastLong(Context context, int resId) {
        showToastLong(context, context.getString(resId));
    }

    public static void cancelToast() {
        if (mToast != null) {
            mToast.cancel();
        }
    }

}
