package com.dim.widget;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.*;
import android.view.View;

import com.dim.circletreveal.CircleRevealHelper;
import com.dim.skin.hepler.DefaultViewSkinHelper;
import com.dim.circletreveal.CircleRevealEnable;
import com.dim.listener.SingleClickListener;
import com.dim.skin.SkinEnable;
import com.dim.skin.SkinStyle;
import com.dim.skin.hepler.SkinHelper;
import com.dim.widget.animation.CRAnimation;

/**
 * Created by zzz40500 on 15/8/26.
 */

public class LinearLayout extends android.widget.LinearLayout implements CircleRevealEnable,SkinEnable {

    private CircleRevealHelper mCircleRevealHelper ;
    private  SkinHelper mSkinHelper;

    public LinearLayout(Context context) {
        super(context);
        init(null);
    }

    public LinearLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(attrs);
    }

    private void init(AttributeSet attrs) {

        mSkinHelper=SkinHelper.create(this);
        mSkinHelper.init(this, attrs);
        mSkinHelper.setCurrentTheme();
        mCircleRevealHelper=new CircleRevealHelper(this);
    }

    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    public LinearLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(attrs);
    }

    @Override
    public void setDividerDrawable(Drawable divider) {
        super.setDividerDrawable(divider);
    }

    @Override
    public void setOnClickListener(OnClickListener l) {
        super.setOnClickListener(new SingleClickListener(l));
    }

    @Override
    public void draw(Canvas canvas) {

        mSkinHelper.preDraw(this);
        mCircleRevealHelper.draw(canvas);
    }


    @Override
    public void superDraw(Canvas canvas) {
        super.draw(canvas);
    }


    @Override
    public CRAnimation circularReveal(int centerX, int centerY, float startRadius, float endRadius) {

        return mCircleRevealHelper.circularReveal(centerX,centerY,startRadius,endRadius);
    }

    @Override
    public void setSkinStyle(SkinStyle skinStyle) {


        mSkinHelper.setSkinStyle(skinStyle);
    }

    @Override
    public LayoutParams generateLayoutParams(AttributeSet attrs) {


        return new SLayoutParams(getContext(),attrs);
    }

    @Override
    public void addView(View child, int index, ViewGroup.LayoutParams params) {
        super.addView(child, index, params);
        if(params instanceof SLayoutParams){
            ((SLayoutParams) params).setSkinHelper(child);
        }
    }

    @Override
    protected LayoutParams generateDefaultLayoutParams() {
        return super.generateDefaultLayoutParams();
    }


    public  class  SLayoutParams extends android.widget.LinearLayout.LayoutParams implements SLayoutParamsI  {

        private DefaultViewSkinHelper mSkinHelper;

        public SLayoutParams(Context c, AttributeSet attrs) {
            super(c, attrs);
            mSkinHelper=SkinHelper.createDeFault(c);
            mSkinHelper.init(null,attrs);
        }

        public void setSkinHelper(View view){
            mSkinHelper.setView(view);
        }
        public void setSkinStyle(SkinStyle skinStyle){
            mSkinHelper.setSkinStyle(skinStyle);
        }

        public SLayoutParams(int width, int height) {
            super(width, height);
        }

        public SLayoutParams(int width, int height, float weight) {
            super(width, height, weight);
        }

        public SLayoutParams(ViewGroup.LayoutParams p) {
            super(p);
        }

        public SLayoutParams(MarginLayoutParams source) {
            super(source);
        }

        @TargetApi(Build.VERSION_CODES.KITKAT)
        public SLayoutParams(LayoutParams source) {
            super(source);
        }
    }
}
