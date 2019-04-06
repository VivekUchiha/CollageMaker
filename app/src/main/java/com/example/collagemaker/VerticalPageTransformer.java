package com.example.collagemaker;

import android.support.v4.view.ViewPager;
import android.view.View;


public class VerticalPageTransformer implements ViewPager.PageTransformer {

    public void transformPage(View view, float position) {
        int pageWidth = view.getWidth();

        if (position < -1) {

            view.setAlpha(0);


        }
        else if (position <= 0) {

            view.setAlpha(1);

            view.setScaleX(1);
            view.setScaleY(1);
            float yPosition = position * view.getHeight();
            view.setTranslationY(yPosition);
            view.setTranslationX(-1 * view.getWidth() * position);

        } else if (position <= 1) {

            view.setAlpha(1 - position);

            view.setTranslationX(-1 * view.getWidth() * position);



        }

        else {

            view.setAlpha(0);
        }

    }

}