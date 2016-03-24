package com.noisay.dota2guide.entity;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by noisa on 2016/3/15.
 */
public class Avatar implements Parcelable{
    private int aId;//头像的R资源ID
    private String aName;//英雄的中文名

    public Avatar(){

    }

    public Avatar(int aId, String aName) {
        this.aId = aId;
        this.aName = aName;
    }

    public int getaId() {
        return aId;
    }

    public void setaId(int aId) {
        this.aId = aId;
    }

    public String getaName() {
        return aName;
    }

    public void setaName(String aName) {
        this.aName = aName;
    }

    /**本类数据的序列化，传送到Fragment的GridView布局里面
     *
     * @return
     */
    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.aId);
        dest.writeString(this.aName);
    }

    protected Avatar(Parcel in) {
        this.aId = in.readInt();
        this.aName = in.readString();
    }

    public static final Creator<Avatar> CREATOR = new Creator<Avatar>() {
        @Override
        public Avatar createFromParcel(Parcel source) {
            return new Avatar(source);
        }

        @Override
        public Avatar[] newArray(int size) {
            return new Avatar[size];
        }
    };
}
