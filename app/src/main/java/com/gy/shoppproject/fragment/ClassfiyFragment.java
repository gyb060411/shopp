package com.gy.shoppproject.fragment;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.gy.shoppproject.R;
import com.gy.shoppproject.base.BaseFragment;
import com.gy.shoppproject.bean.AlbumBean;
import com.gy.shoppproject.bean.ClasBean;
import com.gy.shoppproject.bean.ClasData;
import com.gy.shoppproject.bean.HomeBean;
import com.gy.shoppproject.contract.MainContract;
import com.gy.shoppproject.presenter.MainPersenterImp;
import com.gy.shoppproject.utils.ApiService;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import q.rorbin.verticaltablayout.VerticalTabLayout;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;


public class ClassfiyFragment extends BaseFragment<MainPersenterImp> implements MainContract.MainView {


    private VerticalTabLayout mTablayout;
    private ViewPager mViewpager;
    private ArrayList<Fragment> fragment;
    private ArrayList<String> TitltList;

    protected void initView(View view) {
        mTablayout = view.findViewById(R.id.tablayout);
        mViewpager = view.findViewById(R.id.viewpager);

    }

    @Override
    protected void initData() {
        presenter.getClas();
    }

    @Override
    protected MainPersenterImp getPersenter() {
        return new MainPersenterImp();
    }

    @Override
    protected int getLayoutID() {
        return R.layout.fragment_classfiy;
    }
        //这些多余的方法，不用管他，我只不过把所有的方法都写在一个类里面了
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
        //p层回来的数据
        List<ClasBean.DataBean.CategoryListBean> categoryList = clasBean.getData().getCategoryList();
        TitltList = new ArrayList<>();
        fragment = new ArrayList<>();
        //跟以前的嵌套差不多，就是把tablayout换成了侧边的tablayout，需要添加依赖
        for(int i=0;i<categoryList.size();i++){
            //这个titltList是tablayout存放数据的集合，由于侧边的tablyout缺啥settext赋值属性，必须换方法去写
            TitltList.add(categoryList.get(i).getName());
            int id = categoryList.get(i).getId();
            CalsDadaFragment calsDadaFragment = new CalsDadaFragment();
            Bundle bundle = new Bundle();
            bundle.putInt("id",id);
            calsDadaFragment.setArguments(bundle);
            fragment.add(calsDadaFragment);
        }
        Log.e("TAG", "getClas: +id"+categoryList.toString() );
        //viewpage的内部类方法
        VpAdapter vpAdapter = new VpAdapter(getChildFragmentManager());
        mViewpager.setAdapter(vpAdapter);
        mTablayout.setupWithViewPager(mViewpager);
    }


    @Override
    public void onError(String error) {

    }

    private class VpAdapter extends FragmentPagerAdapter {
        public VpAdapter(FragmentManager fm) {
            super(fm);

        }

        @NonNull
        @Override
        public Fragment getItem(int position) {
            return fragment.get(position);
        }

        @Override
        public int getCount() {
            return fragment.size();
        }
        @Nullable
        @Override
        public CharSequence getPageTitle(int position) {
            return TitltList.get(position).toString();

        }
    }
}