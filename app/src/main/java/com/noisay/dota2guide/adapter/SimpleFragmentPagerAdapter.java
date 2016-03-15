package com.noisay.dota2guide.adapter;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.noisay.dota2guide.fragment.PageFragment;

/**
 * Created by noisa on 2016/3/14.
 */
public class SimpleFragmentPagerAdapter extends FragmentPagerAdapter{
    final int PAGE_COUNT = 4;
    private String tabTitles[] = new String[]{"敏捷英雄", "智力英雄", "力量英雄", "装备"};
    private Context context;

    public SimpleFragmentPagerAdapter(FragmentManager fm, Context context) {
        super(fm);
        this.context = context;
    }

    @Override
    public Fragment getItem(int position) {
        return PageFragment.newInstance(position+1);//加1是因为position是从0开始
    }

    @Override
    public int getCount() {
        return PAGE_COUNT;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return tabTitles[position];
    }
}
