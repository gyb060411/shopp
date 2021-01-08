package com.gy.shoppproject.login.app;

import android.app.Application;

import com.gy.shoppproject.login.bean.LoginBean;
import com.tencent.mmkv.MMKV;

public
class MyApplication extends Application {
    public MyApplication application;
    public static LoginBean.DataBean dataBean;

//    public static MyApplication getApplication() {
//        return this;
//    }

    @Override
    public void onCreate() {
        super.onCreate();
        this.application=this;
        MMKV.initialize(this);
    }
}
