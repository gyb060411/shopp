package com.gy.shoppproject.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.alibaba.android.vlayout.DelegateAdapter;
import com.alibaba.android.vlayout.LayoutHelper;
import com.alibaba.android.vlayout.layout.LinearLayoutHelper;
import com.gy.shoppproject.R;
import com.gy.shoppproject.bean.HomeBean;

import java.util.ArrayList;

public class LinearAdapter extends DelegateAdapter.Adapter {
    private Context context;
    private ArrayList<HomeBean.DataBean.TopicListBean> topicListBeans;
    private LinearLayoutHelper linearLayoutHelper;
    private RecyclerView mRecycler;
    private Linear11Adapter linear11Adapter;

    public LinearAdapter(Context context, LinearLayoutHelper linearLayoutHelper, ArrayList<HomeBean.DataBean.TopicListBean> topicListBeans) {

        this.context = context;
        this.linearLayoutHelper = linearLayoutHelper;
        this.topicListBeans = topicListBeans;
    }

    @Override
    public LayoutHelper onCreateLayoutHelper() {
        return linearLayoutHelper;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.recyceler_item, parent, false);
        return new RecyHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        RecyHolder recyHolder= (RecyHolder) holder;
        LinearLayoutManager linearLayoutHelper = new LinearLayoutManager(context);
        linearLayoutHelper.setOrientation(RecyclerView.HORIZONTAL);
        recyHolder.mRecycler.setLayoutManager(linearLayoutHelper);
        linear11Adapter = new Linear11Adapter(context, topicListBeans);
        recyHolder.mRecycler.setAdapter(linear11Adapter);
    }

    @Override
    public int getItemCount() {
        return 1;
    }

    class RecyHolder extends RecyclerView.ViewHolder {
        RecyclerView mRecycler;
        public RecyHolder(View view) {
            super(view);
            mRecycler = view.findViewById(R.id.recycler);
        }
    }

}
