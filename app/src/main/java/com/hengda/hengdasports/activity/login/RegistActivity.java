package com.hengda.hengdasports.activity.login;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.hengda.hengdasports.R;
import com.hengda.hengdasports.base.BaseActivity;
import com.hengda.hengdasports.utils.SystemUtil;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Description:
 * Data：2018/4/30-17:36
 * steven
 */
public class RegistActivity extends BaseActivity {
    @BindView(R.id.iv_back)
    ImageView ivBack;
    @BindView(R.id.tv_center_name)
    TextView tvCenterName;
    @BindView(R.id.edittext_account)
    EditText edittextAccount;
    @BindView(R.id.edittext_pwd)
    EditText edittextPwd;
    @BindView(R.id.checkbox)
    CheckBox checkbox;
    @BindView(R.id.btn_regist)
    Button btnRegist;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_regist;
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initView(@Nullable Bundle savedInstanceState) {
        SystemUtil.setfullScreen(RegistActivity.this);
        tvCenterName.setText("注册");
    }


    @OnClick({R.id.iv_back, R.id.btn_regist})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_back:
                finish();
                break;
            case R.id.btn_regist:
                break;
        }
    }
}
