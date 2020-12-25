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

public class MainGridAdapter3 extends DelegateAdapter.Adapter {
    private Context context;
    private GridLayoutHelper gridLayoutHelper;
    private ArrayList<HomeBean.DataBean.HotGoodsListBean> hotGoodsListBeans;
    public MainGridAdapter3(GridLayoutHelper gridLayoutHelper3, Context context, ArrayList<HomeBean.DataBean.HotGoodsListBean> hotGoodsListBeans) {
        this.gridLayoutHelper=gridLayoutHelper3;
        this.context=context;
        this.hotGoodsListBeans=hotGoodsListBeans;
    }

    @Override
    public LayoutHelper onCreateLayoutHelper() {
        return gridLayoutHelper;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.item8_item,parent,false);
        return new Item8Holder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        Item8Holder item8Holder= (Item8Holder) holder;
        HomeBean.DataBean.HotGoodsListBean hotGoodsListBean = hotGoodsListBeans.get(position);
        item8Holder.mName.setText(hotGoodsListBean.getName());
        item8Holder.mPrice.setText("￥"+hotGoodsListBean.getRetail_price());
        item8Holder.mBride.setText(hotGoodsListBean.getGoods_brief());
        Glide.with(context).load(hotGoodsListBean.getList_pic_url()).into(item8Holder.mImg);
    }

    @Override
    public int getItemCount() {
        return hotGoodsListBeans.size();
    }
    public class Item8Holder extends RecyclerView.ViewHolder {
        TextView mName;
        TextView mPrice;
        TextView mBride;
        ImageView mImg;
        public Item8Holder(View view){
            super(view);
            this.mName=view.findViewById(R.id.name);
            this.mPrice=view.findViewById(R.id.price);
            this.mBride=view.findViewById(R.id.brief);
            this.mImg=view.findViewById(R.id.img);
        }
    }
}
