package com.gy.shoppproject.fragment;

import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.gy.shoppproject.R;
import com.gy.shoppproject.base.BaseFragment;
import com.gy.shoppproject.cart.CartAdapter;
import com.gy.shoppproject.cart.bean.CartBean;
import com.gy.shoppproject.cart.contract.CartContract;
import com.gy.shoppproject.cart.presenter.CartPresenter;
import com.gy.shoppproject.presenter.MainPersenterImp;

import java.util.ArrayList;
import java.util.List;

public class CartFragment extends BaseFragment<CartPresenter> implements CartContract.View, CartAdapter.PriceCallBackClick {


    private RecyclerView mRecyclerList;
    private ConstraintLayout mConstraintList;
    private CheckBox mCkListCheck;
    private TextView mTvListCheck;
    private TextView mTvListPrice;
    private Button mBtnListPlace;
    private TextView mTvListCompile;
    private ArrayList<CartBean.DataBean.CartListBean> cartListBeans;
    private CartAdapter cartAdapter;
    private int j=0;
    private CartBean cartBean;

    @Override
    protected void initData() {
        presenter.getCartList();
    }

    @Override
    protected void initView(View view) {

        mRecyclerList = view.findViewById(R.id.recycler_list);
        mConstraintList = view.findViewById(R.id.constraint_list);
        mCkListCheck = view.findViewById(R.id.ck_list_check);
        mTvListCheck = view.findViewById(R.id.tv_list_check);
        mTvListPrice = view.findViewById(R.id.tv_list_price);
        mBtnListPlace = view.findViewById(R.id.btn_list_place);
        mTvListCompile = view.findViewById(R.id.tv_list_compile);
        mRecyclerList.setLayoutManager(new LinearLayoutManager(getActivity()));
        cartListBeans = new ArrayList<>();
        cartBean = new CartBean();
        cartAdapter = new CartAdapter(getActivity(), cartListBeans, cartBean);
        mRecyclerList.setAdapter(cartAdapter);

        
        cartAdapter.setPriceCallBackClick(this);

        cartBean.setNumber(0);
        mTvListCompile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                j++;
                if(j%2==0 && j!=0){
                    cartBean.setNumber(0);
                    mTvListCompile.setText("编辑");

                }else{
                    cartBean.setNumber(1);
                    mTvListCompile.setText("完成");
                }
                int number = cartBean.getNumber();
                Toast.makeText(getContext(), number+"", Toast.LENGTH_SHORT).show();
                cartAdapter.notifyDataSetChanged();
            }
        });

        mCkListCheck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(mCkListCheck.isChecked()){
                    mCkListCheck.setChecked(true);
                    for (int i = 0; i < cartListBeans.size(); i++) {
                        cartListBeans.get(i).setChecked(true);
                        prive_num+=cartListBeans.get(i).getRetail_price();
                        shop_num+=1;
                    }
                    mTvListPrice.setText("￥"+prive_num);
                }else{
                    mCkListCheck.setChecked(false);
                    for (int i = 0; i < cartListBeans.size(); i++) {
                        cartListBeans.get(i).setChecked(false);
                        prive_num-=cartListBeans.get(i).getRetail_price();
                        shop_num-=1;
                    }
                    mTvListPrice.setText("￥"+prive_num);

                }
                cartAdapter.notifyDataSetChanged();
            }
        });



    }

    @Override
    protected CartPresenter getPersenter() {
        return new CartPresenter();
    }

    @Override
    protected int getLayoutID() {
        return R.layout.fragment_cart;
    }

    @Override
    public void setCartList(CartBean cartList) {
        List<CartBean.DataBean.CartListBean> cartList1 = cartList.getData().getCartList();
        cartListBeans.addAll(cartList1);
        cartAdapter.notifyDataSetChanged();
    }

    @Override
    public void setFail(String error) {
        Log.e("TAG", "setFail: 错误信息"+error);
    }
    int shop_num=0;
    double prive_num=0;

    @Override
    public void priceChange() {
        shop_num=0;
        for (int i = 0; i < cartListBeans.size(); i++) {
            if(cartListBeans.get(i).isChecked()){
                prive_num+=cartListBeans.get(i).getRetail_price();
            }
        }
        mTvListPrice.setText("￥"+prive_num);
    }

}