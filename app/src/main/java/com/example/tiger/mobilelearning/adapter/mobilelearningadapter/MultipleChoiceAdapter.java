package com.example.tiger.mobilelearning.adapter.mobilelearningadapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.tiger.mobilelearning.R;

import java.util.ArrayList;

/**
 * Created by Tiger on 2017/12/16.
 * 多选页面的adaoter
 */

public class MultipleChoiceAdapter extends BaseAdapter {

    private Context context;
    private ArrayList list;
    private ViewHolder holder;

    public MultipleChoiceAdapter(Context context) {
        this.context = context;
    }

    @Override
    public int getCount() {
        return 4;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        if (convertView==null){
            convertView = LayoutInflater.from(context).inflate(R.layout.item_multipleduo,null);
            holder = new ViewHolder();
            holder.itemExamImg = (ImageView) convertView.findViewById(R.id.itemExamImg);
            holder.itemExamText = (TextView) convertView.findViewById(R.id.itemExamText);
            setimg(holder.itemExamImg,position);
            convertView.setTag(holder);
        }else {
            holder = (ViewHolder) convertView.getTag();
        }
        return convertView;
    }

    private void setimg(ImageView view, int position) {
        switch (position){
            case 0:
                view.setImageResource(R.drawable.img_ano);
                break;
            case 1:
                view.setImageResource(R.drawable.img_bno);
                break;
            case 2:
                view.setImageResource(R.drawable.img_cno);
                break;
            case 3:
                view.setImageResource(R.drawable.img_dno);
                break;
        }
    }

    class ViewHolder{
        TextView itemExamText;
        ImageView itemExamImg;

    }
}
