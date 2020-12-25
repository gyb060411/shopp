package com.gy.shoppproject.adapter;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.alibaba.android.vlayout.DelegateAdapter;
import com.alibaba.android.vlayout.LayoutHelper;
import com.alibaba.android.vlayout.layout.SingleLayoutHelper;
import com.bumptech.glide.Glide;
import com.gy.shoppproject.R;
import com.gy.shoppproject.bean.HomeBean;
import com.gy.shoppproject.fragment.HomeFragment;
import com.youth.banner.Banner;
import com.youth.banner.loader.ImageLoader;

import java.util.ArrayList;

public class MainSingleAdapter extends DelegateAdapter.Adapter{
    SingleLayoutHelper singleLayoutHelper ;
    Context context;

    private ArrayList<HomeBean.DataBean.BannerBean> list;
    public MainSingleAdapter(SingleLayoutHelper singleLayoutHelper, Context context, ArrayList<HomeBean.DataBean.BannerBean> list) {
        this.singleLayoutHelper = singleLayoutHelper;
        this.context = context;
        this.list=list;
    }

    @Override
    public LayoutHelper onCreateLayoutHelper() {
        return singleLayoutHelper;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.item1_item,parent,false);
        return new SingHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

        SingHolder singHolder= (SingHolder) holder;
        singHolder.mbanner.setImages(list).setImageLoader(new ImageLoader() {
            @Override
            public void displayImage(Context context, Object path, ImageView imageView) {
                HomeBean.DataBean.BannerBean bannerBean1= (HomeBean.DataBean.BannerBean) path;
                Glide.with(context).load(bannerBean1.getImage_url()).into(imageView);
            }
        }).start();

    }

    @Override
    public int getItemCount() {
        return 1;
    }
    class SingHolder extends RecyclerView.ViewHolder{
        TextView textView;
        EditText editText;
        Banner mbanner;
        public SingHolder(View view){
            super(view);
            mbanner=view.findViewById(R.id.banner);
        }
    }
}
