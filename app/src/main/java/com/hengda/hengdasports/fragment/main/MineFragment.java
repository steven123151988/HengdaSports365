package com.hengda.hengdasports.fragment.main;

import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.hengda.hengdasports.R;
import com.hengda.hengdasports.base.BaseFragment;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * Description:
 * Data：2018/4/25-15:26
 * steven
 */
public class MineFragment extends BaseFragment {

    @BindView(R.id.iv_person)
    ImageView ivPerson;
    @BindView(R.id.tv_name)
    TextView tvName;
    @BindView(R.id.tv_set)
    ImageView tvSet;
    @BindView(R.id.tv_balance)
    TextView tvBalance;
    @BindView(R.id.iv_refresh)
    ImageView ivRefresh;
    @BindView(R.id.iv_tixian)
    ImageView ivTixian;
    @BindView(R.id.iv_chongzhi)
    ImageView ivChongzhi;
    @BindView(R.id.ll_zhudanjilu)
    LinearLayout llZhudanjilu;
    @BindView(R.id.ll_zhanghumingxi)
    LinearLayout llZhanghumingxi;
    @BindView(R.id.ll_chongzhijilu)
    LinearLayout llChongzhijilu;
    @BindView(R.id.ll_tixianjilu)
    LinearLayout llTixianjilu;
    @BindView(R.id.ll_wanfaguize)
    LinearLayout llWanfaguize;
    @BindView(R.id.ll_xiangxisheding)
    LinearLayout llXiangxisheding;
    @BindView(R.id.ll_guizetiaokuan)
    LinearLayout llGuizetiaokuan;
    @BindView(R.id.ll_service)
    LinearLayout llService;
    @BindView(R.id.ll_jiarudaili)
    LinearLayout llJiarudaili;
    @BindView(R.id.ll_zhanneixin)
    LinearLayout llZhanneixin;
    @BindView(R.id.ll_anquanzhongxin)
    LinearLayout llAnquanzhongxin;
    @BindView(R.id.ll_xinxigonggao)
    LinearLayout llXinxigonggao;
    Unbinder unbinder;

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_mine;
    }
    @Override
    protected void initView() {

    }


    @Override
    protected void initData() {

    }

    @OnClick({R.id.tv_set, R.id.iv_refresh, R.id.ll_zhudanjilu, R.id.ll_zhanghumingxi, R.id.ll_chongzhijilu, R.id.ll_tixianjilu, R.id.ll_wanfaguize, R.id.ll_xiangxisheding, R.id.ll_guizetiaokuan, R.id.ll_service, R.id.ll_jiarudaili, R.id.ll_zhanneixin, R.id.ll_anquanzhongxin, R.id.ll_xinxigonggao})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tv_set:
                break;
            case R.id.iv_refresh:
                Animation operatingAnim = AnimationUtils.loadAnimation(getActivity(), R.anim.version_image_rotate);
                LinearInterpolator lin = new LinearInterpolator();
                operatingAnim.setInterpolator(lin);
                if (operatingAnim != null) {
                    ivRefresh.startAnimation(operatingAnim);
                }
                Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        stopRotate();
                    }
                }, 1000);
                break;
            case R.id.ll_zhudanjilu:
                break;
            case R.id.ll_zhanghumingxi:
                break;
            case R.id.ll_chongzhijilu:
                break;
            case R.id.ll_tixianjilu:
                break;
            case R.id.ll_wanfaguize:
                break;
            case R.id.ll_xiangxisheding:
                break;
            case R.id.ll_guizetiaokuan:
                break;
            case R.id.ll_service:
                break;
            case R.id.ll_jiarudaili:
                break;
            case R.id.ll_zhanneixin:
                break;
            case R.id.ll_anquanzhongxin:
                break;
            case R.id.ll_xinxigonggao:
                break;
        }
    }


    /**
     * 关闭动画
     */
    public void stopRotate() {
        ivRefresh.clearAnimation();
    }


}
