package com.yude.judicialauctionproject.interfaces;

import com.yude.judicialauctionproject.entity.response.UserResponse;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 *
 */
public interface HttpService {

    /**
     * 登陆
     */
    @FormUrlEncoded
    @POST("appLoginMD5")
    Call<UserResponse> getUserByLogin(@Field("account") String account, @Field("passwordKey") String passwordKey);

    /**
     * 获取任务列表<加头>
     */
    @GET("projectTask/taskList")
    Call<UserResponse> getTaskList(@Header("Cookie") String Cookie, @Query("difference") String difference, @Query("isDeal") String isDeal, @Query("pageSize") String pageSize, @Query("number") String number);


    @GET("/") // 因为我们是解析首页，也就是根目录，所以这边写"/"
    Call<UserResponse> getBaidu();





}