package com.example.android.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.android.R;

public class SliderAdapter extends PagerAdapter {

    Context mContext;
    LayoutInflater layoutInflater;

    public SliderAdapter(Context context){
        mContext=context;
    }

    public int[] slide_images={
            R.drawable.tutorialscreen1,
            R.drawable.tutorialscreen2,
            R.drawable.tutorialscreen3
    };

    public String[] slide_headings={
            "Mount the device",
            "Draw the region to capture",
            "Tap the record button"
    };

    public String[] slide_desc = {
            "Place the device in a higher position",
            "To start recording draw the hotspot on video",
            "Start recording for a specific time"
    };
    @Override
    public int getCount() {
        return slide_headings.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object o) {
        return view == (RelativeLayout) o;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        layoutInflater=(LayoutInflater) mContext.getSystemService(mContext.LAYOUT_INFLATER_SERVICE);
        View view =layoutInflater.inflate(R.layout.slide_layout,container,false);
        ImageView slideImageView = view.findViewById(R.id.slide_image);
        TextView slideHeading=view.findViewById(R.id.slide_heading);
        TextView slideDescription=view.findViewById(R.id.slide_desc);

        slideImageView.setImageResource(slide_images[position]);
        slideHeading.setText(slide_headings[position]);
        slideDescription.setText(slide_desc[position]);

        container.addView(view);

        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((RelativeLayout) object);
    }
}
