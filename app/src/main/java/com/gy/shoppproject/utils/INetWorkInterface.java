package com.gy.shoppproject.utils;

public
interface INetWorkInterface {
    <T>void  get(String url,InetCallBack<T> callBack);
}
