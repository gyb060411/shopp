package com.gy.shoppproject.cart.presenter;

import android.util.Log;

import com.gy.shoppproject.base.BasePresenter;
import com.gy.shoppproject.cart.bean.CartBean;
import com.gy.shoppproject.cart.contract.CartContract;
import com.gy.shoppproject.cart.model.CartModel;
import com.gy.shoppproject.utils.InetCallBack;
import com.gy.shoppproject.utils.URLConstart;

public

class CartPresenter extends BasePresenter<CartContract.View,CartContract.Model> implements  CartContract.Presenter {

    @Override
    public void getCartList() {

        iModel.getCartList(URLConstart.Cart_URL, new InetCallBack<CartBean>() {
            @Override
            public void onSuccess(CartBean cartBean) {
                iView.setCartList(cartBean);
            }

            @Override
            public void onFail(String error) {
                iView.setFail(error);
            }
        });
    }

    @Override
    public void deleteCartShoping(String shopID) {

    }


    @Override
    protected CartContract.Model getIModel() {
        return new CartModel();
    }
}
