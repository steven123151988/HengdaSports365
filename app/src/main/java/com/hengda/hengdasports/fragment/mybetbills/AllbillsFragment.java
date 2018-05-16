package com.hengda.hengdasports.fragment.mybetbills;

import com.hengda.hengdasports.R;
import com.hengda.hengdasports.activity.login.LoginActivity;
import com.hengda.hengdasports.api.HttpCallback;
import com.hengda.hengdasports.api.HttpRequest;
import com.hengda.hengdasports.base.BaseFragment;
import com.hengda.hengdasports.base.SportsAPI;
import com.hengda.hengdasports.base.SportsApplication;
import com.hengda.hengdasports.base.SportsKey;
import com.hengda.hengdasports.json2.LoginRsp;
import com.hengda.hengdasports.utils.SharePreferencesUtil;
import com.hengda.hengdasports.utils.ShowDialogUtil;

/**
 * Description: 所有的订单
 * Data：2018/5/10-16:51
 * steven
 */
public class AllbillsFragment extends BaseFragment {
    @Override
    protected int getLayoutId() {
        return R.layout.fragment_allbill;
    }

    @Override
    protected void initView() {
    }

    @Override
    protected void initData() {
        getBetbills(1);
    }


    public void getBetbills(int  page){
        HttpRequest.getInstance().bet_betting(AllbillsFragment.this, page, new HttpCallback<LoginRsp>() {
            @Override
            public void onSuccess(LoginRsp data) {



            }

            @Override
            public void onFailure(String msgCode, String errorMsg) {
                ShowDialogUtil.showFailDialog(AllbillsFragment.this.getActivity(), getString(R.string.loginerr), errorMsg);
            }
        });

    }
}
