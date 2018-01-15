package com.example.tiger.mobilelearning.adapter.mobilelearningadapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.tiger.mobilelearning.R;

import java.util.ArrayList;

/**
 * Created by Tiger on 2017/12/4.
 * 三级列表中嵌套的二级列表的Adapter
 */

public class ThreeExpandableAdapter extends BaseExpandableListAdapter {

    private ArrayList<String> bigList;
    private ArrayList<ArrayList<String>> smallList;
    private Context context;
    private GroupViewHolder holder;
    private ChildViewHolder holder1;

    public ThreeExpandableAdapter(Context context) {
        this.context = context;
    }

    @Override
    public int getGroupCount() {
        return 3;
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return 1;
    }

    @Override
    public Object getGroup(int groupPosition) {
        return bigList.get(groupPosition);
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return smallList.get(groupPosition).get(childPosition);
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.item_personal_two, null);
            holder = new GroupViewHolder();
            holder.personalTwoMenu = (TextView) convertView.findViewById(R.id.personalTwoMenu);
            holder.personalTwoMenuOKNO = (TextView) convertView.findViewById(R.id.personalTwoMenuOKNO);
            holder.personalTwoImg = (ImageView) convertView.findViewById(R.id.personalTwoImg);
            convertView.setTag(holder);
        } else {
            holder = (GroupViewHolder) convertView.getTag();
        }
        return convertView;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        if (convertView == null) {
            holder1 = new ChildViewHolder();
            convertView = LayoutInflater.from(context).inflate(R.layout.item_personal_three, null);
            holder1.personalThreeMenu = (TextView) convertView.findViewById(R.id.personalThreeMenu);
            holder1.personalThreeMenuOKNO = (TextView) convertView.findViewById(R.id.personalThreeMenuOKNO);
            holder1.personalThreeImg = (ImageView) convertView.findViewById(R.id.personalThreeImg);
            convertView.setTag(holder1);
        } else {
            holder1 = (ChildViewHolder) convertView.getTag();
        }
        return convertView;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }

    static class GroupViewHolder {

        TextView personalTwoMenu, personalTwoMenuOKNO;
        ImageView personalTwoImg;

    }

    static class ChildViewHolder {
        TextView personalThreeMenu, personalThreeMenuOKNO;
        ImageView personalThreeImg;
    }
}
