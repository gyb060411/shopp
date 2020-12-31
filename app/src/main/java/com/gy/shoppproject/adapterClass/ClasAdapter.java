package com.gy.shoppproject.adapterClass;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.gy.shoppproject.R;
import com.gy.shoppproject.bean.ClasBean;
import com.gy.shoppproject.bean.ClasData;

import java.util.ArrayList;
import java.util.List;

public class ClasAdapter extends RecyclerView.Adapter {
    private Context context;
    private List<ClasData.DataBean.CurrentCategoryBean.SubCategoryListBean> subCategoryListBeans=new ArrayList<>();

    public void addItem(List<ClasData.DataBean.CurrentCategoryBean.SubCategoryListBean> subCategoryListBeans){
        this.subCategoryListBeans.addAll(subCategoryListBeans);
        notifyDataSetChanged();
    }
    public ClasAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.class_item, parent, false);
        return new ClassHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ClassHolder classHolder= (ClassHolder) holder;
        ClasData.DataBean.CurrentCategoryBean.SubCategoryListBean subCategoryListBean = subCategoryListBeans.get(position);
        classHolder.mName.setText(subCategoryListBean.getName());
        Glide.with(context).load(subCategoryListBean.getWap_banner_url()).into(classHolder.mImg);
    }

    @Override
    public int getItemCount() {
        return subCategoryListBeans.size();
    }
    class ClassHolder extends RecyclerView.ViewHolder {
        private ImageView mImg;
        private TextView mName;

        public ClassHolder(View view) {
            super(view);
            mImg = view.findViewById(R.id.img);
            mName = view.findViewById(R.id.name);
        }


    }

}
