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
import com.gy.shoppproject.bean.ClasBean;
import com.gy.shoppproject.bean.ClasData;
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
        //有上一页跟下一页，一个bean类，我调用了两次
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
        //本页两个内容公用的一个bean类，一个适配器，不用产生多疑
    @Override
    public void getAlbum(AlbumBean albumBean) {
        //mp层返回来的第一页bean类     73-75行是进入默认显示第一页内容
        List<AlbumBean.DataBeanX.DataBean> data = albumBean.getData().getData();
        list.addAll(data);
        albumAdapter.notifyDataSetChanged();
        //第一页的点击事件
        mBtnOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mBtnOne.setEnabled(false);//按钮的点击事件会有变化，true代码未点击，false代表点击
                mBtnTwo.setEnabled(true);
                list.clear();
                list.addAll(data);
                albumAdapter.notifyDataSetChanged();
                n.fullScroll(ScrollView.FOCUS_UP);//我在xml布局写的一个垂直滑动的控件，用来点击下一页的时候回到顶部
            }
        });

    }

    @Override
    public void getAlbum2(AlbumBean albumBean) {
        //bean类的第二个方法（第二页）
        List<AlbumBean.DataBeanX.DataBean> data = albumBean.getData().getData();
        mBtnTwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mBtnOne.setEnabled(true);//按钮的点击事件会有变化，true代码未点击，false代表点击
                mBtnTwo.setEnabled(false);
                list.clear();
                list.addAll(data);
                albumAdapter.notifyDataSetChanged();
                n.fullScroll(ScrollView.FOCUS_UP);
            }
        });
    }

    @Override
    public void getClas(ClasBean clasBean) {

    }


    @Override
    public void onError(String error) {

    }
}