package com.hengda.hengdasports.activity.login;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.hengda.hengdasports.R;
import com.hengda.hengdasports.activity.MainActivity;
import com.hengda.hengdasports.api.HttpCallback;
import com.hengda.hengdasports.api.HttpRequest;
import com.hengda.hengdasports.base.BaseActivity;
import com.hengda.hengdasports.base.SportsKey;
import com.hengda.hengdasports.json2.getUserInfo;
import com.hengda.hengdasports.json2.LoginRsp;
import com.hengda.hengdasports.utils.SharePreferencesUtil;
import com.hengda.hengdasports.utils.ShowDialogUtil;
import com.hengda.hengdasports.utils.SystemUtil;
import com.hengda.hengdasports.utils.UserHelper;

import butterknife.BindView;
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
    @BindView(R.id.checkbox_rememberpsw)
    CheckBox checkboxRememberpsw;
    private boolean isChecked;

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
        /*
         *  选择是否记住密码
         */
        isChecked = SharePreferencesUtil.getBoolean(getApplicationContext(), SportsKey.IF_REMEMBER_PSW, true);
        checkboxRememberpsw.setChecked(isChecked);
        checkboxRememberpsw.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean checked) {
                SharePreferencesUtil.addBoolean(getApplicationContext(), SportsKey.IF_REMEMBER_PSW, checked);
            }
        });
        edittextAccount.setText(SharePreferencesUtil.getString(getApplicationContext(), SportsKey.USER_NAME, ""));
        if (isChecked) {
            edittextPwd.setText(SharePreferencesUtil.getString(getApplicationContext(), SportsKey.PASSWORD, ""));
        } else {
            edittextPwd.setText("");
        }

    }


    @OnClick({R.id.iv_back, R.id.tv_forgetpsw, R.id.btn_login, R.id.tv_regist, R.id.tv_shiwan})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_back:
                finish();
                break;
            case R.id.tv_forgetpsw:
                ShowDialogUtil.showSuccessDialog(LoginActivity.this, "", "请联系在线客服解决！");
                break;
            case R.id.btn_login:
                final String username = edittextAccount.getText().toString().replace(" ", "");
                String psw = edittextPwd.getText().toString().replace(" ", "");
                if (username.isEmpty()) {
                    ShowDialogUtil.showFailDialog(LoginActivity.this, getString(R.string.sorry), "用户名字为空");
                    return;
                }
                if (psw.isEmpty()) {
                    ShowDialogUtil.showFailDialog(LoginActivity.this, getString(R.string.sorry), "密码为空");
                    return;
                }

                HttpRequest.getInstance().login(LoginActivity.this, username, psw, new HttpCallback<getUserInfo>() {
                    @Override
                    public void onSuccess(getUserInfo data) {
                        UserHelper.getInstance().setCurrUser(data);
                        SharePreferencesUtil.addString(LoginActivity.this, SportsKey.UID, data.getData().getUid());
                        SharePreferencesUtil.addString(LoginActivity.this, SportsKey.USER_NAME, username);
                        SharePreferencesUtil.addString(LoginActivity.this, SportsKey.PASSWORD, username);
                        startActivity(new Intent(LoginActivity.this, MainActivity.class));
                        finish();



                    }

                    @Override
                    public void onFailure(String msgCode, String errorMsg) {
                        ShowDialogUtil.showFailDialog(LoginActivity.this, getString(R.string.loginerr), errorMsg);
                    }
                });
                break;
            case R.id.tv_regist:
                startActivity(new Intent(LoginActivity.this, RegistActivity.class));
                break;
            case R.id.tv_shiwan:
                break;
        }
    }


}
