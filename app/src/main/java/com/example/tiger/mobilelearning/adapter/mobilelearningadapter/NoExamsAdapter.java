package com.example.tiger.mobilelearning.adapter.mobilelearningadapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.tiger.mobilelearning.R;

import java.util.ArrayList;

/**
 * Created by Tiger on 2017/11/30.
 */

public class NoExamsAdapter extends RecyclerView.Adapter {

    private Context context;
    private ArrayList<String> list;

    public NoExamsAdapter(Context context, ArrayList<String> list) {
        this.context = context;
        this.list = list;
    }

    static class MyViewHolder extends RecyclerView.ViewHolder {

        private Button butCourse;

        public MyViewHolder(View itemView) {
            super(itemView);
//            butCourse = (Button) itemView.findViewById(R.id.butCourse);
        }
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context
        ).inflate(R.layout.item_courseone, parent,
                false);//这个布局就是一个imageview用来显示图片
        MyViewHolder holder = new MyViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        MyViewHolder myViewHolder = (MyViewHolder) holder;
//        myViewHolder.butCourse.setText(list.get(position));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}
