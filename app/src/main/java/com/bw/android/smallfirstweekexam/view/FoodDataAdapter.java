package com.bw.android.smallfirstweekexam.view;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bw.android.smallfirstweekexam.R;
import com.bw.android.smallfirstweekexam.entify.FoodBean;

import java.util.ArrayList;
import java.util.List;

import jp.wasabeef.glide.transformations.CropCircleTransformation;
/**
 *  Created by lsg on 2019/3/18
 */
public class FoodDataAdapter extends RecyclerView.Adapter<FoodDataAdapter.MyviewHolder> {
    List<FoodBean.DataBean> list = new ArrayList<>();
    public void refresh(List<FoodBean.DataBean> list){
        this.list = list;
    }
    @NonNull
    @Override
    public MyviewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.rev_layout, null);
        return new MyviewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyviewHolder myviewHolder, int i) {
        myviewHolder.tv_rev.setText(list.get(i).getTitle());
        Glide.with(myviewHolder.itemView.getContext())
                .load(list.get(i).getPic())
                .bitmapTransform(new CropCircleTransformation(myviewHolder.itemView.getContext()))
                .into(myviewHolder.iv_rev);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class MyviewHolder extends RecyclerView.ViewHolder{
        TextView tv_rev;
        ImageView iv_rev;
        public MyviewHolder(@NonNull View itemView) {
            super(itemView);
            tv_rev = itemView.findViewById(R.id.tv_rev);
            iv_rev = itemView.findViewById(R.id.iv_rev);
        }
    }
}
