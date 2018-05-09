package com.hengda.hengdasports.fragment.main;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.hengda.hengdasports.R;
import com.hengda.hengdasports.api.HttpCallback;
import com.hengda.hengdasports.api.HttpRequest;
import com.hengda.hengdasports.base.BaseFragment;
import com.hengda.hengdasports.json2.HomeindexRsp;
import com.hengda.hengdasports.json2.LoginRsp;
import com.hengda.hengdasports.utils.LogUtil;
import com.hengda.hengdasports.view.banner.BannerBaseView;
import com.hengda.hengdasports.view.banner.BaseBannerBean;
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
    private BaseBannerBean  baseBannerBean;

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_shouye;
    }

    @Override
    protected void initView() {
    }


    @Override
    protected void initData() {

        HttpRequest.getInstance().homeIndex(FirstFragment.this, new HttpCallback<HomeindexRsp>() {

            @Override
            public void onSuccess(HomeindexRsp data) {
                marquee.setText(data.getData().getNotice());
                marquee.start();

                List list = new ArrayList<>();
                for (int i=0;i<data.getData().getSlide().size();i++){
                    baseBannerBean=new BaseBannerBean(data.getData().getSlide().get(i).getImg(),data.getData().getSlide().get(i).getUrl());
                    list.add(baseBannerBean);
                }


                if (null != getActivity()) {
                    BannerBaseView banner = new MainBannerView(getActivity());
                    bannerCont.addView(banner);
                    banner.update(list);
                    imgDefault.setVisibility(View.GONE);
                    bannerCont.setVisibility(View.VISIBLE);

                }

            }

            @Override
            public void onFailure(String msgCode, String errorMsg) {
            }
        });




    }


    @Override
    public void onResume() {
        super.onResume();

//        if (!ifgetsuccess){
//            LogUtil.e("======ifgetsuccess==="+ifgetsuccess);
//            initData();
//        }

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
