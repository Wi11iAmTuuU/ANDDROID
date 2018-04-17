package com.example.williamtuuu.hw5_1;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.GridView;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.ViewSwitcher;

public class MainActivity extends AppCompatActivity implements ViewSwitcher.ViewFactory {

    private GridView mGridView;
    private ImageSwitcher mImgSwitcher;

    private Integer[] miImgArr = {
            R.drawable.img01, R.drawable.img02, R.drawable.img03,
            R.drawable.img04, R.drawable.img05, R.drawable.img06,
            R.drawable.img07, R.drawable.img08, R.drawable.img09,
            R.drawable.img10, R.drawable.img11, R.drawable.img12};

    private Integer[] miThumbImgArr = {
            R.drawable.img01th, R.drawable.img02th, R.drawable.img03th,
            R.drawable.img04th, R.drawable.img05th, R.drawable.img06th,
            R.drawable.img07th, R.drawable.img08th, R.drawable.img09th,
            R.drawable.img10th, R.drawable.img11th, R.drawable.img12th};

    Animation[] AnimList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mImgSwitcher = (ImageSwitcher) findViewById(R.id.imgSwitcher);

        mImgSwitcher.setFactory(this);	// 主程式類別必須implements ViewSwitcher.ViewFactory
        mImgSwitcher.setInAnimation(AnimationUtils.loadAnimation(this,
                android.R.anim.fade_in));
        mImgSwitcher.setOutAnimation(AnimationUtils.loadAnimation(this,
                android.R.anim.fade_out));

        ImageAdapter imgAdap = new ImageAdapter(this, miThumbImgArr);

        AnimInit();
        mGridView = (GridView)findViewById(R.id.gridView);
        mGridView.setAdapter(imgAdap);
        mGridView.setOnItemClickListener(gridViewOnItemClick);
    }

    @Override
    public View makeView() {
        ImageView v = new ImageView(this);
        v.setBackgroundColor(0xFF000000);
        v.setScaleType(ImageView.ScaleType.FIT_CENTER);
        v.setLayoutParams(new ImageSwitcher.LayoutParams(FrameLayout.LayoutParams.MATCH_PARENT,
                FrameLayout.LayoutParams.MATCH_PARENT));
        v.setBackgroundColor(Color.WHITE);
        return v;
    }


    private AdapterView.OnItemClickListener gridViewOnItemClick = new
            AdapterView.OnItemClickListener() {

                @Override
                public void onItemClick(AdapterView<?> parent,
                                        View v,
                                        int position,
                                        long id) {
            int select = (int) Math.floor(Math.random() * 4);
            mImgSwitcher.setInAnimation(AnimList[select * 2]);
            mImgSwitcher.setOutAnimation(AnimList[select * 2 + 1]);

            mImgSwitcher.setImageResource(miImgArr[position]);
        }
    };
    protected void AnimInit() {
        ScaleAnimation scale__in ,scale__out;
        TranslateAnimation trans__in ,trans__out;
        RotateAnimation rotate__in ,rotate__out;
        AlphaAnimation alpha__in ,alpha__out;

        alpha__in = new AlphaAnimation(0f,1f);
        alpha__in.setInterpolator(new LinearInterpolator());
        alpha__in.setStartOffset(3000);
        alpha__in.setDuration(3000);

        alpha__out = new AlphaAnimation(1f, 0f);
        alpha__out.setInterpolator(new LinearInterpolator());
        alpha__out.setStartOffset(0);
        alpha__out.setDuration(3000);

        scale__in = new ScaleAnimation(0f, 1f, 0f, 1f, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
        scale__in.setInterpolator(new LinearInterpolator());
        scale__in.setStartOffset(3000);
        scale__in.setDuration(3000);

        rotate__in = new RotateAnimation(0, 360, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
        rotate__in.setInterpolator(new AccelerateDecelerateInterpolator());
        rotate__in.setStartOffset(3000);
        rotate__in.setDuration(3000);

        scale__out = new ScaleAnimation(1f, 0f, 1f, 0f, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
        scale__out.setInterpolator(new LinearInterpolator());
        scale__out.setDuration(3000);

        rotate__out = new RotateAnimation(0, 360, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
        rotate__out.setInterpolator(new AccelerateDecelerateInterpolator());
        rotate__out.setDuration(3000);

        trans__in = new TranslateAnimation(0, 0, -500, 0);
        trans__in.setInterpolator(new LinearInterpolator());
        trans__in.setStartOffset(3000);
        trans__in.setDuration(3000);

        trans__out = new TranslateAnimation(0, 0, 0, 500);
        trans__out.setInterpolator(new LinearInterpolator());
        trans__out.setDuration(3000);

        AnimationSet  alpha_in = new AnimationSet(false);
        AnimationSet  alpha_out = new AnimationSet(false);
        AnimationSet  scale_rotate_in = new AnimationSet(false);
        AnimationSet  scale_rotate_out = new AnimationSet(false);
        AnimationSet  scale_rotate_trans_in = new AnimationSet(false);
        AnimationSet  scale_rotate_trans_out = new AnimationSet(false);
        AnimationSet  trans_in = new AnimationSet(false);
        AnimationSet  trans_out = new AnimationSet(false);

        alpha_in.addAnimation(alpha__in);

        alpha_out.addAnimation(alpha__out);

        scale_rotate_in.addAnimation(scale__in);
        scale_rotate_in.addAnimation(rotate__in);

        scale_rotate_out.addAnimation(scale__out);
        scale_rotate_out.addAnimation(rotate__out);

        scale_rotate_trans_in.addAnimation(scale__in);
        scale_rotate_trans_in.addAnimation(rotate__in);
        scale_rotate_trans_in.addAnimation(trans__in);

        scale_rotate_trans_out.addAnimation(scale__out);
        scale_rotate_trans_out.addAnimation(rotate__out);
        scale_rotate_trans_out.addAnimation(trans__out);

        trans_in.addAnimation(trans__in);

        trans_out.addAnimation(trans__out);

        AnimList = new Animation[]{
                alpha_in,
                alpha_out,
                scale_rotate_in,
                scale_rotate_out,
                scale_rotate_trans_in,
                scale_rotate_trans_out,
                trans_in,
                trans_out
        };
    }
}
