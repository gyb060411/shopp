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
import com.alibaba.android.vlayout.layout.LinearLayoutHelper;
import com.bumptech.glide.Glide;
import com.gy.shoppproject.R;
import com.gy.shoppproject.bean.HomeBean;

import java.util.ArrayList;

public class MainLinearAdapter extends DelegateAdapter.Adapter {
    private Context context;
    private ArrayList<HomeBean.DataBean.TopicListBean> topicListBeans;
    private LinearLayoutHelper linearLayoutHelper;
    public MainLinearAdapter(LinearLayoutHelper linearLayoutHelper, Context context, ArrayList<HomeBean.DataBean.TopicListBean> topicListBeans) {
    this.linearLayoutHelper=linearLayoutHelper;
    this.context=context;
    this.topicListBeans=topicListBeans;
    }

    @Override
    public LayoutHelper onCreateLayoutHelper() {
        return linearLayoutHelper;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.item10_item,parent,false);
        return new Item10Holder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        Item10Holder item10Holder= (Item10Holder) holder;
        HomeBean.DataBean.TopicListBean topicListBean = topicListBeans.get(position);
        item10Holder.mTitle.setText(topicListBean.getTitle());
        item10Holder.mSubTitle.setText(topicListBean.getSubtitle());
        Glide.with(context).load(topicListBean.getScene_pic_url()).into(item10Holder.mImg);
    }

    @Override
    public int getItemCount() {
        return topicListBeans.size();
    }
    public class Item10Holder extends RecyclerView.ViewHolder {
        private TextView mTitle;
        private TextView mSubTitle;
        private ImageView mImg;
        public Item10Holder(View view){
            super(view);
//            this.mTitle=view.findViewById(R.id.title);
//            this.mSubTitle=view.findViewById(R.id.subtitle);
            this.mImg=view.findViewById(R.id.img);
        }
    }
}
