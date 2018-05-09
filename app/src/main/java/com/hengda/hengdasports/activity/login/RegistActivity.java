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
import com.hengda.hengdasports.api.HttpCallback;
import com.hengda.hengdasports.api.HttpRequest;
import com.hengda.hengdasports.base.BaseActivity;
import com.hengda.hengdasports.json2.LoginRsp;
import com.hengda.hengdasports.utils.ShowDialogUtil;
import com.hengda.hengdasports.utils.SystemUtil;
import com.hengda.hengdasports.utils.TextUtil;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Description: 注册界面
 * Data：2018/4/30-17:36
 * steven
 */
public class RegistActivity extends BaseActivity {
    @BindView(R.id.tv_center_name)
    TextView tvCenterName;
    @BindView(R.id.edittext_account)
    EditText edittextAccount;
    @BindView(R.id.edittext_pwd)
    EditText edittextPwd;
    @BindView(R.id.checkbox)
    CheckBox checkbox;
    @BindView(R.id.ed_yaoqingma)
    EditText edYaoqingma;
    @BindView(R.id.ed_yanzhengma)
    EditText edYanzhengma;

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
                if (!checkbox.isChecked()) {
                    ShowDialogUtil.showFailDialog(RegistActivity.this, getString(R.string.sorry), "必须同意本app的使用的条款。");
                    return;
                }

                if (edittextAccount.getText().toString().replace(" ", "").isEmpty() || edittextPwd.getText().toString().replace(" ", "").isEmpty()) {
                    ShowDialogUtil.showFailDialog(RegistActivity.this, getString(R.string.sorry), "注册参数填写不完整，请修改。");
                    return;
                }
                String username = edittextAccount.getText().toString().replace(" ", "");
                String password = edittextPwd.getText().toString().replace(" ", "");
                String yaoqingma = edYaoqingma.getText().toString().replace(" ", "");
                String yanzhengma = edYanzhengma.getText().toString().replace(" ", "");

                if (username.isEmpty() || password.isEmpty() || yanzhengma.isEmpty()) {
                    ShowDialogUtil.showFailDialog(RegistActivity.this, getString(R.string.sorry), "信息填写不完整，请重试。");
                    return;
                }

                checkUser(username,password,yaoqingma,yanzhengma);


                break;
        }
    }

    /**
     * 检查用户名是否可用
     */
    private void checkUser(final String username, final String password, final String yaoqingma, final String yanzhengma) {
        HttpRequest.getInstance().checkUser(RegistActivity.this, username, new HttpCallback<LoginRsp>() {
            @Override
            public void onSuccess(LoginRsp data) {
                //用户名可用,直接去注册
                gotoRegist(username,password,yaoqingma,yanzhengma);
            }

            @Override
            public void onFailure(String msgCode, String errorMsg) {
                ShowDialogUtil.showFailDialog(mContext, getString(R.string.sorry), errorMsg);
            }
        });
    }


    /**
     * 去注册
     */
    private void gotoRegist(String username,String password,String yaoqingma,String yanzhengma) {




    }


}
