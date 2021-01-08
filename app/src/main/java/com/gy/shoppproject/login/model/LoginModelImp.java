package com.gy.shoppproject.login.model;

import com.gy.shoppproject.contract.MainContract;
import com.gy.shoppproject.login.logincontract.LoginContract;
import com.gy.shoppproject.utils.InetCallBack;
import com.gy.shoppproject.utils.RetrofitUtils;

import java.util.HashMap;

public
class LoginModelImp implements LoginContract.LoginModel {

    @Override
    public <T> void getLogin_Model(String url, HashMap<String, String> hashMap, HashMap<String, String> headers, InetCallBack<T> inetCallBack) {

        RetrofitUtils.getInstance().getlogin(url, hashMap, headers, inetCallBack);
    }
}
