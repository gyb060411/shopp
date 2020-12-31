package com.gy.shoppproject.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ScrollView;

import androidx.core.widget.NestedScrollView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.gy.shoppproject.R;
import com.gy.shoppproject.adapterAlbum.AlbumAdapter;
import com.gy.shoppproject.base.BaseFragment;
import com.gy.shoppproject.bean.AlbumBean;
import com.gy.shoppproject.bean.HomeBean;
import com.gy.shoppproject.contract.MainContract;
import com.gy.shoppproject.presenter.MainPersenterImp;

import java.util.ArrayList;
import java.util.List;


public class AlbumFragment extends BaseFragment<MainPersenterImp> implements MainContract.MainView {

    private RecyclerView mRecycler;
    private Button mBtnOne;
    private Button mBtnTwo;
    private ArrayList<AlbumBean.DataBeanX.DataBean> list;
    private AlbumAdapter albumAdapter;
    private NestedScrollView n;

    protected void initView(View view) {
        mRecycler =view. findViewById(R.id.recycler);
        mBtnOne = view.findViewById(R.id.btn_one);
        mBtnTwo = view.findViewById(R.id.btn_two);
        n=view.findViewById(R.id.n);
        list = new ArrayList<>();
        albumAdapter = new AlbumAdapter(getActivity(), list);
        mRecycler.setAdapter(albumAdapter);
        mRecycler.setLayoutManager(new LinearLayoutManager(getActivity()));
    }
    @Override
    protected void initData() {
        presenter.Album();
        presenter.Album2();
    }

    @Override
    protected MainPersenterImp getPersenter() {
        return new MainPersenterImp();
    }

    @Override
    protected int getLayoutID() {
        return R.layout.fragment_album;
    }

    @Override
    public void getHome(HomeBean homeBean) {

    }

    @Override
    public void getAlbum(AlbumBean albumBean) {

        List<AlbumBean.DataBeanX.DataBean> data = albumBean.getData().getData();
        list.addAll(data);
        albumAdapter.notifyDataSetChanged();
        mBtnOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mBtnOne.setEnabled(false);
                mBtnTwo.setEnabled(true);
                list.clear();
                list.addAll(data);
                albumAdapter.notifyDataSetChanged();
                n.fullScroll(ScrollView.FOCUS_UP);
            }
        });

    }

    @Override
    public void getAlbum2(AlbumBean albumBean) {
        List<AlbumBean.DataBeanX.DataBean> data = albumBean.getData().getData();
        mBtnTwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mBtnOne.setEnabled(true);
                mBtnTwo.setEnabled(false);
                list.clear();
                list.addAll(data);
                albumAdapter.notifyDataSetChanged();
                mRecycler.scrollToPosition(0);
                n.fullScroll(ScrollView.FOCUS_UP);
            }
        });
    }

    @Override
    public void onError(String error) {

    }
}