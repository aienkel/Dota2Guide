package com.noisay.dota2guide.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.noisay.dota2guide.R;
import com.noisay.dota2guide.entity.Avatar;

import java.util.LinkedList;

/**
 * Created by noisa on 2016/3/15.
 */
public class AvatarAdapter extends BaseAdapter{
    private LinkedList<Avatar> Avatarlist;//头像的容器
    private Context mContext;

    public AvatarAdapter(LinkedList<Avatar> Avatarlist, Context mContext) {
        this.Avatarlist = Avatarlist;
        this.mContext = mContext;
    }

    /**
     * 改写BaseAdapter的默认方法
     *
     * @return
     */
    @Override
    public int getCount() {
        return Avatarlist.size();
    }

    @Override
    public Object getItem(int position) {
        return Avatarlist.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        AvatarViewHolder holder;
        if (convertView == null) {
            convertView = LayoutInflater.from(mContext).inflate(R.layout.item_pick, parent, false);
            holder = new AvatarViewHolder();
            holder.img_avatar = (ImageView) convertView.findViewById(R.id.avatar);
            holder.txt_name = (TextView) convertView.findViewById(R.id.name);
            convertView.setTag(holder);
        } else {
            holder = (AvatarViewHolder) convertView.getTag();
        }
        holder.img_avatar.setBackgroundResource(Avatarlist.get(position).getaId());
        holder.txt_name.setText(Avatarlist.get(position).getaName());
        return convertView;
    }

    /**
     * View的缓存
     */
    static class AvatarViewHolder {
        ImageView img_avatar;
        TextView txt_name;
    }

}
