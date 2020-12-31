package com.gy.shoppproject.utils;

import com.gy.shoppproject.bean.ClasBean;
import com.gy.shoppproject.bean.ClasData;

import io.reactivex.Observable;
import okhttp3.ResponseBody;
import retrofit2.http.GET;
import retrofit2.http.Query;
import retrofit2.http.Url;

public
interface ApiService {
    String BASE_URL = "http://cdplay.cn/";
    @GET
    Observable<ResponseBody> get(@Url String url);


    @GET("api/catalog/index")
    Observable<ClasBean> get();


    @GET("api/catalog/current")
    Observable<ClasData> getSub(@Query("id")int id);
}
