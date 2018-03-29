package com.example.lenovo.retrofit_task_post;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Headers;
import retrofit2.http.POST;

/**
 * Created by LENOVO on 23-03-2018.
 */

interface ApiResponse {
    public static final String api1 = "http://giftzay.vmgtelecoms.com/api/History/";

    @Headers("Accept: application/json")
    @FormUrlEncoded
    @POST("api/History")
    Call<Transactions> request(@Field("Uid") String id);

}
