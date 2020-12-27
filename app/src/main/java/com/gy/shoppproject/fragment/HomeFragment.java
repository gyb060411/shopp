package com.gy.shoppproject.fragment;

import android.util.Log;
import android.view.View;

import androidx.recyclerview.widget.RecyclerView;

import com.alibaba.android.vlayout.DelegateAdapter;
import com.alibaba.android.vlayout.VirtualLayoutManager;
import com.alibaba.android.vlayout.layout.GridLayoutHelper;
import com.alibaba.android.vlayout.layout.LinearLayoutHelper;
import com.alibaba.android.vlayout.layout.SingleLayoutHelper;
import com.gy.shoppproject.R;
import com.gy.shoppproject.adapter.LinearAdapter;
import com.gy.shoppproject.adapter.LinearAdapter2;
import com.gy.shoppproject.adapter.MainGridAdapter;
import com.gy.shoppproject.adapter.MainGridAdapter1;
import com.gy.shoppproject.adapter.MainGridAdapter2;
import com.gy.shoppproject.adapter.MainGridAdapter3;
import com.gy.shoppproject.adapter.MainSingleAdapter;
import com.gy.shoppproject.adapter.MainSingleAdapter1;
import com.gy.shoppproject.adapter.MainSingleAdapter2;
import com.gy.shoppproject.adapter.MainSingleAdapter3;
import com.gy.shoppproject.adapter.MainSingleAdapter4;
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
    private ArrayList<HomeBean.DataBean.ChannelBean> channelBeans;
    private MainSingleAdapter mainSingleAdapter;
    private MainGridAdapter mainGridAdapter;
    private ArrayList<HomeBean.DataBean.BrandListBean> newGoodsListBeans;
    private MainGridAdapter1 mainGridAdapter1;
    private MainSingleAdapter1 mainSingleAdapter1;
    private MainSingleAdapter2 mainSingleAdapter2;
    private ArrayList<HomeBean.DataBean.NewGoodsListBean> newGoodsListBeans1;
    private MainGridAdapter2 mainGridAdapter2;
    private MainSingleAdapter3 mainSingleAdapter3;
    private ArrayList<HomeBean.DataBean.HotGoodsListBean> hotGoodsListBeans;
    private MainGridAdapter3 mainGridAdapter3;
    private MainSingleAdapter4 mainSingleAdapter4;
    private ArrayList<HomeBean.DataBean.TopicListBean> topicListBeans;
    private LinearAdapter linearAdapter;
    private ArrayList<HomeBean.DataBean.CategoryListBean> categoryListBeans;
    private LinearAdapter2 linearAdapter2;


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
        mainSingleAdapter = new MainSingleAdapter(singleLayoutHelper,getActivity(),list);


        GridLayoutHelper gridLayoutHelper = new GridLayoutHelper(5);
        channelBeans = new ArrayList<>();
        mainGridAdapter = new MainGridAdapter(gridLayoutHelper,getActivity(),channelBeans);

        SingleLayoutHelper singleLayoutHelper1 = new SingleLayoutHelper();
        mainSingleAdapter1 = new MainSingleAdapter1(singleLayoutHelper1,getActivity());

        GridLayoutHelper gridLayoutHelper1 = new GridLayoutHelper(2);
        newGoodsListBeans = new ArrayList<>();
        mainGridAdapter1 = new MainGridAdapter1(gridLayoutHelper1, getActivity(), newGoodsListBeans);

        SingleLayoutHelper singleLayoutHelper2 = new SingleLayoutHelper();
        mainSingleAdapter2 = new MainSingleAdapter2(singleLayoutHelper2,getActivity());

        GridLayoutHelper gridLayoutHelper2 = new GridLayoutHelper(2);
        newGoodsListBeans1 = new ArrayList<>();
        mainGridAdapter2 = new MainGridAdapter2(gridLayoutHelper2, getActivity(), newGoodsListBeans1);

        SingleLayoutHelper singleLayoutHelper3 = new SingleLayoutHelper();
        mainSingleAdapter3 = new MainSingleAdapter3(singleLayoutHelper3,getActivity());

        GridLayoutHelper gridLayoutHelper3 = new GridLayoutHelper(1);
        hotGoodsListBeans = new ArrayList<>();
        mainGridAdapter3 = new MainGridAdapter3(gridLayoutHelper3, getActivity(), hotGoodsListBeans);

        SingleLayoutHelper singleLayoutHelper4 = new SingleLayoutHelper();
        mainSingleAdapter4 = new MainSingleAdapter4(singleLayoutHelper4,getActivity());

        LinearLayoutHelper linearLayoutHelper1 = new LinearLayoutHelper();
        topicListBeans= new ArrayList<>();
        linearAdapter = new LinearAdapter(getActivity(), linearLayoutHelper1, topicListBeans);

        LinearLayoutHelper linearLayoutHelper2 = new LinearLayoutHelper();
        linearLayoutHelper2.setItemCount(1);
        categoryListBeans = new ArrayList<>();
        linearAdapter2 = new LinearAdapter2(getActivity(),linearLayoutHelper2,categoryListBeans);

        delegateAdapter = new DelegateAdapter(virtualLayoutManager);
        delegateAdapter.addAdapter(mainSingleAdapter);
        delegateAdapter.addAdapter(mainGridAdapter);
        delegateAdapter.addAdapter(mainSingleAdapter1);
        delegateAdapter.addAdapter(mainGridAdapter1);
        delegateAdapter.addAdapter(mainSingleAdapter2);
        delegateAdapter.addAdapter(mainGridAdapter2);
        delegateAdapter.addAdapter(mainSingleAdapter3);
        delegateAdapter.addAdapter(mainGridAdapter3);
        delegateAdapter.addAdapter(mainSingleAdapter4);
        delegateAdapter.addAdapter(linearAdapter);
        delegateAdapter.addAdapter(linearAdapter2);
//
        mRecycler.setLayoutManager(virtualLayoutManager);
        mRecycler.setAdapter(delegateAdapter);

    }

    @Override
    public void getHome(HomeBean homeBean) {
        List<HomeBean.DataBean.BannerBean> banner = homeBean.getData().getBanner();
        list.addAll(banner);
        mainSingleAdapter.notifyDataSetChanged();
        List<HomeBean.DataBean.ChannelBean> channel = homeBean.getData().getChannel();
        channelBeans.addAll(channel);
        mainGridAdapter.notifyDataSetChanged();
        List<HomeBean.DataBean.BrandListBean> brandList = homeBean.getData().getBrandList();
        newGoodsListBeans.addAll(brandList);
        mainGridAdapter1.notifyDataSetChanged();
        List<HomeBean.DataBean.NewGoodsListBean> newGoodsList = homeBean.getData().getNewGoodsList();
        newGoodsListBeans1.addAll(newGoodsList);
        mainGridAdapter2.notifyDataSetChanged();
        List<HomeBean.DataBean.HotGoodsListBean> hotGoodsList = homeBean.getData().getHotGoodsList();
        hotGoodsListBeans.addAll(hotGoodsList);
        mainGridAdapter3.notifyDataSetChanged();

        List<HomeBean.DataBean.TopicListBean> topicList = homeBean.getData().getTopicList();
        topicListBeans.addAll(topicList);
        linearAdapter.notifyDataSetChanged();

        List<HomeBean.DataBean.CategoryListBean> categoryList = homeBean.getData().getCategoryList();
        categoryListBeans.addAll(categoryList);
        linearAdapter2.notifyDataSetChanged();
        Log.e("TAG", "getHome: +数据"+categoryList.toString() );
    }

    @Override
    public void onError(String error) {

    }
}

