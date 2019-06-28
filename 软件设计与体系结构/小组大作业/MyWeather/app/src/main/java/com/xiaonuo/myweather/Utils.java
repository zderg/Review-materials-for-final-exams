package com.xiaonuo.myweather;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Build;
import android.view.View;


public class Utils {


    private static SharedPreferences sp;

    /**
     * ActionBar隐藏，透明化任务栏
     *
     * @param activity
     */
    public static void hideTaskbar(Activity activity) {
        if (Build.VERSION.SDK_INT >= 21) {
            View decorView = activity.getWindow().getDecorView();
            int option = View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                    | View.SYSTEM_UI_FLAG_LAYOUT_STABLE;
            decorView.setSystemUiVisibility(option);
            activity.getWindow().setStatusBarColor(Color.TRANSPARENT);

        }
    }


    /**
     * 设置状态栏字体颜色为黑色
     *
     * @param activity
     */
    public static void setTaskbarFontBlack(Activity activity) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {//android6.0以后可以对状态栏文字颜色和图标进行修改
            activity.getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN | View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
        }
    }

    public static boolean cleanSp(Context context) {
        if (sp == null) {
            sp = context.getSharedPreferences("config", Context.MODE_MULTI_PROCESS);
        }

        return sp.edit().clear().commit();
    }


    /**
     * @param key   键
     * @param value 值
     * @return true or false
     */
    public static boolean putString(Context context, String key, String value) {
        if (sp == null) {
            sp = context.getSharedPreferences("config", Context.MODE_MULTI_PROCESS);
        }

        return sp.edit().putString(key, value).commit();
    }


    /**
     * @param key          键
     * @param defaultValue 默认值
     * @return 取出值
     */
    public static String getString(Context context, String key, String defaultValue) {
        if (sp == null) {
            sp = context.getSharedPreferences("config", Context.MODE_MULTI_PROCESS);
        }

        return sp.getString(key, defaultValue);
    }

}
