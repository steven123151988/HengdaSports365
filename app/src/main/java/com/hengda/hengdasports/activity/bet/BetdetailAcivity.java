package com.hengda.hengdasports.activity.bet;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.hengda.hengdasports.R;
import com.hengda.hengdasports.activity.MainActivity;
import com.hengda.hengdasports.base.BaseActivity;
import com.hengda.hengdasports.utils.SystemUtil;

/**
 * Description: 投注类
 * Data：2018/5/11-11:22
 * steven
 */
public class BetdetailAcivity extends BaseActivity {
    @Override
    protected int getLayoutId() {
        return R.layout.activity_betdetail;
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initView(@Nullable Bundle savedInstanceState) {
        SystemUtil.setfullScreen(BetdetailAcivity.this);
    }
}
