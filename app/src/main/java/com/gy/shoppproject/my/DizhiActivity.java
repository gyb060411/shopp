package com.gy.shoppproject.my;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.gy.shoppproject.R;
import com.gy.shoppproject.fragment.MeFragment;

public class DizhiActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageView mMyMeReturn;
    private TextView mMeMyDizhi;
    private TextView mMeMyNewdizhi;
    private ImageView mMeMyImg;
    private TextView mMyMeName;
    private TextView mMeMyPhone;
    private TextView mMyMeDefault;
    private TextView mMyMeDizhis;
    private TextView mMyMeCompile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dizhi);
        initView();
    }

    private void initView() {
        mMyMeReturn = findViewById(R.id.My_me_return);
        mMeMyDizhi = findViewById(R.id.Me_my_dizhi);
        mMeMyNewdizhi = findViewById(R.id.Me_my_newdizhi);
        mMeMyImg = findViewById(R.id.Me_my_img);
        mMyMeName = findViewById(R.id.My_me_name);
        mMeMyPhone = findViewById(R.id.Me_my_phone);
        mMyMeDefault = findViewById(R.id.My_me_default);
        mMyMeDizhis = findViewById(R.id.My_me_dizhis);
        mMyMeCompile = findViewById(R.id.My_me_compile);

        mMyMeReturn.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.My_me_return:
                Intent intent = new Intent(DizhiActivity.this, MeFragment.class);
                startActivity(intent);
                finish();
                break;
            case R.id.Me_my_newdizhi:

                break;
            case R.id.My_me_compile:
                Intent intent1 = new Intent(DizhiActivity.this, CompileActivity.class);
                startActivity(intent1);
                break;

        }
    }
}