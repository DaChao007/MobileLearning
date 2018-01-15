package com.example.tiger.mobilelearning.adapter.mobilelearningadapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.tiger.mobilelearning.R;
import com.example.tiger.mobilelearning.entity.mobilelearningentity.PersonalExamBean;
import com.example.tiger.mobilelearning.view.CustomExpandableListView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Tiger on 2017/12/4.
 * 个人考试查询 课程和章节
 */

public class PersonalThreeAdapter extends BaseExpandableListAdapter {


    private static final int WUKAOSHI = 1;
    private static final int WEIKSOHI = 2;
    private static final int WEITONGGUO = 3;
    private static final int YITONGGUO = 4;

    private Context context;
    private ArrayList<PersonalExamBean.DataBean> list;
    private GroupViewHolder holder;
    private ChildViewHolder holder1;

    private boolean isupData;

    public PersonalThreeAdapter(Context context, ArrayList<PersonalExamBean.DataBean> list, boolean isupData) {
        this.context = context;
        this.list = list;
        this.isupData = isupData;
    }

    @Override
    public int getGroupCount() {
        return list.size();
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return 1;
    }

    @Override
    public Object getGroup(int groupPosition) {
        return list.get(groupPosition);
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return list.get(groupPosition).getChapterExm().get(childPosition);
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
            holder = new GroupViewHolder();
            convertView = LayoutInflater.from(context).inflate(R.layout.item_personalexam, null);
            holder.itemName = (TextView) convertView.findViewById(R.id.itemName);
            holder.itemIsExam = (TextView) convertView.findViewById(R.id.itemIsExam);
            holder.itemDown = (ImageView) convertView.findViewById(R.id.itemDown);
            holder.itemNoby = (TextView) convertView.findViewById(R.id.itemNoby);
            convertView.setTag(holder);
        } else {
            holder = (GroupViewHolder) convertView.getTag();
        }
        PersonalExamBean.DataBean dataBean = list.get(groupPosition);
        holder.itemName.setText("  "+dataBean.getCourseTitle());
//        setStatus(holder.itemIsExam, dataBean.getExamStatus());
        return convertView;
    }

    private void setStatus(TextView textView, int examStatus) {
        switch (examStatus) {
            case WUKAOSHI:
                textView.setText("无考试");
                break;
            case WEIKSOHI:
                textView.setText("未考试");
                break;
            case WEITONGGUO:
                textView.setText("未通过");
                break;
            case YITONGGUO:
                textView.setText("已通过");
                break;
        }
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.item_personal_expand, null);
            holder1 = new ChildViewHolder(convertView, list.get(groupPosition).getChapterExm());
            holder1.itemPersonalExpand = (CustomExpandableListView) convertView.findViewById(R.id.itemPersonalExpand);
        } else {
            holder1 = (ChildViewHolder) convertView.getTag();
        }
        return convertView;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }

    class GroupViewHolder {
        TextView itemName, itemIsExam,itemNoby;
        ImageView itemDown;
    }

    class ChildViewHolder {
        CustomExpandableListView itemPersonalExpand;

        public ChildViewHolder(View view, List<PersonalExamBean.DataBean.ChapterExmBean> list) {
            if (list!=null){
                itemPersonalExpand = (CustomExpandableListView) view.findViewById(R.id.itemPersonalExpand);
                PersonalThreeOneAdapter adapter = new PersonalThreeOneAdapter(isupData,context, (ArrayList<PersonalExamBean.DataBean.ChapterExmBean>) list);
                itemPersonalExpand.setAdapter(adapter);
                for (int i = 0; i < list.size(); i++) {
                    itemPersonalExpand.expandGroup(i);
                }
                view.setTag(ChildViewHolder.this);
            }
        }


    }
}
