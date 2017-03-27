package com.yude.judicialauctionproject.adapter.markadapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

import java.util.List;

/**
 * Created by hexiang on 17/3/3.
 */
public class Pager_MarkAdapter extends FragmentPagerAdapter {
    private List<Fragment> twoFragments;
    public Pager_MarkAdapter(FragmentManager fm, List<Fragment> twoFragments) {
        super(fm);
        this.twoFragments = twoFragments;
    }

    @Override
    public Fragment getItem(int position) {
        return twoFragments.get(position);
    }

    @Override
    public int getCount() {
        return twoFragments.size();
    }


}
