package com.hengda.hengdasports.fragment.main;

import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.hengda.hengdasports.R;
import com.hengda.hengdasports.adapter.FragmentAdapter;
import com.hengda.hengdasports.base.BaseFragment;
import com.hengda.hengdasports.fragment.mybetbills.AllbillsFragment;
import com.hengda.hengdasports.fragment.mybetbills.CanclebillsFragment;
import com.hengda.hengdasports.fragment.mybetbills.WillwinFragment;
import com.hengda.hengdasports.fragment.mybetbills.WinbillsFragment;
import com.hengda.hengdasports.utils.KeyBoardUtils;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * Description:  我的注单
 * Data：2018/4/25-15:26
 * steven
 */
public class MybetsFragment extends BaseFragment {
    @BindView(R.id.iv_back)
    ImageView ivBack;
    @BindView(R.id.tv_center)
    TextView tvCenter;
    @BindView(R.id.iv_menu)
    ImageView ivMenu;
    @BindView(R.id.pager)
    ViewPager viewPager;
    @BindView(R.id.rb_position_1)
    RadioButton rbPosition1;
    @BindView(R.id.rb_position_2)
    RadioButton rbPosition2;
    @BindView(R.id.rb_position_3)
    RadioButton rbPosition3;
    @BindView(R.id.rb_position_4)
    RadioButton rbPosition4;
    @BindView(R.id.radioGroup)
    RadioGroup radioGroup;
    Unbinder unbinder;
    private AllbillsFragment allbillFragment;
    private CanclebillsFragment canclebillsFragment;
    private WinbillsFragment winbillsFragment;
    private WillwinFragment willwinFragment;
    private List<Fragment> fragments = new ArrayList<>();
    private int position = 0;

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_mybets;
    }

    @Override
    protected void initView() {


    }

    @Override
    protected void initData() {
        if (null == allbillFragment)
            allbillFragment = new AllbillsFragment();
        if (null == winbillsFragment)
            winbillsFragment = new WinbillsFragment();
        if (null == willwinFragment)
            willwinFragment = new WillwinFragment();
        if (null == canclebillsFragment)
            canclebillsFragment = new CanclebillsFragment();
        fragments.clear();
        fragments.add(allbillFragment);
        fragments.add(winbillsFragment);
        fragments.add(willwinFragment);
        fragments.add(canclebillsFragment);

        //getChildFragmentManager()改成getChildFragmentManager()
        viewPager.setAdapter(new FragmentAdapter(getChildFragmentManager(), fragments));
        viewPager.setCurrentItem(position);
        radioGroup.check(radioGroup.getChildAt(position).getId());

        initListener();
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

    private void initListener() {
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                switch (position) {
                    case 0:
                        radioGroup.check(R.id.rb_position_1);
                        break;
                    case 1:
                        radioGroup.check(R.id.rb_position_2);
                        break;
                    case 2:
                        radioGroup.check(R.id.rb_position_3);
                        break;
                    case 3:
                        radioGroup.check(R.id.rb_position_4);
                        break;

                }

                KeyBoardUtils.hideInputForce(MybetsFragment.this.getActivity());
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
                switch (checkedId) {
                    case R.id.rb_position_1:
                        viewPager.setCurrentItem(0);
                        break;
                    case R.id.rb_position_2:
                        viewPager.setCurrentItem(1);
                        break;
                    case R.id.rb_position_3:
                        viewPager.setCurrentItem(2);
                        break;
                    case R.id.rb_position_4:
                        viewPager.setCurrentItem(3);
                        break;

                }
                KeyBoardUtils.hideInputForce(MybetsFragment.this.getActivity());
            }
        });

    }
}
