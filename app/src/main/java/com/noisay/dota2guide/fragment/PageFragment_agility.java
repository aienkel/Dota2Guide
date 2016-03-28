package com.noisay.dota2guide.fragment;

import android.content.Intent;
import android.os.Bundle;
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
import com.noisay.dota2guide.util.Utils;

import java.util.List;


public class PageFragment_agility extends Fragment {
    public static final String ARG_PAGE = "ARG_PAGE";
    private List<Avatar> Avatarlist = null;//英雄头像容器
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
                intent.putExtra("file_name", Avatarlist.get(position).getDetailFileName());
                startActivity(intent);
            }
        });
        return view;
    }

    /**    初始化英雄头像，名字的方法*/
    private void initdata() {
        Avatarlist = Avatar.createList(Utils.getFileContent(getContext(), "agility_hero_List"));

//        Log.d("test", "sd path:" + Utils.DATA_ROOT_DIR);

//        Utils.createJsonFile2(getContext(), "hero_list.json", Utils.createHeroJsonList(Avatarlist));
//        Utils.createJsonFile(Utils.DATA_ROOT_DIR+"/hero_data/", "hero_list.json" ,Utils.createHeroJsonList(Avatarlist));

    }
}