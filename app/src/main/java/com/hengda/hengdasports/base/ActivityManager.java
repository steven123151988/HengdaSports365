package com.hengda.hengdasports.base;

import android.app.Activity;

import com.hengda.hengdasports.utils.SharePreferencesUtil;

import java.lang.ref.WeakReference;

/**
 * Created by Steven on 2016/12/26.
 */
public class ActivityManager {
    private static ActivityManager instance = new ActivityManager();
    private WeakReference<Activity> mCurrentActivityWeakRef;

    private ActivityManager() {
    }

    public static ActivityManager getInstance() {
        return instance;
    }

    public Activity getCurrentActivity() {
        Activity currentActivity = null;
        if (mCurrentActivityWeakRef != null) {
            currentActivity = mCurrentActivityWeakRef.get();
        }
        return currentActivity;
    }

    public void setCurrentActivity(Activity activity) {
        mCurrentActivityWeakRef = new WeakReference<Activity>(activity);
    }


}
