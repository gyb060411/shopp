package com.gy.shoppproject.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.alibaba.android.vlayout.DelegateAdapter;
import com.alibaba.android.vlayout.LayoutHelper;
import com.alibaba.android.vlayout.layout.LinearLayoutHelper;
import com.gy.shoppproject.R;
import com.gy.shoppproject.bean.HomeBean;

import java.util.ArrayList;
import java.util.List;

public class LinearAdapter2 extends DelegateAdapter.Adapter {
    Context context;
    private ArrayList<HomeBean.DataBean.CategoryListBean> categoryListBeans;
    private LinearLayoutHelper linearLayoutHelper2;
    private ArrayList<HomeBean.DataBean.CategoryListBean.GoodsListBean> goodsListBeans;
    private MainGridAdapter6 mainGridAdapter6;

    public LinearAdapter2(Context content, LinearLayoutHelper linearLayoutHelper2, ArrayList<HomeBean.DataBean.CategoryListBean> categoryListBeans) {
        this.context=content;
        this.linearLayoutHelper2=linearLayoutHelper2;
        this.categoryListBeans=categoryListBeans;

    }

    @Override
    public LayoutHelper onCreateLayoutHelper() {
        return linearLayoutHelper2;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.item_zui,parent,false);
        return new HomeHold(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        HomeHold homeHolder= (HomeHold) holder;
        HomeBean.DataBean.CategoryListBean categoryListBean = categoryListBeans.get(position);
        homeHolder.mName.setText(categoryListBean.getName());
        Log.e("TAG", "onBindViewHolder: 数据"+categoryListBean.toString() );

        goodsListBeans = new ArrayList<>();
        List<HomeBean.DataBean.CategoryListBean.GoodsListBean> goodsList = categoryListBean.getGoodsList();
        goodsListBeans.addAll(goodsList);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(context, 2);
        homeHolder.mRecycler.setLayoutManager(gridLayoutManager);
        mainGridAdapter6 = new MainGridAdapter6(context, goodsListBeans);
        homeHolder.mRecycler.setAdapter(mainGridAdapter6);

    }

    @Override
    public int getItemCount() {
        if(categoryListBeans.size()>0){
            return categoryListBeans.size();
        }else{
            return 0;
        }
    }


    class HomeHold extends RecyclerView.ViewHolder {
        TextView mName;
        RecyclerView mRecycler;


        public HomeHold(@NonNull View itemView) {
            super(itemView);
            mName=itemView.findViewById(R.id.name_zui);
            mRecycler=itemView.findViewById(R.id.recycler);
        }
    }
}
