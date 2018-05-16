package com.hengda.hengdasports.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.hengda.hengdasports.R;
import com.hengda.hengdasports.base.BaseActivity;
import com.hengda.hengdasports.fragment.main.BetRecordsFragment;
import com.hengda.hengdasports.fragment.main.MineFragment;
import com.hengda.hengdasports.fragment.main.MybetsFragment;
import com.hengda.hengdasports.fragment.main.FirstFragment;
import com.hengda.hengdasports.utils.LogUtil;
import com.hengda.hengdasports.utils.SystemUtil;
import com.hengda.hengdasports.utils.UserHelper;

import butterknife.BindView;
import butterknife.OnClick;

public class MainActivity extends BaseActivity {
    @BindView(R.id.view_fragment)
    FrameLayout viewFragment;
    @BindView(R.id.iv_home)
    ImageView ivHome;
    @BindView(R.id.tv_home)
    TextView tvHome;
    @BindView(R.id.ll_home)
    LinearLayout llHome;
    @BindView(R.id.iv_betting)
    ImageView ivBetting;
    @BindView(R.id.tv_betting)
    TextView tvBetting;
    @BindView(R.id.ll_betting)
    LinearLayout llBetting;
    @BindView(R.id.iv_money)
    ImageView ivMoney;
    @BindView(R.id.tv_money)
    TextView tvMoney;
    @BindView(R.id.ll_money)
    LinearLayout llMoney;
    @BindView(R.id.iv_mine)
    ImageView ivMine;
    @BindView(R.id.tv_mine)
    TextView tvMine;
    @BindView(R.id.ll_mine)
    LinearLayout llMine;
    private FragmentManager mFragmentManager;  // Fragment管理器
    private long mClickTime;
    private int currentFragmentIndex = -1; //记录当前显示的fragment
    private Fragment[] fragments;
    private View[] mllViews;
    private FirstFragment shouyeFragment;
    private BetRecordsFragment betRecordsFragment;
    private MybetsFragment mybetsFragment;
    private MineFragment mineFragment;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initView(@Nullable Bundle savedInstanceState) {
        SystemUtil.setfullScreen(MainActivity.this);
        if (null == shouyeFragment)
            shouyeFragment = new FirstFragment();
        if (null == betRecordsFragment)
            betRecordsFragment = new BetRecordsFragment();
        if (null == mybetsFragment)
            mybetsFragment = new MybetsFragment();
        if (null == mineFragment)
            mineFragment = new MineFragment();

        mllViews = new View[]{llHome, llBetting, llMoney, llMine};
        fragments = new Fragment[]{shouyeFragment, betRecordsFragment, mybetsFragment, mineFragment};

        mFragmentManager = getSupportFragmentManager();
        changeShowFragment(0);

    }


    @OnClick({R.id.ll_home, R.id.ll_betting, R.id.ll_money, R.id.ll_mine})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.ll_home:
                changeShowFragment(0);
                break;
            case R.id.ll_betting:
                changeShowFragment(1);
                break;
            case R.id.ll_money:
                changeShowFragment(2);
                break;
            case R.id.ll_mine:
                changeShowFragment(3);
                break;
        }
    }


    /**
     * 根据fragment数组下标，切换需要显示的fragment，并且隐藏当前的fragment
     */
    public void changeShowFragment(int index) {
        changeSelectState(index);
        if (index != currentFragmentIndex) {
            Fragment showFragment = fragments[index];
            FragmentTransaction transaction = mFragmentManager.beginTransaction();
            if (!showFragment.isAdded()) {
                transaction.add(R.id.view_fragment, showFragment);
            }
            if (currentFragmentIndex != -1) {
                transaction.hide(fragments[currentFragmentIndex]);
            }
            transaction.show(showFragment);
            transaction.commitAllowingStateLoss();
            currentFragmentIndex = index;
        }
    }

    private void changeSelectState(int index) {
        for (int i = 0; i < mllViews.length; i++) {
            mllViews[i].setSelected(index == i);
        }
    }


    @Override
    public void onBackPressed() {
        long time = System.currentTimeMillis();
        if (time - mClickTime <= 2000) {
            super.onBackPressed();
            System.exit(0);
        } else {
            mClickTime = time;
            Toast.makeText(this, "再次点击退出。", Toast.LENGTH_SHORT).show();
        }
    }
}
