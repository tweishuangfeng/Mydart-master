package com.example.administrator.mydart;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.VideoView;

/**
 * Created by Administrator on 2018/4/10.
 */

public class MyVideoView  extends VideoView {


    public static int WIDTH;
    public static int HEIGHT;


    public MyVideoView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }


    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int width=getDefaultSize(WIDTH,widthMeasureSpec);
        int height=getDefaultSize(HEIGHT,heightMeasureSpec);

        setMeasuredDimension(width,height);
    }



}
