package com.gy.shoppproject.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.gy.shoppproject.R;
import com.gy.shoppproject.base.BaseFragment;
import com.gy.shoppproject.bean.AlbumBean;
import com.gy.shoppproject.bean.ClasBean;
import com.gy.shoppproject.bean.HomeBean;
import com.gy.shoppproject.contract.MainContract;
import com.gy.shoppproject.presenter.MainPersenterImp;

import java.util.ArrayList;
import java.util.List;

import q.rorbin.verticaltablayout.VerticalTabLayout;


public class ClassfiyFragment extends BaseFragment<MainPersenterImp> implements MainContract.MainView {


    private VerticalTabLayout mTablayout;
    private ViewPager mViewpager;
    private ArrayList<Fragment> fragment;
    private ArrayList<String> TitltList;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View inflate = inflater.inflate(R.layout.fragment_classfiy, container, false);
        // Inflate the layout for this fragment
        return inflate;
    }


    protected void initView(View view) {
        mTablayout = view.findViewById(R.id.tablayout);
        mViewpager = view.findViewById(R.id.viewpager);

    }
    @Override
    protected void initData() {
        presenter.Clas();
        presenter.clasData();
    }

    @Override
    protected MainPersenterImp getPersenter() {
        return new MainPersenterImp();
    }

    @Override
    protected int getLayoutID() {
        return R.layout.fragment_classfiy;
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
        List<ClasBean.DataBean.CategoryListBean> categoryList = clasBean.getData().getCategoryList();
        TitltList = new ArrayList<>();
        fragment = new ArrayList<>();
        for(int i=0;i<categoryList.size();i++){
            TitltList.add(categoryList.get(i).getName());
            int id = categoryList.get(i).getId();
            CalsDadaFragment calsDadaFragment = new CalsDadaFragment();
            Bundle bundle = new Bundle();
            bundle.putInt("id",id);
            calsDadaFragment.setArguments(bundle);
            fragment.add(calsDadaFragment);
        }
        VpAdapter vpAdapter = new VpAdapter(getChildFragmentManager());

    }

    @Override
    public void getClasData(ClasBean clasBean) {

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

    }
}