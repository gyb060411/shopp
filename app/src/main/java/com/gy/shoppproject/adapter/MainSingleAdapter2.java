package com.gy.shoppproject.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.alibaba.android.vlayout.DelegateAdapter;
import com.alibaba.android.vlayout.LayoutHelper;
import com.alibaba.android.vlayout.layout.SingleLayoutHelper;
import com.gy.shoppproject.R;

public class MainSingleAdapter2 extends DelegateAdapter.Adapter {
    private SingleLayoutHelper singleLayoutHelper;
    private Context context;
    public MainSingleAdapter2(SingleLayoutHelper singleLayoutHelper2, Context context) {
        this.singleLayoutHelper=singleLayoutHelper2;
        this.context=context;
    }

    @Override
    public LayoutHelper onCreateLayoutHelper() {
        return singleLayoutHelper;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.item5_item,parent,false);
        return new Item5Holder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 1;
    }
    public class Item5Holder extends RecyclerView.ViewHolder {
        TextView mText;
        public Item5Holder(View view){
            super(view);
            this.mText=view.findViewById(R.id.text5);
        }
    }
}
