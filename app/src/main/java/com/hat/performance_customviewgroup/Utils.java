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
}
