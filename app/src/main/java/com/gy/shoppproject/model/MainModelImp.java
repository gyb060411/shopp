package com.gy.shoppproject.model;

import com.gy.shoppproject.contract.MainContract;
import com.gy.shoppproject.utils.InetCallBack;
import com.gy.shoppproject.utils.RetrofitUtils;

public
class MainModelImp implements MainContract.MainModel {
    private MainContract.MainPersenter persenter;

    public MainModelImp(MainContract.MainPersenter persenter) {
        this.persenter = persenter;
    }

    @Override
    public <T> void getModel(String url, InetCallBack<T> inetCallBack) {
        RetrofitUtils.getInstance().get(url,inetCallBack);
    }
}
