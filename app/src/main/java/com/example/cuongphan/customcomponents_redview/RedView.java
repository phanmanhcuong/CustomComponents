package com.example.cuongphan.customcomponents_redview;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by CuongPhan on 3/20/2017.
 */

public class RedView extends View {
    View view1 = (View)findViewById(R.id.view1);
    public RedView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        view1.setBackgroundColor(Color.RED);

    }

    @Override
    protected void onDraw(Canvas canvas){
        super.onDraw(canvas);

    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec){
        int widthSpecMode = mesureDimWidth(widthMeasureSpec);
        int heightSpecMode = mesureDimHeight(heightMeasureSpec);
        setMeasuredDimension(widthSpecMode, heightSpecMode);
    }


    private int mesureDimWidth(int measureSpec) {
        int specMode = MeasureSpec.getMode(measureSpec);
        int specSize = MeasureSpec.getSize(measureSpec);
        int result = 0;
        if(specMode == MeasureSpec.EXACTLY){
            result = specSize;
        }
        else{
            result = getWidth() - getPaddingLeft() - getPaddingRight();
        }
        return result;
    }

    private int mesureDimHeight(int measureSpec) {
        int specMode = MeasureSpec.getMode(measureSpec);
        int specSize = MeasureSpec.getSize(measureSpec);
        int result = 0;
        if(specMode == MeasureSpec.EXACTLY){
            result = specSize;
        }
        else{
            result = getHeight() - getPaddingBottom()- getPaddingTop();
        }
        return result;
    }

    @Override
    public boolean onTouchEvent(MotionEvent e){
        if(e.getAction() == MotionEvent.ACTION_DOWN ) {
            view1.setBackgroundColor(Color.YELLOW);
            return true;
        }
        else{
            return false;
        }
    }
}
