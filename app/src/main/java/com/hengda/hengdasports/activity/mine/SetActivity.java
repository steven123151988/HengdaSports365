package com.hengda.hengdasports.activity.mine;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.hengda.hengdasports.R;
import com.hengda.hengdasports.activity.MainActivity;
import com.hengda.hengdasports.activity.login.LoginActivity;
import com.hengda.hengdasports.api.HttpCallback;
import com.hengda.hengdasports.api.HttpRequest;
import com.hengda.hengdasports.base.BaseActivity;
import com.hengda.hengdasports.base.SportsKey;
import com.hengda.hengdasports.json2.LoginRsp;
import com.hengda.hengdasports.utils.SharePreferencesUtil;
import com.hengda.hengdasports.utils.ShowDialogUtil;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Description:
 * Data：2018/5/8-19:52
 * steven
 */
public class SetActivity extends BaseActivity {
    @BindView(R.id.iv_back)
    ImageView ivBack;
    @BindView(R.id.tv_center_name)
    TextView tvCenterName;
    @BindView(R.id.bt_loginout)
    Button btLoginout;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_set;
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initView(@Nullable Bundle savedInstanceState) {
        tvCenterName.setText("设置");
    }


    @OnClick({R.id.iv_back, R.id.bt_loginout})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_back:
                finish();
                break;
            case R.id.bt_loginout:
                String uid = SharePreferencesUtil.getString(SetActivity.this, SportsKey.UID, "0");
                HttpRequest.getInstance().loginOut(SetActivity.this, uid, new HttpCallback<LoginRsp>() {
                    @Override
                    public void onSuccess(LoginRsp data) {
                        SharePreferencesUtil.addString(SetActivity.this, SportsKey.UID, "0");
                        startActivity(new Intent(SetActivity.this, MainActivity.class));

                    }

                    @Override
                    public void onFailure(String msgCode, String errorMsg) {
                        ShowDialogUtil.showFailDialog(SetActivity.this, getString(R.string.loginerr), errorMsg);
                    }
                });


                break;
        }
    }
}
