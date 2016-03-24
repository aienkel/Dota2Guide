package com.noisay.dota2guide.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;

import com.noisay.dota2guide.HeroDetailActivity;
import com.noisay.dota2guide.R;
import com.noisay.dota2guide.adapter.AvatarAdapter;
import com.noisay.dota2guide.entity.Avatar;

import java.util.LinkedList;


public class PageFragment_agility extends Fragment implements Parcelable{
    public static final String ARG_PAGE = "ARG_PAGE";
    private LinkedList<Avatar> Avatarlist = null;//英雄头像容器
    private AvatarAdapter avatarAdapter;//头像Adapter
    private GridView item_pick;//英雄选择列表

    public static PageFragment_agility newInstance(int page) {
        Bundle args = new Bundle();
        args.putInt(ARG_PAGE, page);
        PageFragment_agility pageFragmentAgility = new PageFragment_agility();
        pageFragmentAgility.setArguments(args);
        return pageFragmentAgility;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_page, container, false);
        item_pick = (GridView) view.findViewById(R.id.grid_avatar);
        Avatarlist = new LinkedList<>();
        initdata();//初始化英雄头像，名字
        avatarAdapter = new AvatarAdapter(Avatarlist,getContext());
        item_pick.setAdapter(avatarAdapter);
        //给GridView中每个英雄设置监听器以便跳转到HeroDetailActivity
        item_pick.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Avatar avatar = Avatarlist.get(position);
                Intent intent = new Intent(PageFragment_agility.this.getActivity(), HeroDetailActivity.class);
                intent.putExtra("Avatar", Avatarlist.get(position));
                startActivity(intent);
            }
        });
        return view;
    }


    /**    初始化英雄头像，名字的方法*/
    private void initdata(){

        Avatarlist.add(new Avatar(R.mipmap.antimage_full, "敌法师"));
        Avatarlist.add(new Avatar(R.mipmap.drow_ranger_full, "卓尔游侠"));
        Avatarlist.add(new Avatar(R.mipmap.juggernaut_full, "主宰"));
        Avatarlist.add(new Avatar(R.mipmap.mirana_full, "米拉娜"));
        Avatarlist.add(new Avatar(R.mipmap.morphling_full, "变体精灵"));
        Avatarlist.add(new Avatar(R.mipmap.phantom_lancer_full, "幻影长矛手"));
        Avatarlist.add(new Avatar(R.mipmap.vengefulspirit_full, "复仇之魂"));
        Avatarlist.add(new Avatar(R.mipmap.riki_full, "力丸"));
        Avatarlist.add(new Avatar(R.mipmap.sniper_full, "狙击手"));
        Avatarlist.add(new Avatar(R.mipmap.templar_assassin_full, "圣堂刺客"));
        Avatarlist.add(new Avatar(R.mipmap.luna_full, "露娜"));
        Avatarlist.add(new Avatar(R.mipmap.bounty_hunter_full, "赏金猎人"));
        Avatarlist.add(new Avatar(R.mipmap.ursa_full, "熊战士"));
        Avatarlist.add(new Avatar(R.mipmap.gyrocopter_full, "矮人直升机"));
        Avatarlist.add(new Avatar(R.mipmap.lone_druid_full, "德鲁伊"));
        Avatarlist.add(new Avatar(R.mipmap.naga_siren_full, "娜迦海妖"));
        Avatarlist.add(new Avatar(R.mipmap.troll_warlord_full, "巨魔战将"));
        Avatarlist.add(new Avatar(R.mipmap.ember_spirit_full, "灰烬之灵"));
        Avatarlist.add(new Avatar(R.mipmap.bloodseeker_full, "嗜血狂魔"));
        Avatarlist.add(new Avatar(R.mipmap.nevermore_full, "影魔"));
        Avatarlist.add(new Avatar(R.mipmap.razor_full, "剃刀"));
        Avatarlist.add(new Avatar(R.mipmap.venomancer_full, "剧毒术士"));
        Avatarlist.add(new Avatar(R.mipmap.faceless_void_full, "虚空假面"));
        Avatarlist.add(new Avatar(R.mipmap.phantom_assassin_full, "幻影刺客"));
        Avatarlist.add(new Avatar(R.mipmap.viper_full, "冥界亚龙"));
        Avatarlist.add(new Avatar(R.mipmap.clinkz_full, "克林克兹"));
        Avatarlist.add(new Avatar(R.mipmap.broodmother_full, "育母蜘蛛"));
        Avatarlist.add(new Avatar(R.mipmap.weaver_full, "编织者"));
        Avatarlist.add(new Avatar(R.mipmap.spectre_full, "幽鬼"));
        Avatarlist.add(new Avatar(R.mipmap.meepo_full, "米波"));
        Avatarlist.add(new Avatar(R.mipmap.nyx_assassin_full, "司夜刺客"));
        Avatarlist.add(new Avatar(R.mipmap.slark_full, "斯拉克"));
        Avatarlist.add(new Avatar(R.mipmap.medusa_full, "美杜莎"));
        Avatarlist.add(new Avatar(R.mipmap.terrorblade_full, "恐怖利刃"));
        Avatarlist.add(new Avatar(R.mipmap.arc_warden_full, "天穹守望者"));

    }

    /**实现序列化传递PageFragment的Intent，去启动HeroDetailActivity*/
    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeList(this.Avatarlist);
    }

    public PageFragment_agility() {
    }

    protected PageFragment_agility(Parcel in) {
        this.Avatarlist = new LinkedList<>();
        in.readList(this.Avatarlist, Avatar.class.getClassLoader());
    }

    public static final Creator<PageFragment_agility> CREATOR = new Creator<PageFragment_agility>() {
        @Override
        public PageFragment_agility createFromParcel(Parcel source) {
            return new PageFragment_agility(source);
        }

        @Override
        public PageFragment_agility[] newArray(int size) {
            return new PageFragment_agility[size];
        }
    };
}