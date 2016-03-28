package com.noisay.dota2guide.adapter;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.support.v4.util.LruCache;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.noisay.dota2guide.R;
import com.noisay.dota2guide.entity.Avatar;
import com.noisay.dota2guide.util.IconCache;
import com.noisay.dota2guide.util.Utils;

import java.util.List;

/**
 * Created by noisa on 2016/3/15.
 */
public class AvatarAdapter extends BaseAdapter{
    private List<Avatar> Avatarlist;//头像的容器
    private Context mContext;

    private LruCache<String, Bitmap> mLruCache;
    private int mTotalSize = (int) Runtime.getRuntime().totalMemory();

    AssetManager assetManager = null;
    private String[] nameList = null;



    public AvatarAdapter(List<Avatar> Avatarlist, Context mContext) {
        this.Avatarlist = Avatarlist;
        this.mContext = mContext;
        /*mLruCache = new LruCache<String, Bitmap>(mTotalSize / 5){
            @Override
            protected void entryRemoved(boolean evicted, String key, Bitmap oldValue, Bitmap newValue) {
                super.entryRemoved(evicted, key, oldValue, newValue);
                if (evicted && oldValue != null) {
                    oldValue.recycle();
                }
            }


            @Override
            protected Bitmap create(String key) {

                return super.create(key);
            }

            @Override
            protected int sizeOf(String key, Bitmap value) {
                return super.sizeOf(key, value);
            }
        };*/
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
//        holder.img_avatar.setBackgroundResource(Avatarlist.get(position).getaId());
        holder.txt_name.setText(Avatarlist.get(position).getaName());
        /**添加LruCache的判定
         *
         */
        String iconPath = Avatarlist.get(position).getaIconPath();
        Bitmap icon = IconCache.getInstance().get(iconPath);
        if (icon == null) {
            icon = Utils.createBitmapFromFile(mContext, iconPath);
            IconCache.getInstance().put(iconPath, icon);
        }
        holder.img_avatar.setImageBitmap(icon);

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
