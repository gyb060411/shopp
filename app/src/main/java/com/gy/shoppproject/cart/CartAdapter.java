package com.gy.shoppproject.cart;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.gy.shoppproject.R;
import com.gy.shoppproject.cart.bean.CartBean;

import java.util.ArrayList;

public class CartAdapter extends RecyclerView.Adapter {
    Context context;
    private ArrayList<CartBean.DataBean.CartListBean> cartListBeans;
    private int plus;
    private int minus;
    private CartBean cartBean;
    public CartAdapter(Context context, ArrayList<CartBean.DataBean.CartListBean> cartListBeans,CartBean cartBean) {
        this.context = context;
        this.cartListBeans = cartListBeans;
        this.cartBean=cartBean;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.cart_item, parent, false);
        return new CartHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        CartHolder cartHolder = (CartHolder) holder;
        cartHolder.mCkRecyclerSelect.setChecked(cartListBeans.get(position).isChecked());
        CartBean.DataBean.CartListBean cartListBean = cartListBeans.get(position);
        cartHolder.mCartName.setText(cartListBean.getGoods_name());
        cartHolder.mCartNumber.setText("X" + cartListBean.getNumber());
        cartHolder.mCartPrice.setText("￥" + cartListBean.getMarket_price());
        Glide.with(context).load(cartListBean.getList_pic_url()).into(cartHolder.mImageRecycelr);

        cartHolder.mCkRecyclerSelect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (cartListBeans.get(position).isChecked()) {
                    cartHolder.mCkRecyclerSelect.setChecked(false);
                    cartListBeans.get(position).setChecked(false);
                } else {
                    cartHolder.mCkRecyclerSelect.setChecked(true);
                    cartListBeans.get(position).setChecked(true);
                }
                priceCallBackClick.priceChange();
            }
        });


        int number = cartBean.getNumber();
        if (number > 0) {
            cartHolder.mPlus.setVisibility(View.VISIBLE);
            cartHolder.mTvNumber.setVisibility(View.VISIBLE);
            cartHolder.mTvMinus.setVisibility(View.VISIBLE);
            cartHolder.mTvSelect.setVisibility(View.VISIBLE);
            cartHolder.mCartNumber.setVisibility(View.GONE);
        }else {
            cartHolder.mCartNumber.setVisibility(View.VISIBLE);
            cartHolder.mCartName.setVisibility(View.VISIBLE);
            cartHolder.mPlus.setVisibility(View.GONE);
            cartHolder.mTvNumber.setVisibility(View.GONE);
            cartHolder.mTvMinus.setVisibility(View.GONE);
            cartHolder.mTvSelect.setVisibility(View.GONE);
        }
       // Toast.makeText(context, number+"", Toast.LENGTH_SHORT).show();


        cartHolder.mPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                plus++;
                cartHolder.mTvNumber.setText(""+plus);
            }
        });
        cartHolder.mTvMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                plus--;
                cartHolder.mTvNumber.setText(""+plus);
            }
        });
    }



    public interface PriceCallBackClick {
        void priceChange();
    }

    PriceCallBackClick priceCallBackClick;

    public void setPriceCallBackClick(PriceCallBackClick priceClick) {
        priceCallBackClick = priceClick;
    }

    @Override
    public int getItemCount() {
        return cartListBeans.size();
    }

    static class CartHolder extends RecyclerView.ViewHolder {
        private CheckBox mCkRecyclerSelect;
        private ImageView mImageRecycelr;
        private TextView mCartName;
        private TextView mCartPrice;
        private TextView mCartNumber;
        private TextView mTvSelect;
        private TextView mTvMinus;
        private TextView mTvNumber;
        private TextView mPlus;
        public CartHolder(View view) {
            super(view);
            mCkRecyclerSelect = view.findViewById(R.id.ck_recycler_select);
            mImageRecycelr = view.findViewById(R.id.image_recycelr);
            mCartName = view.findViewById(R.id.cart_name);
            mCartPrice = view.findViewById(R.id.cart_price);
            mCartNumber = view.findViewById(R.id.cart_number);
            mTvSelect = view.findViewById(R.id.tv_select);
            mTvMinus = view.findViewById(R.id.tv_minus);
            mTvNumber = view.findViewById(R.id.tv_number);
            mPlus = view.findViewById(R.id.plus);
        }
    }

}
