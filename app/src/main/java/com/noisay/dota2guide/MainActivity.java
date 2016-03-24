package com.noisay.dota2guide;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;

import com.noisay.dota2guide.adapter.SimpleFragmentPagerAdapter;
import com.noisay.dota2guide.fragment.PageFragment_agility;
import com.noisay.dota2guide.fragment.PageFragment_intelligence;
import com.noisay.dota2guide.fragment.PageFragment_item;
import com.noisay.dota2guide.fragment.PageFragment_strength;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by noisa on 2016/3/14.
 */
public class MainActivity extends FragmentActivity {
    private SimpleFragmentPagerAdapter pagerAdapter;
    private ViewPager viewPager;
    private TabLayout tabLayout;

    /**改写本类的默认方法
     *
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        PageFragment_agility pageFragment_agility = new PageFragment_agility();//创建一个Fragment实体
        PageFragment_intelligence pageFragment_intelligence= new PageFragment_intelligence();//创建一个Fragment实体
        PageFragment_strength pageFragment_strength = new PageFragment_strength();
        PageFragment_item pageFragment_item = new PageFragment_item();
        List<Fragment> fragmentList = new ArrayList<Fragment>();//创建一个储存Fragment实体的容器
        fragmentList.add(pageFragment_agility);
        fragmentList.add(pageFragment_intelligence);
        fragmentList.add(pageFragment_strength);
        fragmentList.add(pageFragment_item);

        pagerAdapter = new SimpleFragmentPagerAdapter(getSupportFragmentManager(), fragmentList);//创建一个pagerAdapter，其中参数fragmentList使其和各Fragment动态关联
        viewPager = (ViewPager) findViewById(R.id.viewpager);
        viewPager.setAdapter(pagerAdapter);
        tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);//组装tabLayout和Viewpager
        tabLayout.setTabMode(TabLayout.MODE_FIXED);
    }
}