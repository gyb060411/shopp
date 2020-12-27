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

import org.w3c.dom.Text;

import java.util.ArrayList;

class Linear11Adapter extends RecyclerView.Adapter {
    private Context context;
    private ArrayList<HomeBean.DataBean.TopicListBean> topicListBeans;
    private ImageView mImg;
    private TextView mTitle;
    private TextView mSubtitle;

    public Linear11Adapter(Context context, ArrayList<HomeBean.DataBean.TopicListBean> topicListBeans) {
        this.context = context;
        this.topicListBeans = topicListBeans;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item10_item, parent, false);
        return new Item10Holder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        HomeBean.DataBean.TopicListBean topicListBean = topicListBeans.get(position);
        Item10Holder item10Holder= (Item10Holder) holder;
        item10Holder.mSubTitle.setText(topicListBean.getSubtitle());
        item10Holder.mTitle.setText(topicListBean.getTitle());
        Glide.with(context).load(topicListBean.getScene_pic_url()).into(item10Holder.mImag);
    }

    @Override
    public int getItemCount() {
        return topicListBeans.size();
    }
    class Item10Holder extends RecyclerView.ViewHolder {
        TextView mTitle;
        TextView mSubTitle;
        ImageView mImag;
        public  Item10Holder(View view) {
            super(view);
            mImag = view.findViewById(R.id.img);
            mTitle = view.findViewById(R.id.title);
            mSubTitle = view.findViewById(R.id.subtitle);
        }
    }

}
