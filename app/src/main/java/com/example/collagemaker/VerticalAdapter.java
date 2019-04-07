package com.example.collagemaker;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import java.util.List;

public class VerticalAdapter extends PagerAdapter {

    List<String> mResources1,mResources2;
    Context mContext;
    LayoutInflater mLayoutInflater;
    public HorizontalAdapter horizontalAdapter1,horizontalAdapter2;

    public VerticalAdapter(List<String> mResources1,List<String> mResources2,Context context) {
        this.mResources1=mResources1;
        this.mResources2=mResources2;
        mContext = context;
        horizontalAdapter1 = new HorizontalAdapter(mResources1,mContext);
        horizontalAdapter2 = new HorizontalAdapter(mResources2,mContext);
        mLayoutInflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return 2;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == ((RelativeLayout) object);
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        View itemView = mLayoutInflater.inflate(R.layout.layy, container, false);
        ViewPager viewPager = (ViewPager)itemView.findViewById(R.id.horiViewPager);
        if(position==0){

            viewPager.setAdapter(horizontalAdapter1);
        }
        else {
            viewPager.setAdapter(horizontalAdapter2);

        }

        container.addView(itemView);

        return itemView;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((RelativeLayout) object);
    }
}
