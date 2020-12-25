package com.gy.shoppproject.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.gy.shoppproject.R;


public class HomeFragment extends Fragment {

    private RecyclerView mRecycler;

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

    }
}


/* <EditText
        android:gravity="center"
        android:layout_marginLeft="30dp"
        android:background="@drawable/shape"
        android:layout_width="350dp"
        android:layout_height="50dp"/>
    <ImageView
        android:src="@drawable/a12"
        android:layout_marginLeft="80dp"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"/>
    <TextView
        android:text="商品搜索，共239款好物"
        android:textSize="20dp"
        android:layout_marginLeft="120dp"
        android:layout_marginTop="10dp"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"/>
*/