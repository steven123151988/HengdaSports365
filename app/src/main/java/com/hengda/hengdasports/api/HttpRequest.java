package com.hengda.hengdasports.api;

import android.content.Context;
import android.support.v4.util.ArrayMap;


import com.hengda.hengdasports.base.ActivityManager;
import com.hengda.hengdasports.base.BaseActivity;
import com.hengda.hengdasports.base.SportsAPI;
import com.hengda.hengdasports.base.SportsApplication;
import com.hengda.hengdasports.base.SportsKey;
import com.hengda.hengdasports.json.HotgameRsp;
import com.hengda.hengdasports.json.RegistRsp;
import com.hengda.hengdasports.json.getPicVerificationCodeRsp;
import com.hengda.hengdasports.json2.BetMenuList;
import com.hengda.hengdasports.json2.getUserInfo;
import com.hengda.hengdasports.json2.HomeindexRsp;
import com.hengda.hengdasports.json2.InsideMail;
import com.hengda.hengdasports.json2.LoginRsp;
import com.hengda.hengdasports.utils.JsonUtil;
import com.hengda.hengdasports.utils.SharePreferencesUtil;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import okhttp3.MediaType;
import okhttp3.RequestBody;
import retrofit2.Call;


/**
 * 描述：网络请求类，将网络请求的方法放到此处统一管理  单例
 * 每个请求方法都传了tag标签,Activity和Fragment中请传this,方便生命周期管理.
 */

public class HttpRequest {

    private ApiService mService = ApiClient.getInstance().mApiService;
    private static ArrayMap<Object, List<Call>> mCallMap = new ArrayMap<>();

    private HttpRequest() {
    }

    private static class SingletonHolder {
        private static HttpRequest instance = new HttpRequest();
    }

    public static HttpRequest getInstance() {
        return SingletonHolder.instance;
    }

    private synchronized void putCall(Object tag, Call call) {
        if (tag == null) {
            return;
        }
        List<Call> callList = mCallMap.get(tag);
        if (callList == null) {
            callList = Collections.synchronizedList(new ArrayList<Call>());
        }
        callList.add(call);
        mCallMap.put(tag, callList);
    }

    public synchronized void cancelRequest(Object tag) {
        if (tag == null) {
            return;
        }
        List<Call> callList = mCallMap.get(tag);
        if (callList == null || callList.size() == 0) {
            return;
        }
        for (Call call : callList) {
            if (!call.isCanceled()) {
                call.cancel();
            }
        }
        mCallMap.remove(tag);
    }

    private class RequestBodyBuilder {

        Map<String, Object> params;

        private RequestBodyBuilder() {
            params = new HashMap<>();
        }

        private RequestBodyBuilder addParam(String key, Object value) {
            params.put(key, value);
            return this;
        }

        private RequestBody build() {
            return RequestBody.create(MediaType.parse("application/json; charset=utf-8"), JsonUtil.toJson(params));
        }
    }


    public String getToken(Context context) {
        return SharePreferencesUtil.getString(context, SportsKey.TOKEN, "");

    }


    /**
     * 登陆
     *
     * @param tag
     * @param callback
     */
    public void login(Object tag, String account, String psw, HttpCallback<getUserInfo> callback) {
        RequestBody body = new RequestBodyBuilder()
                .addParam("username", account)
                .addParam("password", psw)
                .build();
        Call<getUserInfo> call = mService.login(body);
        putCall(tag, call);
        call.enqueue(callback);
    }

    /**
     * 登出
     *
     * @param tag
     * @param callback
     */
    public void loginOut(Object tag,  HttpCallback<LoginRsp> callback) {
        RequestBody body = new RequestBodyBuilder()
                .addParam("uid",SportsApplication.getUid())
                .build();
        Call<LoginRsp> call = mService.loginOut(body);
        putCall(tag, call);
        call.enqueue(callback);
    }


    /**
     * 检查用户名是否已经被占用
     *
     * @param tag
     * @param callback
     */
    public void checkUser(Object tag, String account, HttpCallback<LoginRsp> callback) {
        RequestBody body = new RequestBodyBuilder()
                .addParam("username", account)
                .build();
        Call<LoginRsp> call = mService.checkUser(body);
        putCall(tag, call);
        call.enqueue(callback);
    }


    /**
     * 注册
     *
     * @param tag
     * @param account
     * @param psw
     * @param recaptcha
     * @param invitation_code
     * @param callback
     */
    public void regist(Object tag, String account, String psw, String recaptcha, String invitation_code, HttpCallback<RegistRsp> callback) {
        RequestBody body = new RequestBodyBuilder()
                .addParam("username", account)
                .addParam("password", psw)
                .addParam("recaptcha", recaptcha)//验证吗
                .addParam("invitation_code", invitation_code)// 邀请码
                .build();
        Call<RegistRsp> call = mService.regist(body);
        putCall(tag, call);
        call.enqueue(callback);
    }


    /**
     * 首页基本数据
     *
     * @param tag
     * @param callback
     */
    public void homeIndex(Object tag, HttpCallback<HomeindexRsp> callback) {
        RequestBody body = new RequestBodyBuilder()
                .build();
        Call<HomeindexRsp> call = mService.homeIndex(body);
        putCall(tag, call);
        call.enqueue(callback);
    }

    /**
     * 获取图片验证码
     *
     * @param tag
     * @param callback
     */
    public void getPicVerificationCode(Object tag, HttpCallback<getPicVerificationCodeRsp> callback) {
        RequestBody body = new RequestBodyBuilder()
                .build();
        Call<getPicVerificationCodeRsp> call = mService.getPicVerificationCode(body);
        putCall(tag, call);
        call.enqueue(callback);
    }


    /**
     * 获取站内信
     *
     * @param tag
     * @param callback
     */
    public void insideMail(Object tag, int page, HttpCallback<InsideMail> callback) {
        RequestBody body = new RequestBodyBuilder()
                .addParam("page", page)
                .addParam("uid", SportsApplication.getUid())
                .build();
        Call<InsideMail> call = mService.insideMail(body);
        putCall(tag, call);
        call.enqueue(callback);
    }


    /**
     * 获取游戏数据
     */
    public void getGameData(Object tag, String ball, String type, String game, HttpCallback<HotgameRsp> callback) {
        RequestBody body = new RequestBodyBuilder()
                .addParam("ball", ball)
                .addParam("type", type)
                .addParam("game", game)
                .addParam("uid", SportsApplication.getUid())
                .build();
        Call<HotgameRsp> call = mService.getGamedata( body);
        putCall(tag, call);
        call.enqueue(callback);
    }


    /**
     * 获取球类玩法菜单数据
     *
     * @param tag
     * @param ball
     * @param callback
     */
    public void getBetMenuList(Object tag, String ball, HttpCallback<BetMenuList> callback) {
        RequestBody body = new RequestBodyBuilder()
                .addParam("ball", ball)
                .addParam("uid", SportsApplication.getUid())
                .build();
        Call<BetMenuList> call = mService.getBetMenuList(body);
        putCall(tag, call);
        call.enqueue(callback);
    }

    /**
     * 体育注单接口
     *
     * @param tag
     * @param page
     * @param callback
     */
    public void bet_betting(Object tag, int page, HttpCallback<LoginRsp> callback) {
        RequestBody body = new RequestBodyBuilder()
                .addParam("page", page)
                .addParam("uid", SportsApplication.getUid())
                .build();
        Call<LoginRsp> call = mService.bet_betting(body);
        putCall(tag, call);
        call.enqueue(callback);
    }

    /**
     * 充值和取款接口
     *
     * @param tag
     * @param cpage
     * @param type
     * @param callback
     */
    public void payin_takeout(Object tag, int cpage, String type, HttpCallback<LoginRsp> callback) {
        RequestBody body = new RequestBodyBuilder()
                .addParam("cpage", cpage)
                .addParam("uid", SportsApplication.getUid())
                .addParam("type", type)
                .build();
        Call<LoginRsp> call = mService.getMoney_in_out(body);
        putCall(tag, call);
        call.enqueue(callback);
    }


//
//    /**
//     * 获取首页热门赛事信息
//     *
//     * @param tag
//     * @param callback
//     */
//    public void getHotGameData(Object tag, HttpCallback<HotgameRsp> callback) {
//        RequestBody body = new RequestBodyBuilder()
//                .build();
//        Call<HotgameRsp> call = mService.getHotGameDate(body);
//        putCall(tag, call);
//        call.enqueue(callback);
//    }
//
//
//    /**
//     * 获取首页全部赛事信息
//     *
//     * @param tag
//     * @param callback
//     */
//    public void getGameData(Object tag, HttpCallback<getGameDataRsp> callback) {
//        RequestBody body = new RequestBodyBuilder()
//                .build();
//        Call<getGameDataRsp> call = mService.getGameDate(body);
//        putCall(tag, call);
//        call.enqueue(callback);
//    }
//
//    /**
//     * 赛事玩法明细
//     *
//     * @param tag
//     * @param callback
//     */
//    public void getPlayWays(Object tag, String lid, HttpCallback<GamePlaywaysRsp> callback) {
//        RequestBody body = new RequestBodyBuilder()
//                .addParam(SportsKey.LID, lid)
//                .build();
//        Call<GamePlaywaysRsp> call = mService.getPlayWays(body);
//        putCall(tag, call);
//        call.enqueue(callback);
//    }
//
//    /**
//     * 获取银行卡列表
//     *
//     * @param tag
//     * @param token
//     * @param callback
//     */
//    public void getBankList(Object tag, String token, HttpCallback<BankcardList> callback) {
//        RequestBody body = new RequestBodyBuilder()
//                .addParam(SportsKey.TOKEN, token)
//                .build();
//        Call<BankcardList> call = mService.GetBankList(body);
//        putCall(tag, call);
//        call.enqueue(callback);
//    }
//
//
//    /**
//     * 获取验证码
//     *
//     * @param tag
//     * @param token
//     * @param callback 0注册 1修改密码 2绑定手机 3绑定银行卡 4换银行卡 5更改资金密码
//     */
//    public void getVerificationCode(Object tag, String token, String mobile, String type, HttpCallback<BindphoneRsp> callback) {
//        RequestBody body = new RequestBodyBuilder()
//                .addParam(SportsKey.TOKEN, token)
//                .addParam(SportsKey.MOBILE, mobile)
//                .addParam(SportsKey.TYPE, type)
//                .build();
//        Call<BindphoneRsp> call = mService.getVerificationCode(body);
//        putCall(tag, call);
//        call.enqueue(callback);
//    }
//
//

//
//    /**
//     * 绑定手机号
//     *
//     * @param tag
//     * @param token
//     * @param mobile
//     * @param captcha
//     * @param callback
//     */
//    public void bindPhone(Object tag, String token, String mobile, String captcha, HttpCallback<BindphoneRsp> callback) {
//        RequestBody body = new RequestBodyBuilder()
//                .addParam(SportsKey.TOKEN, token)
//                .addParam(SportsKey.MOBILE, mobile)
//                .addParam(SportsKey.CAPTCHA, captcha)
//                .build();
//        Call<BindphoneRsp> call = mService.bindPhone(body);
//        putCall(tag, call);
//        call.enqueue(callback);
//    }
//
//
//    /**
//     * 修改登陆密码
//     *
//     * @param tag
//     * @param token
//     * @param current_password
//     * @param new_password
//     * @param callback
//     */
//    public void changeLoginPsw(Object tag, String token, String current_password, String new_password, HttpCallback<BindphoneRsp> callback) {
//        RequestBody body = new RequestBodyBuilder()
//                .addParam(SportsKey.TOKEN, token)
//                .addParam(SportsKey.CURRENT_PASSWORD, current_password)
//                .addParam(SportsKey.NEW_PASSWORD, new_password)
//                .build();
//        Call<BindphoneRsp> call = mService.changeLoginpsw(body);
//        putCall(tag, call);
//        call.enqueue(callback);
//    }
//
//
//    /**
//     * 充值接口
//     *
//     * @param tag
//     * @param token
//     * @param identifier
//     * @param amount
//     * @param mark
//     * @param callback
//     */
//    public void getPayincome(Object tag, String token, String identifier, String amount, String mark, HttpCallback<Pay> callback) {
//        RequestBody body = new RequestBodyBuilder()
//                .addParam(SportsKey.TOKEN, token)
//                .addParam("identifier", identifier)
//                .addParam("amount", amount)
//                .addParam("mark", mark)
//                .build();
//        Call<Pay> call = mService.getPayincome(body);
//        putCall(tag, call);
//        call.enqueue(callback);
//    }
//
//    /**
//     * 获取绑定的银行卡
//     *
//     * @param tag
//     * @param token
//     * @param callback
//     */
//    public void getBindBankcard(Object tag, String token, HttpCallback<BankcardRsp> callback) {
//        RequestBody body = new RequestBodyBuilder()
//                .addParam(SportsKey.TOKEN, token)
//                .build();
//        Call<BankcardRsp> call = mService.getBindBanklist(body);
//        putCall(tag, call);
//        call.enqueue(callback);
//    }
//
//    /**
//     * 绑定银行卡
//     *
//     * @param tag
//     * @param token
//     * @param bank_id
//     * @param account_name
//     * @param account
//     * @param province_id
//     * @param city_id
//     * @param branch
//     * @param callback
//     */
//    public void bindBankCard(Object tag, String token, String bank_id, String account_name, String account
//            , String province_id, String city_id, String branch,
//                             HttpCallback<BindphoneRsp> callback) {
//        RequestBody body = new RequestBodyBuilder()
//                .addParam(SportsKey.TOKEN, token)
//                .addParam("bank_id", bank_id)
//                .addParam("account_name", account_name)
//                .addParam("account", account)
//                .addParam("province_id", province_id)
//                .addParam("city_id", city_id)
//                .addParam("branch", branch)
//                .build();
//        Call<BindphoneRsp> call = mService.bindBankcard(body);
//        putCall(tag, call);
//        call.enqueue(callback);
//    }
//
//    /**
//     * 获取地区
//     *
//     * @param tag
//     * @param token
//     * @param province_id
//     * @param callback
//     */
//    public void getDistrict(Object tag, String token, String province_id, HttpCallback<AreaRsp> callback) {
//        RequestBody body = new RequestBodyBuilder()
//                .addParam(SportsKey.TOKEN, token)
//                .addParam("province_id", province_id)
//                .build();
//        Call<AreaRsp> call = mService.getDistrict(body);
//        putCall(tag, call);
//        call.enqueue(callback);
//    }
//
//
//    /**
//     * 设置资金密码
//     *
//     * @param tag
//     * @param token
//     * @param fund_pwd
//     * @param callback
//     */
//    public void setMoneyPsw(Object tag, String token, String fund_pwd, HttpCallback<BindphoneRsp> callback) {
//        RequestBody body = new RequestBodyBuilder()
//                .addParam(SportsKey.TOKEN, token)
//                .addParam("fund_pwd", fund_pwd)
//                .build();
//        Call<BindphoneRsp> call = mService.setMoneypsw(body);
//        putCall(tag, call);
//        call.enqueue(callback);
//    }
//
//    /**
//     * 修改资金密码
//     *
//     * @param tag
//     * @param token
//     * @param captcha
//     * @param new_password
//     * @param callback
//     */
//    public void changeMoneyPsw(Object tag, String token, String captcha, String new_password, HttpCallback<BindphoneRsp> callback) {
//        RequestBody body = new RequestBodyBuilder()
//                .addParam(SportsKey.TOKEN, token)
//                .addParam("captcha", captcha)
//                .addParam("new_password", new_password)
//                .build();
//        Call<BindphoneRsp> call = mService.changeMoneypsw(body);
//        putCall(tag, call);
//        call.enqueue(callback);
//    }
//
//
//    /**
//     * 获取充值渠道
//     *
//     * @param tag
//     * @param token
//     * @param callback
//     */
//    public void getPayPlatform(Object tag, String token, HttpCallback<getPayPlatformRsp> callback) {
//        RequestBody body = new RequestBodyBuilder()
//                .addParam(SportsKey.TOKEN, token)
//                .addParam("type", "1")
//                .build();
//        Call<getPayPlatformRsp> call = mService.getPayPlatform(body);
//        putCall(tag, call);
//        call.enqueue(callback);
//    }
//
//
//    /**
//     * 获取充值平台下的充值方式
//     *
//     * @param tag
//     * @param token
//     * @param identifier
//     * @param callback
//     */
//    public void getPayways(Object tag, String token, String identifier, HttpCallback<PaywaysRsp> callback) {
//        RequestBody body = new RequestBodyBuilder()
//                .addParam(SportsKey.TOKEN, token)
//                .addParam("identifier", identifier)
//                .addParam("type", "2")
//                .build();
//        Call<PaywaysRsp> call = mService.getPayways(body);
//        putCall(tag, call);
//        call.enqueue(callback);
//    }
//
//    /**
//     * 提现
//     *
//     * @param tag
//     * @param token
//     * @param bankcard_id
//     * @param amount
//     * @param fund_password
//     * @param callback
//     */
//    public void takeOutMoney(Object tag, String token, String bankcard_id, String amount, String fund_password, HttpCallback<BankcardRsp> callback) {
//        RequestBody body = new RequestBodyBuilder()
//                .addParam(SportsKey.TOKEN, token)
//                .addParam("bankcard_id", bankcard_id)
//                .addParam("amount", amount)
//                .addParam("fund_password", fund_password)
//                .build();
//        Call<BankcardRsp> call = mService.takeOutMoney(body);
//        putCall(tag, call);
//        call.enqueue(callback);
//    }
//
//
//    /**
//     * 充值记录
//     *
//     * @param tag
//     * @param token
//     * @param begin_time
//     * @param end_time
//     * @param page
//     * @param pagesize
//     * @param callback
//     */
//    public void payRecord(Object tag, String token, String begin_time, String end_time, String page, String pagesize, HttpCallback<PayrecordRsp> callback) {
//        RequestBody body = new RequestBodyBuilder()
//                .addParam(SportsKey.TOKEN, token)
//                .addParam("begin_time", begin_time)
//                .addParam("end_time", end_time)
//                .addParam("page", page)
//                .addParam("pagesize", pagesize)
//                .build();
//        Call<PayrecordRsp> call = mService.payRecord(body);
//        putCall(tag, call);
//        call.enqueue(callback);
//    }
//
//
//    public void getMoneyRecord(Object tag, String token, String bankcard_id, String amount, String fund_password, HttpCallback<BankcardRsp> callback) {
//        RequestBody body = new RequestBodyBuilder()
//                .addParam(SportsKey.TOKEN, token)
//                .addParam("bankcard_id", bankcard_id)
//                .addParam("amount", amount)
//                .addParam("fund_password", fund_password)
//                .build();
//        Call<BankcardRsp> call = mService.takeOutMoney(body);
//        putCall(tag, call);
//        call.enqueue(callback);
//    }
//
//    /**
//     * 获取已开奖和未开奖
//     *
//     * @param tag
//     * @param token
//     * @param status
//     * @param page
//     * @param pagesize
//     * @param callback
//     */
//    public void getBetResults(Object tag, String token, String status, String page, String pagesize, HttpCallback<WeijiemingxiRsp> callback) {
//        RequestBody body = new RequestBodyBuilder()
//                .addParam(SportsKey.TOKEN, token)
//                .addParam("status", status)
//                .addParam("page", page)
//                .addParam("pagesize", pagesize)
//                .build();
//        Call<WeijiemingxiRsp> call = mService.getBetResult(body);
//        putCall(tag, call);
//        call.enqueue(callback);
//    }
//
//    /**
//     * 获取赛事公告
//     *
//     * @param tag
//     * @param token
//     * @param callback
//     */
//    public void getGameNotice(Object tag, String token, HttpCallback<GameNoticeRsp> callback) {
//        RequestBody body = new RequestBodyBuilder()
//                .addParam(SportsKey.TOKEN, token)
//                .build();
//        Call<GameNoticeRsp> call = mService.getGameNotice(body);
//        putCall(tag, call);
//        call.enqueue(callback);
//    }
//
//
//    /**
//     * 获取赛事详情
//     *
//     * @param tag
//     * @param token
//     * @param callback
//     */
//    public void getGameNoticeDetail(Object tag, String token, String lid, HttpCallback<GameNoticeDetailRsp> callback) {
//        RequestBody body = new RequestBodyBuilder()
//                .addParam(SportsKey.TOKEN, token)
//                .addParam("lid", lid)
//                .build();
//        Call<GameNoticeDetailRsp> call = mService.getGameNoticeDetail(body);
//        putCall(tag, call);
//        call.enqueue(callback);
//    }
//
//
//    /**
//     * 投注接口
//     *
//     * @param tag
//     * @param token
//     * @param amount
//     * @param gate
//     * @param multiple
//     * @param bet_num
//     * @param max_gate
//     * @param games
//     * @param callback
//     */
//    public void bet(Object tag, String token, String amount, String gate, String multiple, String bet_num, String max_gate, String games, HttpCallback<GameNoticeDetailRsp> callback) {
//        RequestBody body = new RequestBodyBuilder()
//                .addParam(SportsKey.TOKEN, token)
//                .addParam("amount", amount)
//                .addParam("gate", gate)
//                .addParam("multiple", multiple)
//                .addParam("bet_num", bet_num)
//                .addParam("max_gate", max_gate)
//                .addParam("games", games)
//                .build();
//        Call<GameNoticeDetailRsp> call = mService.bet(body);
//        putCall(tag, call);
//        call.enqueue(callback);
//    }
//
//    /**
//     * 获得下注注数
//     *
//     * @param tag
//     * @param token
//     * @param gate
//     * @param game
//     * @param callback
//     */
//    public void getBetNum(Object tag, String token, String gate, String game, HttpCallback<GameNoticeDetailRsp> callback) {
//        RequestBody body = new RequestBodyBuilder()
//                .addParam(SportsKey.TOKEN, token)
//                .addParam("game", game)
//                .addParam("gate", gate)
//                .build();
//        Call<GameNoticeDetailRsp> call = mService.getBetNum(body);
//        putCall(tag, call);
//        call.enqueue(callback);
//    }
//
//    /**
//     * 串关
//     *
//     * @param tag
//     * @param token
//     * @param callback
//     */
//    public void chuanguan(Object tag, String token, HttpCallback<GameNoticeDetailRsp> callback) {
//        RequestBody body = new RequestBodyBuilder()
//                .addParam(SportsKey.TOKEN, token)
//                .build();
//        Call<GameNoticeDetailRsp> call = mService.getBetNum(body);
//        putCall(tag, call);
//        call.enqueue(callback);
//    }
//
//
//
//
//


//
//    /**
//     * app版本升级
//     *
//     * @param tag
//     * @param callback
//     */
//    public void appUpGrade(Object tag, HttpCallback<LotteryVersion> callback) {
//        RequestBody body = new RequestBodyBuilder()
//                .build();
//        Call<LotteryVersion> call = mService.appUpGrade(body);
//        putCall(tag, call);
//        call.enqueue(callback);
//    }
//
//
//    /**
//     * 获取左侧菜单的menu数据
//     *
//     * @param tag
//     * @param uid
//     * @param callback
//     */
//    public void getHomeMenu(Object tag, String uid, HttpCallback<LoginRsp> callback) {
//        RequestBody body = new RequestBodyBuilder()
//                .addParam(SportsKey.FNNAME, "menu")
//                .addParam(SportsKey.UID, uid)
//                .build();
//        Call<LoginRsp> call = mService.getMainMenu(body);
//        putCall(tag, call);
//        call.enqueue(callback);
//    }
//
//    /**
//     * 获取球类信息列表
//     *
//     * @param tag
//     * @param uid
//     * @param ball
//     * @param type
//     * @param callback
//     */
//    public void getBallMsg(Object tag, String uid, String ball, String type, HttpCallback<BallGQRsp> callback) {
//        RequestBody body = new RequestBodyBuilder()
//                .addParam(SportsKey.FNNAME, "mlist")
//                .addParam(SportsKey.UID, uid)
//                .addParam(SportsKey.BALL, ball)
//                .addParam(SportsKey.TYPE, type)
//                .build();
//        Call<BallGQRsp> call = mService.getBallMsg(body);
//        putCall(tag, call);
//        call.enqueue(callback);
//    }
//
//
//    /**
//     * 获取账户历史
//     *
//     * @param tag
//     * @param uid
//     * @param callback
//     */
//    public void getBetHistory(Object tag, String uid, HttpCallback<AccountHistoryRsp> callback) {
//        RequestBody body = new RequestBodyBuilder()
//                .addParam(SportsKey.FNNAME, "bet_his")
//                .addParam(SportsKey.UID, uid)
//                .build();
//        Call<AccountHistoryRsp> call = mService.getBetHistory(body);
//        putCall(tag, call);
//        call.enqueue(callback);
//    }
//
//    /**
//     * 获取赛事详情
//     *
//     * @param tag
//     * @param uid
//     * @param mid
//     * @param callback
//     */
//    public void getMatch(Object tag, String uid, String mid, HttpCallback<BettingDetailRsp> callback) {
//        RequestBody body = new RequestBodyBuilder()
//                .addParam(SportsKey.FNNAME, "selmatch")
//                .addParam(SportsKey.UID, uid)
//                .addParam(SportsKey.MID, mid)
//                .build();
//        Call<BettingDetailRsp> call = mService.getMatch(body);
//        putCall(tag, call);
//        call.enqueue(callback);
//    }
//
//    /**
//     * 修改密码
//     *
//     * @param tag
//     * @param psw1
//     * @param newPSW
//     * @param type
//     * @param callback
//     */
//    public void changePsw(Object tag, String uid, String psw1, String newPSW, String type, HttpCallback<LoginRsp> callback) {
//        RequestBody body = new RequestBodyBuilder()
//                .addParam(SportsKey.UID, uid)
//                .addParam(SportsKey.FNNAME, "chg_pwd")
//                .addParam(SportsKey.OLD_PWD, psw1)
//                .addParam(SportsKey.BEW_PWD, newPSW)
//                .addParam(SportsKey.TYPE, type)
//                .build();
//        Call<LoginRsp> call = mService.changePsw(body);
//        putCall(tag, call);
//        call.enqueue(callback);
//    }
//
//    /**
//     * 获取赛事详情
//     *
//     * @param tag
//     * @param uid
//     * @param ball
//     * @param page
//     * @param callback
//     */
//    public void betBetting(Object tag, String uid, String ball, int page, HttpCallback<BettingRecordRsp> callback) {
//        RequestBody body = new RequestBodyBuilder()
//                .addParam(SportsKey.UID, uid)
//                .addParam(SportsKey.FNNAME, "betlist")
//                .addParam(SportsKey.BALL, ball)
//                .addParam(SportsKey.PAGE, page)
//                .build();
//        Call<BettingRecordRsp> call = mService.betBetting(body);
//        putCall(tag, call);
//        call.enqueue(callback);
//    }
//
//    /**
//     * 在线提款
//     *
//     * @param tag
//     * @param uid
//     * @param callback
//     */
//    public void memOnline(Object tag, String uid, HttpCallback<MemOnlineRsp> callback) {
//        RequestBody body = new RequestBodyBuilder()
//                .addParam(SportsKey.UID, uid)
//                .addParam(SportsKey.FNNAME, "withdrawals")
//                .build();
//        Call<MemOnlineRsp> call = mService.memOnline(body);
//        putCall(tag, call);
//        call.enqueue(callback);
//    }
//


}
