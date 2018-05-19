package com.hengda.hengdasports.activity.mine.safecenter;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.hengda.hengdasports.R;
import com.hengda.hengdasports.base.BaseActivity;
import com.hengda.hengdasports.utils.SystemUtil;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Description:
 * Data：2018/5/17-13:47
 * steven
 */
public class BankcardActivity extends BaseActivity {
    @BindView(R.id.iv_back)
    ImageView ivBack;
    @BindView(R.id.tv_center_name)
    TextView tvCenterName;
    @BindView(R.id.tv_xingming)
    TextView tvXingming;
    @BindView(R.id.tv_name)
    TextView tvName;
    @BindView(R.id.ed_bankcard_number)
    EditText edBankcardNumber;
    @BindView(R.id.tv_bank)
    TextView tvBank;
    @BindView(R.id.ll_select_bank)
    LinearLayout llSelectBank;
    @BindView(R.id.ed_zhihang)
    EditText edZhihang;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_bankcard;
    }

    @Override
    protected void initView(@Nullable Bundle savedInstanceState) {
        SystemUtil.setfullScreen(BankcardActivity.this);
        tvCenterName.setText("我的银行卡");
    }

    @Override
    protected void initData() {

    }

    @OnClick({R.id.iv_back, R.id.ll_select_bank})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_back:
                finish();
                break;
            case R.id.ll_select_bank:
                break;
        }
    }
}
