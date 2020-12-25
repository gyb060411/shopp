package com.gy.shoppproject.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.alibaba.android.vlayout.DelegateAdapter;
import com.alibaba.android.vlayout.LayoutHelper;
import com.alibaba.android.vlayout.layout.GridLayoutHelper;
import com.bumptech.glide.Glide;
import com.gy.shoppproject.R;
import com.gy.shoppproject.bean.HomeBean;

import java.util.ArrayList;

public class MainGridAdapter1 extends DelegateAdapter.Adapter {
    private GridLayoutHelper gridLayoutHelper;
    private Context context;
    private ArrayList<HomeBean.DataBean.BrandListBean> newGoodsListBeans;
    public MainGridAdapter1(GridLayoutHelper gridLayoutHelper, Context context, ArrayList<HomeBean.DataBean.BrandListBean> newGoodsListBeans) {
        this.gridLayoutHelper=gridLayoutHelper;
        this.context=context;
        this.newGoodsListBeans=newGoodsListBeans;
    }

    @Override
    public LayoutHelper onCreateLayoutHelper() {
        return gridLayoutHelper;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.item3_item,parent,false);
        return new Item3Holder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        Item3Holder item3Holder= (Item3Holder) holder;
        HomeBean.DataBean.BrandListBean brandListBean = newGoodsListBeans.get(position);
        item3Holder.mName.setText(brandListBean.getName());
        item3Holder.mPrice.setText(brandListBean.getFloor_price()+"元");
        Glide.with(context).load(brandListBean.getNew_pic_url()).into(item3Holder.mImg);
    }

    @Override
    public int getItemCount() {
        return newGoodsListBeans.size();
    }
    public class Item3Holder extends RecyclerView.ViewHolder {
        private ImageView mImg;
        private TextView mName;
        private TextView mPrice;
        public Item3Holder(View view){
            super(view);
            this.mImg=view.findViewById(R.id.img);
            this.mName=view.findViewById(R.id.name);
            this.mPrice=view.findViewById(R.id.price);
        }
    }
}
