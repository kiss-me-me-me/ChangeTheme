package com.dim.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;

import com.dim.circletreveal.CircleRevealHelper;
import com.dim.skin.SkinStyle;
import com.dim.skin.hepler.SkinHelper;
import com.dim.circletreveal.CircleRevealEnable;
import com.dim.listener.SingleClickListener;
import com.dim.skin.SkinEnable;
import com.dim.widget.animation.CRAnimation;


/**
 * @author zwm
 * @version 2.0
 * @ClassName ImageView
 * @Description TODO(这里用一句话描述这个类的作用)
 * @date 2015/7/9.
 */
public class ImageView extends android.widget.ImageView implements CircleRevealEnable,SkinEnable {

    private CircleRevealHelper mCircleRevealHelper ;
    private SkinHelper mSkinHelper;

    public ImageView(Context context) {
        super(context);
        init(null);

    }

    public ImageView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(attrs);
    }

    private void init(AttributeSet attrs) {

        mSkinHelper=SkinHelper.create(this);
        mSkinHelper.init(this, attrs);
        mSkinHelper.setCurrentTheme();
        mCircleRevealHelper=new CircleRevealHelper(this);
    }

    public ImageView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(attrs);
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
}
