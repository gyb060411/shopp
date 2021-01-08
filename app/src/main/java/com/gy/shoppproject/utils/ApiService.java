package com.gy.shoppproject.utils;

import com.gy.shoppproject.bean.ClasBean;
import com.gy.shoppproject.bean.ClasData;
import com.gy.shoppproject.login.bean.LoginBean;

import java.util.HashMap;

import io.reactivex.Observable;
import okhttp3.ResponseBody;
import retrofit2.http.Field;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.HeaderMap;
import retrofit2.http.POST;
import retrofit2.http.Query;
import retrofit2.http.Url;

public
interface ApiService {

    @GET
    Observable<ResponseBody> get(@Url String url);


    @GET("api/catalog/index")
    Observable<ClasBean> get();


    @GET("api/catalog/current")
    Observable<ClasData> getSub(@Query("id") int id);

    @POST
    @FormUrlEncoded
    Observable<ResponseBody> getlogin(@Url String url, @FieldMap HashMap<String, String> map, @HeaderMap HashMap<String, String> headers);
}
