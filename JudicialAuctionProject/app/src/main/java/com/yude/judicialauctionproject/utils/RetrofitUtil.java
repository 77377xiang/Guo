package com.yude.judicialauctionproject.utils;


import com.yude.judicialauctionproject.consts.ConstUtil;
import com.yude.judicialauctionproject.interfaces.HttpService;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by north on 16/10/17.
 */
public class RetrofitUtil {

    public static HttpService initRatrofit(){
        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient httpClient = new OkHttpClient.Builder()
                .addInterceptor(logging)//添加打印拦截器
                .connectTimeout(30, TimeUnit.SECONDS)//设置请求超时时间
                .retryOnConnectionFailure(true)//设置出现错误进行重新连接。
                .build();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ConstUtil.BAIDU)
                .client(httpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        HttpService httpService = retrofit.create(HttpService.class);

        return httpService;
    }


}
