package com.hengda.hengdasports.api;

import android.content.Intent;
import android.support.annotation.NonNull;

import com.google.gson.JsonParseException;
import com.hengda.hengdasports.activity.login.LoginActivity;
import com.hengda.hengdasports.base.ActivityManager;
import com.hengda.hengdasports.base.SportsAPI;
import com.hengda.hengdasports.json2.BaseModel;

import org.json.JSONException;

import java.io.IOException;
import java.net.ConnectException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import java.text.ParseException;

import javax.net.ssl.SSLHandshakeException;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public abstract class HttpCallback<T extends BaseModel> implements Callback<T> {
    private String msgCode, errormsg = "error";

    @Override
    public void onResponse(@NonNull Call<T> call, @NonNull Response<T> response) {
        if (call.isCanceled()) {
            return;
        }
        if (response.isSuccessful()) {
            T model = response.body();
            if (null == model) {
                return;
            }
            /**
             *  接口getErrnum=0表示成功
             */
            if (model.getCode() == 0) {
                onSuccess(model);
            } else {
                if (model.getCode() == 9) {
                    ActivityManager.getInstance().getCurrentActivity().startActivity(new Intent(ActivityManager.getInstance().getCurrentActivity(), LoginActivity.class));
                } else {
                    onApiFailure(model);
                }


            }
        } else {
            onFailure(call, new IOException("Unexpected code " + response.code()));
        }
    }

    private void onApiFailure(T model) {
        msgCode = String.valueOf(model.getCode());
        errormsg = String.valueOf(model.getMsg());
        onFailure(msgCode, errormsg);
    }

    @Override
    public void onFailure(@NonNull Call<T> call, @NonNull Throwable t) {
        t.printStackTrace();
        if (call.isCanceled()) {
            return;
        }
        if (t instanceof JSONException || t instanceof JsonParseException || t instanceof ParseException) {
            onFailure("10011", SportsAPI.getErrorCodeInfo("10011"));
        } else if (t instanceof ConnectException) {
            onFailure("10012", SportsAPI.getErrorCodeInfo("10012"));
        } else if (t instanceof SSLHandshakeException) {
            onFailure("10013", SportsAPI.getErrorCodeInfo("10013"));
        } else if (t instanceof UnknownHostException) {
            onFailure("10014", SportsAPI.getErrorCodeInfo("10014"));
        } else if (t instanceof SocketTimeoutException) {
            onFailure("10015", SportsAPI.getErrorCodeInfo("10015"));
        } else {
            onFailure("10016", SportsAPI.getErrorCodeInfo("10016"));
        }
    }

    public abstract void onSuccess(T data);

    public abstract void onFailure(String msgCode, String errorMsg);
}
