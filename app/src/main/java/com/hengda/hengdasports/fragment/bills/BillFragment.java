package com.hengda.hengdasports.fragment.bills;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.TextView;

import com.hengda.hengdasports.R;
import com.hengda.hengdasports.activity.bet.BetdetailAcivity;
import com.hengda.hengdasports.api.HttpCallback;
import com.hengda.hengdasports.api.HttpRequest;
import com.hengda.hengdasports.base.BaseFragment;
import com.hengda.hengdasports.json.HotgameRsp;
import com.hengda.hengdasports.utils.LogUtil;
import com.hengda.hengdasports.utils.ShowDialogUtil;

/**
 * Description:  赛事球类信息
 * Data：2018/4/28-14:34
 * steven
 */
public class BillFragment extends BaseFragment {
    private String ball, type, game;


    @Override
    protected int getLayoutId() {
        return R.layout.fragment_bill;
    }

    @Override
    protected void initView() {
        Bundle bundle = getArguments();
        ball = bundle.getString("ball");
        type = bundle.getString("type");
        game = bundle.getString("game");

        LogUtil.e("====ball=========" + ball);
        LogUtil.e("====type=========" + type);
        LogUtil.e("====game=========" + game);


    }

    @Override
    protected void initData() {

        getGameData(ball, type, game);
    }

    public static BillFragment newInstance(String text, String ball, String type, String game) {
        Bundle bundle = new Bundle();
        bundle.putString("text", text);
        bundle.putString("ball", ball);
        bundle.putString("type", type);
        bundle.putString("game", game);
        BillFragment blankFragment = new BillFragment();
        blankFragment.setArguments(bundle);

        return blankFragment;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        TextView textView = (TextView) view.findViewById(R.id.pager_text);
        textView.setText(getArguments().getString("text"));
    }

    public void getGameData(String ball, String type, String game) {
        HttpRequest.getInstance().getGameData(BillFragment.this, ball, type, game, new HttpCallback<HotgameRsp>() {
            @Override
            public void onSuccess(HotgameRsp data) {
            }

            @Override
            public void onFailure(String msgCode, String errorMsg) {
                ShowDialogUtil.showFailDialog(BillFragment.this.getActivity(), "请求失败", errorMsg);
            }
        });
    }


}
