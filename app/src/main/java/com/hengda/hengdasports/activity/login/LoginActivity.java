package com.hengda.hengdasports.activity.login;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.hengda.hengdasports.R;
import com.hengda.hengdasports.activity.MainActivity;
import com.hengda.hengdasports.base.BaseActivity;
import com.hengda.hengdasports.utils.ShowDialogUtil;
import com.hengda.hengdasports.utils.SystemUtil;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Description:
 * Data：2018/4/25-11:24
 * steven
 */
public class LoginActivity extends BaseActivity {
    @BindView(R.id.iv_back)
    ImageView ivBack;
    @BindView(R.id.tv_center_name)
    TextView tvCenterName;
    @BindView(R.id.edittext_account)
    EditText edittextAccount;
    @BindView(R.id.view1)
    View view1;
    @BindView(R.id.edittext_pwd)
    EditText edittextPwd;
    @BindView(R.id.tv_forgetpsw)
    TextView tvForgetpsw;
    @BindView(R.id.btn_login)
    Button btnLogin;
    @BindView(R.id.tv_regist)
    TextView tvRegist;
    @BindView(R.id.tv_shiwan)
    TextView tvShiwan;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_login;
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initView(@Nullable Bundle savedInstanceState) {
        tvCenterName.setText("正式账号登陆");
        SystemUtil.setfullScreen(LoginActivity.this);

    }



    @OnClick({R.id.iv_back, R.id.tv_forgetpsw, R.id.btn_login, R.id.tv_regist, R.id.tv_shiwan})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_back:
                finish();
                break;
            case R.id.tv_forgetpsw:
                ShowDialogUtil.showSuccessDialog(LoginActivity.this,"","请联系在线客服解决！");
                break;
            case R.id.btn_login:
                break;
            case R.id.tv_regist:
                startActivity(new Intent(LoginActivity.this,RegistActivity.class));
                break;
            case R.id.tv_shiwan:
                break;
        }
    }
}
