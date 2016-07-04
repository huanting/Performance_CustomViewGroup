package com.hat.performance_customviewgroup;

import android.view.View;

/**
 * Created by admin on 2016/7/3.
 */
public class Utils {

    public static String getMeasureSpecMode(int mode)
    {
        if(mode == View.MeasureSpec.UNSPECIFIED)
            return "unspecified";
        else if(mode == View.MeasureSpec.EXACTLY)
            return "exactly";
        else
            return "at_most";
    }

    public static String StringFormat(String name, int w,  String wMode, int h, String hMode )
    {
        return String.format("%-30s [w: %-10d %-15s h: %-10d %-15s ]", name, w, wMode, h, hMode);
    }
}
