package com.ziadsyahrul.expandablerecyclerpercobaan.network;

import com.ziadsyahrul.expandablerecyclerpercobaan.model.ResponseHome;

import retrofit2.Call;
import retrofit2.Response;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Header;
import retrofit2.http.POST;

public interface ApiInterface {

    @FormUrlEncoded
    @POST("v1/links")
    Call<ResponseHome> getList(@Field("account_id") String account_id,
                               @Field("mobile") String mobile,
                               @Header("Authorization") String auth);

}
