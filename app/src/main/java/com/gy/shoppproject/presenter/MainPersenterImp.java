package com.gy.shoppproject.presenter;

import com.gy.shoppproject.base.BasePresenter;
import com.gy.shoppproject.bean.AlbumBean;
import com.gy.shoppproject.bean.ClasBean;
import com.gy.shoppproject.bean.ClasData;
import com.gy.shoppproject.bean.HomeBean;
import com.gy.shoppproject.contract.MainContract;
import com.gy.shoppproject.model.MainModelImp;
import com.gy.shoppproject.utils.InetCallBack;
import com.gy.shoppproject.utils.URLConstart;

public
class MainPersenterImp extends BasePresenter<MainContract.MainView,MainContract.MainModel> implements MainContract.MainPersenter {
    @Override
    protected MainContract.MainModel getIModel() {
        return new MainModelImp(this);
    }

    @Override
    public void Home() {
        iModel.getModel(URLConstart.Home_Url, new InetCallBack<HomeBean>() {
            @Override
            public void onSuccess(HomeBean homeBean) {
                iView.getHome(homeBean);
            }

            @Override
            public void onFail(String error) {
                iView.onError(error);
            }
        });
    }

    @Override
    public void Album() {
        iModel.getModel(URLConstart.Album_Url, new InetCallBack<AlbumBean>() {
            @Override
            public void onSuccess(AlbumBean albumBean) {
                iView.getAlbum(albumBean);
            }

            @Override
            public void onFail(String error) {
                iView.onError(error);
            }
        });
    }

    @Override
    public void Album2() {
        iModel.getModel(URLConstart.Album_Url2, new InetCallBack<AlbumBean>() {
            @Override
            public void onSuccess(AlbumBean albumBean) {
                iView.getAlbum2(albumBean);
            }

            @Override
            public void onFail(String error) {
                iView.onError(error);
            }
        });
    }

    @Override
    public void getClas() {
        iModel.getModel(URLConstart.Clas_Url, new InetCallBack<ClasBean>() {
            @Override
            public void onSuccess(ClasBean clasBean) {
                iView.getClas(clasBean);
            }

            @Override
            public void onFail(String error) {
                iView.onError(error);
            }
        });
    }


}
