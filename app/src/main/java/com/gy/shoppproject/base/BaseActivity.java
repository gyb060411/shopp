package com.gy.shoppproject.base;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public
abstract class BaseActivity <P extends BasePresenter> extends AppCompatActivity implements BaseView {
    public P persenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutID());
        if(persenter==null){
            persenter=getPersenter();
            persenter.attachView(this);
        }
        initView();
        initData();

    }

    protected abstract int getLayoutID();

    protected abstract P getPersenter();

    protected abstract void initData();

    protected abstract void initView();


    //解绑mvp
    @Override
    protected void onDestroy() {
        super.onDestroy();
        if(persenter!=null){
            persenter.detachView();
        }
    }
}
