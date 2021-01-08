package com.gy.shoppproject.login;

import com.gy.shoppproject.login.app.MyApplication;
import com.gy.shoppproject.login.bean.LoginBean;
import com.tencent.mmkv.MMKV;

public
class UserInfoUtils {

    public static boolean isSave=true;

    public static LoginBean.DataBean getLoginInfo(){
        return null;
    }

    public static void setToken(){


        if (isSave){
            MMKV mmkv = MMKV.defaultMMKV();
            mmkv.encode("token","");
        }else{

            MyApplication.dataBean.setToken("");
        }
    }
}
