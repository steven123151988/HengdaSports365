package com.hengda.hengdasports.fragment.main;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.hengda.hengdasports.R;
import com.hengda.hengdasports.adapter.Myadapter;
import com.hengda.hengdasports.base.BaseFragment;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * Description:
 * Data：2018/4/25-15:24
 * steven
 */
public class BetRecordsFragment extends BaseFragment {

    @BindView(R.id.iv_back)
    ImageView ivBack;
    @BindView(R.id.tv_bet_title)
    TextView tvBetTitle;
    @BindView(R.id.ll_title)
    LinearLayout llTitle;
    @BindView(R.id.iv_menu)
    ImageView ivMenu;
    @BindView(R.id.fl_title)
    FrameLayout flTitle;
    @BindView(R.id.tab)
    TabLayout tab;
    @BindView(R.id.pager)
    ViewPager pager;
    Unbinder unbinder;

    private List list;

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_mybets;
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void initData() {
//        list = new ArrayList<>();
//        list.clear();
//        for (int i = 0; i < 4; i++) {
//            list.add(new BillFragment());
//            list.add(new BillFragment());
//            list.add(new BillFragment());
//            list.add(new BillFragment());
//        }
        list = new ArrayList<>();
        for (int i = 0; i < 9; i++) {
            list.add(String.format(Locale.CHINA, "第%02d页", i));

        }
        //getChildFragmentManager()改成getChildFragmentManager()
        pager.setAdapter(new Myadapter(getChildFragmentManager(), list));
        /*Tab与ViewPager绑定*/
        tab.setupWithViewPager(pager);
    }


    @OnClick({R.id.iv_back, R.id.iv_menu})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_back:
                break;
            case R.id.iv_menu:
                break;
        }
    }
}
