package com.noisay.dota2guide;

import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.noisay.dota2guide.adapter.DetailRecyclerViewAdapter;
import com.noisay.dota2guide.entity.Avatar;
import com.noisay.dota2guide.entity.HeroDetail;
import com.noisay.dota2guide.util.DividerItemDecoration;

import java.util.ArrayList;

/**
 * Created by noisa on 2016/3/16.
 */
public class HeroDetailActivity extends AppCompatActivity {
    private RecyclerView mRecyclerView;
    private ArrayList<HeroDetail> mHeroDetail;
    private DetailRecyclerViewAdapter mDetailRecyclerViewAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.hero_detail);
        Avatar mAvatar = getIntent().getParcelableExtra("Avatar");

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
        mCollapsingToolbarLayout.setBackgroundResource(mAvatar.getaId());
        mCollapsingToolbarLayout.setTitle(mAvatar.getaName());
        //通过CollapsingToolbarLayout修改字体颜色
        mCollapsingToolbarLayout.setExpandedTitleColor(Color.WHITE);//设置还没收缩时状态下字体颜色
        mCollapsingToolbarLayout.setCollapsedTitleTextColor(Color.WHITE);//设置收缩后Toolbar上字体的颜色


        initDatas();
        initViews();
        //设置布局管理器
        mDetailRecyclerViewAdapter = new DetailRecyclerViewAdapter(this, mHeroDetail);
        mRecyclerView.setAdapter(mDetailRecyclerViewAdapter);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        mRecyclerView.setLayoutManager(linearLayoutManager);
        //设置RecyclerView的Item的分割线
        mRecyclerView.addItemDecoration(new DividerItemDecoration(this, linearLayoutManager.getOrientation()));

    }

    private  void initDatas() {

        mHeroDetail = new ArrayList<HeroDetail>();

        mHeroDetail.add(new HeroDetail(R.mipmap.pixel,"","魔霭圣池，一个处于原初群石的裂缝，从中带有先兆力量的蒸汽不断溢出，作为家族力量的源泉，已经惠及数个世代。在居住于洞穴中的魔霭家族，每个新生儿都会在暗黑迷雾中接受沐浴，经过这样的洗礼，他们与大陆的神秘力量获得了内在的联系。随着他们长大，内心坚信自己的使命是誓死保护世袭的传统和领域的风俗——实际上他们守护的不过就是圣池本身。而迷雾的作用原理尚不明朗。\n" +
                "\n" +
                "当初生的亚巴顿沐浴在圣池中时，众人都表示事情并不对劲。孩子的双眼里闪耀出洞察之光，在场所有人都大吃一惊，神父们纷纷交头接耳。而他之后的成长道路与所有魔霭族裔的传人并无差别——为战争接受训练，在危机时刻需要他挺身而出，率领家族的军队守卫先祖的大陆。但是亚巴顿总是特立独行。其他人挥着武器训练时，他喜欢在迷雾前沉思。他饱吸从圣池中涌出的蒸汽，开始学习将自己的灵魂与家族深处流出的力量相融合；他变成了被暗黑迷雾笼罩的怪物。\n" +
                "\n" +
                "魔霭家族怨气冲天——不论老小都谴责他对自己的责任视而不见。但是亚巴顿驾临战场时，不满全都烟消云散，他们目睹了迷雾的强大力量让他恣意挥洒着生杀大权，族内任何领主都是望尘莫及。"));
        mHeroDetail.add(new HeroDetail(R.mipmap.abaddon_death_coil_hp1, "死亡缠绕\n" +
                "（主动）",
                "以自身生命为祭，通过死亡缠绕伤害/治疗一个敌方/友方单位。\n" +
                "施法距离：800\n" +
                "魔法消耗：50/60/70/80点\n" +
                "施法间隔：5秒\n" +
                "\n" +
                "等级 1 - 以自身75点生命的代价，伤害/治疗一个敌方/友方单位100点的生命。\n" +
                "等级 2 - 以自身100点生命的代价，伤害/治疗一个敌方/友方单位150点的生命。\n" +
                "等级 3 - 以自身125点生命的代价，伤害/治疗一个敌方/友方单位200点的生命。\n" +
                "等级 4 - 以自身150点生命的代价，伤害/治疗一个敌方/友方单位250点的生命。\n" +
                "\n"));
        mHeroDetail.add(new HeroDetail(R.mipmap.abaddon_aphotic_shield_hp1, "无光之盾\n" +
                "（主动）",
                "用黑暗能量创造一个盾牌来保护友方的单位，在盾牌消失前吸收一定量的伤害。在盾牌被摧毁或持续时间到后，会给周围500范围内的敌方单位造成伤害。施放时移除目标身上的负面魔法效果。\n" +
                "\n" +
                "施法距离：500\n" +
                "持续时间：15秒\n" +
                "施法间隔：12/10/8/6秒\n" +
                "魔法消耗：100/105/110/115点\n" +
                "\n" +
                "等级 1 - 总共能吸收110点的伤害。\n" +
                "等级 2 - 总共能吸收140点的伤害。\n" +
                "等级 3 - 总共能吸收170点的伤害。\n" +
                "等级 4 - 总共能吸收200点的伤害。\n" +
                "\n"));
        mHeroDetail.add(new HeroDetail(R.mipmap.abaddon_frostmourne_hp1, "霜之哀伤\n" +
                "（被动）",
                "地狱领主使用传说之剑霜之哀伤的极寒力量使目标减速，持续2.5秒。任何攻击被减速目标的单位得到速度的提升，持续4.5秒。\n" +
                "法球效果 无视魔法免疫\n" +
                "\n" +
                "等级 1 - 降低目标5%/5%攻击/移动速度，提升攻击者10%/15%攻击/移动速度。\n" +
                "等级 2 - 降低目标10%/10%攻击/移动速度，提升攻击者20%/15%攻击/移动速度。\n" +
                "等级 3 - 降低目标15%/15%攻击/移动速度，提升攻击者30%/15%攻击/移动速度。\n" +
                "等级 4 - 降低目标20%/20%攻击/移动速度，提升攻击者40%/15%攻击/移动速度。\n" +
                "\n"));
        mHeroDetail.add(new HeroDetail(R.mipmap.abaddon_borrowed_time_hp1, "回光返照\n" +
                "（主动）", " 启动时，移除身上负面的魔法效果，期间所有受到的伤害转而治疗你。如果你当前的生命值低于400而技能不在CD过程中，则技能会自动启动。\n" +
                "\n" +
                "施法间隔：60/50/40秒\n" +
                "魔法消耗：0点\n" +
                "\n" +
                "等级 1 - 持续4秒。\n" +
                "等级 2 - 持续5秒。\n" +
                "等级 3 - 持续6秒。\n"+
                "\n"));

    }

    private void initViews() {
        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerView);
    }
//    private void initDate(){
//        mRecyclerView = (RecyclerView) this.findViewById(R.id.recyclerView);
//        mRecyclerView.setLayoutManager(new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL));
//        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
//        List<Integer> datas = new ArrayList<>();
//        for (int i = 0; i < 100; i++) {
//            datas.add(i);
//        }
//        mRecyclerView.setAdapter(new DetailRecyclerViewAdapter(this, datas));
//    }




        //使用CollapsingToolbarLayout后，title需要设置到CollapsingToolbarLayout上
/*        CollapsingToolbarLayout collapsingToolbar = (CollapsingToolbarLayout) findViewById(R.id.collapsing_toolbar);
        collapsingToolbar.setContentScrimResource(R.mipmap.abaddon_full);
        collapsingToolbar.setTitle(mAvatar.getaName());*/

//        ImageView avatar = (ImageView) findViewById(R.id.hero_detail_avatar);
//        TextView name = (TextView) findViewById(R.id.hero_detail_name);
//        TextView introduction = (TextView) findViewById(R.id.hero_detail_introduction);
//        avatar.setImageResource(mAvatar.getaId());
//        name.setText(mAvatar.getaName());

    }
