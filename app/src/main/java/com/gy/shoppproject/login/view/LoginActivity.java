package com.gy.shoppproject.login.view;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.gy.shoppproject.MainActivity;
import com.gy.shoppproject.R;
import com.gy.shoppproject.base.BaseActivity;
import com.gy.shoppproject.login.bean.LoginBean;
import com.gy.shoppproject.login.logincontract.LoginContract;
import com.gy.shoppproject.login.presenter.LoginPresenterImp;
import com.tencent.mmkv.MMKV;

public class LoginActivity extends BaseActivity<LoginPresenterImp> implements LoginContract.LoginView {

    private EditText mEtName;
    private EditText mEtPwd;
    private CheckBox mCkJizhu;
    private Button mBtnLogin;
    private Button mBtnRiget;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        initView();
    }

    @Override
    protected int getLayoutID() {
        return R.layout.activity_login;
    }

    @Override
    protected LoginPresenterImp getPersenter() {
        return new LoginPresenterImp();
    }

    @Override
    protected void initData() {

    }

    protected void initView() {
        mEtName = findViewById(R.id.et_name);
        mEtPwd = findViewById(R.id.et_pwd);
        mCkJizhu = findViewById(R.id.ck_jizhu);
        mBtnLogin = findViewById(R.id.btn_login);
        mBtnRiget = findViewById(R.id.btn_riget);
        ckjizhu();
        login();
        mBtnRiget.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginActivity.this,RightActivity.class);
                startActivity(intent);
            }
        });
    }

    private void ckjizhu() {
        mCkJizhu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(mCkJizhu.isChecked()){
                    mCkJizhu.setChecked(true);

                }else{
                    mCkJizhu.setChecked(false);
                }
            }
        });
    }

    private void login() {
        mBtnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                String name = mEtName.getText().toString();
//                String pwd = mEtPwd.getText().toString();
                if(!TextUtils.isEmpty(mEtName.getText()) &&!TextUtils.isEmpty(mEtName.getText())){
                     persenter.getLogin_Presenter(mEtName.getText().toString(),mEtPwd.getText().toString(),mCkJizhu.isChecked());
                    Log.e("TAG", "onClick: "+mEtName.getText().toString()+","+mEtPwd.getText().toString());
                 }else{
                    Toast.makeText(LoginActivity.this, R.string.name_pass_null_toast, Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    @Override
    public void getLogin_View() {

//        Intent intent = new Intent(this, MainActivity.class);
//        startActivity(intent);
        finish();
    }

    @Override
    public void getError(String error) {
        Toast.makeText(this, "用户名密码错误"+error, Toast.LENGTH_SHORT).show();
        Log.e("TAG", "getError: "+error );
    }
}