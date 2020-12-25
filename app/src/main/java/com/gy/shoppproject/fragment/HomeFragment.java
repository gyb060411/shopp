package com.gy.shoppproject.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.alibaba.android.vlayout.DelegateAdapter;
import com.alibaba.android.vlayout.VirtualLayoutManager;
import com.alibaba.android.vlayout.layout.SingleLayoutHelper;
import com.gy.shoppproject.R;
import com.gy.shoppproject.adapter.MainSingleAdapter;
import com.gy.shoppproject.base.BaseActivity;
import com.gy.shoppproject.base.BaseFragment;
import com.gy.shoppproject.bean.HomeBean;
import com.gy.shoppproject.contract.MainContract;
import com.gy.shoppproject.presenter.MainPersenterImp;

import java.util.ArrayList;
import java.util.List;


public class HomeFragment extends BaseFragment<MainPersenterImp> implements MainContract.MainView {

    private RecyclerView mRecycler;
    private ArrayList<HomeBean.DataBean.BannerBean> list;
    private DelegateAdapter delegateAdapter;



    @Override
    protected int getLayoutID() {
        return R.layout.fragment_home;
    }

    @Override
    protected MainPersenterImp getPersenter() {
        return new MainPersenterImp();
    }

    @Override
    protected void initData() {
        presenter.Home();
    }

    @Override
    protected void initView(View view) {
        mRecycler = view.findViewById(R.id.recycler);
        list = new ArrayList<>();
        VirtualLayoutManager virtualLayoutManager =new VirtualLayoutManager(getActivity());
        RecyclerView.RecycledViewPool pool = new RecyclerView.RecycledViewPool();
        mRecycler.setRecycledViewPool(pool);
        SingleLayoutHelper singleLayoutHelper = new SingleLayoutHelper();
        MainSingleAdapter mainSingleAdapter = new MainSingleAdapter(singleLayoutHelper,getActivity(),list);

        delegateAdapter = new DelegateAdapter(virtualLayoutManager);
        delegateAdapter.addAdapter(mainSingleAdapter);
        mRecycler.setLayoutManager(virtualLayoutManager);
        mRecycler.setAdapter(delegateAdapter);
    }

    @Override
    public void getHome(HomeBean homeBean) {
        List<HomeBean.DataBean.BannerBean> banner = homeBean.getData().getBanner();
        list.addAll(banner);
        delegateAdapter.notifyDataSetChanged();
    }

    @Override
    public void onError(String error) {

    }
}

