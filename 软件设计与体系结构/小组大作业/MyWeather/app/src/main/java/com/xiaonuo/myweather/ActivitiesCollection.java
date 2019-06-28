package com.xiaonuo.myweather;

import android.app.Activity;

import java.util.ArrayList;

public class ActivitiesCollection {

    private static ArrayList<Activity> activities = new ArrayList<>();

    /**
     * 饿汉式
     */
    private static ActivitiesCollection activitiesCollection = new ActivitiesCollection();


    /**
     * 私有化构造方法
     */
    private ActivitiesCollection() {

    }

    /**
     * 获取实例方法
     */
    public static ActivitiesCollection getInstance() {
        return activitiesCollection;
    }


    public static boolean addActivity(Activity activity) {
        activities.add(activity);
        return true;
    }


    public static void finishAllActivity() {
        for (int i = activities.size() - 1; i >= 0; i--) {
            activities.remove(i);
        }
    }

}
