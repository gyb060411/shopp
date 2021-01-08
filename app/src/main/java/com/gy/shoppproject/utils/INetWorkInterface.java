package com.gy.shoppproject.utils;

import java.util.HashMap;

public
interface INetWorkInterface {
    <T> void get(String url, InetCallBack<T> callBack);

    <T> void getlogin(String url, HashMap<String, String> hashMap, HashMap<String, String> headers, InetCallBack<T> callBack);
}
