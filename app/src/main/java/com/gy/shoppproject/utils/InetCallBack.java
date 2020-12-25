package com.gy.shoppproject.utils;

public
interface InetCallBack<T> {
    void onSuccess(T t);
    void onFail(String error);
}
