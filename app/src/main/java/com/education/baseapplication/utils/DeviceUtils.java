package com.education.baseapplication.utils;

import android.app.Activity;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.provider.Settings;
import android.telephony.TelephonyManager;

/**
 * Created by zhonghang on 16/8/1.
 */

public class DeviceUtils {
    public static String getDeviceId(Context context) {
        String android_id = Settings.Secure.getString(context.getContentResolver(),
                Settings.Secure.ANDROID_ID);
        return android_id;
    }

    /**
     * 判断是否网络连接
     */
    public static boolean isOnline(Context context) {
        ConnectivityManager manager = (ConnectivityManager) context
                .getSystemService(Activity.CONNECTIVITY_SERVICE);
        NetworkInfo info = manager.getActiveNetworkInfo();
        if (info != null && info.isConnected()) {
            return true;
        }
        return false;
    }

    /**
     * 判断wifi是否连接状态
     */
    public static boolean isWifi(Context context) {
        ConnectivityManager cm = (ConnectivityManager) context
                .getSystemService(Context.CONNECTIVITY_SERVICE);
        return cm != null && cm.getActiveNetworkInfo().getType() == ConnectivityManager.TYPE_WIFI;
    }

    /**
     * 获取移动网络运营商名称，如中国联通、中国移动、中国电信
     */
    public static String getNetworkOperatorName(Context context) {
        TelephonyManager telephonyManager = (TelephonyManager) context
                .getSystemService(Context.TELEPHONY_SERVICE);
        return telephonyManager.getNetworkOperatorName();
    }
}
