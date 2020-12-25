package com.gy.shoppproject.utils;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewpager.widget.ViewPager;

public
class CanSlidingViewpager extends ViewPager {


    public CanSlidingViewpager(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }
    public CanSlidingViewpager(Context context) {

        super(context);
    }
    private boolean isCanScroll = false;
    public boolean onTouchEvent(MotionEvent ev){
        if(isCanScroll){
            return super.onTouchEvent(ev);
        }else{
            return false;
        }
    }
    @Override
    public boolean onInterceptTouchEvent(MotionEvent arg0) {
        // TODO Auto-generated method stub
        if (isCanScroll) {
            return super.onInterceptTouchEvent(arg0);
        } else {
            return false;
        }

    }
    public boolean isScrollble() {
        return isCanScroll;
    }

    /**
     * 设置 是否可以滑动
     *
     * @param isCanScroll
     */
    public void setScrollble(boolean isCanScroll) {
        this.isCanScroll = isCanScroll;

    }
}
