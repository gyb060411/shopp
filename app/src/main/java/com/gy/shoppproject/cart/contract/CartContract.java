package com.gy.shoppproject.cart.contract;

import com.gy.shoppproject.adapterClass.CallBack;
import com.gy.shoppproject.base.BaseModel;
import com.gy.shoppproject.base.BaseView;
import com.gy.shoppproject.cart.bean.CartBean;
import com.gy.shoppproject.utils.InetCallBack;

import java.util.HashMap;

public
class CartContract {
    public interface View extends BaseView {
        void setCartList(CartBean cartList);
        void setFail(String error);
    }
    public interface Model extends BaseModel {
        <T>void getCartList(String url, InetCallBack<T> callBack);
        <I> void Next1(int id,CallBack<I> callBack);
        void deleteCartShoping(String url, HashMap<String,String> hashMap);;
    }
    public interface Presenter{
        void getCartList();
        void deleteCartShoping(String shopID);
    }
}
