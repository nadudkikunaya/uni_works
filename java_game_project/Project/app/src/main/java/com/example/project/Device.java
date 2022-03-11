package com.example.project;

import android.content.Context;
import android.content.res.Resources;

public class Device {
    public static final int screenWidth = Resources.getSystem().getDisplayMetrics().widthPixels;
    public static final int screenHeight = Resources.getSystem().getDisplayMetrics().heightPixels;
    public static float dpi = Resources.getSystem().getDisplayMetrics().density*2;
    public static Resources resources = null;
    public static Context context = null;
    public static void setResources(Resources rs){
        resources = rs;
    }

    public static void setContext(Context c){
        context = c;

    }
}
