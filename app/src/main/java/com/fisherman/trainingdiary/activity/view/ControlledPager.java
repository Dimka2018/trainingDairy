package com.fisherman.trainingdiary.activity.view;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;

public class ControlledPager extends ViewPager {

    private boolean isSwipeEnabled = true;

    @Override
    public void setAdapter(PagerAdapter adapter) {
        super.setAdapter(adapter);
    }

    public ControlledPager(Context context) {
        super(context);
    }

    public ControlledPager(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        return isSwipeEnabled && super.onInterceptTouchEvent(ev);
    }

    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        return isSwipeEnabled && super.onTouchEvent(ev);
    }

    public void setSwipeEnabled(boolean swipeEnabled) {
        this.isSwipeEnabled = swipeEnabled;
    }
}
