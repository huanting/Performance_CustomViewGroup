package com.hat.performance_customviewgroup;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;

import java.util.jar.Attributes;

/**
 * Created by admin on 2016/7/3.
 */
public class MyViewGroup extends ViewGroup {

    public MyViewGroup(Context context,AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {

        int withMode = MeasureSpec.getMode(widthMeasureSpec);
        int heightMode = MeasureSpec.getMode(heightMeasureSpec);
        int sizeWidth = MeasureSpec.getSize(widthMeasureSpec);
        int sizeHeight = MeasureSpec.getSize(heightMeasureSpec);

        //计算出所有的childView宽和高
        measureChildren(widthMeasureSpec, heightMeasureSpec);

        int childCnt = getChildCount();
        int cWidth;
        int cHeight;
        MarginLayoutParams  cParams;

        int tWidth = 0;
        int bWidth = 0;

        // 用于计算左边两个childView的高度
        int lHeight = 0;
        // 用于计算右边两个childView的高度，最终高度取二者之间大值
        int rHeight = 0;

        /**
         * 记录如果是wrap_content是设置的宽和高
         */
        int width = 0;
        int height = 0;


        /**
         * 计算child区域的最大宽度和高度
         */
        for(int i=0; i< childCnt;i++)
        {
            View childView = getChildAt(i);
            cWidth = childView.getMeasuredWidth();
            cHeight = childView.getMeasuredHeight();
            cParams = (MarginLayoutParams)childView.getLayoutParams();

            if(i == 0 || i == 1)
            {
                tWidth += cWidth + cParams.leftMargin + cParams.rightMargin;
            }

            if(i == 2 || i == 3)
            {
                bWidth += cWidth + cParams.leftMargin + cParams.rightMargin;
            }

            if(i == 0 || i == 2)
            {
                lHeight += cHeight + cParams.topMargin + cParams.bottomMargin;
            }

            if(i == 1 || i == 3)
            {
                rHeight += cHeight + cParams.topMargin + cParams.bottomMargin;
            }
        }

        width = Math.max(bWidth, tWidth);
        height = Math.max(lHeight, rHeight);

        setMeasuredDimension(resolveSize(width, widthMeasureSpec),
                resolveSize(height, heightMeasureSpec));

//        setMeasuredDimension(withMode == MeasureSpec.EXACTLY ? sizeWidth : width,
//                heightMode == MeasureSpec.EXACTLY ? sizeHeight : height);
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {

        int childCnt = getChildCount();
        int cWidth;
        int cHeight;
        MarginLayoutParams  cParams;

        int cl = 0, ct = 0, cr = 0, cb = 0;

        for (int i = 0; i < childCnt; i++)
        {
            View childView = getChildAt(i);

            cWidth = childView.getMeasuredWidth();
            cHeight = childView.getMeasuredHeight();
            cParams = (MarginLayoutParams)childView.getLayoutParams();

            switch (i)
            {
                case 0:
                    cl = cParams.leftMargin;
                    ct = cParams.topMargin;
                    break;
                case 1:
                    cl = getWidth() - cWidth - cParams.rightMargin;
                    ct = cParams.topMargin;
                    break;
                case 2:
                    cl = cParams.leftMargin;
                    ct = getHeight() - cParams.bottomMargin - cHeight;
                    break;
                case 3:
                    cl = getWidth() - cWidth - cParams.rightMargin;
                    ct = getHeight() - cParams.bottomMargin - cHeight;
                    break;
            }

            cr = cl + cWidth;
            cb = ct+ cHeight;

            childView.layout(cl, ct, cr,cb);
        }
    }

    @Override
    public LayoutParams generateLayoutParams(AttributeSet attrs) {
        return new MarginLayoutParams(getContext(), attrs);
    }

    @Override
    protected void measureChildWithMargins(View child, int parentWidthMeasureSpec, int widthUsed, int parentHeightMeasureSpec, int heightUsed) {
        super.measureChildWithMargins(child, parentWidthMeasureSpec, widthUsed, parentHeightMeasureSpec, heightUsed);
    }
}
