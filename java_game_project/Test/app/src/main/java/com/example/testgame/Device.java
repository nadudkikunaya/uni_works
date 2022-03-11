package com.example.testgame;

import android.content.Context;
import android.content.res.Resources;

public class Device {
    public static final int screenWidth = Resources.getSystem().getDisplayMetrics().widthPixels;
    public static final int screenHeight = Resources.getSystem().getDisplayMetrics().heightPixels;
    public static Context context;
    public static Resources resources;
    public static int charWidth;
    public static int charHeight;
    public static float dpi = Resources.getSystem().getDisplayMetrics().density*2;
    public static void setContext(Context con) {
        context = con;
    }
    public static void setResources(Resources rs) { resources = rs; }

    public Context getContext(){
        return context;
    }

    public void setCharWidth(int cw) {
        this.charWidth = cw;
    }

    public void setCharHeight(int charHeight){
        this.charHeight = charHeight;
    }

    public int getCharWidth(){
        return charWidth;
    }

    public int getCharHeight(){
        return charHeight;
    }
}
