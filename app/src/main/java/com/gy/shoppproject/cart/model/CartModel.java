package com.gy.shoppproject.cart.model;

import com.gy.shoppproject.adapterClass.CallBack;
import com.gy.shoppproject.cart.contract.CartContract;
import com.gy.shoppproject.utils.InetCallBack;
import com.gy.shoppproject.utils.RetrofitUtils;

import java.util.HashMap;

public
class CartModel implements CartContract.Model {


    @Override
    public <T> void getCartList(String url, InetCallBack<T> callBack) {
        RetrofitUtils.getInstance().get(url,callBack);
    }

    @Override
    public <I> void Next1(int id, CallBack<I> callBack) {

    }

    @Override
    public void deleteCartShoping(String url, HashMap<String, String> hashMap) {

    }
}
