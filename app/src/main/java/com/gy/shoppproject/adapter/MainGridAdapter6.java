package com.gy.shoppproject.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.gy.shoppproject.R;
import com.gy.shoppproject.bean.HomeBean;

import java.util.ArrayList;

class MainGridAdapter6 extends RecyclerView.Adapter {
    private Context context;
    private ArrayList<HomeBean.DataBean.CategoryListBean.GoodsListBean> goodsListBeans;
    public MainGridAdapter6(Context context, ArrayList<HomeBean.DataBean.CategoryListBean.GoodsListBean> goodsListBeans) {
        this.context=context;
        this.goodsListBeans=goodsListBeans;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.item_zui2,parent,false);
        return new  HomeHolder1(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        HomeBean.DataBean.CategoryListBean.GoodsListBean goodsListBean = goodsListBeans.get(position);
        HomeHolder1 homeHolder= (HomeHolder1) holder;
        homeHolder.mName.setText(goodsListBean.getName());
        homeHolder.mPrice.setText("￥"+goodsListBean.getRetail_price());
        Glide.with(context).load(goodsListBean.getList_pic_url()).into(homeHolder.mImg);
    }

    @Override
    public int getItemCount() {
        return goodsListBeans.size();
    }
    class HomeHolder1 extends RecyclerView.ViewHolder {
        TextView mName;
        TextView mPrice;
        ImageView mImg;
        public HomeHolder1(View view){
            super(view);
            mImg=view.findViewById(R.id.img);
            mName=view.findViewById(R.id.name1);
            mPrice=view.findViewById(R.id.price);
        }
    }
}
