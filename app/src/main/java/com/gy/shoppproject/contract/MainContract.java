package com.gy.shoppproject.contract;

import com.gy.shoppproject.base.BaseModel;
import com.gy.shoppproject.base.BaseView;
import com.gy.shoppproject.bean.AlbumBean;
import com.gy.shoppproject.bean.ClasBean;
import com.gy.shoppproject.bean.ClasData;
import com.gy.shoppproject.bean.HomeBean;
import com.gy.shoppproject.utils.InetCallBack;

public
class MainContract {
    public interface MainView extends BaseView{
        void getHome(HomeBean homeBean);
        void getAlbum(AlbumBean albumBean);
        void getAlbum2(AlbumBean albumBean);
        void getClas(ClasBean clasBean);
        void onError(String error);
    }
    public interface MainModel extends BaseModel{
        <T>void getModel(String url, InetCallBack<T> inetCallBack);
    }
    public interface MainPersenter{
        void Home();
        void Album();
        void Album2();
        void getClas();
    }
}
