package com.gy.shoppproject.login.logincontract;

import com.gy.shoppproject.base.BaseModel;
import com.gy.shoppproject.base.BaseView;
import com.gy.shoppproject.login.bean.LoginBean;
import com.gy.shoppproject.utils.InetCallBack;

import java.util.HashMap;

public
class LoginContract {
    public interface LoginView extends BaseView {
        void getLogin_View();
        void getError(String error);
    }
    public interface LoginModel extends BaseModel {
        <T>void getLogin_Model(String url, HashMap<String,String>map, HashMap<String, String> headers, InetCallBack<T> inetCallBack);
    }
    public interface LoginPresenter{
        void getLogin_Presenter(String name,String pass,boolean isSave);
    }
}
