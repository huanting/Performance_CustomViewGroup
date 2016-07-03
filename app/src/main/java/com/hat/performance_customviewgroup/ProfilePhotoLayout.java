package com.hat.performance_customviewgroup;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

/**
 * Created by admin on 2016/7/3.
 */
public class ProfilePhotoLayout extends ViewGroup {

    private ProfilePhoto mProfilePhoto;
    private MyMenu mMenu;
    private Title mTitle;
    private SubTitle mSubtitle;

    public ProfilePhotoLayout(Context context, AttributeSet attrs) {
        super(context, attrs);

    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {


        int pl = 0, pr = 0, pt = 0, pb = 0;
        int ml = 0, mr = 0, mt = 0, mb = 0;
        int tl = 0, tr = 0, tt = 0, tb = 0;
        int sl = 0, sr = 0, st = 0, sb = 0;
        int mid = (b + t)/2;
        int midLeft = 0, midRight = 0;

        //ProfilePhoto
        MarginLayoutParams lp = (MarginLayoutParams)mProfilePhoto.getLayoutParams();

        pl = l + lp.leftMargin;
        pr = pl + mProfilePhoto.getMeasuredWidth();
        pt = mid - mProfilePhoto.getMeasuredHeight()/2;
        pb  = pt + mProfilePhoto.getMeasuredHeight();

        mProfilePhoto.layout(pl,pt, pr, pb);

        midLeft = pr + lp.rightMargin;

        //Menu
        lp = (MarginLayoutParams)mMenu.getLayoutParams();
        ml = r - lp.rightMargin - mMenu.getMeasuredWidth();
        mr = ml + mMenu.getMeasuredWidth();
        mt = t + lp.topMargin;
        mb = mt + mMenu.getMeasuredHeight();

        mMenu.layout(ml, mt, mr, mb);
        midRight = ml - lp.leftMargin;

        //title
        lp = (MarginLayoutParams)mTitle.getLayoutParams();
        tl = midLeft + lp.leftMargin;
        tr = midRight - lp.rightMargin;
        tt = mid - mTitle.getMeasuredHeight() - lp.bottomMargin;
        tb = tt + mTitle.getMeasuredHeight();
        mTitle.layout(tl, tt, tr, tb);

        //subTitle
        lp = (MarginLayoutParams)mSubtitle.getLayoutParams();
        sl = midLeft + lp.leftMargin;
        sr = midRight - lp.rightMargin;
        st = mid + lp.topMargin;
        sb = st + mTitle.getMeasuredHeight();

        mSubtitle.layout(sl, st, sr, sb);

    }


    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {

        if(mProfilePhoto == null)
        mProfilePhoto = (ProfilePhoto)getChildAt(0);


        if(mTitle == null)
            mTitle = (Title)getChildAt(1);
        if(mSubtitle == null)
            mSubtitle = (SubTitle)getChildAt(2);

        if(mMenu == null)
            mMenu = (MyMenu)getChildAt(3);

        // 1. Setup initial constraints.
        int widthConstraints = getPaddingLeft() + getPaddingRight();
        int heightConstraints = getPaddingTop() + getPaddingBottom();
        int width = 0;
        int height = 0;

        // 2. Measure the ProfilePhoto
        measureChildWithMargins(
                mProfilePhoto,
                widthMeasureSpec,
                widthConstraints,
                heightMeasureSpec,
                heightConstraints);

        // 3. Update the contraints.
        widthConstraints += mProfilePhoto.getMeasuredWidth();
        width += mProfilePhoto.getMeasuredWidth();
        height = Math.max(mProfilePhoto.getMeasuredHeight(), height);

        // 4. Measure the Menu.
        measureChildWithMargins(
                mMenu,
                widthMeasureSpec,
                widthConstraints,
                heightMeasureSpec,
                heightConstraints);

        // 5. Update the constraints.
        widthConstraints += mMenu.getMeasuredWidth();
        width += mMenu.getMeasuredWidth();
        height = Math.max(mMenu.getMeasuredHeight(), height);

        // 6. Prepare the vertical MeasureSpec.
        int verticalWidthMeasureSpec = MeasureSpec.makeMeasureSpec(
                MeasureSpec.getSize(widthMeasureSpec) - widthConstraints,
                MeasureSpec.getMode(widthMeasureSpec));

        int verticalHeightMeasureSpec = MeasureSpec.makeMeasureSpec(
                MeasureSpec.getSize(heightMeasureSpec) - heightConstraints,
                MeasureSpec.getMode(heightMeasureSpec));

        // 7. Measure the Title.
        measureChildWithMargins(
                mTitle,
                verticalWidthMeasureSpec,
                0,
                verticalHeightMeasureSpec,
                0);

        // 8. Measure the Subtitle.
        measureChildWithMargins(
                mSubtitle,
                verticalWidthMeasureSpec,
                0,
                verticalHeightMeasureSpec,
                mTitle.getMeasuredHeight());

        // 9. Update the sizes.
        width += Math.max(mTitle.getMeasuredWidth(), mSubtitle.getMeasuredWidth());
        height = Math.max(mTitle.getMeasuredHeight() + mSubtitle.getMeasuredHeight(), height);

        // 10. Set the dimension for this ViewGroup.
        setMeasuredDimension(
                resolveSize(width, widthMeasureSpec),
                resolveSize(height, heightMeasureSpec));


    }

    @Override
    protected void measureChildWithMargins(View child, int parentWidthMeasureSpec, int widthUsed, int parentHeightMeasureSpec, int heightUsed) {
       MarginLayoutParams lp = (MarginLayoutParams)child.getLayoutParams();

        int childWidthMeasureSpec = getChildMeasureSpec(
                parentWidthMeasureSpec,
                widthUsed + lp.leftMargin + lp.rightMargin,
                lp.width);

        int childHeightMeasureSpec = getChildMeasureSpec(
                parentHeightMeasureSpec,
                heightUsed + lp.topMargin + lp.bottomMargin,
                lp.height);
        child.measure(childWidthMeasureSpec, childHeightMeasureSpec);
    }


    @Override
    public LayoutParams generateLayoutParams(AttributeSet attrs) {
        return new MarginLayoutParams(getContext(), attrs);
    }
}
