package com.example.tiger.mobilelearning.adapter.mobilelearningadapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

import com.example.tiger.mobilelearning.R;

import java.util.ArrayList;

/**
 * Created by Tiger on 2017/12/4.
 * 专题课堂二级列表的Adapter
 */

public class ExpandableAdapter extends BaseExpandableListAdapter {

    private ArrayList<String> bigList;
    private ArrayList<ArrayList<String>> smallList;
    private Context context;
    private GroupViewHolder holder;
    private ChildViewHolder holder1;

    public ExpandableAdapter(ArrayList<String> bigList, ArrayList<ArrayList<String>> smallList, Context context) {
        this.bigList = bigList;
        this.smallList = smallList;
        this.context = context;
    }

    @Override
    public int getGroupCount() {
        return bigList.size();
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return smallList.get(groupPosition).size();
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
        if (convertView==null){
            holder = new GroupViewHolder();
            convertView= LayoutInflater.from(context).inflate(R.layout.item_classtwo_one, null);
            holder.classTwoOneName= (TextView) convertView.findViewById(R.id.classTwoOneName);
            convertView.setTag(holder);
        }else {
            holder = (GroupViewHolder) convertView.getTag();
        }
        holder.classTwoOneName.setText(bigList.get(groupPosition));
        return convertView;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        if (convertView==null){
            holder1 = new ChildViewHolder();
            convertView= LayoutInflater.from(context).inflate(R.layout.item_classtwo_two, null);
            holder1.classTwoName= (TextView) convertView.findViewById(R.id.classTwoName);
            convertView.setTag(holder1);
        }else {
            holder1 = (ChildViewHolder) convertView.getTag();
        }
        holder1.classTwoName.setText(smallList.get(groupPosition).get(childPosition));
        return convertView;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }

    static class GroupViewHolder {
        TextView classTwoOneName;
    }
    static class ChildViewHolder {
        TextView classTwoName;
    }
}
