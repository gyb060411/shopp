package com.gy.shoppproject.fragment;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.gy.shoppproject.R;
import com.gy.shoppproject.adapterClass.ClasAdapter;
import com.gy.shoppproject.base.BaseFragment;
import com.gy.shoppproject.bean.AlbumBean;
import com.gy.shoppproject.bean.ClasBean;
import com.gy.shoppproject.bean.ClasData;
import com.gy.shoppproject.bean.HomeBean;
import com.gy.shoppproject.contract.MainContract;
import com.gy.shoppproject.presenter.MainPersenterImp;
import com.gy.shoppproject.utils.ApiService;
import com.gy.shoppproject.utils.URLConstart;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;


public class CalsDadaFragment extends BaseFragment<MainPersenterImp> implements MainContract.MainView {


    private ImageView mImage;
    private TextView mTvName;
    private TextView mTvHeatName;
    private RecyclerView mRecyler;
    int id=1005001;
    private List<ClasData.DataBean.CurrentCategoryBean.SubCategoryListBean> subCategoryListBeans;
    private ClasAdapter clasAdapter1;


    protected void initView(View view) {
        mImage = view.findViewById(R.id.image);
        mTvName = view.findViewById(R.id.tv_name);
        mTvHeatName =view. findViewById(R.id.tv_heat_name);
        mRecyler = view.findViewById(R.id.recyler);
        //接收tablayout页面传过来的id
        Bundle arguments = getArguments();
        id = arguments.getInt("id");
        subCategoryListBeans = new ArrayList<>();
        clasAdapter1 = new ClasAdapter(getActivity());
        //布局为网格布局，每行三列
        mRecyler.setLayoutManager(new GridLayoutManager(getActivity(),3));
        mRecyler.setAdapter(clasAdapter1);
    }
    //viewpager里面的内容，我刚开始写的时候用mvp传id没传明白，所有这个viewpager我没用mvp去写，直接用的原生的网络请求写的
    @Override
    protected void initData() {
        new Retrofit.Builder()
                .baseUrl(URLConstart.Base_Url)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(ApiService.class)
                .getSub(id)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<ClasData>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {

                    }

                    @Override
                    public void onNext(@NonNull ClasData clasData) {
                        ClasData.DataBean.CurrentCategoryBean currentCategory = clasData.getData().getCurrentCategory();
                        List<ClasData.DataBean.CurrentCategoryBean.SubCategoryListBean> subCategoryList = clasData.getData().getCurrentCategory().getSubCategoryList();
                        //这里是重点，仔细看我的布局，我没有把集合传给适配器，是在适配器里面也了一个方法，在适配器里添加的数据跟刷新的ui（第93行）
                        mTvName.setText(currentCategory.getFront_name());
                        mTvHeatName.setText(currentCategory.getName()+"分类");
                        Glide.with(getActivity()).load(currentCategory.getWap_banner_url()).into(mImage);
                        clasAdapter1.addItem(subCategoryList);

                    }

                    @Override
                    public void onError(@NonNull Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    @Override
    protected MainPersenterImp getPersenter() {
        return new MainPersenterImp();
    }

    @Override
    protected int getLayoutID() {
        return R.layout.fragment_cals_dada;
    }

    @Override
    public void getHome(HomeBean homeBean) {

    }

    @Override
    public void getAlbum(AlbumBean albumBean) {

    }

    @Override
    public void getAlbum2(AlbumBean albumBean) {

    }

    @Override
    public void getClas(ClasBean clasBean) {

    }


    @Override
    public void onError(String error) {

    }
}