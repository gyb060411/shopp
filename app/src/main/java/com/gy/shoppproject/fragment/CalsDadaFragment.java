package com.gy.shoppproject.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.gy.shoppproject.R;
import com.gy.shoppproject.base.BaseFragment;
import com.gy.shoppproject.bean.AlbumBean;
import com.gy.shoppproject.bean.ClasBean;
import com.gy.shoppproject.bean.HomeBean;
import com.gy.shoppproject.contract.MainContract;
import com.gy.shoppproject.presenter.MainPersenterImp;


public class CalsDadaFragment extends BaseFragment<MainPersenterImp> implements MainContract.MainView {


    private ImageView mImage;
    private TextView mTvName;
    private TextView mTvHeatName;
    private RecyclerView mRecyler;
    int id;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View inflate = inflater.inflate(R.layout.fragment_cals_dada, container, false);
        return inflate;
    }


    protected void initView(View view) {
        mImage = view.findViewById(R.id.image);
        mTvName = view.findViewById(R.id.tv_name);
        mTvHeatName =view. findViewById(R.id.tv_heat_name);
        mRecyler = view.findViewById(R.id.recyler);
        Bundle arguments = getArguments();
         id = arguments.getInt("id");
    }

    @Override
    protected void initData() {
//        presenter.clasData(id);
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
    public void getClasData(ClasBean clasBean) {

    }

    @Override
    public void onError(String error) {

    }
}