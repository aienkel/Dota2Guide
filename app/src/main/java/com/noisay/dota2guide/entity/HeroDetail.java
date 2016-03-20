package com.noisay.dota2guide.entity;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by noisa on 2016/3/15.
 */
public class HeroDetail implements Parcelable{
    private int hId;
    private String herobackground,abilityName,abilityIntroduction;

    public HeroDetail(int hId, String abilityName, String abilityIntroduction) {
        this.hId = hId;
//      this.herobackground = herobackground;
        this.abilityName = abilityName;
        this.abilityIntroduction = abilityIntroduction;
    }

    public int gethId() {
        return hId;
    }
    public void sethId(int hId) {
        this.hId = hId;
    }

//    public String getherobackground() {
//        return herobackground;
//    }
//    public void setherobackground(String herobackground) {
//        this.herobackground = herobackground;
//    }

    public String getabilityName() {
        return abilityName;
    }
    public void setabilityName(String abilityName) {
        this.abilityName = abilityName;
    }

    public String getabilityIntroduction() {
        return abilityIntroduction;
    }
    public void setabilityIntroduction(String abilityIntroduction) {
        this.abilityIntroduction = abilityIntroduction;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.hId);
//        dest.writeString(this.herobackground);
        dest.writeString(this.abilityName);
        dest.writeString(this.abilityIntroduction);
    }

    protected HeroDetail(Parcel in) {
        this.hId = in.readInt();
//        this.herobackground = in.readString();
        this.abilityName = in.readString();
        this.abilityIntroduction = in.readString();
    }

    public static final Creator<HeroDetail> CREATOR = new Creator<HeroDetail>() {
        @Override
        public HeroDetail createFromParcel(Parcel source) {
            return new HeroDetail(source);
        }

        @Override
        public HeroDetail[] newArray(int size) {
            return new HeroDetail[size];
        }
    };
}
