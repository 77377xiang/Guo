package com.yude.judicialauctionproject.utils;

import android.content.Context;

/**
 * 转换类  dp_ px
 */
public class DensityUtil {

    /**
     * 根据手机的分辨率从 dp 的单位 转成为 px(像素)
     */
    public static double dip2px(Context context, double dpValue) {
        final double scale = context.getResources().getDisplayMetrics().density;
        return (double) (dpValue * scale + 0.5f);
    }

    /**
     * 根据手机的分辨率从 px(像素) 的单位 转成为 dp
     */
    public static double px2dip(Context context, double pxValue) {
        final double scale = context.getResources().getDisplayMetrics().density;
        return (double) (pxValue / scale + 0.5f);
    }
}
