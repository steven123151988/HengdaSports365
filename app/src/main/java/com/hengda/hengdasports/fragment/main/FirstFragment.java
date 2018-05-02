package com.hengda.hengdasports.fragment.main;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.hengda.hengdasports.R;
import com.hengda.hengdasports.base.BaseFragment;
import com.hengda.hengdasports.view.banner.BannerBaseView;
import com.hengda.hengdasports.view.banner.MainBannerView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Description:
 * Data：2018/4/25-15:19
 * steven
 */
public class FirstFragment extends BaseFragment {
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

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_shouye;
    }

    @Override
    protected void initView() {

        marquee.setText(" huodp 活动公告");
        marquee.start();
    }

    @Override
    protected void initData() {


        List<String> list = new ArrayList<>();
        list.add("http://pic29.nipic.com/20130602/7447430_185802070000_2.jpg");
        list.add("http://pic36.nipic.com/20131209/7487939_011617689000_2.jpg");
        list.add("http://img5.imgtn.bdimg.com/it/u=2793250479,2216840076&fm=27&gp=0.jpg");

        if (null != getActivity()) {
            BannerBaseView banner = new MainBannerView(getActivity());
            bannerCont.addView(banner);
            banner.update(list);
            imgDefault.setVisibility(View.GONE);
            bannerCont.setVisibility(View.VISIBLE);

        }

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
