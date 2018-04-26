package com.hengda.hengdasports.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.hengda.hengdasports.R;
import com.hengda.hengdasports.base.BaseFragment;
import com.hengda.hengdasports.view.MarqueeTextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * Description:
 * Data：2018/4/25-15:19
 * steven
 */
public class ShouyeFragment extends BaseFragment {
    @BindView(R.id.img_default)
    ImageView imgDefault;
    @BindView(R.id.banner_cont)
    RelativeLayout bannerCont;
    @BindView(R.id.marquee)
    com.hengda.hengdasports.view.MarqueeView marquee;
    @BindView(R.id.ll_chongzhi)
    LinearLayout llChongzhi;
    @BindView(R.id.ll_shiwan)
    LinearLayout llShiwan;
    @BindView(R.id.ll_youhui)
    LinearLayout llYouhui;
    @BindView(R.id.ll_kefu)
    LinearLayout llKefu;
    @BindView(R.id.ll_football)
    LinearLayout llFootball;
    @BindView(R.id.ll_basketball)
    LinearLayout llBasketball;
    @BindView(R.id.ll_netball)
    LinearLayout llNetball;
    @BindView(R.id.ll_volleyball)
    LinearLayout llVolleyball;
    Unbinder unbinder;

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_shoye;
    }

    @Override
    protected void initData() {
        marquee.setText(" huodp 活动公告");
        marquee.start();

    }



    @OnClick({R.id.ll_chongzhi, R.id.ll_shiwan, R.id.ll_youhui, R.id.ll_kefu, R.id.ll_football, R.id.ll_basketball, R.id.ll_netball, R.id.ll_volleyball})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.ll_chongzhi:
                break;
            case R.id.ll_shiwan:
                break;
            case R.id.ll_youhui:
                break;
            case R.id.ll_kefu:
                break;
            case R.id.ll_football:
                break;
            case R.id.ll_basketball:
                break;
            case R.id.ll_netball:
                break;
            case R.id.ll_volleyball:
                break;
        }
    }
}
