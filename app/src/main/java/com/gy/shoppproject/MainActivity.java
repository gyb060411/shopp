package com.gy.shoppproject;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.gy.shoppproject.base.BaseActivity;
import com.gy.shoppproject.bean.AlbumBean;
import com.gy.shoppproject.bean.ClasBean;
import com.gy.shoppproject.bean.HomeBean;
import com.gy.shoppproject.contract.MainContract;
import com.gy.shoppproject.fragment.AlbumFragment;
import com.gy.shoppproject.fragment.CartFragment;
import com.gy.shoppproject.fragment.ClassfiyFragment;
import com.gy.shoppproject.fragment.HomeFragment;
import com.gy.shoppproject.fragment.MeFragment;
import com.gy.shoppproject.presenter.MainPersenterImp;
import com.gy.shoppproject.utils.CanSlidingViewpager;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends BaseActivity<MainPersenterImp> implements MainContract.MainView {


    private ViewPager mViewPager;
    private BottomNavigationView mNavView;
    private ArrayList<Fragment> fragment;

    MyFragmentPagerAdapter myFragmentPagerAdapter;

    @Override
    protected int getLayoutID() {
        return R.layout.activity_main;
    }

    @Override
    protected MainPersenterImp getPersenter() {
        return new MainPersenterImp();
    }

    @Override
    protected void initData() {

    }

    protected void initView() {
        mViewPager = findViewById(R.id.viewPager);
        mNavView = findViewById(R.id.nav_view);

//            mViewPager.setScrollble(false);
        initFragment();

        myFragmentPagerAdapter = new MyFragmentPagerAdapter(getSupportFragmentManager(),fragment);
        mViewPager.setAdapter(myFragmentPagerAdapter);
         mNavView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
           @Override
           public boolean onNavigationItemSelected(@NonNull MenuItem item) {
               switch (item.getItemId()){
                   case R.id.navigation_home:
                       item.setIcon(R.mipmap.ic_menu_choice_pressed);
                       mViewPager.setCurrentItem(0);
                       return  true;
                   case R.id.navigation_topic:
                       item.setIcon(R.mipmap.ic_menu_topic_pressed);
                       mViewPager.setCurrentItem(1);
                       return true;
                   case R.id.navigation_sort:
                       item.setIcon(R.mipmap.ic_menu_sort_pressed);
                       mViewPager.setCurrentItem(2);
                       return true;
                   case R.id.navigation_shop:
                       item.setIcon(R.mipmap.ic_menu_shoping_pressed);
                       mViewPager.setCurrentItem(3);
                       return true;
                   case R.id.navigation_me:
                       item.setIcon(R.mipmap.ic_menu_me_pressed);
                       mViewPager.setCurrentItem(4);
                       return true;
               }
               return false;
           }
       });
       mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
           @Override
           public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

           }
           @Override
           public void onPageSelected(int position) {
                mNavView.getMenu().getItem(position).setChecked(true);
           }
           @Override
           public void onPageScrollStateChanged(int state) {

           }
       });
    }
    private void initFragment() {
        fragment = new ArrayList<>();
        fragment.add(new HomeFragment());
        fragment.add(new AlbumFragment());
        fragment.add(new ClassfiyFragment());
        fragment.add(new CartFragment());
        fragment.add(new MeFragment());
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

    class MyFragmentPagerAdapter extends FragmentPagerAdapter{

        List<Fragment> fragments;
        public MyFragmentPagerAdapter(@NonNull FragmentManager fm,List<Fragment> fragments) {
            super(fm);
            this.fragments=fragments;
        }

        @NonNull
        @Override
        public Fragment getItem(int position) {
            return fragments.get(position);
        }

        @Override
        public int getCount() {
            return fragment.size();
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        int id = getIntent().getIntExtra("id", 0);
        mViewPager.setCurrentItem(id);
    }
}