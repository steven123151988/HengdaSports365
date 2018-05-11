package com.hengda.hengdasports.activity.mine;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.hengda.hengdasports.R;
import com.hengda.hengdasports.api.HttpCallback;
import com.hengda.hengdasports.api.HttpRequest;
import com.hengda.hengdasports.base.BaseActivity;
import com.hengda.hengdasports.json2.InsideMail;
import com.hengda.hengdasports.utils.ShowDialogUtil;
import com.hengda.hengdasports.utils.SystemUtil;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Description:
 * Data：2018/5/10-13:20
 * steven
 */
public class InsideMailActivity extends BaseActivity {
    @BindView(R.id.iv_back)
    ImageView ivBack;
    @BindView(R.id.tv_center)
    TextView tvCenter;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_insidemail;
    }

    @Override
    protected void initData() {
        insideMail(1);

    }

    @Override
    protected void initView(@Nullable Bundle savedInstanceState) {
        SystemUtil.setfullScreen(InsideMailActivity.this);
        tvCenter.setText("站内信");
    }


    @OnClick(R.id.iv_back)
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_back:
                finish();
                break;
        }
    }


    public void insideMail(int page) {
        HttpRequest.getInstance().insideMail(InsideMailActivity.this, page, new HttpCallback<InsideMail>() {
            @Override
            public void onSuccess(InsideMail data) {

            }

            @Override
            public void onFailure(String msgCode, String errorMsg) {
                ShowDialogUtil.showFailDialog(InsideMailActivity.this, getString(R.string.loginerr), errorMsg);
            }
        });
    }
}