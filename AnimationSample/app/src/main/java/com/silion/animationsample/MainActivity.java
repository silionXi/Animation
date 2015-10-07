package com.silion.animationsample;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.ImageView;

/**
 * Created by silion on 2015/8/18.
 */
public class MainActivity extends Activity {
    private ImageView mImage = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);
        Button alphaCode = (Button) findViewById(R.id.alphaCode);
        alphaCode.setOnClickListener(mAlphaCodeListener);
        Button alphaXML = (Button) findViewById(R.id.alphaXML);
        alphaXML.setOnClickListener(mAlphaXMLListener);

        Button rotateCode = (Button) findViewById(R.id.rotateCode);
        rotateCode.setOnClickListener(mRotateCodeListener);
        Button rotateXML = (Button) findViewById(R.id.rotateXML);
        rotateXML.setOnClickListener(mRotateXMLListener);

        Button scaleCodeBtn = (Button) findViewById(R.id.scaleCode);
        scaleCodeBtn.setOnClickListener(mScaleCodeListener);
        Button scaleXMLBtn = (Button) findViewById(R.id.scaleXML);
        scaleXMLBtn.setOnClickListener(mScaleXMLListener);

        Button translateBtn = (Button) findViewById(R.id.translateCode);
        translateBtn.setOnClickListener(mTranslateBtn);
        Button translateXMLBtn = (Button) findViewById(R.id.translateXML);
        translateXMLBtn.setOnClickListener(mTranslateXMLListener);

        Button animRenameAllBtn = (Button) findViewById(R.id.animaMul);
        animRenameAllBtn.setOnClickListener(mAnimMulListener);
        mImage = (ImageView) findViewById(R.id.image);

    }

    View.OnClickListener mAlphaCodeListener = new View.OnClickListener() {
        public void onClick(View view) {
            Animation alpha = getAlphaAnim();
            alpha.setDuration(3000);
            mImage.startAnimation(alpha);
        }
    };

    View.OnClickListener mAlphaXMLListener = new View.OnClickListener() {
        public void onClick(View view) {
            Animation alphaAnimation = AnimationUtils.loadAnimation(MainActivity.this, R.anim.alpha);
            mImage.startAnimation(alphaAnimation);
        }
    };

    View.OnClickListener mRotateCodeListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Animation rotate = getRotateAnim();
            rotate.setDuration(3000);
            mImage.startAnimation(rotate);
        }
    };

    View.OnClickListener mRotateXMLListener = new View.OnClickListener() {
        public void onClick(View view) {
            Animation rotateAnimation = AnimationUtils.loadAnimation(MainActivity.this,
                    R.anim.rotate);
            mImage.startAnimation(rotateAnimation);
        }
    };

    View.OnClickListener mScaleCodeListener = new View.OnClickListener() {
        public void onClick(View view) {
            Animation scale = getScaleAnim();
            scale.setDuration(3000);
            mImage.startAnimation(scale);
        }
    };

    View.OnClickListener mScaleXMLListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Animation scaleAni = AnimationUtils.loadAnimation(MainActivity.this,
                    R.anim.scale);
            mImage.startAnimation(scaleAni);
        }
    };

    View.OnClickListener mTranslateBtn = new View.OnClickListener() {
        public void onClick(View view) {
            Animation translate = getTranslteAnim();
            translate.setDuration(3000);
            mImage.startAnimation(translate);
        }
    };

    View.OnClickListener mTranslateXMLListener = new View.OnClickListener(){
        @Override
        public void onClick(View v) {
            Animation translateAni = AnimationUtils.loadAnimation(MainActivity.this,
                    R.anim.translate);
            mImage.startAnimation(translateAni);
        }
    };

    View.OnClickListener mAnimMulListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            AnimationSet animSet = new AnimationSet(true);
            Animation alpha = getAlphaAnim();
            animSet.addAnimation(alpha);
            Animation translate = getTranslteAnim();
            animSet.addAnimation(translate);
            animSet.setDuration(4000);
            animSet.setRepeatCount(3);
            animSet.setInterpolator(new AccelerateDecelerateInterpolator());
            mImage.startAnimation(animSet);
        }
    };

    public Animation getAlphaAnim() {
        Animation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
//        alphaAnimation.setDuration(3 * 1000);
//        AnimationSet animationSet = new AnimationSet(false);
//        animationSet.addAnimation(alphaAnimation);
//        mImage.startAnimation(animationSet);
        return alphaAnimation;
    }

    public Animation getRotateAnim() {
        /**
         * degree 开始角度/结束角度
         * 360.0f, 0.0f anticlockwise(逆时针)
         * 0.0f, 360.0f clockwise(顺时针)
         */
        Animation rotate = new RotateAnimation(45.0f, 360.0f,
                Animation.RELATIVE_TO_PARENT, 0.2f, Animation.RELATIVE_TO_PARENT, 0.2f);
//        AnimationSet animationSet = new AnimationSet(true);
//        animationSet.addAnimation(rotate);
//        animationSet.setDuration(3 * 1000);
//        mImage.startAnimation(animationSet);
        return rotate;
    }

    public Animation getScaleAnim() {
        Animation scale = new ScaleAnimation(1.0f, 0.1f, 1.0f, 0.1f);
//        AnimationSet animationSet = new AnimationSet(true);
//        animationSet.addAnimation(scale);
//        animationSet.setDuration(3 * 1000);
//        mImage.startAnimation(animationSet);
        return scale;
    }

    public Animation getTranslteAnim() {
        Animation translate = new TranslateAnimation(Animation.RELATIVE_TO_PARENT, 0.5f,
                Animation.RELATIVE_TO_PARENT, 1.0f, Animation.RELATIVE_TO_PARENT, 0.5f,
                Animation.RELATIVE_TO_PARENT, 0.0f);
//        AnimationSet animationSet = new AnimationSet(true);
//        animationSet.addAnimation(translate);
//        animationSet.setDuration(3 * 1000);
//        mImage.startAnimation(animationSet);
        return translate;
    }
}
