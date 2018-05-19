package com.hengda.hengdasports.activity.bet;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.hengda.hengdasports.R;
import com.hengda.hengdasports.adapter.Myadapter;
import com.hengda.hengdasports.api.HttpCallback;
import com.hengda.hengdasports.api.HttpRequest;
import com.hengda.hengdasports.base.BaseActivity;
import com.hengda.hengdasports.json2.BetMenuList;
import com.hengda.hengdasports.utils.LogUtil;
import com.hengda.hengdasports.utils.SystemUtil;
import com.hengda.hengdasports.view.dialog.SwitchGamePopupWindow;
import com.hengda.hengdasports.view.dialog.easypopup.HorizontalGravity;
import com.hengda.hengdasports.view.dialog.easypopup.VerticalGravity;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
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
    @BindView(R.id.tab)
    TabLayout tab;
    @BindView(R.id.pager)
    ViewPager pager;
    private String ball;
    private BetMenuList betMenuList;
    private List list_plays;
    private String game_type;//玩法
    private String game;//具体游戏


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




    private void getBetmenulist(final String ball) {
        HttpRequest.getInstance().getBetMenuList(BetdetailAcivity.this, ball, new HttpCallback<BetMenuList>() {
            @Override
            public void onSuccess(BetMenuList data) {
                betMenuList = data;

//                List list = new ArrayList();
//                for (int i = 0; i < data.getData().size(); i++) {
//                    list.add(data.getData().get(i).getType());
//                }

                // 首先选择显示今日赛事
//                if (!list.contains("jrss")) {
//                    getGameData(ball, "jrss","");
//                    tvCenter.setText("今日赛事");
//                    game_type="jrss";
//                } else {
                //                }

                game_type = data.getData().get(0).getType();
                game = data.getData().get(0).getPaly_method().get(0).getGame();

                tvCenter.setText(data.getData().get(0).getAlias());
                list_plays = new ArrayList<>();
                list_plays.clear();
                for (int i = 0; i < data.getData().get(0).getPaly_method().size(); i++) {
                    list_plays.add(data.getData().get(0).getPaly_method().get(i).getAlias());
                }

                //getChildFragmentManager()改成getChildFragmentManager()
                pager.setAdapter(new Myadapter(getSupportFragmentManager(), list_plays,ball,game_type,game));
                /*Tab与ViewPager绑定*/
                tab.setupWithViewPager(pager);
            }

            @Override
            public void onFailure(String msgCode, String errorMsg) {
            }
        });
    }


    @OnClick({R.id.iv_back, R.id.ll_title, R.id.iv_menu})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_back:
                finish();
                break;
            case R.id.ll_title:
                showSwitchGamePopup();
                break;
            case R.id.iv_menu:
                break;
        }
    }

    private void showSwitchGamePopup() {

        if (null != betMenuList) {
            new SwitchGamePopupWindow(this, betMenuList)
                    .setOnItemClickListener(new SwitchGamePopupWindow.OnItemClickListener() {
                        @Override
                        public void onItemClick(int position,String type, String alias) {

                            game_type = type;
                            tvCenter.setText(alias);
                            LogUtil.e("====game_type==="+game_type);

                            list_plays = new ArrayList<>();
                            list_plays.clear();
                            for (int i = 0; i < betMenuList.getData().get(position).getPaly_method().size(); i++) {
                                list_plays.add(betMenuList.getData().get(position).getPaly_method().get(i).getAlias());
                            }

                            //getChildFragmentManager()改成getChildFragmentManager()
                            pager.setAdapter(new Myadapter(getSupportFragmentManager(), list_plays,ball,game_type,game));
                            /*Tab与ViewPager绑定*/
                            tab.setupWithViewPager(pager);
                            //                            recreate();
                        }
                    })
                    .createPopup()
                    .showAtAnchorView(llTitle, VerticalGravity.BELOW, HorizontalGravity.CENTER);
        }


    }
}
