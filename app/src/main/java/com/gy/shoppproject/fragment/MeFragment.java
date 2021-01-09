package com.gy.shoppproject.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;

import com.gy.shoppproject.R;
import com.gy.shoppproject.login.view.LoginActivity;
import com.gy.shoppproject.my.DizhiActivity;


public class MeFragment extends Fragment implements View.OnClickListener {


    private ConstraintLayout mMyConstraint;

    private TextView mMeLogin;

    private LinearLayout mLlFiveDingdan;
    private LinearLayout mLlFiveYouhuiquan;
    private LinearLayout mLlFiveLipinka;
    private LinearLayout mLlFiveShoucang;
    private LinearLayout mLlFiveZuji;
    private LinearLayout mLlFiveFuli;
    private LinearLayout mLlFiveDizhi;
    private LinearLayout mLlFiveZhanghao;
    private LinearLayout mLlFiveLianxi;
    private LinearLayout mLlFiveBangzhu;
    private LinearLayout mLlFiveFankui;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View inflate = inflater.inflate(R.layout.fragment_me, container, false);
        initView(inflate);
        // Inflate the layout for this fragment
        return inflate;
    }

    private void initView(View view) {
        mMyConstraint = view.findViewById(R.id.My_constraint);
        mMeLogin = view.findViewById(R.id.Me_login);
        mLlFiveDingdan = view.findViewById(R.id.ll_five_dingdan);
        mLlFiveYouhuiquan = view.findViewById(R.id.ll_five_youhuiquan);
        mLlFiveLipinka = view.findViewById(R.id.ll_five_lipinka);
        mLlFiveShoucang = view.findViewById(R.id.ll_five_shoucang);
        mLlFiveZuji = view.findViewById(R.id.ll_five_zuji);
        mLlFiveFuli = view.findViewById(R.id.ll_five_fuli);
        mLlFiveDizhi = view.findViewById(R.id.ll_five_dizhi);
        mLlFiveZhanghao = view.findViewById(R.id.ll_five_zhanghao);
        mLlFiveLianxi = view.findViewById(R.id.ll_five_lianxi);
        mLlFiveBangzhu = view.findViewById(R.id.ll_five_bangzhu);
        mLlFiveFankui = view.findViewById(R.id.ll_five_fankui);

        mMeLogin.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.Me_login:
                Intent intent = new Intent(getActivity(), LoginActivity.class);
                startActivity(intent);
                break;
            case R.id.ll_five_dizhi:
                Intent intent1 = new Intent(getActivity(), DizhiActivity.class);
                startActivity(intent1);
                break;
        }
    }
}