package com.noisay.dota2guide.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * Created by noisa on 2016/3/14.
 */
public class SimpleFragmentPagerAdapter extends FragmentPagerAdapter{
    private String tabTitles[] = new String[]{"力量英雄", "敏捷英雄", "智力英雄", "装备"};//tab标题
    private List<Fragment> fragmentList;//Fragment容器
    public SimpleFragmentPagerAdapter(FragmentManager fm, List<Fragment> fragmentList) {
        super(fm);
        this.fragmentList = fragmentList;
    }

    /**改写FragmentAdapter的默认方法
     *
     * @param position
     * @return
     */
    @Override
    public Fragment getItem(int position) {
        return fragmentList.get(position);
    }

    @Override
    public int getCount() {
        return fragmentList.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return tabTitles[position];
    }
}
