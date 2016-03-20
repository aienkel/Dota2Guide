package com.noisay.dota2guide.fragment;

import android.content.Context;
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


public class PageFragment extends Fragment implements Parcelable{
    public static final String ARG_PAGE = "ARG_PAGE";
    private int mPage;//此变量纯粹用来做Fragment内容的展示编号，后期会删除
    /*实现英雄列表选择功能*/
    private LinkedList<Avatar> Avatarlist = null;//实现英雄列表选择功能

    private Context mContext;
    private AvatarAdapter avatarAdapter;
    private GridView item_pick;

    public static PageFragment newInstance(int page) {
        Bundle args = new Bundle();
        args.putInt(ARG_PAGE, page);
        PageFragment pageFragment = new PageFragment();
        pageFragment.setArguments(args);
        return pageFragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPage = getArguments().getInt(ARG_PAGE)
        ;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_page, container, false);
        /*TextView textView = (TextView) view;
        textView.setText("Fragment #" + mPage);*/
        item_pick = (GridView) view.findViewById(R.id.grid_avatar);//
        Avatarlist = new LinkedList<>();

        Avatarlist.add(new Avatar(R.mipmap.abaddon_full, "亚巴顿"));
        Avatarlist.add(new Avatar(R.mipmap.alchemist_full, "炼金术师"));
        Avatarlist.add(new Avatar(R.mipmap.ancient_apparition_full, "远古冰魂"));
        Avatarlist.add(new Avatar(R.mipmap.antimage_full, "敌法师"));
        Avatarlist.add(new Avatar(R.mipmap.arc_warden_full, "天穹守望者"));

        avatarAdapter = new AvatarAdapter(Avatarlist,getContext());
        item_pick.setAdapter(avatarAdapter);

            /*实现序列化传递PageFragment的Intent，去启动HeroDetailActivity*/
/*        */

        item_pick.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Avatar avatar = Avatarlist.get(position);
                Intent intent = new Intent(PageFragment.this.getActivity(), HeroDetailActivity.class);
                intent.putExtra("Avatar", Avatarlist.get(position));
                startActivity(intent);
            }
        });
        return view;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeList(this.Avatarlist);
    }

    public PageFragment() {
    }

    protected PageFragment(Parcel in) {
        this.Avatarlist = new LinkedList<>();
        in.readList(this.Avatarlist, Avatar.class.getClassLoader());
    }

    public static final Creator<PageFragment> CREATOR = new Creator<PageFragment>() {
        @Override
        public PageFragment createFromParcel(Parcel source) {
            return new PageFragment(source);
        }

        @Override
        public PageFragment[] newArray(int size) {
            return new PageFragment[size];
        }
    };
}