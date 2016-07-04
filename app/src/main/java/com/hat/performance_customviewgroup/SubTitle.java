package com.hat.performance_customviewgroup;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.TextView;

/**
 * Created by admin on 2016/7/3.
 */
public class SubTitle extends TextView {
    public SubTitle(Context context, AttributeSet attrs) {
        super(context, attrs);
    }


    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {

        int withMode = MeasureSpec.getMode(widthMeasureSpec);
        int heightMode = MeasureSpec.getMode(heightMeasureSpec);
        int sizeWidth = MeasureSpec.getSize(widthMeasureSpec);
        int sizeHeight = MeasureSpec.getSize(heightMeasureSpec);

        Log.d("test", Utils.StringFormat("      > SubTitle", sizeWidth, Utils.getMeasureSpecMode(withMode) , sizeHeight, Utils.getMeasureSpecMode(heightMode) ));

        super.onMeasure(widthMeasureSpec, heightMeasureSpec);

    }
}
