package com.gy.shoppproject.login.presenter;

import com.gy.shoppproject.base.BasePresenter;
import com.gy.shoppproject.login.app.MyApplication;
import com.gy.shoppproject.login.bean.LoginBean;
import com.gy.shoppproject.login.logincontract.LoginContract;
import com.gy.shoppproject.login.model.LoginModelImp;
import com.gy.shoppproject.login.view.LoginActivity;
import com.gy.shoppproject.utils.InetCallBack;
import com.gy.shoppproject.utils.URLConstart;
import com.tencent.mmkv.MMKV;

import java.util.HashMap;

public
class LoginPresenterImp extends BasePresenter<LoginActivity, LoginModelImp> implements LoginContract.LoginPresenter {


    @Override
    protected LoginModelImp getIModel() {
        return new LoginModelImp();
    }


    @Override
    public void getLogin_Presenter(String name, String pass, boolean isSave) {

        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("username", name);
        hashMap.put("password", pass);
        HashMap<String, String> headers = new HashMap<>();

        iModel.getLogin_Model(URLConstart.Login_Url, hashMap, headers, new InetCallBack<LoginBean>() {
            @Override
            public void onSuccess(LoginBean loginBean) {
                MMKV mmkv = MMKV.defaultMMKV();
                if (loginBean.getData().getCode() == 200) {
                        if(isSave){
//                            loginBean.getData().setToken("233");
                            mmkv.encode("loginInfo",loginBean.getData());
                        }else{
                            mmkv.removeValueForKey("loginInfo");
                        }
                        MyApplication.dataBean=loginBean.getData();
//                        mmkv.decodeParcelable("loginInfo",LoginBean.DataBean.class);

                    iView.getLogin_View();
//                        mmkv.encode("data",loginBean.getData());
                } else {
                    iView.getError("账号密码错误");
                }

            }

            @Override
            public void onFail(String error) {
                iView.getError(error);
            }
        });
    }
}
