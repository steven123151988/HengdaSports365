package com.hengda.hengdasports.api;

import com.hengda.hengdasports.json.BindphoneRsp;
import com.hengda.hengdasports.json.HotgameRsp;
import com.hengda.hengdasports.json.RegistRsp;
import com.hengda.hengdasports.json.getPicVerificationCodeRsp;
import com.hengda.hengdasports.json2.BetMenuList;
import com.hengda.hengdasports.json2.HomeindexRsp;
import com.hengda.hengdasports.json2.InsideMail;
import com.hengda.hengdasports.json2.LoginRsp;

import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Url;

public interface ApiService {
    /**
     * 登陆
     */
    @POST("/login/login")
    Call<LoginRsp> login(@Body RequestBody body);

    /**
     * 注册
     */
    @POST("/member/register/chk_reg")
    Call<RegistRsp> regist(@Body RequestBody body);

    /**
     * 检查用户名是否被注册
     */
    @POST("/member/register/chk_user")
    Call<LoginRsp> checkUser(@Body RequestBody body);

    /**
     * 登出
     */
    @POST("/login/loginout")
    Call<LoginRsp> loginOut(@Body RequestBody body);

    /**
     * 获取首页数据
     */

    @POST("/")
    Call<HomeindexRsp> homeIndex(@Body RequestBody body);

    /**
     * 获取验证码
     */
    @POST("/member/register/generate_captcha")
    Call<BindphoneRsp> getVerificationCode(@Body RequestBody body);


    /**
     * 获取图片验证码
     */
    @POST("/member/register/generate_captcha")
    Call<getPicVerificationCodeRsp> getPicVerificationCode(@Body RequestBody body);

    /**
     * 站内信
     */
    @POST("/member/mesg/inbox")
    Call<InsideMail> insideMail(@Body RequestBody body);

    /**
     * 获取盘口数据
     */
    @POST("/home/get_match")
    Call<HotgameRsp> getGamedata( @Body RequestBody body);

    /**
     * 赛首菜单的数据
     */
    @POST("/home/main_menu")
    Call<BetMenuList> getBetMenuList(@Body RequestBody body);


    /**
     * 获取注单记录
     */
    @POST("/member/member/bet_beting")
    Call<LoginRsp> bet_betting( @Body RequestBody body);

    /**
     * 获取充值提现记录
     */
    @POST("/member/member/mem_capital_flow")
    Call<LoginRsp> getMoney_in_out( @Body RequestBody body);










//
//    /**
//     * 获取热门赛事信息
//     */
//    @POST("service?action=GetHotGames&terminal_id=1")
//    Call<HotgameRsp> getHotGameDate(@Body RequestBody body);
//
//    /**
//     * 获取全部赛事信息
//     */
//    @POST("service?action=GetGameData&terminal_id=1")
//    Call<getGameDataRsp> getGameDate(@Body RequestBody body);

//    /**
//     * 赛事玩法明细
//     */
//    @POST("service?action=GetGameLottery&terminal_id=1")
//    Call<GamePlaywaysRsp> getPlayWays(@Body RequestBody body);
//
//    /**
//     * 银行列表
//     */
//    @POST("service?action=GetBankList&terminal_id=1")
//    Call<BankcardList> GetBankList(@Body RequestBody body);
//
//


//
//    /**
//     * 绑定手机号码
//     */
//
//    @POST("service?action=BindMobile&terminal_id=1&token=22441c03ade39bac8a561005edfe56be4f2d48f9")
//    Call<BindphoneRsp> bindPhone(@Body RequestBody body);
//
//    /**
//     * 修改登陆密码
//     */
//    @POST("service?action=ChangeLoginPwd&terminal_id=1")
//    Call<BindphoneRsp> changeLoginpsw(@Body RequestBody body);
//
//
//    /**
//     * 绑定银行卡
//     */
//    @POST("service?action=BindBankCard&terminal_id=1")
//    Call<BindphoneRsp> bindBankcard(@Body RequestBody body);
//
//
//    /**
//     * 获取地区
//     */
//    @POST("service?action=GetDistrict&terminal_id=1")
//    Call<AreaRsp> getDistrict(@Body RequestBody body);
//
//    /**
//     * 设置资金密码
//     */
//    @POST("service?action=SetFundPwd&terminal_id=1")
//    Call<BindphoneRsp> setMoneypsw(@Body RequestBody body);
//
//
//    /**
//     * 修改资金密码
//     */
//    @POST("service?action=ChangeFundPwd&terminal_id=1&token=22441c03ade39bac8a561005edfe56be4f2d48f9")
//    Call<BindphoneRsp> changeMoneypsw(@Body RequestBody body);
//
//    /**
//     * 选择充值平台
//     */
//    @POST("/service?action=GetAvailablePaymentType&terminal_id=1")
//    Call<getPayPlatformRsp> getPayPlatform(@Body RequestBody body);
//
//    /**
//     * 获取该平台下的充值渠道
//     */
//
//    @POST("service?action=GetAvailablePaymentType&terminal_id=1")
//    Call<PaywaysRsp> getPayways(@Body RequestBody body);
//
//    /**
//     * 充值接口
//     */
//    @POST("service?action= DoPay&terminal_id=1")
//    Call<Pay> getPayincome(@Body RequestBody body);
//
//    /**
//     * 获取已经绑定的银行卡
//     */
//    @POST("service?action=GetBankCardList&terminal_id=1")
//    Call<BankcardRsp> getBindBanklist(@Body RequestBody body);
//
//    /**
//     * 提现
//     */
//    @POST("service?action=Withdraw&terminal_id=1")
//    Call<BankcardRsp> takeOutMoney(@Body RequestBody body);
//
//
//    /**
//     *获得资金明细列表
//     */
//    @POST("service?action=GetTransactionList&terminal_id=1")
//    Call<BankcardRsp> getMoneyRecord(@Body RequestBody body);
//
//    /**
//     *  充值记录
//     */
//    @POST("service?action=GetDepositList&terminal_id=1")
//    Call<PayrecordRsp> payRecord(@Body RequestBody body);
//
//    /**
//     * 已开奖未开奖
//     */
//
//    @POST("service?action=bill&terminal_id=1")
//    Call<WeijiemingxiRsp> getBetResult(@Body RequestBody body);
//
//    /**
//     *  获取赛事公告
//     */
//
//    @POST("service?action=GetNoticeList&terminal_id=1")
//    Call<GameNoticeRsp> getGameNotice(@Body RequestBody body);
//
//    /**
//     * 获取公告详情
//     */
//    @POST("service?action=GetNoticeDetail&terminal_id=1")
//    Call<GameNoticeDetailRsp> getGameNoticeDetail(@Body RequestBody body);
//
//    /**
//     * 投注接口
//     */
//    @POST("service?action=UserProgram&terminal_id=1")
//    Call<GameNoticeDetailRsp> bet(@Body RequestBody body);
//
//    /**
//     * 获得注数
//     */
//    @POST("service?action=CheckBet&terminal_id=1")
//    Call<GameNoticeDetailRsp> getBetNum(@Body RequestBody body);
//
//
//    /**
//     *  串关
//     * @return
//     */
//    @POST("/service?action=WayOadds&terminal_id=1")
//    Call<GameNoticeDetailRsp> chuanguan(@Body RequestBody body);
//
//
//
//

//
//    /**
//     * 升级APP
//     */
//    @POST(SportsAPI.GET_VERSION_ANDROID)
//    Call<LotteryVersion> appUpGrade(@Body RequestBody body);
//
//    /**
//     * 获取左侧menu信息
//     */
//    @POST(SportsAPI.HOME_MENU)
//    Call<LoginRsp> getMainMenu(@Body RequestBody body);
//
//    /**
//     * 获取球类信息列表
//     */
//    @POST(SportsAPI.MATCH_LIST)
//    Call<BallGQRsp> getBallMsg(@Body RequestBody body);
//
//
//    /**
//     * 获取球类信息列表
//     */
//    @POST(SportsAPI.BET_HIS)
//    Call<AccountHistoryRsp> getBetHistory(@Body RequestBody body);
//
//    /**
//     * 赛事详情
//     */
//    @POST(SportsAPI.GET_MATCH)
//    Call<BettingDetailRsp> getMatch(@Body RequestBody body);
//
//    /**
//     * 修改账户密码
//     */
//    @POST(SportsAPI.CHANGE_PWD)
//    Call<LoginRsp> changePsw(@Body RequestBody body);
//
//
//    /**
//     * 赛事详情
//     */
//
//    @POST(SportsAPI.BET_BETTING)
//    Call<BettingRecordRsp> betBetting(@Body RequestBody body);
//
//    /**
//     * 在线提款
//     */
//    @POST(SportsAPI.MEM_ONLINE)
//    Call<MemOnlineRsp> memOnline(@Body RequestBody body);
//


}