package com.example.cuongphan.customcomponents_redview;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by CuongPhan on 3/20/2017.
 */

public class ColoredView extends View {
    View view2 = (View)findViewById(R.id.view2);
    private int defaultOriginalColor = Color.BLACK;
    private int defaultAfterColor = Color.GRAY;
    private float defaultDimensionWidth = 200;
    private float defaultDimensionHeight = 200;
    private static int originalColor;
    private static int afterColor;
    private static int dimensionWidth;
    private static int dimensionHeight;
    public ColoredView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initializeCustomComponents(attrs);
        view2.setBackgroundColor(originalColor);
    }

    private void initializeCustomComponents(AttributeSet attrs) {
        TypedArray attributeArray = getContext().obtainStyledAttributes(attrs, R.styleable.RedView);
        originalColor = attributeArray.getColor(R.styleable.RedView_original_background, defaultOriginalColor);
        afterColor = attributeArray.getColor(R.styleable.RedView_after_background, defaultAfterColor);
        dimensionWidth = (int) attributeArray.getDimension(R.styleable.RedView_dimension_width, defaultDimensionWidth);
        dimensionHeight = (int) attributeArray.getDimension(R.styleable.RedView_dimension_height, defaultDimensionHeight);
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
            result = dimensionWidth;
        }
        return result;
    }

    private int mesureDimHeight(int measureSpec) {
        int specMode = MeasureSpec.getMode(measureSpec);
        int specSize = MeasureSpec.getSize(measureSpec);
        int result;
        if(specMode == MeasureSpec.EXACTLY){
            result = specSize;
        }
        else{
            result = dimensionHeight;
        }
        return result;
    }

    @Override
    public boolean onTouchEvent(MotionEvent e){
        if(e.getAction() == MotionEvent.ACTION_DOWN ) {
            view2.setBackgroundColor(afterColor);
            return true;
        }
        else{
            return false;
        }
    }
}
