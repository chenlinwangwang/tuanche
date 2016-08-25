package com.bwf.tuanche.details.adapter;

import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.bwf.tuanche.R;

/**
 * 自定义加载更多的ListVIew
 */
public class RefreshListView extends ListView implements AbsListView.OnScrollListener ,Handler.Callback{
    private OnLoadMoreListener onLoadMoreListener;
    private View footerView;//添加底部加载更多布局
    private View headerView;//添加头部动画
    private TextView tv_loading;
    private ImageView img_header;
    private int headerViewHeight;
    private Handler handler;
    private AnimationDrawable headerAnimation;

    public RefreshListView(Context context) {
        this(context, null);
    }

    public RefreshListView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public RefreshListView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    public void init(Context context) {
        handler = new Handler(this);
        //添加handerView
        headerView = View.inflate(context, R.layout.header_view, null);
        addHeaderView(headerView);
        tv_loading = (TextView) headerView.findViewById(R.id.tv_loading);
        img_header = (ImageView) headerView.findViewById(R.id.img_header);
        headerAnimation = (AnimationDrawable) img_header.getDrawable();

        //计算高度
        measureView(headerView);
        headerViewHeight = headerView.getMeasuredHeight();
        headerView.setPadding(0,-headerViewHeight,0,0);

        //添加footerView
        footerView = View.inflate(context, R.layout.foot_view, null);
        addFooterView(footerView);
        ImageView img_progressbar = (ImageView) footerView.findViewById(R.id.img_progressbar);
        AnimationDrawable animationDrawable = (AnimationDrawable) img_progressbar.getDrawable();
        animationDrawable.start();
        //footerView隐藏
        footerView.setVisibility(INVISIBLE);
        setOnScrollListener(this);
    }

    public void measureView(View child) {
        ViewGroup.LayoutParams p = child.getLayoutParams();
        if (p == null) {
            p = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.FILL_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        }
        int childWidthSpec = ViewGroup.getChildMeasureSpec(0, 0, p.width);
        int lpHeight = p.height;
        int childHeightSpec;
        if (lpHeight > 0) {
            childHeightSpec = View.MeasureSpec.makeMeasureSpec(lpHeight, View.MeasureSpec.EXACTLY);
        } else {
            childHeightSpec = View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED);
        }
        child.measure(childWidthSpec, childHeightSpec);
    }

    @Override
    public void onScrollStateChanged(AbsListView view, int scrollState) {
        if (scrollState != SCROLL_STATE_IDLE)
            return;

        if (getLastVisiblePosition() == getCount() - 1) {
            if (onLoadMoreListener != null) {
                onLoadMoreListener.loadMore();
                footerView.setVisibility(VISIBLE);
            }
        }
    }

    @Override
    public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
    }

    /**
     * 触摸事件  1,按下事件  2，滑动事件  3，抬起事件
     */
    private int startY, endY, moveY;

    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        if (getFirstVisiblePosition() != 0)
            return super.onTouchEvent(ev);
        switch (ev.getAction()) {
            case MotionEvent.ACTION_DOWN://按下事件
                startY = (int) ev.getY();
                tv_loading.setText("松开刷新数据");
                break;
            case MotionEvent.ACTION_MOVE://滑动事件
                endY = (int) ev.getY();
                moveY = endY - startY;
                if (moveY > 0) {
                    setSelection(0);
                    headerView.setPadding(0, -headerViewHeight + moveY, 0, 0);
                    if (moveY > headerViewHeight)
                        handler.removeMessages(1);
                        handler.removeMessages(2);
                        handler.removeMessages(3);
                        tv_loading.setText("松开刷新数据");
                }
                break;
            case MotionEvent.ACTION_UP://抬起事件
                if (moveY > headerViewHeight && onLoadMoreListener != null) {
                    onLoadMoreListener.onRefresh();
                    headerView.setPadding(0, 0, 0, 0);
                    handler.sendEmptyMessage(1);
                    headerAnimation.start();
                }
                break;
        }
        return super.onTouchEvent(ev);
    }

    /**
     * 加载完成
     */
    public void setOnComplete() {
        footerView.setVisibility(INVISIBLE);
        setSelection(0);
        tv_loading.setText("拼命加载中");
        headerView.setPadding(0,-headerViewHeight,0,0);
    }

    /**
     * 设置加载更多监听
     */
    public void setOnLoadMoreListener(OnLoadMoreListener onLoadMoreListener) {
        this.onLoadMoreListener = onLoadMoreListener;
    }

    @Override
    public boolean handleMessage(Message message) {
        switch (message.what) {
            case 1:
                tv_loading.setText("拼命加载中·");
                handler.sendEmptyMessageDelayed(2, 500);
                break;
            case 2:
                tv_loading.setText("拼命加载中··");
                handler.sendEmptyMessageDelayed(3, 500);
                break;
            case 3:
                tv_loading.setText("拼命加载中···");
                handler.sendEmptyMessageDelayed(1, 500);
                break;
        }
        return false;
    }

    /**
     * 加载更多
     */
    public interface OnLoadMoreListener {
        void loadMore();//加载更多
        void onRefresh();//下拉刷新
    }

}
