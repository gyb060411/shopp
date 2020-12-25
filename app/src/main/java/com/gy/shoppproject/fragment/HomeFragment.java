package com.gy.shoppproject.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.alibaba.android.vlayout.DelegateAdapter;
import com.alibaba.android.vlayout.VirtualLayoutManager;
import com.alibaba.android.vlayout.layout.SingleLayoutHelper;
import com.gy.shoppproject.R;
import com.gy.shoppproject.adapter.MainSingleAdapter;
import com.gy.shoppproject.bean.HomeBean;

import java.util.ArrayList;


public class HomeFragment extends Fragment {

    private RecyclerView mRecycler;
    private ArrayList<HomeBean.DataBean.BannerBean> list;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View inflate = inflater.inflate(R.layout.fragment_home, container, false);
        // Inflate the layout for this fragment
        initView(inflate);
        return inflate;
    }

    private void initView(View view) {
        mRecycler = view.findViewById(R.id.recycler);
        list = new ArrayList<>();
        VirtualLayoutManager virtualLayoutManager =new VirtualLayoutManager(getActivity());
        RecyclerView.RecycledViewPool pool = new RecyclerView.RecycledViewPool();
        mRecycler.setRecycledViewPool(pool);
        SingleLayoutHelper singleLayoutHelper = new SingleLayoutHelper();
        MainSingleAdapter mainSingleAdapter = new MainSingleAdapter(singleLayoutHelper,getActivity(),list);


        DelegateAdapter delegateAdapter = new DelegateAdapter(virtualLayoutManager);
        delegateAdapter.addAdapter(mainSingleAdapter);
        mRecycler.setLayoutManager(virtualLayoutManager);
        mRecycler.setAdapter(delegateAdapter);
    }
}

