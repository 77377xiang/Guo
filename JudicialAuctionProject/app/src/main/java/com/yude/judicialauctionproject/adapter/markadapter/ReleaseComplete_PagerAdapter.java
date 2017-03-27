package com.yude.judicialauctionproject.adapter.markadapter;

import android.content.Context;
import android.content.Intent;
import android.support.v4.view.PagerAdapter;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import com.yude.judicialauctionproject.activitys.mark_activity.ImageActivity;

import java.util.List;

/**
 *
 */
public class ReleaseComplete_PagerAdapter extends PagerAdapter {
    List<ImageView> list;
    Context context;
    List<String> uils;

    public ReleaseComplete_PagerAdapter(List<ImageView> list, Context context, List<String> uil) {
        this.list = list;
        this.context = context;
        this.uils = uil;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, final int position) {
        ImageView imageView = list.get(position);
        container.addView(imageView);
        imageView.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {
                // 注意 position
                if (position==6){
                    String uil = uils.get(0);
                    Intent intent = new Intent(context, ImageActivity.class);
                    intent.putExtra("uil", uil);
                    context.startActivity(intent);

                }else {
                    String uil = uils.get(position - 1);
                    Intent intent = new Intent(context, ImageActivity.class);
                    intent.putExtra("uil", uil);
                    context.startActivity(intent);
                }
            }
        });

        return list.get(position);


    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView(list.get(position));
    }
}

