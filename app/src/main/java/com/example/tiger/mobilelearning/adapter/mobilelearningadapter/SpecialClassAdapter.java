package com.example.tiger.mobilelearning.adapter.mobilelearningadapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.tiger.mobilelearning.R;

import java.util.ArrayList;

/**
 * Created by Tiger on 2017/11/29.
 * 专题课堂里的adapter 一级的
 */

public class SpecialClassAdapter extends RecyclerView.Adapter {

    private Context context;
    private ArrayList list = new ArrayList();

    public SpecialClassAdapter(Context context, ArrayList list) {
        this.context = context;
        this.list = list;
    }

    class MyViewHolder extends RecyclerView.ViewHolder {

        private TextView specialClassOneName;
        private TextView specialClassOneNum;

        public MyViewHolder(View itemView) {
            super(itemView);
            specialClassOneName = (TextView) itemView.findViewById(R.id.specialClassOneName);
            specialClassOneNum = (TextView) itemView.findViewById(R.id.specialClassOneNum);
        }
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context
        ).inflate(R.layout.item_special, parent, false);//这个布局就是一个imageview用来显示图片
        MyViewHolder holder = new MyViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        MyViewHolder myViewHolder = (MyViewHolder) holder;
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}
