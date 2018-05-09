package com.hengda.hengdasports.activity.login;

import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.ImageView;


import com.hengda.hengdasports.R;
import com.hengda.hengdasports.activity.MainActivity;
import com.hengda.hengdasports.api.HttpCallback;
import com.hengda.hengdasports.api.HttpRequest;
import com.hengda.hengdasports.base.BaseActivity;
import com.hengda.hengdasports.base.SportsKey;
import com.hengda.hengdasports.json.LotteryVersion;
import com.hengda.hengdasports.utils.AppUtils;
import com.hengda.hengdasports.utils.LogUtil;
import com.hengda.hengdasports.utils.NetUtil;
import com.hengda.hengdasports.utils.SharePreferencesUtil;
import com.hengda.hengdasports.utils.ShowDialogUtil;
import com.hengda.hengdasports.utils.SystemUtil;
import com.hengda.hengdasports.view.UploadApkDialog;

import cn.pedant.SweetAlert.SweetAlertDialog;


public class SplashActivity extends BaseActivity {
    private int sdk_version = Build.VERSION.SDK_INT;  // 进入之前获取手机的SDK版本号
    private UploadApkDialog uploadApkDialog;  //升级的对话框
    private SweetAlertDialog SweetAlertDialog;
    private LotteryVersion lotteryVersion2;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_splash;
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initView(@Nullable Bundle savedInstanceState) {
        SystemUtil.setfullScreen(SplashActivity.this);
        ImageView view = (ImageView) findViewById(R.id.iv);
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.3f, 1.0f);
        alphaAnimation.setDuration(1000);
        view.startAnimation(alphaAnimation);
        alphaAnimation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
                try {
                    checkAndroidVertion();
                } catch (Exception e) {
                    getAppGrade();
                }
            }

            @Override
            public void onAnimationEnd(Animation animation) {

            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
    }


    @Override
    protected void onResume() {
        super.onResume();
        //先判断网络情况,可以的话走下去，不可以的话提示网络有问题
        if (NetUtil.checkNetworkState()) {
            checkAndroidVertion();
        } else {
            ShowDialogUtil.showFailDialog(SplashActivity.this, getString(R.string.sorry), getString(R.string.net_error));
        }
    }


    /**
     * 检查手机的版本号 最低4.0才能使用
     */
    private void checkAndroidVertion() {
        //只适配SDK大于16的手机
        if (sdk_version > 15) {
            //延迟5秒关闭
            Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    //检查是否需要升级
                    getAppGrade();
                }
            }, 1500);
        } else {
            ShowDialogUtil.showFailDialog(SplashActivity.this, getString(R.string.sorry), getString(R.string.app_support_lowest_sdk));
        }
    }


    /**
     * 检查APP是否需要升级
     */
    private void getAppGrade() {
//        HttpRequest.getInstance().appUpGrade(SplashActivity.this, new HttpCallback<LotteryVersion>() {
//            @Override
//            public void onSuccess(LotteryVersion lotteryVersion) {
//                lotteryVersion2 = lotteryVersion;
//                if (null != lotteryVersion.getForcedUpdate() &&
//                        null != lotteryVersion.getVersion() &&
//                        Float.parseFloat(lotteryVersion.getVersion()) > Float.parseFloat(AppUtils.getAppVersionName(getApplicationContext()))) {
//                    if (isFinishing()) {
//                        return;
//                    }
//                    if (lotteryVersion.getForcedUpdate().equals("yes")) {
//                        SweetAlertDialog = new SweetAlertDialog(SplashActivity.this, SweetAlertDialog.CUSTOM_IMAGE_TYPE);
//                        SweetAlertDialog.setTitleText(getString(R.string.app_update) + lotteryVersion.getVersion())
//                                .setCustomImage(R.mipmap.update)
//                                .setContentText(getString(R.string.center_text))
//                                .setConfirmText(getString(R.string.confirm_text))
//                                .setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
//                                    @Override
//                                    public void onClick(SweetAlertDialog sDialog) {
//                                        SweetAlertDialog.dismiss();
//                                        showUpdateDialog();
//                                    }
//                                })
//                                .show();
//                    } else {
//                        SweetAlertDialog = new SweetAlertDialog(SplashActivity.this, SweetAlertDialog.CUSTOM_IMAGE_TYPE);
//                        SweetAlertDialog.setTitleText(getString(R.string.app_update) + lotteryVersion.getVersion())
//                                .setCustomImage(R.mipmap.update)
//                                .setContentText(getString(R.string.center_text))
//                                .setCancelText(getString(R.string.cancle_text))
//                                .setConfirmText(getString(R.string.confirm_text))
//                                .showCancelButton(true)
//                                .setCancelClickListener(new SweetAlertDialog.OnSweetClickListener() {
//                                    @Override
//                                    public void onClick(SweetAlertDialog sDialog) {
//                                        SweetAlertDialog.dismiss();
//                                        initLogType();
//                                    }
//                                })
//                                .setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
//                                    @Override
//                                    public void onClick(SweetAlertDialog sDialog) {
//                                        SweetAlertDialog.dismiss();
//                                        showUpdateDialog();
//                                    }
//                                })
//                                .show();
//                    }
//                } else {
//                    initLogType();
//                }
//            }
//
//            @Override
//            public void onFailure(String msgCode, String errorMsg) {
//                initLogType();
//            }
//        });

        initLogType();
    }

    /**
     * 展示升级对话框
     */
    private void showUpdateDialog() {
        if (!isFinishing()) {
            if (null == uploadApkDialog) {
                uploadApkDialog = new UploadApkDialog(SplashActivity.this, lotteryVersion2.getUrl());
            }
            uploadApkDialog.show();
        }
    }


    /**
     * 查看登陆状态，若UID为空就要去登陆
     */
    private void initLogType() {
        if (SharePreferencesUtil.getString(mContext, SportsKey.UID, "0").equals("0")) {
            startActivity(new Intent(mContext, LoginActivity.class));
        } else {
            startActivity(new Intent(this, MainActivity.class));
        }
        finish();

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ShowDialogUtil.dismissDialogs();
        if (null != SweetAlertDialog) {
            SweetAlertDialog.dismiss();
        }
        if (null != uploadApkDialog) {
            uploadApkDialog.cancel();
        }

    }


}
