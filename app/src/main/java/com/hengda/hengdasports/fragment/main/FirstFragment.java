package com.hengda.hengdasports.fragment.main;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.hengda.hengdasports.R;
import com.hengda.hengdasports.activity.bet.BetdetailAcivity;
import com.hengda.hengdasports.api.HttpCallback;
import com.hengda.hengdasports.api.HttpRequest;
import com.hengda.hengdasports.base.BaseFragment;
import com.hengda.hengdasports.json2.HomeindexRsp;
import com.hengda.hengdasports.view.MarqueeView;
import com.hengda.hengdasports.view.banner.BannerBaseView;
import com.hengda.hengdasports.view.banner.BaseBannerBean;
import com.hengda.hengdasports.view.banner.MainBannerView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

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
    MarqueeView marquee;
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
    @BindView(R.id.iv_laba)
    ImageView ivLaba;
    @BindView(R.id.img_jiantou)
    ImageView imgJiantou;
    @BindView(R.id.tv_football)
    TextView tvFootball;
    @BindView(R.id.tv_basketball)
    TextView tvBasketball;
    Unbinder unbinder;
    private BaseBannerBean baseBannerBean;
    private Intent intent;
    private int footballnum=0;
    private int basketballnum=0;

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
                footballnum=data.getData().getFt_nums();
                basketballnum=data.getData().getBk_nums();

                marquee.setText(data.getData().getNotice());
                marquee.start();

                initText(data);

                List list = new ArrayList<>();
                for (int i = 0; i < data.getData().getSlide().size(); i++) {
                    baseBannerBean = new BaseBannerBean(data.getData().getSlide().get(i).getImg(), data.getData().getSlide().get(i).getUrl());
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

    private void initText(HomeindexRsp data) {
        String beforeText = "共有";
        String afterText = String.valueOf(data.getData().getFt_nums()) + "场";
        String lasttext = "可投";
        int beforeSize = 16;
        int afterSize = 16;
        SpannableStringBuilder builder = new SpannableStringBuilder(beforeText); //创建SpannableStringBuilder，并添加前面文案
        builder.setSpan(new ForegroundColorSpan(Color.parseColor("#000000")), 0, beforeText.length(), Spannable.SPAN_EXCLUSIVE_INCLUSIVE); //设置前面的字体颜色
        builder.setSpan(new AbsoluteSizeSpan(beforeSize, true), 0, beforeText.length(), Spannable.SPAN_INCLUSIVE_EXCLUSIVE); //设置前面的字体大小
        builder.append(afterText); //追加后面文案
        builder.setSpan(new ForegroundColorSpan(Color.parseColor("#ff0000")), beforeText.length(), beforeText.length() + afterText.length(), Spannable.SPAN_EXCLUSIVE_INCLUSIVE); //设置后面的字体颜色
        builder.setSpan(new AbsoluteSizeSpan(afterSize, true), beforeText.length(), lasttext.length(), Spannable.SPAN_INCLUSIVE_EXCLUSIVE);//设置后面的字体大小
        builder.append(lasttext);
        builder.setSpan(new ForegroundColorSpan(Color.parseColor("#000000")), beforeText.length() + afterText.length(), builder.length(), Spannable.SPAN_EXCLUSIVE_INCLUSIVE); //设置后面的字体颜色
        builder.setSpan(new AbsoluteSizeSpan(afterSize, true), lasttext.length(), builder.length(), Spannable.SPAN_INCLUSIVE_EXCLUSIVE);//设置后面的字体大小
        tvFootball.setText(builder);


        SpannableStringBuilder builder2 = new SpannableStringBuilder(beforeText); //创建SpannableStringBuilder，并添加前面文案
        String afterText2 = String.valueOf(data.getData().getBk_nums()) + "场";
        builder2.setSpan(new ForegroundColorSpan(Color.parseColor("#000000")), 0, beforeText.length(), Spannable.SPAN_EXCLUSIVE_INCLUSIVE); //设置前面的字体颜色
        builder2.setSpan(new AbsoluteSizeSpan(beforeSize, true), 0, beforeText.length(), Spannable.SPAN_INCLUSIVE_EXCLUSIVE); //设置前面的字体大小
        builder2.append(afterText2); //追加后面文案
        builder2.setSpan(new ForegroundColorSpan(Color.parseColor("#ff0000")), beforeText.length(), beforeText.length() + afterText2.length(), Spannable.SPAN_EXCLUSIVE_INCLUSIVE); //设置后面的字体颜色
        builder2.setSpan(new AbsoluteSizeSpan(afterSize, true), beforeText.length(), lasttext.length(), Spannable.SPAN_INCLUSIVE_EXCLUSIVE);//设置后面的字体大小
        builder2.append(lasttext);
        builder2.setSpan(new ForegroundColorSpan(Color.parseColor("#000000")), beforeText.length() + afterText2.length(), builder.length(), Spannable.SPAN_EXCLUSIVE_INCLUSIVE); //设置后面的字体颜色
        builder2.setSpan(new AbsoluteSizeSpan(afterSize, true), lasttext.length(), builder.length(), Spannable.SPAN_INCLUSIVE_EXCLUSIVE);//设置后面的字体大小
        tvBasketball.setText(builder2);

    }


    @Override
    public void onResume() {
        super.onResume();

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
                if (footballnum!=0){
                    intent = new Intent(getActivity(), BetdetailAcivity.class);
                    intent.putExtra("ball", "FT");
                    startActivity(intent);
                }
                break;
            case R.id.ll_basketball:
                if (basketballnum!=0){
                    intent = new Intent(getActivity(), BetdetailAcivity.class);
                    intent.putExtra("ball", "BK");
                    startActivity(intent);
                }
                break;
            case R.id.ll_netball:
                break;
            case R.id.ll_volleyball:
                break;
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // TODO: inflate a fragment view
        View rootView = super.onCreateView(inflater, container, savedInstanceState);
        unbinder = ButterKnife.bind(this, rootView);
        return rootView;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
