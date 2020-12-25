package com.gy.shoppproject.base;

public
abstract class BasePresenter <V extends BaseView,M extends BaseModel>{
    public V iView;
    public M iModel;
    public void attachView(V v){
        iView=v;
        iModel=getIModel();

    }
    public void detachView(){
        iView=null;
        iModel=null;
    }
    protected abstract M getIModel();
}
