package com.hengda.hengdasports.activity.bet;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.hengda.hengdasports.R;
import com.hengda.hengdasports.api.HttpCallback;
import com.hengda.hengdasports.api.HttpRequest;
import com.hengda.hengdasports.base.BaseActivity;
import com.hengda.hengdasports.json.HotgameRsp;
import com.hengda.hengdasports.json2.BetMenuList;
import com.hengda.hengdasports.utils.ShowDialogUtil;
import com.hengda.hengdasports.utils.SystemUtil;
import com.hengda.hengdasports.view.dialog.SwitchGamePopupWindow;
import com.hengda.hengdasports.view.dialog.easypopup.HorizontalGravity;
import com.hengda.hengdasports.view.dialog.easypopup.VerticalGravity;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Description: 投注类
 * Data：2018/5/11-11:22
 * steven
 */
public class BetdetailAcivity extends BaseActivity {
    @BindView(R.id.iv_back)
    ImageView ivBack;
    @BindView(R.id.tv_center)
    TextView tvCenter;
    @BindView(R.id.ll_title)
    LinearLayout llTitle;
    @BindView(R.id.iv_menu)
    ImageView ivMenu;
    private String ball;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_betdetail;
    }


    @Override
    protected void initView(@Nullable Bundle savedInstanceState) {
        SystemUtil.setfullScreen(BetdetailAcivity.this);
        ball = getIntent().getStringExtra("ball");


    }

    @Override
    protected void initData() {
        getBetmenulist(ball);
    }


    public void getGameData(String ball, String type, String game) {
        HttpRequest.getInstance().getGameData(BetdetailAcivity.this, ball, type, game, new HttpCallback<HotgameRsp>() {
            @Override
            public void onSuccess(HotgameRsp data) {

            }

            @Override
            public void onFailure(String msgCode, String errorMsg) {
                ShowDialogUtil.showFailDialog(BetdetailAcivity.this, getString(R.string.loginerr), errorMsg);
            }
        });
    }


    private void getBetmenulist(final String ball) {
        HttpRequest.getInstance().getBetMenuList(BetdetailAcivity.this, ball, new HttpCallback<BetMenuList>() {
            @Override
            public void onSuccess(BetMenuList data) {
                List list = new ArrayList();
                for (int i = 0; i < data.getData().size(); i++) {
                    list.add(data.getData().get(i).getType());
                }


                if (list.contains("jrss")) {
                    getGameData(ball, "jrss", "");
                } else {
                    getGameData(ball, data.getData().get(0).getType(), "");
                }


            }

            @Override
            public void onFailure(String msgCode, String errorMsg) {
            }
        });
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }

    @OnClick({R.id.iv_back, R.id.tv_center, R.id.ll_title, R.id.iv_menu})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_back:
                break;
            case R.id.tv_center:
                break;
            case R.id.ll_title:
                break;
            case R.id.iv_menu:
                break;
        }
    }

    private void showSwitchGamePopup() {
        new SwitchGamePopupWindow(this)
                .setOnItemClickListener(new SwitchGamePopupWindow.OnItemClickListener() {
                    @Override
                    public void onItemClick(int gameCode) {
                        recreate();
                    }
                })
                .createPopup()
                .showAtAnchorView(llTitle, VerticalGravity.BELOW, HorizontalGravity.CENTER);
    }
}
