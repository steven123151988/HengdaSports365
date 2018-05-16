package com.hengda.hengdasports.activity.mine;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.hengda.hengdasports.R;
import com.hengda.hengdasports.api.HttpCallback;
import com.hengda.hengdasports.api.HttpRequest;
import com.hengda.hengdasports.base.BaseActivity;
import com.hengda.hengdasports.json2.LoginRsp;
import com.hengda.hengdasports.utils.ShowDialogUtil;
import com.hengda.hengdasports.utils.SystemUtil;

/**
 * Description: 充值记录
 * Data：2018/5/15-12:01
 * steven
 */
public class PayinActivity  extends BaseActivity {
    @Override
    protected int getLayoutId() {
        return R.layout.activity_payin;
    }

    @Override
    protected void initView(@Nullable Bundle savedInstanceState) {
        SystemUtil.setfullScreen(PayinActivity.this);

    }

    @Override
    protected void initData() {

        getPayin(1);

    }

    public  void  getPayin(int page){
        HttpRequest.getInstance().payin_takeout(PayinActivity.this, page,"deposit" ,new HttpCallback<LoginRsp>() {
            @Override
            public void onSuccess(LoginRsp data) {

            }

            @Override
            public void onFailure(String msgCode, String errorMsg) {
                ShowDialogUtil.showFailDialog(PayinActivity.this, getString(R.string.loginerr), errorMsg);
            }
        });

    }
}
