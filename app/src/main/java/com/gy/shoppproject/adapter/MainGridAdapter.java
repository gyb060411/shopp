package com.gy.shoppproject.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.alibaba.android.vlayout.DelegateAdapter;
import com.alibaba.android.vlayout.LayoutHelper;
import com.alibaba.android.vlayout.layout.GridLayoutHelper;
import com.bumptech.glide.Glide;
import com.gy.shoppproject.R;
import com.gy.shoppproject.bean.HomeBean;
import com.gy.shoppproject.fragment.HomeFragment;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class MainGridAdapter extends DelegateAdapter.Adapter {
    private GridLayoutHelper gridLayoutHelper;
    private ArrayList<HomeBean.DataBean.ChannelBean> channelBeans;
    Context context;
    public MainGridAdapter(GridLayoutHelper gridLayoutHelper, Context context, ArrayList<HomeBean.DataBean.ChannelBean> channelBeans) {
        this.gridLayoutHelper = gridLayoutHelper;
        this.context = context;
        this.channelBeans=channelBeans;
    }

    @Override
    public LayoutHelper onCreateLayoutHelper() {
        return gridLayoutHelper;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       View view= LayoutInflater.from(context).inflate(R.layout.item2_item,parent,false);
       return new Item2Holder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        Item2Holder item2Holder= (Item2Holder) holder;
        HomeBean.DataBean.ChannelBean channelBean = channelBeans.get(position);
        item2Holder.mName.setText(channelBean.getName());
        Glide.with(context).load(channelBean.getIcon_url()).into(item2Holder.mImg);
    }

    @Override
    public int getItemCount() {
        return channelBeans.size();
    }
    public class Item2Holder extends RecyclerView.ViewHolder {
        public ImageView mImg;
        public TextView mName;
        public Item2Holder(View view){
            super(view);
            this.mImg=view.findViewById(R.id.img);;
            this.mName=view.findViewById(R.id.name);
        }
    }
}
