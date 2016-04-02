package com.noisay.dota2guide;

import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;

import com.ms.square.android.expandabletextview.ExpandableTextView;
import com.noisay.dota2guide.adapter.DetailRecyclerViewAdapter;
import com.noisay.dota2guide.entity.Avatar;
import com.noisay.dota2guide.entity.HeroAbility;
import com.noisay.dota2guide.entity.HeroDetail;
import com.noisay.dota2guide.util.DividerItemDecoration;
import com.noisay.dota2guide.util.Utils;

/**
 * Created by noisa on 2016/3/16.
 */
public class HeroDetailActivity extends AppCompatActivity {
    private RecyclerView mRecyclerView;
    private DetailRecyclerViewAdapter mDetailRecyclerViewAdapter;//RecclerView的Adapter

    /**改写AppCompatActivity的默认方法
     *
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.hero_detail);
        Avatar mAvatar = getIntent().getParcelableExtra("Avatar");//对PageFragment序列化传过来的"Avatar"进行反序列化
        Toolbar mToolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        //增加一个返回按钮，可能会删掉，毕竟大屏谁去按左上角
        mToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
        //使用CollapsingToolbarLayout必须把title设置到CollapsingToolbarLayout上，设置到Toolbar上则不会显示
        CollapsingToolbarLayout mCollapsingToolbarLayout = (CollapsingToolbarLayout) findViewById(R.id.collapsing_toolbar_layout);
        mCollapsingToolbarLayout.setBackground(new BitmapDrawable(getResources(), Utils.createBitmapFromFile(this, mAvatar.getaIconPath())));
        mCollapsingToolbarLayout.setTitle(mAvatar.getaName());
        //通过CollapsingToolbarLayout修改字体颜色
        mCollapsingToolbarLayout.setExpandedTitleColor(Color.WHITE);//设置还没收缩时状态下字体颜色
        mCollapsingToolbarLayout.setCollapsedTitleTextColor(Color.WHITE);//设置收缩后Toolbar上字体的颜色
        initViews();//初始化View
        //接受PageFragment传过来的参数
        String fileName = getIntent().getStringExtra("file_name");
        HeroDetail detail = getHeroDetail(fileName);
        /**用第三方类库ExpandableTextView设置英雄背景文字的收缩扩展
         *
         */
        ExpandableTextView herobackground = (ExpandableTextView) findViewById(R.id.expand_text_view);
        herobackground.setText(detail.bio_l);
        //设置布局管理器
        mDetailRecyclerViewAdapter = new DetailRecyclerViewAdapter(this, detail.ability);
        mRecyclerView.setAdapter(mDetailRecyclerViewAdapter);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        mRecyclerView.setLayoutManager(linearLayoutManager);
        //设置RecyclerView的Item的分割线
        mRecyclerView.addItemDecoration(new DividerItemDecoration(this, linearLayoutManager.getOrientation()));
    }

    private HeroDetail getHeroDetail(String fileName) {
        String heroStr = Utils.getFileContent(this, fileName);
        HeroDetail detail = HeroDetail.create(heroStr);
        if (detail != null) {
            Log.d("test", "bio_l:" + detail.bio_l);
            if (detail.ability != null) {
                for (HeroAbility ability : detail.ability) {
                    Log.d("test", "chName: " + ability.chName);
                }
            }
        }
        return detail;
    }

    /**初始化View
     *
     */
    private void initViews() {
        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerView);
    }

}
