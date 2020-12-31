package com.gy.shoppproject.adapterClass;

public
interface CallBack<T> {
    void success(T data);
    void fail(String error);
}
