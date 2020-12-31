package com.gy.shoppproject.adapterClass;

import com.gy.shoppproject.base.BaseModel;
import com.gy.shoppproject.base.BaseView;
import com.gy.shoppproject.bean.AlbumBean;
import com.gy.shoppproject.bean.ClasBean;
import com.gy.shoppproject.bean.ClasData;
import com.gy.shoppproject.bean.HomeBean;
import com.gy.shoppproject.utils.InetCallBack;

public
class ClassContract {
    public interface ClassView extends BaseView {
        void getClas(ClasBean clasBean);
        void getClasData(ClasData clasData);

    }
    public interface ClassModel extends BaseModel {
        void getClas(CallBack callBack);
        void getClasData(int id,CallBack callBack);
    }
    public interface ClassPersenter{
       void getClas();
       void getClasData(int id);
    }
}
