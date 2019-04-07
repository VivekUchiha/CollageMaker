package com.example.collagemaker;


import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import java.util.List;

public class HorizontalAdapter extends PagerAdapter {

    List<String> mResources;
    Context mContext;
    LayoutInflater mLayoutInflater;

    public HorizontalAdapter(List<String> mResources,Context context) {
        this.mResources=mResources;
        mContext = context;
        mLayoutInflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return mResources.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == ((RelativeLayout) object);
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        View itemView = mLayoutInflater.inflate(R.layout.layimage, container, false);
        ImageView imageView = (ImageView) itemView.findViewById(R.id.imagsss);
        if(mResources.get(position)==""){
            imageView.setImageResource(R.drawable.firefo);
        }
        else{

        }

        container.addView(itemView);

        return itemView;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((RelativeLayout) object);
    }
}

