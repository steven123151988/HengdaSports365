package com.hengda.hengdasports.utils;


import android.app.Activity;
import android.content.Intent;

import com.hengda.hengdasports.activity.login.LoginActivity;
import com.hengda.hengdasports.base.ActivityManager;
import com.hengda.hengdasports.base.SportsApplication;
import com.hengda.hengdasports.json2.getUserInfo;

public class UserHelper {

    private static final String CURRENT_USER = "current_user";
    private static getUserInfo currUser;//当前用户

    private UserHelper() {
    }

    private static class SingletonHolder {
        static UserHelper INSTANCE = new UserHelper();
    }

    public static UserHelper getInstance() {
        return SingletonHolder.INSTANCE;
    }

    /**
     * 设置当前用户
     *
     * @param user 当前用户
     */
    public void setCurrUser(getUserInfo user) {
        currUser = user;
        SharePreferencesUtil.addString(SportsApplication.getInstance(), CURRENT_USER, JsonUtil.toJson(user));
//        EventBus.getDefault().post(new UserChangedEvent(currUser));
        //webSocket
//        if (user == null) {
//            SocketHelper.get().disconnectWebSocket();
//        } else {
//            SocketHelper.get().connectWebSocket();
//        }
    }

    /**
     * @return 当前用户
     */
    public getUserInfo getCurrUser() {
        if (currUser == null) {
            String jsonStr = SharePreferencesUtil.getString(SportsApplication.getInstance(), CURRENT_USER, null);
            currUser = JsonUtil.fromJson(jsonStr, getUserInfo.class);
        }
        return currUser;
    }

    /**
     * @return 用户id
     */
    public String getUserId() {
//        getUserInfo user = getCurrUser();
//        if (user != null) {
//            return user.getId();
//        } else {
//            return null;
//        }

        return "";
    }

    /**
     * @return sessionId
     */
    public String getSessionId() {
        getUserInfo user = getCurrUser();
//        if (user != null) {
//            return user.getSessionId();
//        } else {
//            return null;
//        }
        return "";
    }

    /**
     * 退出登录
     */
    public void userSignOut() {
        setCurrUser(null);
        Activity activity = ActivityManager.getInstance().getCurrentActivity();
        Intent intent = new Intent(activity, LoginActivity.class);
        activity.startActivity(intent);
    }

}
