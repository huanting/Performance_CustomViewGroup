package com.hat.performance_customviewgroup;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.LinearLayout;

/**
 * Created by admin on 2016/7/3.
 */
public class MyLinearLayout extends LinearLayout {
    public MyLinearLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {

        int withMode = MeasureSpec.getMode(widthMeasureSpec);
        int heightMode = MeasureSpec.getMode(heightMeasureSpec);
        int sizeWidth = MeasureSpec.getSize(widthMeasureSpec);
        int sizeHeight = MeasureSpec.getSize(heightMeasureSpec);

        Log.d("test", "LinearLayout orientation=" +  getOrientation() + ", wMode: " + Utils.getMeasureSpecMode(withMode) + " hMode:" + Utils.getMeasureSpecMode(heightMode)
                + " w=" + sizeWidth + ", h=" + sizeHeight);

        super.onMeasure(widthMeasureSpec, heightMeasureSpec);

    }
}
