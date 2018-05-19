package com.hengda.hengdasports.activity.mine;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.hengda.hengdasports.R;
import com.hengda.hengdasports.activity.MainActivity;
import com.hengda.hengdasports.activity.mine.safecenter.BankcardActivity;
import com.hengda.hengdasports.activity.mine.safecenter.ChangeLoginPswActivity;
import com.hengda.hengdasports.activity.mine.safecenter.ChangeMoneypswActivity;
import com.hengda.hengdasports.base.BaseActivity;
import com.hengda.hengdasports.utils.SystemUtil;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Description:
 * Data：2018/5/17-11:20
 * steven
 */
public class SafecenterActivitty extends BaseActivity {
    @BindView(R.id.iv_back)
    ImageView ivBack;
    @BindView(R.id.tv_center_name)
    TextView tvCenterName;
    @BindView(R.id.rl_mybankcard)
    RelativeLayout rlMybankcard;
    @BindView(R.id.rl_loginpsw)
    RelativeLayout rlLoginpsw;
    @BindView(R.id.rl_moneypsw)
    RelativeLayout rlMoneypsw;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_safe;
    }

    @Override
    protected void initView(@Nullable Bundle savedInstanceState) {
        SystemUtil.setfullScreen(SafecenterActivitty.this);
        tvCenterName.setText("安全中心");
    }

    @Override
    protected void initData() {

    }



    @OnClick({R.id.iv_back, R.id.rl_mybankcard, R.id.rl_loginpsw, R.id.rl_moneypsw})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_back:
                finish();
                break;
            case R.id.rl_mybankcard:
                startActivity(new Intent(SafecenterActivitty.this, BankcardActivity.class));
                break;
            case R.id.rl_loginpsw:
                startActivity(new Intent(SafecenterActivitty.this, ChangeLoginPswActivity.class));
                break;
            case R.id.rl_moneypsw:
                startActivity(new Intent(SafecenterActivitty.this, ChangeMoneypswActivity.class));
                break;
        }
    }
}
