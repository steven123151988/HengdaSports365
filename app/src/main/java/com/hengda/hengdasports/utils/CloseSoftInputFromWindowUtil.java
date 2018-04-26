package com.hengda.hengdasports.utils;

import android.content.Context;
import android.view.View;
import android.view.inputmethod.InputMethodManager;

/**
 * 关闭弹起的键盘
 */

public class CloseSoftInputFromWindowUtil {

    public static void closeSoftInputFromWindow() {

        View view = ActivityManager.getInstance().getCurrentActivity().getWindow().peekDecorView();
        if (null != view) {
            InputMethodManager inputmanger = (InputMethodManager) ActivityManager.getInstance().getCurrentActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
            inputmanger.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }

    }
}


