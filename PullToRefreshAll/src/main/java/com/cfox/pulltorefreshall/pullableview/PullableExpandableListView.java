package com.cfox.pulltorefreshall.pullableview;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ExpandableListView;

/**
 * <br/>************************************************
 * <br/>PROJECT_NAME : PullToRefreshAll
 * <br/>PACKAGE_NAME : com.cfox.pulltorefreshall.pullableview
 * <br/>AUTHOR : CFOX
 * <br/>MSG :
 * <br/>************************************************
 */
public class PullableExpandableListView extends ExpandableListView implements Pullable {

    private boolean isCanPullDown = true, isCanPullUp = false;

    public PullableExpandableListView(Context context) {
        super(context);
    }

    public PullableExpandableListView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public PullableExpandableListView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }


    @Override
    public boolean canPullDown() {

        if (isCanPullDown) {
            if (getCount() == 0) {
                // 没有item的时候也可以下拉刷新
                return true;
            } else if (getFirstVisiblePosition() == 0 && getChildAt(0).getTop() >= 0) {
                // 滑到顶部了
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    @Override
    public boolean canPullUp() {
        if (isCanPullUp) {
            if (getCount() == 0) {
                // 没有item的时候也可以上拉加载
                return true;
            } else if (getLastVisiblePosition() == (getCount() - 1)) {
                // 滑到底部了
                if (getChildAt(getLastVisiblePosition() - getFirstVisiblePosition()) != null
                        && getChildAt(
                        getLastVisiblePosition()
                                - getFirstVisiblePosition()).getBottom() <= getMeasuredHeight())
                    return true;
                else
                    return false;
            } else {

                return false;
            }
        } else {
            return false;
        }
    }

    public void setCanPullDown(boolean canPullDown) {
        isCanPullDown = canPullDown;
    }

    public void setCanPullUp(boolean canPullUp) {
        isCanPullUp = canPullUp;
    }
}
