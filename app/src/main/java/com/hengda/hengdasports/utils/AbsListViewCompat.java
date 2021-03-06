package com.hengda.hengdasports.utils;

import android.view.View;
import android.widget.AbsListView;

/**
 *  监控listview滑动位置的工具类
 * @param <T>
 */
public class AbsListViewCompat<T extends AbsListView> {

    public interface OnScrollCallback {
        int STATE_SCROLLING = 1;
        int STATE_STOPPED = 2;

        int SCROLL_DIRECTION_NOTHING = 0;
        int SCROLL_DIRECTION_UP = 1;
        int SCROLL_DIRECTION_DOWN = 2;

        int SCROLL_POSITION_TOP = 1;
        int SCROLL_POSITION_BOTTOM = 2;
        int SCROLL_POSITION_OTHER = 0;

        void onScrollChanged(int state, int direction, int position);
    }

    /**
     * 滚动回调接口
     */
    private OnScrollCallback callback;
    /**
     * 最后一次滚动值
     */
    private int firstViewScrollY;
    /**
     * 最后滑动的位置listview的位置
     */
    private int lastposition;
    /**
     * 滚动视图最后一个可见的item
     */
    private int lastVisibleItem;
    /**
     * 手指在屏幕的y值
     */
    private int mTouchY;
    /**
     * 滚动视图
     */
    private T scrollView;

    /**
     * 是否是手动滑动，排除setselection
     */
    private boolean fromTouch;

    /**
     * 设置需要滚动的view
     * @param scrollView
     * @return
     */
    public AbsListViewCompat setScrollView(T scrollView) {
        if (null == scrollView) {
            return this;
        }
        this.scrollView = scrollView;
        setUpScroll();
        return this;
    }

    /**
     * 获取当前滚动的view
     *
     * @return
     */
    public T getScrollView() {
        return scrollView;
    }

    public AbsListViewCompat setOnScrollCallback(OnScrollCallback callback) {
        this.callback = callback;
        return this;
    }

    /**
     * 设置scroll回调
     */
    private void setUpScroll() {
        scrollView.setOnScrollListener(new AbsListView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(AbsListView view, int scrollState) {
                if (null == callback) {
                    return;
                }
                switch (scrollState) {
                    //滑动停止
                    case AbsListView.OnScrollListener.SCROLL_STATE_IDLE:
                        int position = getPosition();
                        firstViewScrollY = getFirstViewScrollY();
//                        LogUtil.e("==========position========== : " + position + " firstViewScrollY : " + firstViewScrollY);
                        callback.onScrollChanged(OnScrollCallback.STATE_STOPPED, OnScrollCallback.SCROLL_DIRECTION_NOTHING, position);
                        break;
                    //手指在滑动
                    case AbsListView.OnScrollListener.SCROLL_STATE_TOUCH_SCROLL:
                        fromTouch = true;
                        break;
                    //手指移开
                    case AbsListView.OnScrollListener.SCROLL_STATE_FLING:
                        break;
                }
            }

            @Override
            public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
                if (!fromTouch) {
                    return;
                }
                if (null == callback) {
                    return;
                }
                final int tempY = getFirstViewScrollY();
                if (firstViewScrollY == tempY) {
                    return;
                }
//                LogUtil.e("scrollY : " + tempY + " firstViewScrollY ：" + firstViewScrollY);
                firstViewScrollY = tempY;
                View childAt = scrollView.getChildAt(0);
                int[] location = new int[2];
                childAt.getLocationOnScreen(location);
//                LogUtil.e("firstVisibleItem= " + firstVisibleItem + " , y=" + location[1]);
                int direction = OnScrollCallback.SCROLL_DIRECTION_NOTHING;
                int state = OnScrollCallback.STATE_SCROLLING;
                if (firstVisibleItem != lastVisibleItem) {
                    if (firstVisibleItem > lastVisibleItem) {
//                        LogUtil.e("向上滑动");
                        direction = OnScrollCallback.SCROLL_DIRECTION_UP;
                    } else if (firstVisibleItem < lastVisibleItem) {
//                        LogUtil.e("向下滑动");
                        direction = OnScrollCallback.SCROLL_DIRECTION_DOWN;
                    }
                    lastVisibleItem = firstVisibleItem;
                    mTouchY = location[1];
                } else {
                    if (mTouchY > location[1]) {
//                        LogUtil.e("->向上滑动");
                        direction = OnScrollCallback.SCROLL_DIRECTION_UP;
                    } else if (mTouchY < location[1]) {
//                        LogUtil.e("->向下滑动");
                        direction = OnScrollCallback.SCROLL_DIRECTION_DOWN;
                    } else {
//                        LogUtil.e("->未滑动");
                        state = OnScrollCallback.STATE_STOPPED;
                    }
                    mTouchY = location[1];
                }
                callback.onScrollChanged(state, direction, getPosition());
            }
        });
    }

    /**
     * 获取第一个item的宽度
     */
    private int getFirstViewScrollY() {
        View c = scrollView.getChildAt(0);//第一个可见的view
        if (c == null) {
            return 0;
        }
        int top = c.getTop() + scrollView.getPaddingTop();
//        LogUtil.e("===========-top========="+-top);
        return -top;
    }
    /**
     * 获取滑动的总的宽度
     */
    public int getScrollY() {
        View c = scrollView.getChildAt(0);
        if (c == null) {
            return 0;
        }
        int firstVisiblePosition = scrollView.getFirstVisiblePosition();
        int top = c.getTop();
        return -top + firstVisiblePosition * c.getHeight() ;
    }

    /**
     * 判断当前滚动内容的位置
     *
     * @return
     */
    private int getPosition() {
//        //滑动到底部，最后可见的item为list最后一个数据，且自后一个item已完全显示，底部padding也完全显示
//        if (scrollView.getLastVisiblePosition() == scrollView.getCount() - 1 && scrollView.getChildAt(scrollView.getChildCount() - 1).getBottom() + scrollView.getPaddingBottom() == scrollView.getBottom()) {
//            return OnScrollCallback.SCROLL_POSITION_BOTTOM;
//        }
//        //滑动到顶部
//        else if (scrollView.getFirstVisiblePosition() == 0 && scrollView.getChildAt(0).getTop() == scrollView.getPaddingTop()) {
//            return OnScrollCallback.SCROLL_POSITION_TOP;
//        }
//        //其他
//        else {
//            return OnScrollCallback.SCROLL_POSITION_OTHER;
//        }

        if (getFirstViewScrollY()!=0){
            lastposition=getScrollY()/getFirstViewScrollY();
            return lastposition;
        }else{
            return 0;
        }
    }
}
