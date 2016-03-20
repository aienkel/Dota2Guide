package com.noisay.dota2guide.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.noisay.dota2guide.R;
import com.noisay.dota2guide.entity.HeroDetail;

import java.util.List;

/**
 * Created by noisa on 2016/3/19.
 */
public class DetailRecyclerViewAdapter extends RecyclerView.Adapter<ItemViewHolder> {
    private LayoutInflater mInflater;
    private Context mContext;
    private List<HeroDetail> mHeroDetail;

    public DetailRecyclerViewAdapter(Context context, List<HeroDetail> mHeroDetail) {
        this.mContext = context;
        this.mHeroDetail=mHeroDetail;
        mInflater = LayoutInflater.from(context);
    }


    @Override
    public ItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.hero_detail_item, null);
        ItemViewHolder itemViewHolder = new ItemViewHolder(view);
        return itemViewHolder;
    }



    @Override
    public void onBindViewHolder(ItemViewHolder holder, int position) {
        holder.imgAbility.setImageResource(mHeroDetail.get(position).gethId());
/*        holder.heroBackground.setText(mHeroDetail.get(position).getherobackground());*/
        holder.nameAbility.setText(mHeroDetail.get(position).getabilityName());
        holder.introductionAbility.setText(mHeroDetail.get(position).getabilityIntroduction());
    }

    @Override
    public int getItemCount() {
        return mHeroDetail.size();
    }
}

class ItemViewHolder extends RecyclerView.ViewHolder {
    ImageView imgAbility;
    TextView heroBackground,nameAbility, introductionAbility;
    public ItemViewHolder(View view){
        super(view);
        imgAbility = (ImageView) view.findViewById(R.id.item_ability_img);
//        heroBackground = (TextView) view.findViewById(R.id.item_background);
        nameAbility = (TextView) view.findViewById(R.id.item_ability_name);
        introductionAbility = (TextView) view.findViewById(R.id.item_ability_introduction);


    }

}












/*    protected Context mContext;
    protected LayoutInflater mLayoutInflater;


    protected List<String> heroDetailItem;

    public DetailRecyclerViewAdapter(List<String> dataItems) {
        heroDetailItem = (dataItems != null) ? dataItems : new ArrayList<String>();
    }


    @Override

    public ItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(mContext).inflate(R.layout.hero_detail_item, null);
        return new ItemViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ItemViewHolder itemViewHolder, int position) {
        itemViewHolder.imgAbility.setImageResource(item.get(position));
        itemViewHolder.nameAbility.setText(item.get(position));
        itemViewHolder.introductionAbility.setText(item.get(position));

    }

    @Override
    public int getItemCount() {
        return (this.item != null) ? this.item.size() : 0;
    }

class ItemViewHolder extends RecyclerView.ViewHolder {
        protected View root;
        protected ImageView imgAbility;
        protected TextView nameAbility, introductionAbility;

        public ItemViewHolder(View root) {
            super(root);
            nameAbility = (TextView) root.findViewById(R.id.item_ability_name);
            introductionAbility = (TextView) root.findViewById(R.id.item_ability_introduction);
            imgAbility = (ImageView) root.findViewById(R.id.item_ability_img);
        }
    }
}*/
    /*
    private List<Integer> datas;
    private Context context;
    private List<Integer> lists;
    public DetailRecyclerViewAdapter(Context context, List<Integer> datas) {
        this.datas = datas;
        this.context = context;
        getRandomHeights(datas);
    }

    private void getRandomHeights(List<Integer> datas) {
        lists = new ArrayList<>();
        for (int i = 0; i < datas.size(); i++) {
            lists.add((int) (200 + Math.random() * 400));
        }
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.hero_detail_item, parent, false);
        MyViewHolder viewHolder = new MyViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        ViewGroup.LayoutParams params = holder.itemView.getLayoutParams();
        params.height = lists.get(position);//把随机的高度赋予item布局
        holder.itemView.setLayoutParams(params);
        holder.mTextView.setText(position+"");
    }

    @Override
    public int getItemCount() {
        return datas.size();
    }
}

class MyViewHolder extends RecyclerView.ViewHolder {
    TextView mTextView;
    public MyViewHolder(View itemView) {
        super(itemView);
        mTextView = (TextView) itemView.findViewById(R.id.item_tv);
    }*/
