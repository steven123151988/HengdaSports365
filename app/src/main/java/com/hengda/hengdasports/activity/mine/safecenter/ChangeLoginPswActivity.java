package com.hengda.hengdasports.activity.mine.safecenter;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
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
 * Data：2018/5/17-14:28
 * steven
 */
public class ChangeLoginPswActivity extends BaseActivity {
    @BindView(R.id.iv_back)
    ImageView ivBack;
    @BindView(R.id.tv_center_name)
    TextView tvCenterName;
    @BindView(R.id.ed_psw_before)
    EditText edPswBefore;
    @BindView(R.id.ed_psw_new)
    EditText edPswNew;
    @BindView(R.id.ed_psw_certain)
    EditText edPswCertain;
    @BindView(R.id.btn_ok)
    Button btnOk;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_changeloginpsw;
    }

    @Override
    protected void initView(@Nullable Bundle savedInstanceState) {
        SystemUtil.setfullScreen(ChangeLoginPswActivity.this);
        tvCenterName.setText("修改登陆密码");
    }

    @Override
    protected void initData() {

    }


    @OnClick({R.id.iv_back, R.id.btn_ok})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_back:
                finish();
                break;
            case R.id.btn_ok:
                break;
        }
    }
}
