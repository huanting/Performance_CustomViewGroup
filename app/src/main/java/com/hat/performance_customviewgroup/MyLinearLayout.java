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

        int orientation = getOrientation();
        String str = orientation == 1 ? "Vertical" : "Horizontal";
        if(orientation == VERTICAL)
            Log.d("test", Utils.StringFormat("  > MyLinearLayout " + str, sizeWidth, Utils.getMeasureSpecMode(withMode) , sizeHeight, Utils.getMeasureSpecMode(heightMode) ));
        else
            Log.d("test", Utils.StringFormat("> MyLinearLayout " + str, sizeWidth, Utils.getMeasureSpecMode(withMode), sizeHeight, Utils.getMeasureSpecMode(heightMode)));

        super.onMeasure(widthMeasureSpec, heightMeasureSpec);

    }
}
