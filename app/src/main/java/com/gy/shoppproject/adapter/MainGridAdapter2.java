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

import org.w3c.dom.Text;

import java.util.ArrayList;

import javax.microedition.khronos.opengles.GL;

public class MainGridAdapter2 extends DelegateAdapter.Adapter {
    private ArrayList<HomeBean.DataBean.NewGoodsListBean> newGoodsListBeans1;
    private Context context;
    private GridLayoutHelper gridLayoutHelper;
    public MainGridAdapter2(GridLayoutHelper gridLayoutHelper2, Context context, ArrayList<HomeBean.DataBean.NewGoodsListBean> newGoodsListBeans1) {
        this.gridLayoutHelper=gridLayoutHelper2;
        this.context=context;



        this.newGoodsListBeans1=newGoodsListBeans1;
    }

    @Override
    public LayoutHelper onCreateLayoutHelper() {
        return gridLayoutHelper;
    }

    @NonNull
    @Override


    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.item6_item,parent,false);
        return new Item6Holder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        Item6Holder item6Holder= (Item6Holder) holder;
        HomeBean.DataBean.NewGoodsListBean newGoodsListBean = newGoodsListBeans1.get(position);
        item6Holder.mName.setText(newGoodsListBean.getName());
        item6Holder.mPrice.setText(newGoodsListBean.getRetail_price());
        Glide.with(context).load(newGoodsListBean.getList_pic_url()).into(item6Holder.mImg);
    }

    @Override
    public int getItemCount() {
        return newGoodsListBeans1.size();
    }
    public class Item6Holder extends RecyclerView.ViewHolder{
        private ImageView mImg;
        private TextView mName;
        private TextView mPrice;
        public Item6Holder(View view){
            super(view);
            this.mName=view.findViewById(R.id.name);
            this.mImg=view.findViewById(R.id.img);
            this.mPrice=view.findViewById(R.id.price);
        }
    }
}
