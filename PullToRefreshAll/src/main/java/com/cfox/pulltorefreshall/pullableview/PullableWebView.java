package com.cfox.pulltorefreshall.pullableview;

import android.content.Context;
import android.util.AttributeSet;
import android.webkit.WebView;
/**
 * <br/>************************************************
 * <br/>PROJECT_NAME : PullToRefreshAll
 * <br/>PACKAGE_NAME : com.cfox.pulltorefreshall.pullableview
 * <br/>AUTHOR : CFOX
 * <br/>MSG :
 * <br/>************************************************
 */
public class PullableWebView extends WebView implements Pullable {

    private boolean isCanPullDown = true, isCanPullUp = false;

    public PullableWebView(Context context) {
        super(context);
    }

    public PullableWebView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public PullableWebView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    @Override
    public boolean canPullDown() {

        if (isCanPullDown){
            if (getScrollY() == 0)
                return true;
            else
                return false;
        }else {
            return false;
        }
    }

    @Override
    public boolean canPullUp() {

        if (isCanPullUp){
            if (getScrollY() >= getContentHeight() * getScale()
                    - getMeasuredHeight())
                return true;
            else
                return false;
        }else {
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
