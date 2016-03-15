package com.noisay.dota2guide.entity;

/**
 * Created by noisa on 2016/3/15.
 */
public class Avatar {
    private int aId;
    private String aName;

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
}
