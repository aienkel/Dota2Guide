package com.noisay.dota2guide.entity;

import android.text.TextUtils;

import com.noisay.dota2guide.util.Utils;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by noisa on 2016/3/26.
 * HeroDetail实体类
 */
public class HeroDetail {

    public String bio_l;//英雄背景故事，不在RecyclerView中，单独写

    public List<HeroAbility> ability;//容器

    public HeroDetail() {

    }

    public static HeroDetail create(String body) {
        if (TextUtils.isEmpty(body)) {
            return null;
        }

        try {
            JSONObject rootJson = new JSONObject(body);
            HeroDetail heroDetail = new HeroDetail();

            heroDetail.bio_l = Utils.getSafeJsonField(rootJson, "bio_l");

            if (rootJson.has(HeroAbility.HEREO_FIELD_KEY)) {
                JSONArray abilityStr = rootJson.getJSONArray(HeroAbility.HEREO_FIELD_KEY);
                if (abilityStr != null) {
                    List<HeroAbility> abilities = new ArrayList<HeroAbility>();
                    for (int i=0; i<abilityStr.length(); i++) {
                        abilities.add(HeroAbility.create(abilityStr.getString(i)));
                    }

                    heroDetail.ability = abilities;
                }
            }

            return heroDetail;
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return  null;
    }

}
