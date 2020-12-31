package com.gy.shoppproject.adapterAlbum;

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
import com.gy.shoppproject.bean.AlbumBean;

import java.util.ArrayList;

public class AlbumAdapter extends RecyclerView.Adapter {

    private Context context;
    private ArrayList<AlbumBean.DataBeanX.DataBean> list;


    public AlbumAdapter(Context context, ArrayList<AlbumBean.DataBeanX.DataBean> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.album_item, parent, false);
        return new AlbumHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        AlbumHolder albumHolder= (AlbumHolder) holder;
        AlbumBean.DataBeanX.DataBean dataBean = list.get(position);
        albumHolder.mTitle.setText(dataBean.getTitle());
        albumHolder.mPrice.setText(dataBean.getPrice_info()+"元起");
        albumHolder.mSubtitle.setText(dataBean.getSubtitle());
        Glide.with(context).load(dataBean.getScene_pic_url()).into(albumHolder.mImg);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class AlbumHolder extends RecyclerView.ViewHolder {
        private ImageView mImg;
        private TextView mTitle;
        private TextView mSubtitle;
        private TextView mPrice;

        public AlbumHolder(View view) {
            super(view);
            mImg = view.findViewById(R.id.img);
            mTitle = view.findViewById(R.id.title);
            mSubtitle = view.findViewById(R.id.subtitle);
            mPrice = view.findViewById(R.id.price);
        }


    }

}
