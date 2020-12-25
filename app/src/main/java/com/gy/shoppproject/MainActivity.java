package com.gy.shoppproject;

import android.os.Bundle;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import com.gy.shoppproject.fragment.AlbumFragment;
import com.gy.shoppproject.fragment.CartFragment;
import com.gy.shoppproject.fragment.ClassfiyFragment;
import com.gy.shoppproject.fragment.HomeFragment;
import com.gy.shoppproject.fragment.MeFragment;

public class MainActivity extends AppCompatActivity {

    private LinearLayout mFlContainer;
    private RadioGroup mRgGroup;
    private RadioButton mRbHome;
    private RadioButton mRbAlbum;
    private RadioButton mRbClassify;
    private RadioButton mRbCart;
    private RadioButton mRbMe;
    private HomeFragment homeFragment;
    private AlbumFragment albumFragment;
    private ClassfiyFragment classfiyFragment;
    private CartFragment cartFragment;
    private MeFragment meFragment;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();

        homeFragment = new HomeFragment();
        albumFragment = new AlbumFragment();
        classfiyFragment = new ClassfiyFragment();
        cartFragment = new CartFragment();
        meFragment = new MeFragment();
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction
                .add(R.id.fl_container, homeFragment)
                .add(R.id.fl_container, albumFragment)
                .add(R.id.fl_container, classfiyFragment)
                .add(R.id.fl_container, cartFragment)
                .add(R.id.fl_container, meFragment)
                .hide(albumFragment)
                .hide(classfiyFragment)
                .hide(cartFragment)
                .hide(meFragment)
                .show(homeFragment);
    }

    private void initView() {
        mFlContainer = findViewById(R.id.fl_container);
        mRgGroup = findViewById(R.id.rg_group);
        mRbHome = findViewById(R.id.rb_home);
        mRbAlbum = findViewById(R.id.rb_album);
        mRbClassify = findViewById(R.id.rb_classify);
        mRbCart = findViewById(R.id.rb_cart);
        mRbMe = findViewById(R.id.rb_me);

        mRgGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
                switch (i){
                    case R.id.rb_home:
                        fragmentTransaction.hide(albumFragment).hide(classfiyFragment).hide(cartFragment).hide(meFragment).show(homeFragment).commit();
                        break;
                    case R.id.rb_album:
                        fragmentTransaction.hide(homeFragment).hide(classfiyFragment).hide(cartFragment).hide(meFragment).show(albumFragment).commit();
                        break;
                    case R.id.rb_classify:
                        fragmentTransaction.hide(homeFragment).hide(albumFragment).hide(cartFragment).hide(meFragment).show(classfiyFragment).commit();
                        break;
                    case R.id.rb_cart:
                        fragmentTransaction.hide(homeFragment).hide(albumFragment).hide(classfiyFragment).hide(meFragment).show(cartFragment).commit();
                        break;
                    case R.id.rb_me:
                        fragmentTransaction.hide(homeFragment).hide(albumFragment).hide(classfiyFragment).hide(cartFragment).show(meFragment).commit();
                        break;
                }
            }
        });
    }


}